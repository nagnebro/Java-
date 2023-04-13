package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {

    public static void main(String[] args) {

//        String str = "Hello Java Programming" ;

        // 파일을 바이트로 출력하는 스트림이 있다.  -> 여기서 출력한다는 건 컴퓨터에 파일로써 작성한다는 것이다.

        // 입출력은 문자기반이냐 바이트기반이냐에 따라 처리 속도 및 범위가 다르다

        // 문자기반일 경우 2byte 사용, 바이트기반의 경우 8byte? 이다.  >>> 한번 더 개념 정리 해야할 듯 하다. 스트림과 입출력, 파일에 관련해서


        //
        try {
            File file = new File("gugudan"); // 구구단 파일을 만들어라.
            if (!file.exists()) { // 파일이 있는지 확인 , 없으면 만들고 있으면 그냥 넘겨라.( 위에서 이미 file 선언하면서 생성한 거 아닌가?)
                file.createNewFile(); // 새로운 파일은 있는지 묻고 없으면 생성.
            }

            FileOutputStream fos = new FileOutputStream(file); // file을 작성하기 위한 writer라고 생각하면 됨.
            // 그것이 문자기반의 스트림이 아닌 바이트 기반의 스트림이 OutputStream?이다

            for (int i = 2 ; i<10; i ++){
                for (int j =1; j<10 ; j++){

                    String str = i+" x "+j+" = "+ i*j + "\n";

                    // 문자열 str을 byte타입으로 저장.
                    // write 메서드의 매개변수로는 int나 byte타입의 배열만 올 수 있다. 따라서 문자열을 바이트타입(아스키코드값)으로
                    // 치환한 숫자를 저장할 배열에다가 저장시키고 작성한다. 이 때 문자든 숫자든 모두 아스키코드값으로 저장되기 때문에
                    // write할 떄 알아서 아스키코드를 변환 후 파일을 작성하기 때문에 문자든 숫자든 구분없이 잘 작성되는 것이다.
                    byte [] b = str.getBytes();
                    System.out.println(b.length);
                    fos.write(b); // 바이트로 변경한 것을 그떄그떄 fos를 통해 작성한다.

                }
            }



            fos.close();

            System.out.println("정상적");

            }catch(IOException e){
            System.out.println("파일에 대한 예외발생.");
        }

    }
}


