package com.epam.jmp.grpc.client

import com.epam.jmp.grpc.PingPongRequest
import com.epam.jmp.grpc.PingPongServiceGrpc
import io.grpc.ManagedChannelBuilder

fun main() {
    val channel = ManagedChannelBuilder.forAddress("localhost", 8081)
        .usePlaintext()
        .build()

    val stub = PingPongServiceGrpc.newBlockingStub(channel)

    val pingRequest = PingPongRequest.newBuilder().setMessage("ping").build()
    val pongResponse = stub.ping(pingRequest)
    println(pongResponse.message)

    val pongRequest = PingPongRequest.newBuilder().setMessage("pong").build()
    val pingResponse = stub.ping(pongRequest)
    println(pingResponse.message)

    val invalidRequest = PingPongRequest.newBuilder().setMessage("pang").build()
    val errorResponse = stub.ping(invalidRequest)
    println(errorResponse.message)
}