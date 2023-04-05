package Interface;


// 삼성카드
// 놀이동산 메서드 출력

// 롯데카드
// 쇼핑, 주유, 영화, 놀이동산 기능 추가
// 주유
abstract class Card2 {

    String cardNum ;
    String cardPw;

    abstract void pay();
    abstract void signUp();
    void inorm(){}

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardPw() {
        return cardPw;
    }

    public void setCardPw(String cardPw) {
        this.cardPw = cardPw;
    }
}

interface Discount{
    void discount();
}
interface CashBack{
    void giveCash();
}
class Lotte extends Card2 implements Discount, CashBack{
    @Override
    void pay() {
    }
    @Override
    void signUp() {
    }

    @Override
    public void discount() {

    }

    @Override
    public void giveCash() {

    }
}
public class InterfaceEx02 {
    public static void main(String[] args) {
        Lotte l = new Lotte();
        l.discount();
        l.giveCash();
        l.pay();
        l.signUp();
    }
}
