import packtest1.A;



public class PublicEx {
    public static void main(String[] args) {
        //자바 파일명과 동일해야된다.
        //자바 파일안에서 Public 무조건 하나만 쓸 수 있다. 즉 public 클래스는 .java 파일안에는 한개의 public class만 존재할 수 있다.
        //클래스 멤버변수(인스턴스) 들 각각 설정
        //다른 폴더든 같은폴더든 어디서든지 public 클래스의 폴더의 주소만 붙이면 어디서든지 접근이 가능하다. 우리가 java.util.Scanner와 같이
        //import하며 접근하는 것과 마찬가지다.
        Galaxy g = new Galaxy(); // 같은 Day7 패키지에 있는 Galaxy 클래스에 접근 가능한 모습
        A a1 = new A();
        // 참조변수 a1을 통해 접근할 수 있는 A클래스의 멤버는 재어자가 public인 변수 a뿐이다.
        int a = a1.a;
    }
}
