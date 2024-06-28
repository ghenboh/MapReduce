package com.example.communication;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.example.grpc.TaskMessage;
import com.example.grpc.TaskServiceGrpc;
import com.example.grpc.TaskMessage.TaskRequest;
import com.example.grpc.TaskMessage.TaskResponse;
import com.example.grpc.TaskMessage.TaskResult;
import com.example.grpc.TaskServiceGrpc.TaskServiceBlockingStub;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Clients {

    public static void main(String[] args) throws Exception {
        Clients clients = new Clients();
        try {
            clients.remoteCall("src\\main\\resources\\text\\", ".txt", 88);
        } catch (Exception e) {e.printStackTrace();}
    }

    public void remoteCall(String pathPrefix, String pathSuffix, int maxNumber) {
        TaskRequest request = TaskMessage.TaskRequest.newBuilder().setPathPrefix(pathPrefix).setPathSuffix(pathSuffix).setMaxNumber(maxNumber).build();
        TaskResponse response;
        try {
            Channel channel =  ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            TaskServiceBlockingStub blockingStub = TaskServiceGrpc.newBlockingStub(channel).withDeadlineAfter(1, TimeUnit.DAYS);
            response = blockingStub.processTasks(request);
        } catch (StatusRuntimeException e) {
            return;
        }

        System.out.println("test");
        List<TaskResult> with = response.getResultsList();
        Map<String, Integer> ret = new HashMap<>();
        for(TaskResult taskResult: with) {
            for(Map.Entry<String, Integer> single: taskResult.getResultMap().entrySet()) {
                ret.put(single.getKey().replaceAll("/[a-zA-Z]+$", ""), ret.getOrDefault(single.getKey().replaceAll("/[a-zA-Z]+$", ""), 0) + single.getValue());
            }
        }
        List<List<String>> terminals = new ArrayList<>();
        for(Map.Entry<String, Integer> single: ret.entrySet()) {
            terminals.add(List.of(single.getKey(), String.valueOf(single.getValue())));
        }
        Collections.sort(terminals, (a, b) -> Integer.parseInt(a.get(1)) != Integer.parseInt(b.get(1)) ? Integer.parseInt(b.get(1)) - Integer.parseInt(a.get(1)) : a.get(0).compareTo(b.get(0)));
        try {
            PrintWriter printWriter = new PrintWriter(new File("src\\main\\resources\\text\\100.txt"));
            printWriter.println(terminals);
            printWriter.println(ret);
            for(TaskResult taskResult: with) {
                printWriter.println(taskResult.getResultMap());
            }
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {e.printStackTrace();}
    }

}
