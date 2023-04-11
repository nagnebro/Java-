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
          try {
              Thread.sleep(1100);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          sc = new Scanner(System.in);
          System.out.println("입력");
          int input = sc.nextInt();


          if(input == this.pw ){


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


    synchronized int input(String name){
        for ( int i = 0 ; i < 1000000; i++) {

        }
        System.out.println("시작");

        // 스레드에 synchronized 제어자를 붙여도 그것이 그 메서드의 완전한 락을 의미하지는 않는다. 보통 우리가 일반적인 메서드에 접근할때는
        // 프로그램이 위에서 아래로 순차적으로 작동하지만 thread는 동시다발적으로 실행된다. 이 때 싱크로나이즈가 해주는 역할은 단지 거의 동시에 run메서드가
        // 실행된 후 모든 스레드가 그 메서드에 접근하려고 할떄 하나의 객체만 그 메서드를 이용할 수 있게 잠깐(?)이나마 시간을 벌어주는 것 뿐이다.
        // 완전한 락이 되지는 않는다는 것. 그래서 synchronize붙은 input메서드에 sleep로 지연을 시켜도 결과는 똑같다. 단지 3초뒤에 withd() 메서드가
        // 실행되는 것 뿐이다. 이것의 방법론적인 것에 대한 공부가 더 필요할 듯 하다.

        // int input = sc.nextInt();
        // 위와 같이 스캐너를 통해 출금할 가격을 입력받아도 계좌 잔액에 대한 출금에 대해서 문제가 생기진 않는다. 비밀번호를 입력하러 접근한 사람이 김영찬 1인지
        // 2인지 3인지 4인지는 매번 다르지만(즉 비밀번호를 입력하는 현재 내가 누군지 모름 그러나 이것은 어차피 입력하는 디스플레이는 개개인의 atm기에 출력
        // 될 것이므로 문제가 되지 않는다.) 어쩄든 4명이 동시에 같은 비밀번호를 입력해서 출금을 하더라도 잔액이 정상적으로 반영이 된다는 것.
        // 기능적인 부분에서는 정상 작동한다.

        try {
            sleep(1000);  // <- 다음과 같이 지연시켜도 동시에 이 메서드에 접근 하기 떄문에 synchronize가 의미가 없다.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } System.out.println("비밀번호 입력하세요");
        return 5263; // 계좌의 비밀번호를 임의로 설정. input으로 설정해도 된다.

    }
    @Override
   public void run() {

        a.withd("김영찬");

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
        aa.start(); // start()이기 때문에 멀티스레드로 동시접근 할 것이다. 그렇게 되면 문제가 발생할 수 있다.
        aa2.start();
        aa3.start();
        aa4.start();
    }
}