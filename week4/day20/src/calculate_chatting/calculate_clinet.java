package calculate_chatting;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class calculate_clinet {



    public static void main(String[] args) {

        Socket socket = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        Scanner sc = new Scanner(System.in);
        try{

            socket = new Socket("localhost",1111);// 매개변수로 프록시 등 다양한게 올 수 있네. 나는 그냥 호스트네임이랑 포트번호로 생성
            // 이거 이름이 localhost가 아니면 안되네..
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 이까지 생성해놓으면 기본 입출력을 전달받고 전달하기 위한 세팅은 끝났다.
            //  클라이언트기준으로는 나가는 메시지니까 outputMessage

            while(true){
                System.out.print("계산식 (빈칸으로 구분해서 입력) > ");
                String outputMessage = sc.nextLine();// 띄어쓰기 기준으로 숫자2개와 기호를 각각 입력받는다.

                if(outputMessage.equalsIgnoreCase("bye")){
                    System.out.println("클라이언트의 요청으로 종료합니다");
                    bw.flush();
                    break;

                }

                bw.write(outputMessage+"\n"); //   버퍼에 계산한 값을 저장, 줄바꿈안하면 어찌되는지 보자.
                bw.flush(); // 서버 소켓에다가 현재 버퍼에 있는 값을 전달.

                String inputMessage = br.readLine(); // 서버의 입력이 들어오기까지 계속 대기한다. 서버가 클라이언트의 입력값을 계산한 후 전달해준다
                System.out.println("계산결과 : "+inputMessage); // 입력이 들어오면 곧바로 서버가 입력한 문자열을 출력한다.

            }
        }catch(IOException e){
            System.out.println("ioex");
        }
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