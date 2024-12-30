package com.github.q0215.app.grpc

import com.github.q0215.app.Empty
import com.github.q0215.app.HelloReply
import com.github.q0215.app.HelloServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class HelloServiceImpl: HelloServiceGrpc.HelloServiceImplBase() {

    override fun hello(request: Empty?, responseObserver: StreamObserver<HelloReply>?) {
        responseObserver?.onNext(HelloReply.newBuilder().setMessage("Hello gRPC.").build())
        responseObserver?.onCompleted()
    }
}
