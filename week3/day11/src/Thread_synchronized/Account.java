package Thread_synchronized;

import java.util.Scanner;

public class Account extends Thread{
    private String name; // 계좌
    private int pw;      // 비밀번호는 숫자
    private int money = 100000;   // 잔액
    Scanner sc = null;
    //출금
      synchronized void withd(String name){ // 매개변수는 비밀번호, 접근하는 사람 이름으로 설정할 것.
        // 비밀번호가 맞으면 출금액을 입력받고 출금액이 기존 돈보다 많지 않으면 출금하고
        // 기존 돈보다 출금액이 많으면 출금하지마라. 뽑으면 잔액도 출력하던가.
//          try {
//              Thread.sleep(1100);
//          } catch (InterruptedException e) {
//              throw new RuntimeException(e);
//          }
          sc = new Scanner(System.in);
          System.out.println("비밀번호를 입력하세요");
          int input = sc.nextInt();

          if(input == this.pw ){
                sc = new Scanner(System.in);
                System.out.println("금액을 입력하세요");
                int input2 = sc.nextInt();
                String answer = input2>this.money ? "출금액이 많습니다." : String.format( "출금하신 분은 %s," +
                " 현재 잔액은 %d입니다\n",name,this.money-input2);
                if (input2>this.money){
                    System.out.println(answer);
                    return;
                }
                this.money -= input2;
                System.out.println(answer);
          }
    }



    public Account(String name, int pw) {
        this.name = name;
        this.pw = pw;
    }
}


//엄마가 10만원 뽑으면 내 통장의 돈은90만원
// 아빠가 20뽑으면 70만원
class ATM extends Thread{
    Account a; // 고객정보 받는 참조변수
    String name; // 이용하는 사람의 정보
    Scanner sc = new Scanner(System.in);


//    synchronized int input(String name){
//
//        try {
//            sleep(1000);
//            // 불가능함을 알 수 있다.
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } System.out.println("비밀번호 입력하세요");
//        return 5263; // 계좌의 비밀번호를 임의로 설정. input으로 설정해도 된다.
//
//    }
    @Override
   public void run() {

        a.withd(name); // 이게 중요하다.

        //a.withd(name,pw);
    }

    public ATM(Account a, String name) {
        this.a = a;
        this.name = name;
    }
}

class AccountTest {
    public static void main(String[] args) {
        Account a = new Account("1251125",5263);
        ATM aa = new ATM(a, "김영찬");
        ATM aa2 = new ATM(a, "김영찬2");
        ATM aa3= new ATM(a, "김영찬3");
        ATM aa4 = new ATM(a, "김영찬4");
        aa.start(); // start()이기 때문에 멀티스레드로 동시접근 할 것이다. 그렇게 되면 문제가 발생할 수 있다.따라서
        aa2.start();
        aa3.start();
        aa4.start();
    }
}