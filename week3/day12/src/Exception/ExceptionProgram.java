package Exception;

import java.util.Scanner;

public class ExceptionProgram {
    int stockNum ;
    Scanner sc = new Scanner(System.in);
    ExceptionProgram(){}
    void updateStock() throws MyException2{
        // throws 예약어는 자신을 호출한 곳에서 예외를 처리하라고 넘겨주는 것이다.
        // subStock 메서드에서 throws를 사용했으니 updateStock메서드에서도 예외가 발생한다.
        // 그러나 이 역시도 main에서 호출했기 떄문에 thorws가 가능하다. 이떄 발생한 예외의 클래스 타입에 맞게
        // 넘겨줘야한다. 모르겠으면 Exception 쓰면 되는듯하다.

        subStock(110); // 재고수량 조정할때 마다 30씩 빼준다.

    }
    void stockManager(int stock){
        this.stockNum = stock;
    }


    void subStock(int amount) throws MyException2 {

        if(stockNum < amount){
            throw new MyException2("재고가 부족합니다"); // 고의로 예외를 발생시킨다. MyException2 클래스가 Exception클래스를
            // 상속받게 하고 상속받은 클래스로 예외 발생시키면 예외도 발생시키면서 생성자로 내가 원하는 에러메시지를 만들어낼 수 있다.

        }else{
            stockNum -= amount;
            System.out.println("재고가 수정됩니다 현재 재고 : "+stockNum);
        }
    }

    // 최종적으로 예외 처리를 해주는 곳. 기본적으로 main 메서드에서는 예외처리를 하지 않는 것이 좋다.
    // main을 실행시켜주는 녀석은 어떠한 메서드가 아닌 JVM이기 떄문이다. 그러므로 예외처리가 되지 않고 그냥 우리가 알고 있는
    // 예외가 발생하며 메인메서드는 종료된다. while 문을 사용해 동작해보면 내가 예외처리한 구문은 단순 에러메시지 출력이기 때문 무한반복되지만에
    // JVM에게 넘겨주게 되면 예외가 한번만 발생하며 메인메서드가 종료된다.
    public static void main(String[] args) throws MyException2 { // 여기서 처리하기 때문에 throws해도 여기서 처리됨.
                                                                // 만약 아래이ㅡ try-catch문을 지우면 jvm이 처리하며 예외발생.
        ExceptionProgram ee = new ExceptionProgram();
        ee.stockManager(100);

        while (true) {
            try {
                ee.updateStock();
            }catch(MyException2 e){
                    System.out.println("ㅗㅑ");
                    System.out.println("에러발생");
                    e.printStackTrace();

                }
            }
        }
    }
    // 런타임 도중 예외가 발생하는 경우 말고 사용자가 컴파일전에 예외를 던져(throw) 컴파일에러가 발생한 경우에는 당연하게도 catch문으로 처리를 해주어야한다.
    // throw는 본인이 속한 블럭(메서드나 생성자나 등등)에서 예외를 발생시켜주고 발생시켰다면 그 예외 구문을 try-catch문으로 바로 처리할 것인지
    // 혹은 본인을 호출한 메서드로 예외를 넘길 것인지 정해야한다. 이떄 예외를 발생시킬 클래스 타입은 곧 우리가 catch문으로 처리해야할 예외타입과 같거나
    // 더 상위의 클래스여야한다.


class MyException2 extends Exception{ // 예외를 발생시킬 클래스로 작성. 아래는 에러 Msg를 출력할 메서드와 생성자 정리.

    String msg;
    public MyException2(String msg) {
        //super(msg);  //Exception 부모클래스가 객체를 생성할 때
        this.msg = msg;
    }
    @Override
    public String toString() {
        return "Exception : " + this.msg;
    }
}