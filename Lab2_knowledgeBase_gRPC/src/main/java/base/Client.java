package base;

import grpc.base.BaseGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        // сначала строим соединение с сервером
        // с помощью Channel мы подключаем клиента к серверу
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        // далее создаём клиента
        BaseGrpc.BaseBlockingStub client = BaseGrpc.newBlockingStub(channel);
        
        Gui app = new Gui(client);
        app.setVisible(true);
    }
}
