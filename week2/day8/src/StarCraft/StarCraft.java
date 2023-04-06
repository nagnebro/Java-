package StarCraft;
/*

    빈 인터페이스
    marker interface
    상속관계가 아닌 클래스들을 그룹화 시켜줄 수 있다.

 */

// 여러가지 클래스간의 연결관계를 맺어주기 위해 인터페이스가 필요함.

// ===========================abstract 개념에 대해 확실히 정리할 것====================

public class StarCraft {
//    void show(){
//        System.out.println("탱크 : "+ t.hp);
//        System.out.println("마린 : "+ m.hp);
//        System.out.println("드랍십 : "+g.hp);
//    }

}


class Terran extends StarCraft{}
class Zerg extends StarCraft{}
class Protoss extends StarCraft{}
// 여기서 테란 저그 프로토스와 스타크래프트는 그냥 상속관계를 확인하기 위해서 작성한 것일 뿐 아래의 unit클래스와는 관계없으니 참고.


interface Repairable{} // 기계들만 고치기 위해 구분시켜줄 인터페이스
interface Medical{} // 사람들만 치료하기 위해 구분시켜줄 인터페이스

abstract class Unit {
    // 공격성을 가진 아이들은 모두 유닛.

    final int maxhp ;
    int hp ;
    String name;
    int x,y;

    abstract void attack();
    abstract void move();
    Unit(int hp){
        this.maxhp = hp;
    } // 상수를 생성자에서 초기화
    Unit(){
        maxhp = 0; // 자손에서 super();를 호출하기 떄문에 기본 생성자에서도 상수를 초기화
    }
}
class Marine extends Unit implements Medical{
    @Override
    void attack(){} // 반드시 초기화해야하는 Unit 클래스의 추상 메서드 attack과 move
    void move(){}

    public Marine(int hp) {
        super(hp);
    }
}
class Tank extends Unit implements Repairable{ // 탱크는 유닛이면서 수리 가능한 기계에 속한다.
    @Override
    void attack(){}
    void move(){}

    public Tank(int hp) {
        super(hp);
    }

}

class Doctor extends Unit implements Medical{
    void heal(Medical m){// 다른 방벙으로 작성하려면 매개변수로 Unit u로 받고 난 후에 instanceof를 이용해서 작성해도 된다. 메디칼 인터페이스와
        // 들어온 참조변수의 타입이 같은지 확인하는 조건문을 넣으면 된다.
        Unit u = (Unit)m ;
        while (u.hp <= u.maxhp) {// 객체별로 다른 최대체력을 갖고 있기 떄문에.
            System.out.println(u.hp++);
            try {
                Thread.sleep(1); // 프로그램을 약간 지연시킨다. 단위는 ms 1초는 1000ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("치료완료");
    } //사람만 고친다
    @Override
    void attack() {}

    public Doctor(int hp) {
        super(hp);
    }

    @Override
    void move() {}

}

class Dropship extends Unit implements Repairable{
    void move(){}
    void attack(){}
    public Dropship(int hp) {
        super(hp);
    }

}


class SCV extends Unit implements Repairable {
    @Override
    void attack() {}

    @Override
    void move() {}

    void repair(Repairable r) { // repairable 타입의 참조변수 r로 자손타입의 인스턴스를 받아온다.
        Unit u = (Unit)r; // 현재 r 안에는 tank타입의 인스턴스가 있다고 치자. 현재 tank는 조상으로 Unit클래스도 상속받고 있고
        // 인터페이스 Repairable도 구현하고 있다. 따라서 참조변수의 타입으로 Unit으로 받아도 되고 ㅅRepaiable로 받아도되지만 Unit으로 받아버리게
        // 되면은 바이오유닛(마린,메딕)같은 애들도 같이 매개변수로 들어올 수 있기 때문에 Repairable타입으로 매개변수를 받아야 한다.
        // 그러나 여기서 탱크의 hp에 접근하기 위해서는 참조변수의 타입을 바꿔줘야 한다. 그래서 인터페이스 Repairable타입에서 클래스 Unit타입으로
        // 캐스팅을 해주는 것이다 (애초에 이게 가능한지는 몰랐다.) 이후에는 참조변수는 Unit타입이 되므로 Tank클래스에서 오버라이딩한 메서드와
        // Unit의 멤버는 이용할 수 있는 u라는 참조변수가 새로 선언되는 것이다.
        while (u.hp <= u.maxhp) {// 객체별로 다른 최대체력을 갖고 있기 떄문에.
            System.out.println(u.hp++);
            try {
                Thread.sleep(1); // 프로그램을 약간 지연시킨다. 단위는 ms 1초는 1000ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("수리완료");

    }
    public SCV( int hp){
        super(hp);
    }
}
/*

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
 */