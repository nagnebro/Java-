class A{
    int num;
    A(){
        // super(); 가 생략돼있음. 최고 조상은 Object 클래스
        System.out.println("a입니다"); // 조상과 자손 클래스의 생성자 실행 순서를 보기 위함.
    }
    A(int num){
        this.num = num;
    }
}

// 부모클래스에서 생성자가 생기면 부모의 변수를 초기화해서 자식클래스에 줘야된다. 이 때 이 조상의 생성자가 실행되기 전까지 자손클래스의 변수는 사용할 수 없다.
// 초기화가 되지 않았기 떄문이다. 또한 조상클래스에 생성자가 매개변수만 받는 생성자만 있다면 기본생성자를 생성해주거나 자손클래스에서 조상클래스 호출을 super();가
// 아닌 매개변수가 대입되는 생성자만 호출하게끔 해야한다.

class B extends A{
    B(){
        // super(); 가 생략돼있음. a로부터 상속받기 때문에 여기서 super();는 클래스 A의 생성자를 뜻하며 모든 클레스에는 생략돼있을 뿐 조상생성자가 있기
        // 때문에 최고조상인 Object 클래스를 제외하고는 생성자에 모두 super(); 가 새얅돼있음.
        System.out.println("b입니다");
    }
}


public class InheritanceEx02 {
    public static void main(String[] args) {

        //상속 받은 자식클래스 객체를 생성
        B b = new B();

    }
}

class Person1{
    String name;
    String age;
   // Person1(String name, String age) 이 코드를 작성시에 Person1() 기본 생성자가 생성되지 않기 떄문에 컴파일 에러발생.


    public Person1(String name, String age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person1{
    Student(String name, String age){
        super(name,age); // 무조건 첫번째 줄에 선언해야한다. 작성하지 않을 시 묵시적으로 무조건 첫째줄에서 실행됨. 인스턴스 멤버들 초기화해야 사용할 수 있으니 최우선적임.

    }
    void study(){}
}

class Teacher extends Person1{

    Teacher(String name, String age){
        // super(); 를 통해 name과 age가 초기화된 상태에서 아래코드가 실행되기 떄문에 문제가 없음.
        super(name,age);
    }

    void teach(){}
}

class School{
    public static void main(String[] args) {
        Teacher t = new Teacher("김영찬","5");
        System.out.println(t.name);
    }
}