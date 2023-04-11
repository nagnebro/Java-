package InnerClass_membertest;

import java.util.Scanner;


class AccountException extends Exception {

    String msg;

    AccountException(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}



class Account{

    int no;
    String name;
    int money;
    private int pw;
    static Scanner sc = new Scanner(System.in);

    public Account(int no, String name, int money, int pw) {
        this.no = no;
        this.name = name;
        this.money = money;
        this.pw = pw;
        System.out.println(this.money);
    }


    Account(){}

    void deposit(int money){ // 예금은 그냥 입금할수 있으니 굳이 입력받고 비밀번호 거치는 단계 생략한다.

        this.money += money;
        System.out.printf("입금돼 잔액이 %d 원이 됐습니다.",this.money);
    }
    private void withdraw()throws AccountException{ // 바깥의 메인메서드에서는 출금 기능에 접근해서는 안되기 때문에 제어자 private을 설정.

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
            withdraw();
        }else{

            throw new AccountException("비밀번호가 맞지 않습니다");
        }
    }

    //앞전의 예제를 내부클래스로 구현. 그러나 withdraw()실행하는 부분에서 매개변수 없이 접근하려니 여전히 문제발생
    // 내부클래스에서 실행된 외부 클래스의 메서드에서는 인스턴스 타입이 달라진다.
    class CheckCard{ // 얘는 말그대로 결제기능만 추가한 복사본일 뿐이다. 그러므로 조상의 참조변수로 계속 계좌정보에 접근할 수 있어야한다.

        String CardNum ;
        // 생성자보다 얘네 변수 초기화가 더 빠르다. 그래서 다음과 같이 초기화하려 했도 참조변수 값이 없어서 안된다.
        // 체크카드가 들어갔을 떄 조상의 멤버를 어떠헥 초기화하고 조상의 값을 계속 참조하면서 체크카드읹 아닌지를 구분할 것인지
        // 혹은 Account를 넘기고 체크카드 구분하는 법을 찾을ㄹ것인지
        void pay() throws AccountException{
            if (true ){ // this에는 account 인스턴스 타입만 들어온다.
                //   System.out.println( this ins);
                System.out.println("체크카드로 접근하셨습니다. 결제하겠습니다.");
                money -= 5000; // 여기서 money는 외부클래스의 money이다. 내부 클래스로 선언헀기에 다음과 같이 pricate money에 그냥 접근이가능한것
                // 그러나 withdraw에 매개변수를 받기는 좀 그렇다
                System.out.printf("결제가 완료됐습니다. 결제하신 금액은 %d, 잔액은 %d입니다 \n",5000,money);
                return;
            }
        }



    }

}





class AccountMain {
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
        Account user1 = new Account(1234, "김영찬", 100000,1111);
        Account.CheckCard card1 = user1.new CheckCard(); // 내부 클래스에 접근하는 체크카드 참조변수. 이떄 user1이라는 참조변수를 통해
        // 접근됐으므로 체크카드 클래스 밖의 어카운트 클래스를 참조하는 참조변수는 user1의 주소와 같은 것이다.
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
