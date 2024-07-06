package com.example.communication;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

import com.example.distribute.Maps;
import com.example.grpc.TaskMessage.Empty;
import com.example.grpc.TaskMessage.StringListResponse;
import com.example.grpc.TaskServiceGrpc.TaskServiceImplBase;

public class MapWorker {

    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        final MapWorker servers = new MapWorker();
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
        public void emptyRequestToStringList(Empty req, StreamObserver<StringListResponse> responseObserver) {
            StringListResponse reply = StringListResponse.newBuilder().addAllMessages((new Maps()).doMap()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

}
