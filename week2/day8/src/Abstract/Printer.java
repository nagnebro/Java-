package Abstract;


abstract class Printer{
    abstract void print();
}

class Samsung extends Printer{ // 추상클래스인 Printer 클래스를 상속받기 위해서는 1. 추상메서드를 오버라이딩하던지 2. 추상 클래스화 하던지
    void print(){
        System.out.println("삼성 프린터");
    };
}

abstract class Lg extends Printer{
    // 추상메서드를 오버라이딩 할 것이 아니라면 클래스를 추상클래스로 선언해야한다.
    // 추상클래스로 선언하기 싫다면 Print클래스의 print 메서드를 오버라이딩 해라.
}


