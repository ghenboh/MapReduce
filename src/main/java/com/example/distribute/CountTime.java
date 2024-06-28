package com.example.distribute;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import com.example.grpc.TaskMessage.TaskResult;

public class CountTime {
    ExecutorService executor;

    public CountTime() {
        executor = new ThreadPoolExecutor(12, 13, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(77));
    }

    public List<TaskResult> countWordTime(String pathPrefix, String pathSuffix, int maxNumber) {
        List<TaskResult> ret = new ArrayList<>();
        List<Future<TaskResult>> futures = new ArrayList<>();
        for(int helper = 0; helper <= maxNumber; helper++) {
            StringBuilder sb = new StringBuilder(pathPrefix).append(helper).append(pathSuffix);
            futures.add(executor.submit(() -> doMap(sb.toString())));
        }
        try {
            for(Future<TaskResult> single: futures) {
                ret.add(single.get());
            }
        } catch (Exception e) {e.printStackTrace();}
        return ret;
    }

    public TaskResult doMap(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            Map<String, Integer> ret = new HashMap<>();
            List<String> mid = new ArrayList<>();
            while(scanner.hasNextLine()) {
                String now = scanner.nextLine();
                mid.add(now);
            }
            scanner.close();
            for(String now: mid) {
                List<Word> transfer = WordSegmenter.seg(now);
                for(Word single: transfer) {
                    ret.merge(single.toString(), 1, Integer::sum);
                }
            }
            TaskResult taskResult = TaskResult.newBuilder().putAllResult(ret).build();
            return taskResult;
        } catch(Exception e) {e.printStackTrace(); return null;}
    }
}
