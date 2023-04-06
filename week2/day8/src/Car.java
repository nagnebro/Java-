
// 상속은 물려만 준다.
// 강제성이 없다. 즉 상속받은 것을 굳이 자손이 사용해야 하는 강제성이 없다는 것.

public class Car { // 자동차들의 공통적인 내용이나 기능들을 포함할 클래스
    int x= 30;
    String color;
    int door;
    int wheel;

    void drive(){
        System.out.println("운전");
    };

    void stop(){
        System.out.println("정지");
    };
}

class FireEngine extends Car{

    int x= 20;
    void drive(){
        System.out.println("FireEngine의 운전");
    } // 오버라이딩

    void water(){
        System.out.println("소화");
    }
}

class Ambulance extends Car{
    int x= 10;
    void drive(){
        System.out.println("AmbulanceEngine의 운전");
    } // 오버라이딩
    void siren(){
        System.out.println("에에엥");
    }
}

// default 제어자
// 생략이 가능하다.
// 같은 패키지에서만 접근이 가능하다.
// 값을 변경, 객체를 생성, 메서드를 호출하는 것이 가능.