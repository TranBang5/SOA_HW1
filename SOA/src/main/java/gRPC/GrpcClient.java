package gRPC;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext()
            .build();

        CalculatorServiceGrpc.CalculatorServiceBlockingStub stub =
            CalculatorServiceGrpc.newBlockingStub(channel);

        CalculatorRequest request = CalculatorRequest.newBuilder().setA(5).setB(3).build();
        CalculatorResponse response = stub.add(request);

        System.out.println("Addition Result: " + response.getResult());
    }
}
