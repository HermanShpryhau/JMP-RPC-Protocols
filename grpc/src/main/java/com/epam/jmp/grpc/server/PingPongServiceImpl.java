package com.epam.jmp.grpc.server;

import com.epam.jmp.grpc.PingPongRequest;
import com.epam.jmp.grpc.PingPongResponse;
import com.epam.jmp.grpc.PingPongServiceGrpc;
import io.grpc.stub.StreamObserver;

public class PingPongServiceImpl extends PingPongServiceGrpc.PingPongServiceImplBase {
    @Override
    public void ping(PingPongRequest request, StreamObserver<PingPongResponse> responseObserver) {
        PingPongResponse response;
        String message = request.getMessage();
        if (message.equalsIgnoreCase("ping")) {
            response = PingPongResponse.newBuilder().setMessage("pong").build();
        } else if (message.equalsIgnoreCase("pong")) {
            response = PingPongResponse.newBuilder().setMessage("ping").build();
        } else {
            response = PingPongResponse.newBuilder().setMessage("No such move in this game!").build();
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
