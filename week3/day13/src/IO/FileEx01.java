package IO;

import java.io.File;
import java.io.IOException;

public class FileEx01 {

    public static void main(String[] args) {
        //File 클래스
        // - 파일 또는 디렉터리 (폴더) 생성, 삭제 및 이름 변경
        // 디렉터리 내용 나열 등의 기능을 제공하는 file 클래스

        // File file = new File("[\디렉토리명\]");
        File file = new File("test1");

        //  만약 지정위치에 파일이 존재하면 false
        //                   없으면   true

        try {
            boolean res = file.createNewFile(); // 파일이 없을 수도 있기 때문에 컴파일에러 발생하므로 예외처리 해줘야한다.
            System.out.println(res);// 없으면 true를 반환한 후에 곧바로 생성하는 원리이다. 그래서 2번쨰 실행부터는 false가 출력된다.
            if (res){
                System.out.println("파일이 생성완료합니다");
            }else{
                System.out.println("기존 파일이 있습니다..");
            }

            // exists()  파일의 존재 유무를 묻는 메서드. 위의 create 메서드는 없으면 생성하는데 얘는 정말로 있는지만 묻는 것.
            if(file.exists()) {
                System.out.println("파일의 이름 : " + file.getName());
                System.out.println("파일의 경로 : " + file.getAbsolutePath());
                System.out.println("파일 쓰기 가능? : " + file.canWrite());
                System.out.println("파일 읽기 가능? : " + file.canRead());
                System.out.println("파일 크기 : " + file.length());
            }else {
                System.out.println("파일이 없습니다...");
            }
            //file.mkdir();
            // 디렉터리 mkdir()
            // 새 폴더를 생성
        } catch (IOException e) { //  file클래스를 다루면서 발생할 수 있는 모든 예외를 처리하기 위해 IOException 선언.
            throw new RuntimeException(e);
        }

    }





}
