package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.31.1)",
    comments = "Source: task.proto")
public final class TaskServiceGrpc {

  private TaskServiceGrpc() {}

  public static final String SERVICE_NAME = "task.TaskService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty,
      com.example.grpc.TaskMessage.StringResponse> getEmptyRequestToStringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmptyRequestToString",
      requestType = com.example.grpc.TaskMessage.Empty.class,
      responseType = com.example.grpc.TaskMessage.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty,
      com.example.grpc.TaskMessage.StringResponse> getEmptyRequestToStringMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty, com.example.grpc.TaskMessage.StringResponse> getEmptyRequestToStringMethod;
    if ((getEmptyRequestToStringMethod = TaskServiceGrpc.getEmptyRequestToStringMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getEmptyRequestToStringMethod = TaskServiceGrpc.getEmptyRequestToStringMethod) == null) {
          TaskServiceGrpc.getEmptyRequestToStringMethod = getEmptyRequestToStringMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.TaskMessage.Empty, com.example.grpc.TaskMessage.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EmptyRequestToString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.TaskMessage.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.TaskMessage.StringResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TaskServiceMethodDescriptorSupplier("EmptyRequestToString"))
              .build();
        }
      }
    }
    return getEmptyRequestToStringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty,
      com.example.grpc.TaskMessage.ListStringListResponse> getEmptyRequestToListStringListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmptyRequestToListStringList",
      requestType = com.example.grpc.TaskMessage.Empty.class,
      responseType = com.example.grpc.TaskMessage.ListStringListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty,
      com.example.grpc.TaskMessage.ListStringListResponse> getEmptyRequestToListStringListMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty, com.example.grpc.TaskMessage.ListStringListResponse> getEmptyRequestToListStringListMethod;
    if ((getEmptyRequestToListStringListMethod = TaskServiceGrpc.getEmptyRequestToListStringListMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getEmptyRequestToListStringListMethod = TaskServiceGrpc.getEmptyRequestToListStringListMethod) == null) {
          TaskServiceGrpc.getEmptyRequestToListStringListMethod = getEmptyRequestToListStringListMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.TaskMessage.Empty, com.example.grpc.TaskMessage.ListStringListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EmptyRequestToListStringList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.TaskMessage.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.TaskMessage.ListStringListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TaskServiceMethodDescriptorSupplier("EmptyRequestToListStringList"))
              .build();
        }
      }
    }
    return getEmptyRequestToListStringListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty,
      com.example.grpc.TaskMessage.StringListResponse> getEmptyRequestToStringListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmptyRequestToStringList",
      requestType = com.example.grpc.TaskMessage.Empty.class,
      responseType = com.example.grpc.TaskMessage.StringListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty,
      com.example.grpc.TaskMessage.StringListResponse> getEmptyRequestToStringListMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty, com.example.grpc.TaskMessage.StringListResponse> getEmptyRequestToStringListMethod;
    if ((getEmptyRequestToStringListMethod = TaskServiceGrpc.getEmptyRequestToStringListMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getEmptyRequestToStringListMethod = TaskServiceGrpc.getEmptyRequestToStringListMethod) == null) {
          TaskServiceGrpc.getEmptyRequestToStringListMethod = getEmptyRequestToStringListMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.TaskMessage.Empty, com.example.grpc.TaskMessage.StringListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EmptyRequestToStringList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.TaskMessage.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.TaskMessage.StringListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TaskServiceMethodDescriptorSupplier("EmptyRequestToStringList"))
              .build();
        }
      }
    }
    return getEmptyRequestToStringListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty,
      com.example.grpc.TaskMessage.MapResponse> getEmptyToMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmptyToMap",
      requestType = com.example.grpc.TaskMessage.Empty.class,
      responseType = com.example.grpc.TaskMessage.MapResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty,
      com.example.grpc.TaskMessage.MapResponse> getEmptyToMapMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.TaskMessage.Empty, com.example.grpc.TaskMessage.MapResponse> getEmptyToMapMethod;
    if ((getEmptyToMapMethod = TaskServiceGrpc.getEmptyToMapMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getEmptyToMapMethod = TaskServiceGrpc.getEmptyToMapMethod) == null) {
          TaskServiceGrpc.getEmptyToMapMethod = getEmptyToMapMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.TaskMessage.Empty, com.example.grpc.TaskMessage.MapResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EmptyToMap"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.TaskMessage.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.TaskMessage.MapResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TaskServiceMethodDescriptorSupplier("EmptyToMap"))
              .build();
        }
      }
    }
    return getEmptyToMapMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TaskServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TaskServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TaskServiceStub>() {
        @java.lang.Override
        public TaskServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TaskServiceStub(channel, callOptions);
        }
      };
    return TaskServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TaskServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TaskServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TaskServiceBlockingStub>() {
        @java.lang.Override
        public TaskServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TaskServiceBlockingStub(channel, callOptions);
        }
      };
    return TaskServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TaskServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TaskServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TaskServiceFutureStub>() {
        @java.lang.Override
        public TaskServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TaskServiceFutureStub(channel, callOptions);
        }
      };
    return TaskServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TaskServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 空请求体-String 响应
     * </pre>
     */
    public void emptyRequestToString(com.example.grpc.TaskMessage.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEmptyRequestToStringMethod(), responseObserver);
    }

    /**
     * <pre>
     * 空请求体-List&lt;String&gt; 响应
     * </pre>
     */
    public void emptyRequestToListStringList(com.example.grpc.TaskMessage.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.ListStringListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEmptyRequestToListStringListMethod(), responseObserver);
    }

    /**
     * <pre>
     * 空请求体-List&lt;List&lt;String&gt;&gt; 响应
     * </pre>
     */
    public void emptyRequestToStringList(com.example.grpc.TaskMessage.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.StringListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEmptyRequestToStringListMethod(), responseObserver);
    }

    /**
     * <pre>
     * 空请求体-Map&lt;String, List&lt;Integer&gt;&gt; 响应
     * </pre>
     */
    public void emptyToMap(com.example.grpc.TaskMessage.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.MapResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEmptyToMapMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEmptyRequestToStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.TaskMessage.Empty,
                com.example.grpc.TaskMessage.StringResponse>(
                  this, METHODID_EMPTY_REQUEST_TO_STRING)))
          .addMethod(
            getEmptyRequestToListStringListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.TaskMessage.Empty,
                com.example.grpc.TaskMessage.ListStringListResponse>(
                  this, METHODID_EMPTY_REQUEST_TO_LIST_STRING_LIST)))
          .addMethod(
            getEmptyRequestToStringListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.TaskMessage.Empty,
                com.example.grpc.TaskMessage.StringListResponse>(
                  this, METHODID_EMPTY_REQUEST_TO_STRING_LIST)))
          .addMethod(
            getEmptyToMapMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.TaskMessage.Empty,
                com.example.grpc.TaskMessage.MapResponse>(
                  this, METHODID_EMPTY_TO_MAP)))
          .build();
    }
  }

  /**
   */
  public static final class TaskServiceStub extends io.grpc.stub.AbstractAsyncStub<TaskServiceStub> {
    private TaskServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TaskServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 空请求体-String 响应
     * </pre>
     */
    public void emptyRequestToString(com.example.grpc.TaskMessage.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEmptyRequestToStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 空请求体-List&lt;String&gt; 响应
     * </pre>
     */
    public void emptyRequestToListStringList(com.example.grpc.TaskMessage.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.ListStringListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEmptyRequestToListStringListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 空请求体-List&lt;List&lt;String&gt;&gt; 响应
     * </pre>
     */
    public void emptyRequestToStringList(com.example.grpc.TaskMessage.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.StringListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEmptyRequestToStringListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 空请求体-Map&lt;String, List&lt;Integer&gt;&gt; 响应
     * </pre>
     */
    public void emptyToMap(com.example.grpc.TaskMessage.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.MapResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEmptyToMapMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TaskServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TaskServiceBlockingStub> {
    private TaskServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TaskServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 空请求体-String 响应
     * </pre>
     */
    public com.example.grpc.TaskMessage.StringResponse emptyRequestToString(com.example.grpc.TaskMessage.Empty request) {
      return blockingUnaryCall(
          getChannel(), getEmptyRequestToStringMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 空请求体-List&lt;String&gt; 响应
     * </pre>
     */
    public com.example.grpc.TaskMessage.ListStringListResponse emptyRequestToListStringList(com.example.grpc.TaskMessage.Empty request) {
      return blockingUnaryCall(
          getChannel(), getEmptyRequestToListStringListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 空请求体-List&lt;List&lt;String&gt;&gt; 响应
     * </pre>
     */
    public com.example.grpc.TaskMessage.StringListResponse emptyRequestToStringList(com.example.grpc.TaskMessage.Empty request) {
      return blockingUnaryCall(
          getChannel(), getEmptyRequestToStringListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 空请求体-Map&lt;String, List&lt;Integer&gt;&gt; 响应
     * </pre>
     */
    public com.example.grpc.TaskMessage.MapResponse emptyToMap(com.example.grpc.TaskMessage.Empty request) {
      return blockingUnaryCall(
          getChannel(), getEmptyToMapMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TaskServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TaskServiceFutureStub> {
    private TaskServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TaskServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 空请求体-String 响应
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.TaskMessage.StringResponse> emptyRequestToString(
        com.example.grpc.TaskMessage.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getEmptyRequestToStringMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 空请求体-List&lt;String&gt; 响应
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.TaskMessage.ListStringListResponse> emptyRequestToListStringList(
        com.example.grpc.TaskMessage.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getEmptyRequestToListStringListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 空请求体-List&lt;List&lt;String&gt;&gt; 响应
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.TaskMessage.StringListResponse> emptyRequestToStringList(
        com.example.grpc.TaskMessage.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getEmptyRequestToStringListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 空请求体-Map&lt;String, List&lt;Integer&gt;&gt; 响应
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.TaskMessage.MapResponse> emptyToMap(
        com.example.grpc.TaskMessage.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getEmptyToMapMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EMPTY_REQUEST_TO_STRING = 0;
  private static final int METHODID_EMPTY_REQUEST_TO_LIST_STRING_LIST = 1;
  private static final int METHODID_EMPTY_REQUEST_TO_STRING_LIST = 2;
  private static final int METHODID_EMPTY_TO_MAP = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TaskServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TaskServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EMPTY_REQUEST_TO_STRING:
          serviceImpl.emptyRequestToString((com.example.grpc.TaskMessage.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.StringResponse>) responseObserver);
          break;
        case METHODID_EMPTY_REQUEST_TO_LIST_STRING_LIST:
          serviceImpl.emptyRequestToListStringList((com.example.grpc.TaskMessage.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.ListStringListResponse>) responseObserver);
          break;
        case METHODID_EMPTY_REQUEST_TO_STRING_LIST:
          serviceImpl.emptyRequestToStringList((com.example.grpc.TaskMessage.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.StringListResponse>) responseObserver);
          break;
        case METHODID_EMPTY_TO_MAP:
          serviceImpl.emptyToMap((com.example.grpc.TaskMessage.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.TaskMessage.MapResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TaskServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TaskServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.TaskMessage.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TaskService");
    }
  }

  private static final class TaskServiceFileDescriptorSupplier
      extends TaskServiceBaseDescriptorSupplier {
    TaskServiceFileDescriptorSupplier() {}
  }

  private static final class TaskServiceMethodDescriptorSupplier
      extends TaskServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TaskServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TaskServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TaskServiceFileDescriptorSupplier())
              .addMethod(getEmptyRequestToStringMethod())
              .addMethod(getEmptyRequestToListStringListMethod())
              .addMethod(getEmptyRequestToStringListMethod())
              .addMethod(getEmptyToMapMethod())
              .build();
        }
      }
    }
    return result;
  }
}
