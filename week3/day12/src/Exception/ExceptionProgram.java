package Exception;

import java.util.Scanner;

public class ExceptionProgram {
    int stockNum ;
    Scanner sc = new Scanner(System.in);
    ExceptionProgram(){}
    void updateStock() throws MyException2{

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

    public static void main(String[] args) {
        ExceptionProgram ee = new ExceptionProgram();
        ee.stockManager(100);

        try{
            ee.updateStock();
        }catch(MyException2 e){
            System.out.println("에러발생");
            e.printStackTrace();

        }
    }
}

//============================예외 throws와 throw해줄떄 넘겨주는 클래스 타입이 어떤걸 의미하는지 정리하기============================로드


class MyException2 extends Exception{

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