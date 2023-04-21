package network_tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class ClientSocketMain {

    public static void main(String[] args) {

        //클라이언트 소켓 생성
        try {
            Socket clientsocket = new Socket("128.12.1.1",9999);

            //소콋으로 데이터를 전솔할 입출력 스트림 생성
            // 1. 버퍼, 입출력
            BufferedReader in = new BufferedReader((new InputStreamReader(clientsocket.getInputStream())));

            //저장 , 내보내기
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientsocket.getOutputStream()));

            out.write("hello\n");
            out.flush(); //스트림속의 데이터 모두를 전송. 버퍼에게 저장하고 있는 내용을 모두 출력하라고 지시하는 메서드
            // 버퍼의 저장공간이 65000비트인데 다 찰떄까지 기다려싿가 데이터를 전송하면 비효율적이니 그때그떄 계속 보내게 해주는 메서드.
            clientsocket.close();

            //소켓으로 데이터를 전송할 입출력 스트림 생성.
        }catch (UnknownHostException e){}
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
