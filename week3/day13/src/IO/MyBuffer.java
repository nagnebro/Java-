package IO;

import java.io.*;
import java.nio.Buffer;

public class MyBuffer {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        //문자기반 파일 클래스

        FileReader fr = null;
        FileWriter fw = null;
        try {

            fr = new FileReader("./for");
            fw = new FileWriter("./for");
            BufferedReader bin = new BufferedReader(fr);
            BufferedWriter bout = new BufferedWriter(fw);

        } catch (IOException e) {
            System.out.println(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("실행시간 : "+(end-start)/1000.0);
    }
}
