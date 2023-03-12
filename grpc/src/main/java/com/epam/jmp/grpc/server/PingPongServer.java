package com.epam.jmp.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class PingPongServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8081).addService(new PingPongServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }
}
