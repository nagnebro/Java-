package Abstract;

abstract class Animal{
    String name;
    String getName(){
        return name;
    } //그러니까 추상 메서드는 그냥 자손에서 메소드를 오버라이딩 하려고 하는데
    // 거기에 강제성을 부여함으로서 오버라이딩을 하지 않는 일이 없게끔 만든다. 즉 무조건 구현해야하는 메서드는
    // 추상메서드로 선언해야하는 편이 코드를 작성할 때 도움이 된다.
    abstract void bark(); // 자손에서 반드시 구현해야하는 추상메서드. 오버라이딩 해야함.

    void introduce(){ // 공통적으로 toString을 통해 강아지와 개의 이름 및 정보에 대한 문자열이 반환된 후에 추가적으로 문장끝에
        // "이다" 라는 문자열을 추가해야하는 상황에서는 조상클래스에서 공통적으로 결과값을 주는 것이 낫다. 이때 헷갈렷던 것이 자손 클래스에서 super든 메서드든
        //  어떠한 경로를 통해서 조상클래스로 갔을떄는 조상클래스의 멤버만 사용할 수 있지 않냐는 것이었다. 즉 조상타입의 참조변수로 자손타입의 인스턴스를 참조하는
        // 것과 비슷한 원리이지 않을까 생각했다.
        // 캣과 도그에 다른 메서드 선언해놓고 animal에서 실행되는지 확인하기.
        System.out.print(this.toString()+"이다 "); // 이 부분에 대해선 코드해석이 조금 필요한 듯 하다.
        bark();
        // this.dog(); // 인스턴스 타입에 따라 메서드가 어떻게 실행되는지 알 수 있음. 조상의 dog()를 자손에서 오버라이딩 한 후이기 때문에 자손의 인스턴스가
        // introduce 메서드 내로 들어오게 되면 자손의 dog가 실행되고 만약에 조상에 dog()가 오버로딩이 돼있지 않으면 실행이 되지 않는다
        // 이 과정을 보면 위의 this.toString()이 어떻게 동작하는지 어느정도 이해할 것이다.
    }

    Animal(String name){
        this.name = name;
    }
}
class Cat extends Animal{

    int age ;
    void bark(){
        System.out.println("야옹");
    }



    public String toString(){// Cat과 Dog에서 구현해야하는 toString의 내용이 다르기 떄문에
        // 각각의 클래스에 다른 toString을 오버라이딩 하는데 이때 Animal클래스에 toString을 정의해놨다면
        // 오버라이딩 일 것이고 안해놨으면 Object클래스의 오버라이딩이다. 그러나 굳이 Animal 클래스에서는
        // toString을 정의할 필요가 없다고 판단해 하지 않았다. 다만 추상메서드로 선언할 수는 있을 것이다.
        return String.format("%d살의 %s",age,name); // age+" 의 "+name
    }

    Cat(String name,int age){
        super(name);
        this.age = age;
    }
}
class Dog extends Animal{
    String type;
    void bark(){
        System.out.println("멍멍");
    }
    void dog(){
        System.out.println("도그의 개");
    }
    public String toString(){ // 역시 Object클래스의 toString을 오버라이딩.
        return String.format("%s의 %s",type,name);
    }

    public Dog(String name, String type) {
        super(name);
        this.type = type;
    }
}

public class AbstractEx01 {
    public static void main(String[] args) {
        Dog d = new Dog("단추", "시츄");
        Cat c = new Cat("묘묘",6);
        d.bark();
        c.bark();
        System.out.println(d.getName());
        System.out.println(c.getName());
        System.out.println(d);
        System.out.println(c);
        c.introduce();
        d.introduce();
    }
}
