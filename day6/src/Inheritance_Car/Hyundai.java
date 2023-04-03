package Inheritance_Car;

public class Hyundai {
    String brand = "hyundai";
    String color = "white";
    String size = "G";
    int price = 5000;

    public Hyundai(String brand, String color, String size, int price) {
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    Hyundai(){}

    void drive(){}

    void reverse(){}
    void brake(){}


}

class Avante extends Hyundai{

    void avante(){}
    Avante(String brand, String color, String size, int price){
     super();
     this.brand = brand;
     this.color = color;
     this.size = color;
     this.price = price;
     // 컴파일 에러 이유. 애초에 super()를 갓다온 후에 얘네 인스턴스 변수들이 초기화가 되는데 초기화되지도 않은
        // 값들을 이용해 인자로 집어넣으니 당연히 조상의 생성자로 초기화되기 전에는 참조가 불가능하다.
    }
}

class Grandeur extends Hyundai{
    void Grandeur(){}
}

class Genesis extends Hyundai{
    void genesis(){}
}