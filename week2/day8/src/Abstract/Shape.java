package Abstract;



public abstract class Shape {
    // 도형 클래스
    // draw() 메서드를 추상화 한다.
    // 정삼각형을 그린다.
    // 정사각형을 그린다.
    abstract void draw(); // 추상 메서드로 선언함으로서 자손클래스에서 무조건 구현하게끔 강제성을 부여
    void color(){
        System.out.println("색을 칠합니다");
    }  // 도형을 색칠하는 메서드. 굳이 색칠하는 기능은 없어도 되니까 추상메서드가 아닌 일반 메서드로 선언함.
}

class Triangle extends Shape{

    void draw(){
        System.out.println("삼각형을 그립니다.");
    }
}
class Circle extends Shape{

    void draw(){
        System.out.println("원을 그립니다.");
    }
}
class Square extends Shape{

    void draw(){
        System.out.println("사각형을 그립니다.");
    }
}

class ShapeTest{
    public static void main(String[] args) {
        Triangle t = new Triangle();
        Circle c = new Circle();
        Square s =new Square();
        t.draw();
        c.draw();
        s.draw();
        s.color();
    }
}


