class Shape{
    String name; // 도형의 이름.

    double area(){
        return 0;


    }
    public String toString(){
        return "name : "+name;
    }
    Shape(){}
    public Shape(String name) {
        this.name = name;
    }
}

class Square extends Shape{
    double line;
    @Override
    double area(){
        return line*line;
    }

    public Square(String name, double line) {
        super(name);
        this.line = line;
    }
}

class Circle extends Shape{
    double r;
    @Override
    double area(){
        return r*r*3.14;
    }

    public Circle(String name, double r) {
        super(name);
        this.r = r;
    }
}
class Triangle extends Shape{
    double line, height;
    //not Override
    double area(){
        return (line*height)/2;
    }


    public Triangle(String name, double line, double height) {
        super(name);
        this.line = line;
        this.height = height;
    }
}

public class OverrideEx02 {

    // 클래스 shape
    // 멤버변수 name
    // 멤버메서드 area
    //    return double
    // 클래스로 사용!

    // 정사각형은 도형 shape
    // 클래스 이름:square
    //  멤버 변수 :한변의 길이 변수명
    //  area 오버라이딩해서 넓이 구하시오!

    // 삼각형 도형
    // triangle
    // 밑변,높이 멤버변수
    //  area 오버라이딩해서 넓이 구하시오!

    // 원 도형
    // Circle
    // 반지름 멤버변수
    // area 오버라이딩해서 넓이 구하시오!

    // 위에있는 아이들의 그룹(업캐스팅)업캐스팅해서 배열에만 도형정보 담아보라ㅏ.
    // 반복문과 배열을 이용해서
    // 코드의줄을 4줄 안쪽으로 작성해보세요!
    // 부모의 방에 도형들의 정보를 저장한다. 즉 인스턴스를 저장한다.

    public static void main(String[] args) {
        Shape [] shape_list = new Shape[3];
        Circle c = new Circle("circle",4);
        Triangle t = new Triangle("triangle",5,3);
        Square s = new Square("square",7);
        shape_list[0] = (Shape)c; // 생략가능
        shape_list[1] = (Shape)t; // 조상 클래스 타입에 자손 타입의 인스턴스를 넣을 수 있음  >> 다형성
        shape_list[2] = (Shape)s; // c t s 모두 인스턴스는 shape의 자손 타입이지만 참조변수는 shape타입임.
        // double a1 = shape_list[0]).r; 다음과 같이 작성 불가능. 아래와 같이 다운캐스팅을 해줘야 한다.
        // 자손타입의 인스턴스를 가진 조상타입의 참조변수로 area에 접근할 수 있는 이유는 조상인 Shape클래스에 area()가 정의돼있기 떄문이다.
        // 조상 자신의 멤버는 사용하는 것이 가능하다.
        double a2= ((Circle)shape_list[0]).r;
        System.out.println(c.area());
        System.out.println(t.area());
        System.out.println(s.area());
        //for (int i = 0 ; i < shape_list.length; i++)
        for (Shape tmp : shape_list){
            System.out.println(tmp+" "+tmp.area());
            //System.out.println(tmp+tmp.area());

        }

    }


}
