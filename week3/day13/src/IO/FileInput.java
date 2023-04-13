package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInput {

    public static void main(String[] args) {

//        String str = "Hello Java Programming" ;

        // 파일을 바이트로 출력하는 스트림이 있다.

        // 입출력은 문자기반이냐 바이트기반이냐에 따라 처리 속도 및 범위가 다르다

        // 문자기반일 경우 2byte 사용, 바이트기반의 경우 8byte? 이다.  >>> 한번 더 개념 정리 해야할 듯 하다. 스트림과 입출력, 파일에 관련해서


        // Stream을 사용하면 writer reader buffer를 번갈아가며 사용하지 않고 좀 더 간단하게 파일에 접근할 수 있다.
        try {
            File file = new File("gugudan"); // 구구단을 읽어 온다.
            if (!file.exists()) { // 파일이 있는지 확인
                file.createNewFile(); // 새로운 파일은 있는지 묻고 없으면 생성.
            } // 아래에서 inputstream으로 파일을 읽어와야하기 떄문.

            FileInputStream fos = new FileInputStream(file);
            // InputStream과 OutputStream은 추상클래스이다.


            // null 나오기 전까지 읽어오기

            int i = 0;
            // read() 데이터를 읽을 것이 없다면 -1

            while((i =fos.read()) != -1) {// fos.read가 -1이라면 데이터가 없다는 뜻
                // 즉 데이터가 있을 동안, 출력할 문장이 있을 동안 while 문 실행
                // fos.read는 한글자씩 아스키코드값(정수형)으로 반환하는 형태인 것 같다.
                // br.readLine과 마찬가지로 처음부터 읽고나면 다음으로 넘어가는 식이며 다 읽엇다면 null대신 -1을 반환
                System.out.print((char)i); // 숫자형태로 저장돼있을 것이다.
                // char 형변환을 안해줄 시 아스키코드 값에 해당하는 숫자가 나오기 떄문에 형변환 해줘야한다.
            }

            fos.close();

            System.out.println("정상적");

            }catch(IOException e){
            System.out.println("파일에 대한 예외발생.");
        }

    }
}


