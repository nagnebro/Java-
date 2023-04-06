package Interface;


import java.util.ArrayList;

interface  Array{
    void discount();
}
class Product{
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    void calculate(int food, int elec, int clothe){
        System.out.println("총합 : "+(food+elec+clothe));
    }

}
class Food extends Product implements  Array{
    public Food(String name, int price) {
        super(name, price);
    }

    @Override
    public void discount() {
        price = (int)(price*0.9);
    }
}

class Elec extends  Product implements Array{
    public Elec(String name, int price) {
        super(name, price);
    }

    @Override
    public void discount() {
        price = (int)(price*0.8);
        System.out.println(price);
    }
}

class Clothe extends Product implements Array{
    public Clothe(String name, int price) {
        super(name, price);
    }

    @Override
    public void discount() {
        price = (int)(price*0.7);
    }
}




public class Calculate {

    public static void main(String[] args) {
        ArrayList<Array> p = new ArrayList<>();
        Clothe c = new Clothe("셔츠",49900);
        Food f = new Food("치킨",19800);
        Elec e  = new Elec("이어폰",199000);
        p.add(c); // 인덱스 번호가 있을텐데 인덱스번호로 포문돌려서 배열에 추가하는게 더 효율적일듯하다.
        p.add(f);
        p.add(e);
        for (int i = 0 ; i<p.size(); i++){
            p.get(i).discount();
            System.out.println(((Product)(p.get(i))).price); // p.get(i)는 Array타입의 참조변수 따라서 Array의 멤버밖에 사용하지 못함.
            // 위의 discount는 오버라이딩이 됐지만 변수 price에는 접근못함.
            // 따라서 위와같이 참조변수를 Product타입으로 캐스팅 해줘도 되지만 조금 번거롭네. 애초에 실습 자체가 interface를 사용하라는 조건이
            // 있었기 떄문에 discount를 추상메서드로 선언하기는 했는데 조금 모호한 것 같다.
        }
        c.calculate(c.price,f.price,e.price);
    }
}
