package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {

    public static void main(String[] args) {
        // 간단한 채팅 프로그램
        //  서로 한번씩 번갈아 가면서 문자열 전송과
        //  문자열 끝에 \n 덧붙여 보내고 라인 단위로 수신
        //  종료 (bye) 클라이언트가

        BufferedReader in = null;
        BufferedWriter out = null;
        ServerSocket listener = null;
        Socket socket = null;
        Scanner sc = new Scanner(System.in); // 키보드에서 읽을 내용

        try {
            // 서버 생성
            listener = new ServerSocket(2222);
            System.out.println("연결을 기다리고 있습니다.....");
            // 클라이언트로 부터 연결 요청 대기 무한대기중! 시간설정하면 일정 시간 요청으 대기하다가 소켓을 닫아버림.
            socket = listener.accept(); // socekt타입의 결과값을 반환하는 accpet()메서드.
            // 클라이언트 쪽에서 메인메서드를 실행시킴과 동시에 설정한 포트번호의 소켓이 동작되면서 서버도 동작할 준비를 마친 상태.
            System.out.println("hi");


            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            out = new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream()));
            while(true) {
                // 클라이언트로 부터 한 행 씩 읽기!
                String inputMessage = in.readLine(); // 이 메서드떄문에 서버에서는 먼저 입력을 넘겨줄 수 없음
                // 즉 클라이언트의 메시지를 읽기전까지 내가 메시지를 보낼 수가 없음. 따라서 대화 순서가 클라이언트> 서버 로 진행됨

                if(inputMessage.equalsIgnoreCase("bye")) {
                    System.out.println("클라이언트가 bye로 연결 종료!");
                    break;
                }
                System.out.println("클라이언트:"+inputMessage); // 클라이언트로부터 읽은 문자열을 출력함.
                System.out.print("서버>");
                String outputMessage = sc.nextLine(); //서버가 입력하는 메시지
                out.write(outputMessage +"\n"); // 서버로부터 받은 입력을 bufferwiter로 버퍼에다가 작성해줌.
                out.flush(); // 모든 내용을 전송!
            }

        }catch(IOException e) {	}
        finally {
            sc.close();  // 스캐너 닫기
            try {
                socket.close();   // 통신용 소캣 닫기
                listener.close(); // 서버소캣닫기

            } catch (IOException e) {}
        }// finally 끝
    }
}
