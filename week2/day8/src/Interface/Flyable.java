package Interface;

public interface Flyable{
    void fly();

}

class Bird1 implements Flyable{
    @Override
    public void fly() {
        System.out.println("새가 난다");
    }

}
class Helicopter implements Flyable{
    @Override
    public void fly() {
        System.out.println("헬기가 힘차게 난다");
    }
}
class Rocket implements Flyable{
    @Override
    public void fly() {
        System.out.println("로켓이 우주로 간다.");
    }
}


class FlyableTest{
    public static void main(String[] args) {
        Bird1 b = new Bird1();
        Helicopter h = new Helicopter();
        Rocket r = new Rocket();

        b.fly();
        h.fly();
        r.fly();

    }
}