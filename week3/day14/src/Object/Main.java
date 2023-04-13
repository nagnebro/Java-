package Object;

public class Main {
    public static void main(String[] args) {
        // getClass()
        // 자신이 속한 클래스의 객체를 반환하는 메서드
        // 클래스당 1개만 존재
        // 자바 파일이 .class 파일을 생성하고 객체 생성할때 알 수 있음.
        Main a = new Main();
        System.out.println(a.getClass());
    }
}
