public class PolymorphismEx01 {
    public static void main(String[] args) {

        // 다형성
        // - 업캐스팅과 똑같은 내용
        // - 하나의 참조변수로 여러 타입의 객체를 참조할 수 있는 것!
        // - 서로 상속관계를 맺고 있어야 다형성을 가지는 것이 가능하다.

        // - 형변환
        // - 조상타입 참조변수는 자손타입의 인스턴스를 참조 가능
        // - 자손타입 참조변수는 조상타입 인스터를 참조 불가능.

        // 레퍼런스 변수 (참조변수)
        Car c1 = new Car();

        // 레퍼런스 변수
        FireEngine f1 = new FireEngine();

        // 레퍼런스 변수
        Ambulance a1 = new Ambulance();

        // 참조 : 주소값을 가르킨다.
        // 조상클래스가 자손클래스를 참조하고 있으면 조상의 멤버에만 접근이 가능하다.

        // 단 아래와 같이 가능하다.
        // 자손클래스에 있는 내용에 접근하고 싶다면 자손클래스에서 오버라이딩을 하면 된다.
        Car c2 = f1;
        c2.drive(); // *****메서드는 참조변수 타입에 관계없이 인스턴스 타입의 메서드를 따라간다.*****

        Car c3 = a1;
        c3.drive();
        // drive()의 실행결과는 각각의 클래스에 오버라이딩 된 drive()메서드가 실행된다.

        // Object 클래스
        // 모든 클래스의 최고 부모이다. 자동상속이 이루어진다.

        Object o1 = new Car();
        Object o2 = new FireEngine();
        Object o3 = new Ambulance();

        // 다음과 같이 생성하게 되면 Object 클래스에 있는 멤버에만 접근할 수 있다.

        // 이렇게 다형성을 가지는 참조변수들의 인스턴스 타입을 확인하기 위한 연산자. instance of

        System.out.println(o1 instanceof Object);
        System.out.println(o1 instanceof Car);
        System.out.println(o1 instanceof Ambulance);
        System.out.println(o2 instanceof Object);
        System.out.println(o3 instanceof Object);


    }
}

class AvgTest{

    void average(int a, int b){
        System.out.println("평균은 : " +(a+b)/2);
    }

    void average(int a, int b, int c){
        System.out.println("평균은 : " +(a+b+c)/3);
    }
}

class Avg{

    public static void main(String[] args) {
        AvgTest a = new AvgTest();
        a.average(30,50);
        a.average(30,50,90);
    }
}