class Animal_Hospital{
    Cat c;
    Cat c1;
    Cat c2;

    Animal [] 대기표 = {new Cat(),new Dog()};


    // Animal 타입의 참조변수 배열을 생성함. 단 이때 참조변수 타입은 Animal타입이라고 할지라도 들어오는 인스턴스 타입은 다형성에 의해 자손의 인스턴스들이 들어올 수 있음.
    // line40 참고
}

class Animal{
    String name;
    int age;
}


class Cat extends Animal{
    void meow(){}
}
class Elegator extends Animal{
    void attack(){}
}
class Dog extends Animal{
    void sit(){}
}

public class UpCastingEx01 {
    public static void main(String[] args) {
        // 업캐스팅
        // -자식 객체를 부모의 타입으로 해석하는 것

        Cat c = new Cat();

        Animal a = (Animal)new Cat();  // 조상 타입의 참조변수로 자손 타입의 인스턴스를 참조가 가능하다. 다형성을 가지는 것. (Animal)의 업캐스팅은 생략돼있음.

        // Cat c1 =new Animal(); 다음과 같이 자손타입의 참조변수로 부모타입의 인스턴스를 참조할 수는 없음.
        a = (Animal)c; // 참조변수간에도 캐스팅이 가능하다. // 참조변수간에 대입은 조금 헷갈릴 수가 있는데 쉽게 생각하면 왼쪽의 참조변수가 오른쪽 참조변수의 주소를
        // 함께 참조하겠다는 것이다. 즉 a와 c 모두 c의 인스턴스의 주소를 참조하는 참조변수가 되는 것이다.
        c = (Cat)a; // 다음과 같이 자손타입의 참조변수로 부모타입의 참조변수의 주소를 참조하기 위해서는 조상타입의 참조변수를 명시적으로 다운캐스팅을 해주어야 한다.

        // 단 이때 서로 캐스팅하는 참조변수들의 인스턴스 타입은 같거나 한쪽은 null이어야한다. 한쪽이 조상이라면 한쪽은 자손일 것이고 그렇다면 서로 자손타입의 참조변수로는
        // 조상타입의 인스턴스를 저장하지 못한다.

        Animal a2= new Animal();
        Cat c2= new Cat();
        // c2 = a2; 다음과 같이는 할 수 없다. 조상타입의 참조변수가 참조하고 있는 인스턴스가 조상타입이기 떄문에 자손타입의 참조변수에 저장할 수 없다.

        Animal_Hospital ah = new Animal_Hospital();



        //=========================================참조변수 배열의 다형성 정리=============================================
        Animal [] aa = new Animal[5]; // 다시 정의해보자. 조상타입의 참조변수 배열인 aa에는 animal 타입의 참조변수가 들어올 수도 있고
        // 그 자손들의 참조변수가 들어올 수도 있다. 물론 묵시적으로 업캐스팅은 생략이 가능하다. 이때 당연하게도 인스턴스 타입은 조상과 같거나 자손일 것이기 때문에
        // 크게 신경쓸 것이 없다. 위 배열은 다음과 같다. {null,null,null,null,null}

        aa[0] = new Cat(); // 현재 nul값이 저장돼있음. 인스턴스도, 참조변수도 없는 상황. 참조변수 배열에서는 인덱스 번호가 곧 참조변수와 같은 역할이다.
        aa[1] = new Dog(); // 따라서 인덱스 번호(즉 Animal 타입의 참조변수)에 인스턴스를 저장하는 과정이다
        aa[2] = new Elegator();

        Animal [] bb = {null,null,null}; // 이 배열은 위와 같은 형태이나 직관적이라 조금 더 이해하기 쉬울 것이다.
        bb[0] = new Cat();
        bb[1] = new Dog();
        bb[2] = new Elegator();

        Animal [] cc = {new Cat(), new Dog(), new Elegator(),new Animal()}; // 다음과 같이 선언하는 것은 이미 인스턴스를 배열안에 생성한 것이다.
        // 즉 Animal[0] = new Cat(), Animal[1] = new Dog(), Animal[2] = new Elegator(); 과 같이 인스턴스를 참조변수(인덱스)에 저장한 것.
        Animal aaa = cc[0]; // cc[0]의 참조변수 타입은 Animal이므로 다음과 같이 캐스팅 없이도 저장이 가능하다. 물론 묵시적으로 (Animal)이 생략돼있다.
        Cat ccc = (Cat)cc[0]; // 하지만 자손타입의 참조변수에 저장하기 위해서는 다운 캐스팅을 해줘야한다.
        // 그렇다면 여기서 animal타입의 참조변수들로는 자손타입의 멤버들을 사용할 수 없는 것을 다음 코드를 통해 알 수 있다.
        //cc[0].meow(); 이렇게 작성해서는 컴파일 에러 발생. cc[0]의 참조변수의 타입은 Animal, 인스턴스 타입은 Cat이지만 조상타입의 참조변수로는
        // 조상타입의 멤버에만 접근할 수 있기 때문에 아래와 같이 참조변수를 다운캐스팅 해서는 자손타입의 인스턴스에도 접근이 가능하다.
        ((Cat) cc[0]).meow();



    }
}


class Parent{
    private int amount; // 비상금. 자손에서 접근하지 못하게 숨겨놓음.
    int money;
    Parent(){
        money = 100000;
        amount = money/10;
    }

    int getMoney(String s){
        if(s.equals(s)){
            return 10000;
        }
        return 0;
    }
}

class Childeren extends Parent{

}

class Test{
    public static void main(String[] args) {

        Parent p1 = new Parent();
        Childeren c1 = new Childeren();
        System.out.println(p1.money);
        // System.out.println(c1.amount; 자식타입의 참조변수로 부모의 비상금 private amount에 접근할 수 없다.

    }
}

