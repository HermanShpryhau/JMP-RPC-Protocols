package com.epam.jmp.grpc.server;

import com.epam.jmp.grpc.PingPongServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class PingPongServer {
    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(8081).addService(PingPongServiceGrpc)
    }
}
