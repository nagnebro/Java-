package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTest {
    // 메모장에 1. test.txt 파일명으로 하고 폴더는 현재 기본폴더로 설정
// 1번 줄 출력했습니다.
// 2번줄 출력했습니다.
// 3번줄 출력했습니다.
// 100번줄 출력했습니다.  저장

//저장(문자만 저장)

//2 . 읽기 반복문.


// 3. 김철수/20, 이만수/30, 이영희/40 이렇게 입력된 텍스트를 문자열 구분으로 아래와같이 배열로 나눠라. 그리고 그 정보를 반복문으로 출력해라.
/*

    String [] names = {"김철수","이만수","}
    int [] ages = {20, 30, 40}
 */
// 파일명  student. txt

// 읽을떄 이름 : 김철수
//   나이 : 20
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("./for");
            for (int i = 1; i<=100 ; i++){
                fw.write(i+"번째 문장입니다\n");

            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(fw);
    }


}

class FileTest2{
    public static void main(String[] args) {


        try {
            FileReader fr = new FileReader("./for");
            BufferedReader br = new BufferedReader(fr);

            for (int i = 1 ; i <=100; i++) { // while 돌려도 null되면 알아서 꺼지나?
                String str = br.readLine();
                System.out.println(str);
            }
            fr.close();
            br.close();
        } catch (IOException e) { //FileNotFoundException e 으로 설정돼있을건데 IOException으로 바꿔줘여한다.
            throw new RuntimeException(e);
        }
    }
}


class FileTest3{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String [] student_list = null;
        String [] name = null;
        int [] age = null;
        FileWriter fw = null;
        FileReader fr = null;


        try {


            fw = new FileWriter("./student");
            fr = new FileReader("./student");
            BufferedReader br = new BufferedReader(fr);
            System.out.println("학생 정보를 입력하세요");
            String input1  = sc.next();

            fw.write(input1);
            // 현재 여기서는 프로그램을 입력값에 내가 접근할 수 있게끔 했지만 사실은 readlines로 읽어오는게 맞다. 근데 어차피 그 readlines
            // 한번만 읽어오면 결과는 똑같다.
            fw.close(); // close를 해야 입력값이 제대로 넘어간다.
            String input = br.readLine(); //readline을 통해 파일에 쓰인 값을 읽어온다.
            System.out.println(input);
            int length = input.split(",").length;
            name = new String[length]; // 배열로 받게되면 길이를 생성할떄 좀 거슬리는 부분이 있다. 물론 미리 넉넉하게 잡아도 되지만 사용자가
            //입력을 어떻게 줄지 모르기 때문에 최대한 안전하게 입력값을 확인한 후에 length만큼 배열을 생성한다.
            //하지만 이렇게되면 좀 껄끄럽기 때문에 차라리 name과 age를 ArrayList를 사용하면 길이를 지정할 필요없이 set()메서드만 사용하면 된다.
            age = new int[length]; // 입력값의 길이, 즉 학생수만큼 입력값을 받는다.
            student_list = new String[length];
            System.out.println("학생 정보 읽어오기를 시작합니다");

            student_list = input.split(","); //컴마 기준ㅇ로 나눈 문자열을 임시저장.
            for (int i = 0; i< length ; i++) {
                 // input을 ,기준으로 자르면 학생 수가 나오고 그 수만큼 어레이리스트에 추가.
                name[i] = student_list[i].split("/")[0];
                age[i] = Integer.parseInt(student_list[i].split("/")[1]);

            }

            for (int i = 0 ; i<name.length; i++){
                System.out.println("이름 : " +name[i]);
                System.out.println("나이 : " +age[i]);
            }

            fw.close();
            fr.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}