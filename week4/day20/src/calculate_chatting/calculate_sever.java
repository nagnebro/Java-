package calculate_chatting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class calculate_sever {

    public static void main(String[] args) {

        Socket socket = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        ServerSocket serverSocket = null; // 서버측에서는 서버소켓을 가지고 있어야 통신이됨.
        Scanner sc = new Scanner(System.in);

        try{
            serverSocket = new ServerSocket(1111);
            System.out.println("클라이언트의 응답을 기다리는 중입니다....");
            socket = serverSocket.accept(); // 클라이언트의 응답을 기다린다.
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 이까지 생성해놓으면 기본 입출력을 전달받고 전달하기 위한 세팅은 끝났다.
            //  클라이언트기준으로는 나가는 메시지니까 outputMessage


            while(true){
            String inputMessage = br.readLine();
            System.out.println(inputMessage);
            String [] list = inputMessage.split(" ");
            int num1 = Integer.parseInt(list[0]);
            int num2 = Integer.parseInt(list[2]);
            int res = list[1].equals("+") ? num1+num2 : list[1].equals("x") ? num1*num2 : list[1].equals("-")? num1-num2 : 0;
            // "+"는 리터럴이 맞지만 배열이 갖고 있는 값은 리터럴이아니다.

            System.out.println(res);

            bw.write(res+"\n"); //   버퍼에 계산한 값을 저장, 줄바꿈안하면 어찌되는지 보자.
            bw.flush(); // 서버 소켓에다가 현재 버퍼에 있는 값을 전달.

            }
        }catch(IOException e){
            System.out.println("ioex");
        }
        finally {
            sc.close();  // 스캐너 닫기
            try {
                socket.close();   // 통신용 소캣 닫기
                serverSocket.close(); // 서버소캣닫기

            } catch (IOException e) {}
        }// finally 끝
    }
}
