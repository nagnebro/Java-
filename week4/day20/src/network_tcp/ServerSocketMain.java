package network_tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerSocketMain {

    public static void main(String[] args) {

        //클라이언트가 접속해서 정보를 가져갈 서버를 생성
        // -> TCP 통신에서 소켓으로부터 연결요청을 수락하는 서버 역할하는 클래스.
        ServerSocket serverSocket1 = null;
        ServerSocket serverSocket2 = null;

        // Binding : 수신 호스트에서 연결 요청이 들어온 경우
        // 해당 데이터를 전달할 연결 포트 지정
        // Connect : 원격지 특정 주소로의 연결을 수행

        try {
            serverSocket1 = new ServerSocket();
            serverSocket2 = new ServerSocket(20000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //#2. ServerSocket 메서드
//@bind
        System.out.println(serverSocket1.isBound());//false
        System.out.println(serverSocket2.isBound());//true
        try {
            serverSocket1.bind(new InetSocketAddress("127.0.0.1", 10000));
        } catch (IOException e) {}

        //소켓과 소켓이 연결된 상태를 바인딩이라고 한다.
        //프로그램에서 사용된 구성 요소의 실제값을 저장 하는 의미
        //함수를 호출하는 부분에서 실제 함수가 위치한 메모리를 연결하는 것.
        //바인딩은 서버소켓과 클라이언트 소켓이 연결돼서 실제 서버에 접근하거나 클라이언트에게 접근이 성공됨을 뜻한다.
        //isBound()
        // -ServerSocket이 바인딩 돼있는지 여부를 확인한다.

        //accept()
        // -연결 요청을 수락.서버소켓이 실행되고 있는 상태에서 클라이언트의 소켓을 받으면서 통신이 되는 형태.
        // -연결 수락까지 설정된 시간만큼 blocking
        // -하나의 서버에 두개의 클라이언트가 오게되면 먼저 들어온 클라이언트 소켓 만들어서 통신할 동안 기다린다.
        // 기다리는 포트는 9999번으로 설정.

        // 이 시간을 설정할 수 있다
        // -setSoTimeout(int timeout)
        // -getSoTimeout() 무한대기, 클라이언트의 요청이 올떄까지 accpet메서드가 계속 동작중인 상태.
        System.out.println(serverSocket1.isBound());//true
        System.out.println(serverSocket2.isBound());//true
        System.out.println();

        //tcp 1:1 통신.

        //사용중인 tcp포트를 확인할 수 있다. 터미널의 netstat 명령어

        for(int i = 1 ; i < 65536; i++){
            try {
                ServerSocket serverSocket = new ServerSocket(i);
                System.err.println(i+"번째 포트 사용중! ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
        try {
            serverSocket1.setSoTimeout(3000);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            Socket socket = serverSocket1.accept(); // 무한대기
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(serverSocket1.getSoTimeout()+"ms 시간이 지나 listening 종료합니다");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
