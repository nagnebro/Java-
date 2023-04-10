package Thread_synchronized;

import java.util.Scanner;

public class Account{
    private String name; // 계좌
    private int pw;      // 비밀번호는 숫자
    private int money = 100000;   // 잔액
    Scanner sc = null;
    //출금
      synchronized void withd(String name, int pw){ // 매개변수는 비밀번호, 접근하는 사람 이름으로 설정할 것.
        // 비밀번호가 맞으면 출금액을 입력받고 출금액이 기존 돈보다 많지 않으면 출금하고
        // 기존 돈보다 출금액이 많으면 출금하지마라. 뽑으면 잔액도 출력하던가.
        if(pw == this.pw ){

            sc = new Scanner(System.in);
            System.out.println("금액을 입력하세요");
            int input = 2000;
            String answer = input>this.money ? "출금액이 많습니다." : String.format( "출금하신 분은 %s," +
                    " 현재 잔액은 %d입니다\n",name,this.money-input);
            if (input>this.money){
                System.out.println(answer);
                return;
            }
            this.money -= input;
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
        System.out.println("비밀번호 입력하세요"); // 스캐너 사용시 여러가지 문제점 발생. family thread에 관련내용 정리.
        //========================================================================다시한번 개념정리할것========
        int input = sc.nextInt();
        return input;

    }
    @Override
   public void run() {

        int pw = input(name);

        a.withd(name,pw);
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