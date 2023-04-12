package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 입출력 스트림은 자바 프로그램이 종료된 후에도 사용자가 입력한 데이터를 저장하기 위해 사용한다.
        // 스트림은 데이터를 바이트나 문자 형태로 저장할 수 있다.

        // 스트림(데이터 이동하는 통로)
        // input -> 외부에서 자바프로그램안으로 가지고 들어온다.( 읽기 )
        // output -> 자바프로그램 안에서 외부로 나간다.( 쓰기 )
        // InputStream input = null;

        /*
            파일을 생성할 때 파일이 기존에 있는 경우
            그 안에 있는 내용을 싹! 지우고 현재 저장되는 내용만 저장
            파일이 없다! 파일을 생성하고 내용저장.
         */
        // 문자 (텍스트 파일)
        Scanner sc = new Scanner(System.in);
        FileWriter fw = null; // try 문 밖에 써놓지 않으면 try의 바깥 블럭에선 실행될 수 없다. 1. 파일을 생성한다.
        String io = "./io/"; // 절대경로를 저장하는 문자열.
        String fileName = sc.next();
        try {
            fw = new FileWriter(io+fileName); // 파이썬의  open함수와 비슷한 것 같네.내가 파일을 읽어올 경로와 파일명

            fw.write("김철수/10, 이영희/30, 박박박민수/50"); // 실행하고 나면 경로의 시작지점에 파일이 생성된다.2. 파일 내용 저장
            fw.write("\n졸리다..\t");
            fw.write("아  잠온다");

            fw.close();// 3. 파일을 닫는다.
        } catch (IOException e) {
            e.printStackTrace();

        }
        System.out.println(fw);
    }


}
//public abstract class InputStream extends Object implements Closeable{
//
//    // 자식 클래스들이 구현해야할 read 추상 메서드
//    // 바이트 하나를 읽어서 int로 반환하되, 더 이상 읽을 값이 없으면 -1을 리턴.
//    public abstract int read() throws IOException;
//
//    // len 바이트의 데이터를 읽어서 배열 b에 off 위치부터 집어넣기 (off위치는 배열 b의 index라고 생각하면 됨)
//    // 읽은 바이트 개수를 반환하되, 더이상 읽을 값이 없으면 -1을 리턴
//    public int read(byte[] b, int off, int len){
//    	...
//    }
//
//    //byte b의 길이만큼 데이터를 InputStream으로부터 읽어들여 byte 배열 b에 삽입.
//    //읽은 바이트 개수를 반환하되, 더이상 읽을 값이 없으면 -1을 리턴
//    public int read(byte[] b) throws IOException {
//    	...
//
//    }
//    // InputStream을 닫는역할.
//    public void close() throws IOException{
//    	...
//    }
//    ...
//
//}