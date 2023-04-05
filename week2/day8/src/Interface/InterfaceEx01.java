package Interface;

// interface 인터페이스명
// 인터페이스의 멤버
// - 상수 (final)
// - 추상메서드만 가능
// - 객체 생성X

// 자바에서 클래스는 다중상속을 허용하지 않기 떄문에 interface로 공통요소를 묶어내는 것이 필요하다

interface Alarm{
    // 상수의 경우 public static final 이 변수앞에 생략돼있고
    // 메서드의 경우 public abstract가 생략돼있음
    // 생략된 제어자 부분은 컴파일러가 실행시에 추가해준다.

    int num = 0; // 상수기 때문에 선언과 동시에 초기화 해줘야 한다.
    void beep(); // 추상메서드만 가능.
    void playMusic();
}

class SmartPhone implements Alarm{
    @Override
    public void beep() { // 인터페이스의 추상메서드는 public abstract가 생략돼있다. 즉 접근제어자가 Public이므로 오버라이딩할때 접근제어자의
        // 범위가 같거나 더 넓은 걸 사용해야 한다. 따라서 접근제어자의 범위가 가장 넓은 Public을 붙여준다.

    }

    @Override
    public void playMusic() {

    }
}

public class InterfaceEx01 {
//    인터페이스란
//    -인터페이스란, 역할을 부여하는 것이다.
//    -인터페이스는 추상 메소드로 구성된다.
//    추상 메소드란
//    -중괄호 내부가 없는 껍데기 메소드이다.
//    -인터페이스 정의 및 구현
//    -인터페이스 구현 시, implements 키워드를 사용한다.
//    -해당 인터페이스(역할)를 구현하는(부여받은) 클래스를 구현체 클래스라 한다.
//    -구현체 클래스는 모든 추상 메소드를 오버라이딩(재정의)해야 한다.
//    -인터페이스의 장점
//    -프로그램 설계의 명확성
//    -서로 다른 객체에게 관계성 부여(업캐스팅 가능)
//    -한 객체를 다양한 인터페이스로 해석 가능(다형성)
    public static void main(String[] args) {

    }

}
