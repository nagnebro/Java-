package Exception;

import java.util.Scanner;

public class ThrowMain { // 일부러 예외를 발생시켜주는 thorw

    public static void check(int num) throws NumberFormatException{ // throws해주는 거랑 안하는 거랑 무슨 차이지?
        if(num < 0){
            throw new NumberFormatException("0보다 작습니다"); // 일부러 예외를 발생시켜준다.여기서 발생한 메시지는 아래의 예외처리 구문에서
            // 메시지로 넘어간다.
        }else{
            System.out.println("정상");
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자");
        int num = sc.nextInt();


        try {
            check(num); // 또 예외가 발생할 수 있다.
        }catch(NumberFormatException e){
            System.out.println("예외발생"+e);
        }
        System.out.println("정상종료입니다.");

    }
}
