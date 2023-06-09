package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

    public static void clientex(){
        BufferedReader in = null;
        BufferedWriter out = null;
        System.out.println("클라이언트 메인메서드 실행");
        Socket socket = null;
        Scanner sc = new Scanner(System.in); // 키보드에서 읽을 내용

        try {
            // 클라이언트 소캣 생성 , 서버에 연결 (자동연결됨)
            // 둘 중 하나라도 없으면 연결X 소캣은 생성된다!
            socket = new Socket("localhost",1111); // 서버와 클라이언트의 포트 내용이 다르면 실행되지않는다.

            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            out = new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream()));

            while(true) {
                System.out.print("클라이언트 >");

                // 클라이언트로 부터 한 행 씩 읽기!
                // 클라이언트가 먼저 시작!
                String outputMessage = sc.nextLine(); // 클라이언트가 입력을 시작해야 서ㅈ버쪽에서 소켓의 요청을 받아들이며 대화가 시작된다.

                if(outputMessage.equalsIgnoreCase("bye")) {
                    out.flush();
                    break; // 서버로 전송 후 끝내기!
                }
                out.write(outputMessage +"\n"); //
                out.flush(); // 만약 bye 안해도 전송 , 사용자가 엔터키를 누른 것은 버퍼에 저장한다는 뜻에서 입력만 끝낸거고 버퍼에서
                // 넘겨줘야하기 떄문에

                // 서버에서생 한 행 수신
                String inputMessage = in.readLine();
                System.out.println("서버:" + inputMessage);

            }
        } catch (IOException e) {}
        finally {
            sc.close();  // 스캐너 닫기
            try {

                if(socket != null) socket.close();   // 통신용 소캣 닫기

            } catch (IOException e) {
                System.out.println("서버와 채팅 중 오류가 발생했다!");
            }
        }// finally 끝

    }
}
