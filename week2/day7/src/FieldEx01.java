class Socar{

    // 운전자명
    static String name = "쏘카";
}

class User{
    String name;

    User(String name){
        this.name = name;
    }
}

public class FieldEx01 {
    public static void main(String[] args) {
        // static 제어자는 '공유'의 개념을 가진다
        // 클래스의 필드와 메서드에 적용할 수 있다
        // static 필드 --> 클래스 변수
        // static 메서드 --> 클래스 메서드
        // 클래스 변수는 하나의 독립된 변수이며 인스턴스 변수는 인스턴스를 생성할 떄마다
        // 해당 인스턴스가 가지는 별개의 변수가 된다.

        Socar s = new Socar();
        System.out.println(s.name);
        s.name = "그린카 최고";
        Socar s2 = new Socar();
        System.out.println(s2.name); // s.name을 바꿨음에도 불구하고 s2.name의 값도 변경됨을 확인할 수 있음.
    }
}
