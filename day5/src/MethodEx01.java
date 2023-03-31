import java.util.Random;
import java.util.Scanner;

public class MethodEx01 {
    public static void main(String[] args) {
        /*
            메서드(함수)
              - 일련의 코드를 단순화한 문법
              - 반복되는 명령문들을 묶었다.
              - 어떤 문제를 처리하기 위한 방법을 소스코드로 묶어놓고 필요에 따라서 동작하는 기능
         */

        //한 학생의 세과목의 점수에 대한 평가를 하기 위해서는 같은 평가를 3번 반복해야한다

        int [] scores = new int[3];
        Scanner sc = new Scanner(System.in);
        System.out.println("국어, 수학, 영어 중 과목 점수를 차례로 입력하세요");
        int [] scores2 = {55,77,88,99,33};
        scores[0] = sc.nextInt();
        scores[1] = sc.nextInt();
        scores[2] = sc.nextInt();
        String str = null;
        // 여기서 서로 다른 학생들의 점수를 입력받기 위해서는 문제가 발생한다. 등급을 판별하는 조건식과 for문이 반복되기 떄문이다.
        // 따라서 같은 기능을 하는 메서드 grade를 작성하였다.
        for ( int i = 0; i<scores.length ; i++){
            if(scores[i]>=90){
                str = "A";
            }else if(scores[i]>=80){
                str = "B";
            }else if(scores[i]>=70){
                str = "C";
            }
            System.out.println(str);
        }//scores의 등급을 판별.

        for( int i = 0; i<scores2.length;i++){
            System.out.println("등급은"+ grade(scores2[i])+" 입니다");
        }

        //scores2의 등급을 판별.

    }
    public static String grade(int score){
        String str = null;
        if(score>=90){
            str = "A";
        }else if(score>=80){
            str = "B";
        }else if(score>=70){
            str = "C";
        }else{
            str = "F";
        }
        return str;
    }
}