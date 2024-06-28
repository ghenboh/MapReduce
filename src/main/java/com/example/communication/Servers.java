package com.example.communication;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

import com.example.distribute.CountTime;
import com.example.grpc.TaskMessage.TaskRequest;
import com.example.grpc.TaskMessage.TaskResponse;
import com.example.grpc.TaskServiceGrpc.TaskServiceImplBase;

public class Servers {

    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        final Servers servers = new Servers();
        servers.start();
        servers.blockUntilShutdown();
    }

    private void start() throws IOException {
        int port = 50051;
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
        @Override
        public void processTasks(TaskRequest req, StreamObserver<TaskResponse> responseObserver) {
            TaskResponse reply = TaskResponse.newBuilder().addAllResults((new CountTime()).countWordTime(req.getPathPrefix(), req.getPathSuffix(), req.getMaxNumber())).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

}
