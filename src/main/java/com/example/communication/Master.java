package com.example.communication;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import com.example.grpc.TaskMessage;
import com.example.grpc.TaskServiceGrpc;
import com.example.grpc.TaskMessage.Empty;
import com.example.grpc.TaskMessage.ListStringListResponse;
import com.example.grpc.TaskMessage.MapResponse;
import com.example.grpc.TaskMessage.StringListResponse;
import com.example.grpc.TaskMessage.StringResponse;
import com.example.grpc.TaskServiceGrpc.TaskServiceBlockingStub;
import com.example.grpc.TaskServiceGrpc.TaskServiceImplBase;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class Master {
    private Server server;
    static List<List<String>> middle;

    public static void main(String[] args) throws Exception {
        try {
            new Thread(() -> 
            {
                final Master servers = new Master();
                try {
                    servers.start();
                    servers.blockUntilShutdown();
                } catch(Exception e) {e.printStackTrace();}
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> transfer = new Master().remoteCallMap();
        Map<String, List<String>> other = new HashMap<>();
        for(String single: transfer) {
            if(!other.containsKey(single)) {
                other.put(single, new ArrayList<>());
            }
            other.get(single).add(single);
        }
        middle = new ArrayList<>();
        for(List<String> value: other.values()) {
            middle.add(value);
        }
        List<List<String>> ret = (new Master()).remoteCallWorker();
        PrintWriter printWriter = new PrintWriter(new File("src\\main\\resources\\text\\101.txt"));
        printWriter.println(ret);
        printWriter.flush();
        printWriter.close();
    }

    public List<String> remoteCallMap() {
        Empty emptyAsk = TaskMessage.Empty.newBuilder().build();
        StringListResponse response;
        try {
            Channel channel =  ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            TaskServiceBlockingStub blockingStub = TaskServiceGrpc.newBlockingStub(channel).withDeadlineAfter(1, TimeUnit.DAYS);
            response = blockingStub.emptyRequestToStringList(emptyAsk);
            return response.getMessagesList();
        } catch (StatusRuntimeException e) {
            return null;
        }
    }

    public List<List<String>> remoteCallWorker() {
        Empty emptyAsk = TaskMessage.Empty.newBuilder().build();
        MapResponse response;
        try {
            Channel channel =  ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
            TaskServiceBlockingStub blockingStub = TaskServiceGrpc.newBlockingStub(channel).withDeadlineAfter(1, TimeUnit.DAYS);
            response = blockingStub.emptyToMap(emptyAsk);
            Map<String, Integer> ret = response.getResultMap();
            List<List<String>> terminals = new ArrayList<>();
            for(Map.Entry<String, Integer> single: ret.entrySet()) {
                terminals.add(List.of(single.getKey(), String.valueOf(single.getValue())));
            }
            Collections.sort(terminals, (a, b) -> Integer.parseInt(a.get(1)) != Integer.parseInt(b.get(1)) ? Integer.parseInt(b.get(1)) - Integer.parseInt(a.get(1)) : a.get(0).compareTo(b.get(0)));
            return terminals;
        } catch (StatusRuntimeException e) {
            return null;
        }
    }


    private void start() throws IOException {
        int port = 50052;
        server = ServerBuilder.forPort(port)
                .addService(new TaskImpl())
                .build()
                .start();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    static class TaskImpl extends TaskServiceImplBase {
        int map = -1;
        final int MAXMUM = 88;
        int from = 0;
        @Override
        public void emptyRequestToString(Empty req, StreamObserver<StringResponse> responseObserver) {
            StringResponse reply = StringResponse.newBuilder().setMessage(makeStringOfPath()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void emptyRequestToListStringList(Empty req, StreamObserver<ListStringListResponse> responseObserver) {
            ListStringListResponse reply = ListStringListResponse.newBuilder().addAllMessages(makeSubList()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        public String makeStringOfPath() {
            map++;
            return map <= MAXMUM ? "src\\main\\resources\\text\\" + map + ".txt" : "null";
        }

        public List<StringListResponse> makeSubList() {
            if(from >= Master.middle.size()) {
                return null;
            }
            List<StringListResponse> ret = new ArrayList<>();
            for(int helper = from; helper < Math.min(from + 10000, Master.middle.size()); helper++) {
                ret.add(StringListResponse.newBuilder().addAllMessages(Master.middle.get(helper)).build());
            }
            from += 10000;
            return ret;
        }
    }
}

// System.out.println("test");
// List<TaskResult> with = response.getResultsList();
// Map<String, Integer> ret = new HashMap<>();
// for(TaskResult taskResult: with) {
//     for(Map.Entry<String, Integer> single: taskResult.getResultMap().entrySet()) {
        // ret.put(single.getKey().replaceAll("/[a-zA-Z]+$", ""), ret.getOrDefault(single.getKey().replaceAll("/[a-zA-Z]+$", ""), 0) + single.getValue());
//     }
// }
// List<List<String>> terminals = new ArrayList<>();
// for(Map.Entry<String, Integer> single: ret.entrySet()) {
//     terminals.add(List.of(single.getKey(), String.valueOf(single.getValue())));
// }
// Collections.sort(terminals, (a, b) -> Integer.parseInt(a.get(1)) != Integer.parseInt(b.get(1)) ? Integer.parseInt(b.get(1)) - Integer.parseInt(a.get(1)) : a.get(0).compareTo(b.get(0)));
// try {
//     PrintWriter printWriter = new PrintWriter(new File("src\\main\\resources\\text\\100.txt"));
//     printWriter.println(terminals);
//     printWriter.println(ret);
//     for(TaskResult taskResult: with) {
//         printWriter.println(taskResult.getResultMap());
//     }
//     printWriter.flush();
//     printWriter.close();
// } catch (Exception e) {e.printStackTrace();}