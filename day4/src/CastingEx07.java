
/*

    변수의 종류
    reference types
    레퍼런스 변수(참조변수) - 객체를 가리키는 변수, 특정 객체를 간접적으로 가리키는 변수

    기본형(primitive types)
    특정값을 직접 저장.

 */

class Bank {

    // 은행의 계좌 정보는 외부에서 수정돼서는 안된다. 즉 프로그램을 캡슐화 시켜줘야 한다. 접근 제어자에 대한 개념의 시작.
    // Bank 그 자체에서 말고 다른 클래스에서 참조변수를 이용한 접근을 금지시킨다.!!!!!!!!
    // 그러므로 접근하고자 하는 클래스 내부에서 참조변수를 선언하고 그 참조변수를 이용한 static 메서드를 이용해 접근한다
    // 보통 값을 바꾸는 기능을 하는 메소드를 setter, 값을 가져오는 것을 getter라고 한다.
    private String accName;
    private String accNum;
    private String accPw;
    private int balance= 1000000;

    Bank() { }
    int givemoney(int money){
        if(this.balance>=money) {
            this.balance -= money;
        }
        System.out.println(money+"원을 출금합니다");
        return this.balance;
    }

    int innermoney(int money){
        this.balance += money;
        System.out.println("잔액은 : "+this.balance);
        return this.balance;

    }
    Bank(String accName, String accNum, String accPw, int balance) {
        this.accName = accName;
        this.accNum = accNum;
        this.accPw = accPw;
        this.balance = balance;
    }

    void info() {
        System.out.println("계좌명     : " + accName);
        System.out.println("계좌번호    : " + accNum);
        System.out.println("계좌비밀번호 : " + accPw);
        System.out.println("잔액      : " + balance + "원");
    }
}



public class CastingEx07 {

    public static void main(String[] args) {
        Bank yeong = new Bank();
        // yeong.balance = 50000; 다음과 같이 직접적인 접근이 불가능하다.
        yeong.givemoney(5000);
        yeong.innermoney(5000000);
        yeong.givemoney(5000);
        //객체에 변수를 직접 저장한 것이 아니라 함수를 이용해 간접적으로 저장했음.


    }
}

class Wallet{
    private int money = 100000;
    void outmoney(int money){
        if(this.money>=money){
            System.out.println("출금합니다 출금전 잔액은  "+this.money+" 출금후 잔액은 "+(this.money-money)+"입니다");
            this.money -= money;

        }
    }
}

class BankTest{
    public static void main(String [] args){

        Wallet w = new Wallet();
        w.outmoney(40000);
    }
}