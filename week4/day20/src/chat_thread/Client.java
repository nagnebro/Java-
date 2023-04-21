package chat_thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    // 소캣 , 필터스트림(선)

    private Socket clinetSocket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public Client(Socket temp){
        this.clinetSocket = temp;
        try {
            // 서버가 나한테 응답해주는 거
            dataInputStream = new DataInputStream(clinetSocket.getInputStream());

            // 내가 서버한테 요청하는 것! (전화걸기)
            dataOutputStream = new DataOutputStream(clinetSocket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }// 클라이언트 생성자의 끝.

    public void send(String message){

        // 익명클래스
        // -이름이 없는 클래스 1회용  -> 인터페이스도 단 1회에 안해 인스턴스를 생성할 수 있게 해주는?
        Runnable thread = new Runnable() { // 익명클래스
            @Override
            public void run() {

                try {
                    dataOutputStream.writeUTF(message); // 인코딩 변환해서 문자열을 내보내기 위해 writeUTF메서드 사용.
                } catch (IOException e) {

                }
            }
        };
        Server.threadpool.submit(thread);
        // 여러개의 스레드를 관리하는 pool

    }
    public void receive(){

        Runnable thread = new Runnable() {// 굳이 thread클래스를 상속받을 필요가 없다. 그냥 run()메서드만 필요한 거기 떄문에
            @Override
            public void run() {
                try{
                    // 메시지 수신을 계속 반복적으로 한다.
                    while(true){

                        String recvData = dataInputStream.readUTF();
                        System.out.println("메시지 수신 성공");
                        // getRemoteSocketAddress()연결된 시스템에 대한 주소를 반환한다.
                        System.out.println(clinetSocket.getRemoteSocketAddress()+ Thread.currentThread().getName()); // 스레드에 대한 현재 정보를 가지고 옴.

                        for (Client client : Server.clientlist){
                            client.send(Thread.currentThread().getName() + recvData);
                        }
                    }
                }catch(IOException e){

                }
            }
        };//run의 끝
        Server.threadpool.submit(thread);

    }

}

