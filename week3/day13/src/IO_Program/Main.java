package IO_Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void save(int hak){
        FileWriter fw = null;
        try {
            fw = new FileWriter("hakbunlist",true);
            fw.write(""+hak+"\n");
            fw.write(hak); // 이러면 새로 열고 새 파일에 계속 작성하는 거 아닌가?

            fw.close();
        } catch (IOException e) {
            e.getMessage();
        }

    }
    public static void main(String[] args) {
        // 학번을 입력 받아서 파일로 저장을 하고 읽어오는 코드를 작성해보자.

        int [] hak_list = new int[5];
        int count = 0;
        Scanner sc = new Scanner(System.in);


        for ( int i = 0; i<5 ; i++) {
            System.out.println("1. 파일저장 2. 파일 읽기 3. 학번 조회 4. 학번 추가");
            int input = sc.nextInt();


            switch (input) {
                case 1:
//                    FileWriter fw = null;
//                    // 학번, 문자로 텍스트 파일로 hakbunlist.txt
//                    try {
//                        fw = new FileWriter("hakbunlist");
//
//
//                       // fw.write(hak); // 이러면 새로 열고 새 파일에 계속 작성하는 거 아닌가?
//
//                        fw.close();
//                    } catch (IOException e) {
//                        e.getMessage();
//                    }

                    break;
                case 2:
                    break;
                case 3:

                    //학번 리스트 읽어오기

                    try {
                        FileReader fr = new FileReader("hakbunlist");
                        BufferedReader br = new BufferedReader(fr);
                        String str = null;
                        while((str = br.readLine()) != null) { // 읽어올 문자열의 값이 null이 아니라면 버퍼를 통해 계속 파일의 줄을 읽어온다.
                            System.out.println(str);
                            fr.close();
                        }
                    }catch (IOException e) {
                        //throw new RuntimeException(e); 왜 얘잇으면 에러 발생하지?
                    }
//                    for ( int j = 0; j<hak_list.length; j++){
//                        System.out.println(hak_list[j]);
//                    }
                    break;
                case 4:
                    System.out.println("학번입력");
                    int hak = sc.nextInt();
                    hak_list[count++] = hak;
                    save(hak);
                    break;
                default:
                    System.out.println("제대로 입력하세요");
            }
        }// 메뉴를 5번 반복하면 메인메서드가 종료되면서 사용자에게 입력받은 학번이 모두 삭제된다. 따라서 그 전에 데이터를
        // 다른 형태로 저장해야할 필요성이 있는것이다.

    }
}
