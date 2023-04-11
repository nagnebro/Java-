package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsMain { // 예외처리를 넘겨주는 , 떠넘기는 throws
    public static Scanner sc = new Scanner(System.in);
    public static void fn() throws Exception{
        // 일부러 예외를 발생시키는 throw와 호출한 메서드로 예외를 넘겨주는 throws와 확실히 구분해라
        // 메서드 안에 try문을 만들어 놓으면 메서드 호출할떄마다 일일히 계속 예외를 검사해야하기 떄문에 비효율적이다. 따라서


            System.out.println("정수1입력");
            int num = sc.nextInt();

            System.out.println("정수2입력");
            int num2 = sc.nextInt();

            System.out.println(num / num2); // 두번쨰 숫자를 0으로 입력하면 0으로 나눌 수 없기 떄문에 에러발생.

            int[] arr = new int[2];
            System.out.println(arr[3]);

    }

    public static void main(String[] args) { //메인메서드는 JVM이 호출하기 떄문에 메인에서는 throws를 하지 않는다? 못한다? 확인해봐야할 듯
        try {
            fn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 예외를 함수 안에 넣고 반복적으로 호출해서 처리하는 것보다는
        // 한 곳에서 처리를 해주는 것이 좋다.
    }
}
