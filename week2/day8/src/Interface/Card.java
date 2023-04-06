package Interface;

public abstract class Card {

    private String cardNumber; // 카드번호
    String cardName;
    private String cardPw;
    int cvc;

    abstract void pay();
    abstract void save();
    // setter , getter


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardPw() {
        return cardPw;
    }

    public void setCardPw(String cardPw) {
        this.cardPw = cardPw;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
}


// 현대카드의 기능, 쇼핑 주유
interface Shopping{ // 쇼핑 기능을 가진 인터페이스

    void shop();
}

interface Point{ // 포인트 적립 기능을 가진 인터페이스
    void plusPoint();
}
interface Movie{ // 영화 기능을 가진 인터페이스

}

// 상속과 구현의 순서는 상속을 먼저하고 구현하는 것이다.
class Hyundai extends Card implements Shopping,Point,Movie{
    @Override
    void pay() {
        System.out.println("현대카드 결제");
    }

    @Override
    void save() {
        System.out.println("현대카드 적립");
    }

    @Override
    public void shop() {
        System.out.println("쇼핑시작");
    }

    @Override
    public void plusPoint() {

    }
}

class Test{
    public static void main(String[] args) {
        Hyundai h = new Hyundai();
        // Card c = new Card();  추상클래스는 인스턴스를 생성할 수 없다. 오버라이딩이 돼있고 안돼있고의 문제가 아니고 그냥 안된다.
    }
}



