package com.example.distribute;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import com.example.grpc.TaskMessage;
import com.example.grpc.TaskMessage.Empty;
import com.example.grpc.TaskMessage.StringResponse;
import com.example.grpc.TaskServiceGrpc;
import com.example.grpc.TaskServiceGrpc.TaskServiceBlockingStub;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Maps {
    public List<String> doMap() {
        ExecutorService executor;
        executor = new ThreadPoolExecutor(6, 13, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(77));
        List<Future<List<String>>> futures = new ArrayList<>();
        for(int helper = 0; helper < 6; helper++) {
            futures.add(executor.submit(() -> makeSingle()));
        }
        List<String> ret = new ArrayList<>();
        for(Future<List<String>> future: futures) {
            try {
                ret.addAll(future.get());
            } catch (Exception e) {e.printStackTrace();}
        }
        return ret;
    }

    public List<String> makeSingle() {
        List<String> ret = new ArrayList<>();
        String path;
        while(!(path = remoteCall()).equals("null")) {
            try {
                Scanner scanner = new Scanner(new File(path));
                List<String> mid = new ArrayList<>();
                while(scanner.hasNextLine()) {
                    String now = scanner.nextLine();
                    mid.add(now);
                }
                scanner.close();
                for(String now: mid) {
                    List<Word> transfer = WordSegmenter.seg(now);
                    for(Word word: transfer) {
                        ret.add(word.toString().replaceAll("/[a-zA-Z]+$", ""));
                    }
                }
                scanner.close();
            } catch(Exception e) {e.printStackTrace();}
        }
        return ret;
    }

    public String remoteCall() {
        Empty emptyAsk = TaskMessage.Empty.newBuilder().build();
        StringResponse response;
        try {
            Channel channel =  ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            synchronized(Maps.class) {
                TaskServiceBlockingStub blockingStub = TaskServiceGrpc.newBlockingStub(channel).withDeadlineAfter(1, TimeUnit.DAYS);
                response = blockingStub.emptyRequestToString(emptyAsk);
            }
            return response.getMessage();
        } catch (StatusRuntimeException e) {
            return "";
        }
    }

}
