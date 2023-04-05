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
    void discount(){}
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
        ArrayList<Product> p = new ArrayList<>();
        Clothe c = new Clothe("셔츠",49900);
        Food f = new Food("치킨",19800);
        Elec e  = new Elec("이어폰",199000);
        p.add(c);
        p.add(f);
        p.add(e);
        for (int i = 0 ; i<p.size(); i++){
            p.get(i).discount();
            System.out.println(p.get(i).price);
        }
        c.calculate(c.price,f.price,e.price);
    }
}
