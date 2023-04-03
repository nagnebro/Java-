class Animal{

    String name;
    void cry(){}
}

class Pet extends Animal{
    int age;
    int price;
    void play(){};

    public Pet(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }


}


public class InheritanceEx03 {
    public static void main(String[] args) {
        Pet p = new Pet("차우차우",5,200000);
        System.out.printf("{name : %s, age : %d, price : %d}",p.name,p.age,p.price);
    }
}


class Elf{
    String name;
    int hp;
    @Override public String toString(){
        return "[엘프] Name :"+name+", HP: "+hp;
    }


    public Elf(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

}

class HighElf extends Elf{
    int mp;
    @Override public String toString(){
        return "[하이엘프] Name :"+name+", HP: "+hp+", MP: "+mp;
    }

    public HighElf(String name, int hp, int mp) {
        super(name, hp);
        this.mp = mp;
    }
}
class ElfLord extends HighElf{
    int shield;
    @Override public String toString(){
        return "[엘프로드] Name :"+name+", HP: "+hp+", MP: "+mp+", shield: "+shield;
    }


    public ElfLord(String name, int hp, int mp, int shield) {
        super(name, hp, mp); // 생성자를 이렇게 초기화하는 것과 super();로 먼저 기본값으로 초기화 한후에 밑에서
        // this.name = name; this.hp = hp; this.mp = mp; 로 하는 것중에 아무래도 super(name,hp,mp)의 경우가 더 간결하고
        // 좋은 것 같다. 심지어 이렇게하면 조상의 기본 생성자는 생성하지 않아도 된다. 어차피 매개변수를 가진 조상의 생성자만 호출하게끔 돼있기 때문이다.

        this.shield = shield;
    }
}

class ElfTest{

    public static void main(String[] args) {

        Elf elf = new Elf("티란데",100);
        HighElf highelf = new HighElf("말퓨리온",200,100);
        ElfLord elflord = new ElfLord("마이헤브",300,200,100);

        System.out.println(elf);
        System.out.println(highelf);
        System.out.println(elflord);
    }
}

class Cylinder{
    int radius;
    int height;

    void getVolume(){
        System.out.printf("원기둥의 부피 : %d\n",radius*height*2);
    };
    void getArea(){
        System.out.printf("원기둥의 겉넓이 : %.2f\n",radius*height*3.14);
    };
    // 수식은 찾기 귀찮아서 그냥 대충 내 마음대로 출력.
    public Cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }
}
class CylinderTest{
    public static void main(String[] args) {
        Cylinder c = new Cylinder(202,103);
        c.getArea();
        c.getVolume();
    }
}

class Food{
    String name;
    int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String toString(){
        return "{ name : "+name+", price : "+price+"원 }";
    }
}
class FoodTest{
    public static void main(String[] args) {
        Food f1 = new Food("치킨",23000);
        Food f2 = new Food("피자",13000);
        Food f3 = new Food("초밥세트",33000);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
    }
}

class Bike{
    String name;
    int price;

    public Bike(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String toString(){  // 오버라이딩한 메서드는 참조변수의 인스턴스 타입에 해당하는 메서드가 실행되기 때문에 bike 타입의 인스턴스가
        // 오버라이딩 된 메서드를 실행하면 bike 클래스의 toString()이 실행되고 motorBike타입의 인스턴스가 toString을 실행하면
        // motorBike타입의 toString이 실행된다. 다만 지금은 MotorBike에 toString이 정의돼있지 않기 떄문에 조상(bike)의 toString()을
        // 사용하는데 이떄 인스턴스 타입은 다르기 떄문에 결과값은 원하는대로 출력된다. 하지만 인스턴스별로 조금씩 출력이 달라져야한다면 toString()메서드는
        // 클래스별로 개별 작성해줘야할 것이다.

        return "name : "+name+", price : "+price;
    }
}
class MotorBike extends Bike{
    MotorBike(String name, int price){
        super(name,price);
    }

}
class BikeTest{
    public static void main(String[] args) {
        Bike b = new Bike("알톤",5000);
        MotorBike m = new MotorBike("가와사키",15000);
        System.out.println(b);
        System.out.println(m);
    }
}