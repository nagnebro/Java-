package packtest;


import packtest2.A;

public class Ab {
    public static void main(String[] args) {

    }
    // packtest1과 packtest2에 모두 public class A가 있을때 다음과 같이 인스턴스를 생성하려면 import를 할때
    // 같은 이름을 가진 클래스 둘 중 1개만 import가 가능하다.
    A aa = new A(); // 따라서 import 한 후에 다음과 같이 객체에 접근해 인스턴스를 생성하는 것이 가능하며
    int a = aa.a; // 다음과 같이 public 제어자를 가진 변수에도 접근이 가능하다.
}
