package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    public static void main(String[] args) {

        // 파일읽기

        FileReader fr = null;
        String name = "./io/name";
        BufferedReader br = null; // 중간에 버퍼 생성(임시저장공간)  -> 파일을 쓸때는 상관없지만 파일을 읽어올때는 버퍼가 있어야하는건가
        try {
            fr = new FileReader(name); // 확장자명 쓰면 안되네

            //  자식 클래스들이 구현해야할 read 추상 메서드
            // 바이트 하나를 읽어서 int로 반환하되, 더 이상 읽을 값이 없으면 -1을 리턴
            br = new BufferedReader(fr); // FileReader랑 버퍼랑 연결됨
            String str = br.readLine(); // 한줄씩 읽기, 버퍼에 파일리더의 참조변수가 있고 그걸 통해 한줄씩 읽는 듯하다.
            System.out.println(str);
            str = br.readLine(); // 한줄씩 읽기, 버퍼에 파일리더의 참조변수가 있고 그걸 통해 한줄씩 읽는 듯하다.
            System.out.println(str);

            fr.close(); // 파일을 닫아준다.
            br.close(); // 버퍼도 닫아주어야 한다.

        } catch (IOException e) { // 스트림의 조상에 있는 IOException 타입으로 에러 처리함.
            e.printStackTrace();
        }

    }
}


