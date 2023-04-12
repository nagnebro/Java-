package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 예외처리
        // - 비정상적인 종료를 막기 위해서 ! 사용하는 것!

        // 에러(error) : 개발자가 해결할 수 없는 치명적인 오류
        // 예외(exception) : 개발자가 해결할 수 있는 오류
//        Compile Error: 컴파일 시점에서 발생하는 에러로 소스코드를 컴파일러가 컴파일하는 시점에서 소스의 오타나 잘못된 구문, 자료형 체크등 검사를 수행하는데
//        여기서 발생하는 에러를 컴파일 에러라 하며 이 시점에서 발생하는 문제들을 수정 후 컴파일을 성공적으로 마칠경우 클래스 파일(*.class) 파일이 생성된다.
//        Runtime Error: 프로그램 실행 시점에서 발생하는 에러로 컴파일러는 컴파일 시점에서 문법 오류나 오타같은 컴파일시점에서 예측가능한 오류는 잡아줄 수 있지만,
//        실행 중 발생할 수 있는 잠재적인 에러까지 잡을 순 없다.
//        그래서 컴파일은 문제없이 완료되어 프로그램 실행이되고 실행도중 의도치않은 동작에 대처하지못해 에러가 발생할 수 있다.
//

//        에러(Error): 메모리 부족(OutOfMemoryError)이나 스택오버플로우(StackOverflowError)와 같이 일단 발생하면 복구할 수 없는 심각한 오류
//        예외(exception): 인자값 Null 에러NPE(NullPointException)같은 발생하더라도 수습이 가능한 덜 심각한 오류.


//        에러와 예외의 정확한 차이는 무엇인가 ? 위의 컴파일에러와 런타임에러가 있다면 우리가 프로그램 실행전 실행 후 발생하는 것은 모두 에러라는 말인데
//        위의 문맥을 봤을때는 런타임 에러, 컴파일 에러 모두 예외를 뜻하는 듯하다. 객체와 인스턴스처럼 조금 의미가 중복적으로 사용되는 것 같다.


//        Logical Error: 소스 코드 컴파일도 정상적으로 되고 런타임상 에러가 발생하는 것도아닌 개발자의 의도와는 다르게동작하는 에러를 뜻한다.
//        버튼을 클릭하면 팝업이 뜨게 만들었으나 팝업이아닌 새로운 페이지가 뜨거나 아무동작을 안하거나 하는 것처럼 시스템상 프로그램이 멈추거나 하지는 않지만,
//        의도와는 다르게 동작하는 것을 말한다.

        // try ~ catch문
        /*
            try{
                예외가 발생할 수 있는 문장;
            }catch(){
                발생한 예외를 처리하는 문장;

            }
         */
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("정수1입력");
            int num = sc.nextInt(); // 발생할 수 있는 에러1, nextInt()메서드에 String이 들어올 수도 있음. 아래 스캐너도 마찬가지.

            System.out.println("정수2입력");
            int num2 = sc.nextInt();

            System.out.println(num / num2); // 두번쨰 숫자를 0으로 입력하면 0으로 나눌 수 없기 떄문에 에러발생.

            int[] arr = new int[2]; // 발생할 수 있는 에러2, 인덱스 번호가 벗어날 수 있음. 아래 arr[3]도 마찬가지.
            System.out.println(arr[3]); //
        }// 예외가 발생할 수 있는 부분의 전체를 try블럭으로 감싸준다.
        catch(Exception e){// Exception 클래스를 이용해서 업 캐스팅 해준다, 그러면 자손들의 예외가 발생해도 예가 실행된다.
            System.out.println(e.getMessage());
        }
        System.out.println("메인 정상 종료");


    }
}
//        catch(IndexOutOfBoundsException e){
//            System.out.println("예외처리");
//            System.out.println(e.getMessage()); // 발생한 에러메시지를 가지고 문자열 형태로 가지고온다.
//        }catch(InputMismatchException e){ // 에러를 발생시킨 클래스의 참조변수, 인스턴스 타입이 catch문의 매개참조변수와 같은지 비교한다.
//            System.out.println("문자를 입력해서 에러발생");
//            System.out.println(e.getMessage());
//        }catch(ArithmeticException e){
//            System.out.println("0을 입력했습니다");
//            System.out.println(e.getMessage());
//        }
