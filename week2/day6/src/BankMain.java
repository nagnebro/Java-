//Bank.java 파일의 Bank 클래스를 상속받음.

public class BankMain {
    public static void main(String[] args) {
        Bank acc1 = new Bank();
        CheckCard accCard1 = new CheckCard();

        acc1.accName = "계좌명";
        accCard1.cardPw = 1234;

    }
}
