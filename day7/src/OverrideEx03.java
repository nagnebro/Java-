class Drink{
    String name;
    int price;
    void order(){
        System.out.println("name : "+name+"이 주문됐습니다. ");
    }

    public Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
class Coffee extends Drink{
    public Coffee(String name, int price) {
        super(name, price);
    }
}

class Tea extends Drink{
    public Tea(String name, int price) {
        super(name, price);
    }
}

class Juice extends Drink{
    public Juice(String name, int price) {
        super(name, price);
    }
}


public class OverrideEx03 {
    public static void main(String[] args) {

        //커피가게
        // 주문서 (여러개의 객체를 관리하는 배열)
        // Drink클래스
        // 밑에 중복되는 내용들을 정리해서
        // 상속 구조 만들고 오버라이딩해서 출력
        // ordered


        // 커피클래스
        // 멤버 name , price
        // 메서드 ordered()
        //    name 커피가 주문되었습니다.

        // 티클래스
        // 멤버 name, price
        //메서드 ordered()
        //name 티(name)가 주문되었습니다.

        // 주스클래스
        // 멤버 name,price
        //메서드 ordered()
        //name 티(name)가 주문되었습니다.

        Drink [] d = new Drink[3];
        d[0] =  new Coffee("아메리카노",500);
        d[1] = new Tea("얼그레이티",1000);
        d[2] = new Juice("사과주스",2000);
        for (Drink tmp : d){
            tmp.order();
            System.out.println("name : " +tmp.name + " price : "+ tmp.price);
        }




    }
}


