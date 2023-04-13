package Generice;

public class Box  <T>{


    //박스하나에 모든 물건 다 집어넣을 수 있는 것처럼 제너릭은 그런 역할을 해준다

    T[] obj;

}


class Apple{}
class Book{}
class Shoes{}
class Main2{
    public static void main(String[] args) {

        // 박스생성 (사과만 담는 박스)
        // new 메모리 생성하겠다. 박스라는 클래스를 이용해서 Apple 타입만 저장하겠다

        Box applebox = new Box<Apple>();

        applebox.obj = new Apple[30]; // 그떄그떄 타입을 지정하면서 생성이 가능하다.

        System.out.println("사과박스에 신발을 저장한다.");
    }
}