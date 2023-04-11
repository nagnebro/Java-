package InnerClass;


class Outer{
    private static int num = 0; // private이면서 스태틱이면...? 외부에서는 접근 못하지만 내부에서는 static이니까
    // 참조변수없이 어디서든 접근이 가능하다는 뜻.

    static class Nested1{ //내부 클래스
        void add (int n){
            num += n;
        }
    }
    static class Nested2{ //내부 클래스
        int get(){
            return num;
        }
    }

}


public class Static_Inner2 {
    public static void main(String[] args) {
        // static 멤버가 많아지면 프로그램이 무거워진다. static 멤버는 컴파일때부터 메모리 스택?에 할당된(?) 상태이기 때문이다.
        Outer.Nested1 nst1 = new Outer.Nested1();
        // 내부클래스가 static이 아니면 Outer의 객체를 먼저 생성 후 그 객체로 다시 Nested1 클래스에 접근해야할 것이다.
        // 쉽게 생각하면 내부클래스는 그냥 메서드라 생각해라. static 붙어있으면 static 메서드고 안붙어있으면 인스턴스 메서드이다.
        Outer.Nested2 nst2 = new Outer.Nested2();

        nst1.add(5);
        int num = nst2.get();
        System.out.println(num);

        // 단 static은 static 제어자가 붙은 메서드, 변수, 클래스에서만 객체 호출, 객체 수정변경, 생성할 수 있다.
        // 그러니까 내부 클래스는 본인의 static여부에 관계없이 바깥의 static 변수를 이용할 수 있으나 바깥의 변수가 static이 아니라면
        // non static 내부클래스여야만 외부클래스의 변수를 이용할 수 있다. 그냥 스태틱 메서드와 스태틱,인스턴스 변수간의 관계와
        // 인스턴스 메서드와 스태틱, 인스턴스 변수간의 관계와 같다.
    }
}
