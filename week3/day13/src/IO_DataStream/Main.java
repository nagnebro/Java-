package IO_DataStream;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 기초 타입 데이터를 읽는 메서드와 기초 타입 데이터를 기록하는 메서드를 사용할 수 있는 스트림. ->Datainput,Dataoutput 스트림
        // 자료형이 다른 몇개의 데이터를 파일에 출력했다가 다시 출력하기 - > 뭔 소리야 이게


        DataInputStream in = null;
        DataOutputStream out = null;

        // 내용물, fos 는 인풋 아웃풋에서 읽어올 파일에 대한 정보임
        try {

            FileOutputStream fos = new FileOutputStream("data.bin");     // input, output stream 객체가 하나 있어야된다.
            out = new DataOutputStream(fos);
            out.writeInt(123);
            out.writeDouble(123.456);
            out.writeBoolean(true);
            out.writeBytes("안녕안녕안녕...");
            out.close();

//            FileInputStream fis = new FileInputStream("data.bin");
//            in = new DataInputStream(fis);

            int aint = in.readInt();
            double adouble = in.readDouble();
            System.out.println(aint);
            System.out.println(adouble);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
