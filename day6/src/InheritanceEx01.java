class 포켓몬{
    // 포켓몬의 공통적인 부분을 묶는다.
    String name; // 이름
    int hp; // 체력
    String type; // 속성
    double wei; // 몸무게
}

class 꼬부기 extends 포켓몬{
    void 물대포(){}
}
class 어니부기 extends 꼬부기{
    void 두배강한물대포(){}
}
class 거북왕 extends 어니부기{
    void 파괴광선(){}
}

class Character{
    int hp;
    int 민첩;
    int 힘;
    String id;
}

class Magician extends Character{
    void fireball(){}
}

class 마법사진화1 extends Magician{
    void thunderBolt(){}
}
class 마법사진화2 extends Magician{
    void teleport(){}
}

class 마법사진화3 extends Magician{
    void heal(){}
}

class Warrior extends Character{
    void slashAttack(){}
}

public class InheritanceEx01 {
    public static void main(String[] args) {

        //상속

        // -기존 클래스를 확장하여 새 클래스를 만든다. 간단하게 말해 상속해준 클래스의 것들을 물려받는다.
        // -공통되는 클래스들의 내용을 묶는다.
        // class 클래스명 extends 상속받고자 하는 클래스명


        //장점

        //-코드 중복 제거.
        //-확장성이 좋다.

        꼬부기 kkobuk = new 꼬부기();
        어니부기 unibuk = new 어니부기();
        마법사진화1 m = new 마법사진화1();

        System.out.println(unibuk.hp);
        unibuk.물대포(); // 꼬부기가 갖고있는 물대포 스킬도 쓸 수 있음. 상속받았기 때문.
        m.fireball(); // 기본 마법사의 스킬인 fireball 메서드를 사용할 수 있음.

    }
}
        // 히어로 클래스
        // Person 클래스
        // 이름, 나이, 키, 몸무게, 혈액형
        // 먹다, 놀다, 잔다.

class Person{
    String name;
    int height;
    int weight;
    int age;

    void eat(){}
    void sleep(){}
    void play(){}
}

class Hero extends Person{
    int speed;
    int power;
    void attack(){}
    void shield(){}
    void callAvengers(){}
}

class Hulk extends Hero{
    void powerpunch(){}
}

class IronMan extends Hero{
    void fly(){}
    void shotGun(){}
}
class Captain extends Hero{
    void throwShield(){}
}

class HeroTest{
    public static void main(String[] args) {
        Captain c = new Captain();
        Hulk h = new Hulk();

        c.callAvengers(); // Hero 클래스에 있는 메서드도 자손인 캡틴아메리카 클래스에서 사용가능한 모습.
        c.throwShield();
        h.callAvengers(); // 마찬가지로 헐크 클래스에서도 Hero 클래스의 멤버에 접근 가능.
        h.powerpunch();
        h.eat(); // 조상클래스인 Person 클래스의 메소드에 접근가능
        c.sleep(); // 마찬가지.
    }
}