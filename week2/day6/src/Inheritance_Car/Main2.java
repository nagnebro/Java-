package Inheritance_Car;

class HyundaiTest {
    public static void main(String[] args) {
        Avante a = new Avante("white","branc","G",5);
        System.out.println(a.color);
        System.out.println(a.brand);
        Grandeur g = new Grandeur();
        Genesis g2 = new Genesis();
        g2.genesis();

    }
}


