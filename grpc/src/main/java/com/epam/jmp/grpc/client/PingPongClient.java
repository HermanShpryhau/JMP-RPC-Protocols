package com.epam.jmp.grpc.client;

import com.epam.jmp.grpc.PingPongRequest;
import com.epam.jmp.grpc.PingPongResponse;
import com.epam.jmp.grpc.PingPongServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PingPongClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        PingPongServiceGrpc.PingPongServiceBlockingStub stub = PingPongServiceGrpc.newBlockingStub(channel);

        var pingRequest = PingPongRequest.newBuilder().setMessage("ping").build();
        PingPongResponse pongResponse = stub.ping(pingRequest);
        System.out.println(pongResponse.getMessage());

        var pongRequest = PingPongRequest.newBuilder().setMessage("pong").build();
        PingPongResponse pingResponse = stub.ping(pongRequest);
        System.out.println(pingResponse.getMessage());

        var invalidRequest = PingPongRequest.newBuilder().setMessage("pang").build();
        PingPongResponse errorResponse = stub.ping(invalidRequest);
        System.out.println(errorResponse.getMessage());
    }
}
