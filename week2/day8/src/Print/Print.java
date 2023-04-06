package Print;

public interface Print {

    void print(String p);  // 흑백
}


interface ColorPrint extends Print{ // 인터페이스 간 상속이 가능.
    void color(String p);
}



interface Print3D extends Print,ColorPrint{ // 심지어 인터페이스는 다중상속이 가능하다.
    // 새로운 기능이 추가될때 마다 인터페이스를 다중상속하면서 문제가 없게끔 만들어준다.
    void three_d(String p);
}

// 다만 자바 몇버전? 이상부터는 interface가 추상클래스와 개념이 모호해지게끔 만든 업데이트를 했다.
// 바로 위와같이 다중상속을 받을 수 있더라도 결국엔 새로운 기능이 추가 될떄마다 새로운 기능을 가진 인터페이스를 생성해야하기 때문에
// 인터페이스의 개수가 많아질 수 밖에 없다. 그래서 다음과 같이 가능하게 만들었다.

interface Test1{
    void test1();
    void test2();
    default void test3(){ // 메서드에 제어자 default를 추가하면 우리가 추상클래스에 abstract를 붙이지 않고 일반 메서드를 작성한 것과 같은 상태를 뜻한다.
        // 따라서 인터페이스를 구현한 Test1Test 클래스에서 오버라이딩 해주지 않아도 된다.
        // 물론 인터페이스는 그래도 상수만 작성할 수 있고 제어자가 생략돼있는 등 추상클래스와 구분점이 있기는 하지만 인터페이스에 저 기능이 추가된 후로 어느정도
        // 그 경계가 모호해졌다는 것.
        System.out.println("오버라이딩 안해도 된다.");
    }
}

class Test1Test implements Test1{
    public void test1(){}
    public void test2(){}
}

class TT {
    public static void main(String[] args) {
        Test1Test t = new Test1Test();
        t.test3();
    }
}
