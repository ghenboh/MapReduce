package com.example.distribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


import com.example.grpc.TaskMessage;
import com.example.grpc.TaskMessage.Empty;
import com.example.grpc.TaskMessage.ListStringListResponse;
import com.example.grpc.TaskMessage.StringListResponse;
import com.example.grpc.TaskServiceGrpc;
import com.example.grpc.TaskServiceGrpc.TaskServiceBlockingStub;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Reduces {
    public Map<String, Integer> doReduces() {
        ExecutorService executor;
        executor = new ThreadPoolExecutor(6, 13, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(77));
        List<Future<Map<String, Integer>>> futures = new ArrayList<>();
        for(int helper = 0; helper < 6; helper++) {
            futures.add(executor.submit(() -> makeSingle()));
        }
        Map<String, Integer> ret = new HashMap<>();
        for(Future<Map<String, Integer>> future: futures) {
            try {
                ret.putAll(future.get());
            } catch (Exception e) {e.printStackTrace();}
        }
        return ret;
    }

    public Map<String, Integer> makeSingle() {
        Map<String, Integer> ret = new HashMap<>();
        List<List<String>> mids;
        while((mids = remoteCall()) != null) {
            try {
                for(List<String> single: mids) {
                    ret.put(single.get(0), single.size());
                }
            } catch(Exception e) {e.printStackTrace();}
        }
        return ret;
    }

    public List<List<String>> remoteCall() {
        Empty emptyAsk = TaskMessage.Empty.newBuilder().build();
        ListStringListResponse response;
        try {
            Channel channel =  ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            synchronized(Reduces.class) {
                TaskServiceBlockingStub blockingStub = TaskServiceGrpc.newBlockingStub(channel).withDeadlineAfter(1, TimeUnit.DAYS);
                response = blockingStub.emptyRequestToListStringList(emptyAsk);
            }
            List<List<String>> ret = new ArrayList<>();
            for(StringListResponse single: response.getMessagesList()) {
                ret.add(single.getMessagesList());
            }
            return ret;
        } catch (StatusRuntimeException e) {
            return null;
        }
    }
}
