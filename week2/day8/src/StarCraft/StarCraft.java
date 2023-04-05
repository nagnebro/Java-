package StarCraft;



// 여러가지 클래스간의 연결관계를 맺어주기 위해 인터페이스가 필요함.

// ===========================abstract 개념에 대해 확실히 정리할 것====================

class Test{
    public static void main(String[] args) {
        StarCraft st = new StarCraft();
        st.show();
    }
}
class Terran extends StarCraft{}
class Zerg extends StarCraft{}
class Protoss extends StarCraft{}


public class StarCraft {

    public Tank t = new Tank();
    public Marine m = new Marine();
    public Dropship g = new Dropship();
    public void show(){
        System.out.println("탱크 : "+ t.hp);
        System.out.println("마린 : "+ m.hp);
        System.out.println("드랍십 : "+g.hp);
    }

}

abstract class Unit {
    // 공격성을 가진 아이들은 모두 유닛.

    final int maxhp = 100;
    int hp = maxhp;
    String name;
    int x,y;

    abstract void attack();
    abstract void move();
}

class Marine extends Unit{
    @Override
    void attack(){}
    void move(){}
}
class Tank extends Unit{
    @Override
    void attack(){}
    void move(){}
}

class Dropship extends Unit{
    void move(){}
    void attack(){}
}