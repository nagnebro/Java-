package Exception_Account;


import java.util.Scanner;


class AccountException extends Exception { // 나만의 예외처리 클래스.

    String msg;

    AccountException(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}

class CheckCard extends Account{ // 얘는 말그대로 결제기능만 추가한 복사본일 뿐이다. 그러므로 조상의 참조변수로 계속 계좌정보에 접근할 수 있어야한다.

    Account a;
    // 이 프로그램을 구현하면서 체크카드의 결제기능 직전까지는 굉장히 순조로웠다. 이제 private money에 어떻게 접근할 것이며
    // 어떻게 Account에 생성된 계좌의 정보를 공유할 것인가가 주된 문제였다. 우선 문제점은 다음과 같았다.
    // - 조상의 withdraw() 메서드가 실행돼아하지만 그 withdraw로 가게되면 인스턴스 타입은 곧 CheckCard타입이 돼버린다.
    // 그래서 아래와 같이 참조변수 a를 통해 getMoney를 거쳐(사실 쟤는 빠져도 상관없음) withdraw를 실행시키게 되면
    // a의 인스턴스로 실행된다는 것이다. 이렇게 실행되면 withdraw를 참조한 참조변수가 곧 계좌의 인스턴스와 같기 때문에 동작은 문제없이 잘된다.
    // 그럼 여기서 문제점은 무엇이냐. 내가 원했던 기능은 withdraw메서드 내에서 들어온 참조변수의 타입이
    // 체크카드냐 어카운트냐를 비교하고 서로 다른 동작을 하는 프로그램을 구현하고 싶었다. 메서드 매개변수나 오버라이딩, 인터페이스 등을 고려하지 않고
    // 될듯 말듯 했기에 될 것 같은 방법을 계속 고민했으나 결국은 아래와 같이 해결했다.

    // withdraw를 실행시킬 때 메서드 매개변수를 주어 CheckCard에서 실행할 떄는 체크카드의 this를, Account에서 실행할떄는 그것의 this를
    // 주고 그렇게 인자로 들어온 this를 withdraw에서 다형성을 이용해 Account 타입의 참조매개변수로 받는다. 그리고 인스턴스 타입을 비교하게 되면
    // withdraw가 체크카드에서 실행된 것인지, 어카운트에서 실행된 것인지 구분하며 출금/계좌의 기능과 출력문구를 구분할 수 있게 된다.


    void pay() throws AccountException{

       a.getMoney(this);

    }
    public CheckCard(Account a) { // 조상타입,즉 내 계좌의 인스턴스 타입이 들어오게된다. 이제 내 카드의 인스턴스와 이 계좌의 인스턴스는 공유돼야한다.
        this.a  = a;
    }
}

class Account{

    int no;
    String name;
    private int money; // 접근 불가능한 정보
    private int pw; // 접근불가능
    static Scanner sc = new Scanner(System.in);

    public Account(int no, String name, int money, int pw) {
        this.no = no;
        this.name = name;
        this.money = money;
        this.pw = pw;
        System.out.println(this.money);
    }

    public void getMoney(Account a) throws AccountException {
        System.out.println("체크카드로 결제를 시도합니다.");
        withdraw(a); // 여기선 체크카드 인스턴스가 넘어간다


    }

    Account(){}

    void deposit(int money){ // 예금은 그냥 입금할수 있으니 굳이 입력받고 비밀번호 거치는 단계 생략한다.

        this.money += money;
        System.out.printf("입금돼 잔액이 %d 원이 됐습니다.",this.money);
    }
    private void withdraw(Account a)throws AccountException{ // 바깥의 메인메서드에서는 출금 기능에 접근해서는 안되기 때문에 제어자 private을 설정.
        if (a instanceof CheckCard ){ // 현재 조상의 메서드로 자손의 인스턴스가 들어왔다. 오버라이딩된 메서드 외에는 접근할 수 없다.
            System.out.println("체크카드로 접근하셨습니다. 결제하겠습니다.");
            this. money -= 5000; // 여기서 this는 체크카드의 this이다. 들어올떄는 체크카트 인스턴스 타입이지만 사용은 조상타입의 인스턴스로 해야한다

            System.out.printf("결제가 완료됐습니다. 결제하신 금액은 %d, 잔액은 %d입니다 \n",5000,this.money);
            return;
        }
        System.out.println("출금할 금액을 입력하세요");

        int moneyinput = sc.nextInt();
        if(moneyinput < this.money){
            this.money -= moneyinput;
            System.out.printf("출금이 완료됐습니다. 잔액은 %d입니다 \n",this.money);
        }else{
            throw new AccountException("잔액이 부족합니다");
        }


    }
    void check() throws AccountException{
        System.out.println("비밀번호를 입력하세요");
        int pwinput = sc.nextInt();
        if(this.pw == pwinput){
            withdraw(this); // 여기선 Account타입의 인스턴스가 넘어간다.
        }else{
            throw new AccountException("비밀번호가 맞지 않습니다");
        }
    }
}





public class AccountMain {
//    Class명 : Account
//    속성 : no(계좌), name(예금주), private money(잔액) 게터세터 사용?
//    생성자(기본 생성자 – 매개변수 O )
//    no=x
//    name=y
//    money=z
    // pw -
//    기능 : deposit() , withdraw()
//    deposit() : 매개변수만큼 예금(단위 만원) 입금
//    withdraw() : 매개변수 만큼 출금(단위 만원)
    //              출금액 부족하면 한도초과! 예외처리!


    // check() : 비밀번호를 입력받는다
    //  계좌등록시 입력한 비밀번호랑 현재 비밀번호 비교. 맞으면 출금함수 호출, 아니면 예외발생. "비밀번호가 맞지 않습니다 출력"

    // 위의 조건을 다 실행했으면 체크카드를 발급하는 클래스를 만들어서 번호랑 기능을 부여한다. 외부에 접근 불가능(private)한 변수로 선언.
    // account 계좌의 내용을 체크카드가 고대로 물려받는다 (뭐 계좌번호나 잔액이나 예금주 등등등 상속구조임)
    // 카드의 결제기능이 또 따로 존재한다. pay(); 결제할 카드금액을 account가 가지고 있는 출금메서드로 넘긴다. 즉 잔액에 반영된다. 결과값으로 잔액반환.
    // 카드 금액만큼 결제되면 결제 완료! 마찬가지로 잔액없으면 한도초과 (얘는 상속받으니 그대로 처리하면 되나?)


    public static void main(String[] args) {
        Account user1 = new Account(1234, "김영찬", 100000,2567);
        CheckCard card1 = new CheckCard(user1);
        user1.deposit(100000);
        while(true){
        try{
            user1.check();
            card1.pay();

        }catch(AccountException a){
            a.printStackTrace();
        }

        }
    }

}
