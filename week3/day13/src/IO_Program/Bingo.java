package IO_Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Bingo {

    public static void save(int score){

        try {
            FileWriter fw = new FileWriter("scorelist",true);
            fw.write(""+score+"\n");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        int score = 100;
        int com = ran.nextInt(100) + 1;


        // 100점에서 정답을 맞출떄까지 5점 차감.
        // scorelist.txt 파일을 만들어서 점수 저장시키기.
        // FileWriter로 기록을 추가해서 작성, 아직 기록 순위를 매기라는 거는 아님.
        while (score>=0) {
            //System.out.println(com);
            System.out.println("숫자 입력[1~100] : ");
            int me = scan.nextInt();

            if (com > me) {
                System.out.println("Up!");

            } else if (com < me) {
                System.out.println("Down!");

            } else if (com == me) {
                System.out.println("Bingo!");
                save(score);
                break;
            }
            score -= 5;
            System.out.println("현재 점수 :"+ score);
        }
        System.out.println("현재 점수 :"+ score);
        System.out.println("정답 = " + com);

    }
}
