package StarCraft;

public class Main {
    public static void main(String[] args) {

        Tank t = new Tank(1000);
        Marine m = new Marine(100);
        Dropship g = new Dropship(2000);

        // 전쟁을 하다보니  체력이 많이 감소
        t.hp = 10;
        m.hp = 40;
        g.hp = 50;


        //차료해줄 사람이나 기계

        Doctor d =new Doctor(100); // 사람만 고친다.
        SCV s = new SCV(500); // 기계만 고친다

        s.repair(t); // 탱크는 기계
        s.repair(g); // 수송선은 기계
        d.heal(m);

    }
}


abstract class A{
     void a(){
        System.out.println("추상");
    }
}
interface B{
    default void c(){
        System.out.println("인터페이스");
    };
}
class C extends A implements B{

}

class AA{
    public static void main(String[] args) {
        C c = new C();
        c.a();
        c.c();
    }
}