
public class OverloadingEx {
    public static void add(int a, int b){
        System.out.println("정수 합"+(a+b));
    }
    public static void add(float a, float b){
        System.out.println("실수 합"+(a+b));
    }
    public static void add(float a, int b){
        System.out.println("실수와 정수 합"+(a+b));
    }
    public static void main(String[] args) {
        // 똑같은 이름의 함수를 여러개 정의할 수 있다.
        //
        // *조건
        // 1. 함수명이 똑같아야 한다. 2. 매개변수의 개수가 다르거나 매개변수 타입이 달라야 된다.
        // 즉 비슷한 기능을 하는 메서드들은 서로 같은 이름을 사용하는 것이 좀 더 직관적이고 사용하기에 편리하기 때문에 (ex println 메서드)
        // 매개변수의 타입이나 개수가 다르게 만들어놓으면 서로 다른 기능을 수행하는 같은 이름을 가진 메서드가 중복 생성되는 것이다.
        // 만약 오버로딩을 하지 못한다고 생각하면 매개변수의 타입이나 개수가 다를때마다 메서드의 이름을 새로 지정해줘야 하므로
        // 사용하는 것이 여간 불편하는 것이 아닐 것이다.
        add(3,5);
        add(3.4f,5);
        add(3.5f,6.7f);
        System.out.println(-2*-2);
        int c = 5;
        c= -c;
        System.out.println(c);
    }
}
