package com.example.communication;

import java.io.IOException;

import com.example.distribute.Reduces;
import com.example.grpc.TaskMessage.Empty;
import com.example.grpc.TaskMessage.MapResponse;
import com.example.grpc.TaskServiceGrpc.TaskServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ReduceWorkers {

    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        final ReduceWorkers servers = new ReduceWorkers();
        servers.start();
        servers.blockUntilShutdown();
    }

    private void start() throws IOException {
        int port = 50053;
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
        public void emptyToMap(Empty req, StreamObserver<MapResponse> responseObserver) {
            MapResponse reply = MapResponse.newBuilder().putAllResult((new Reduces()).doReduces()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

}
