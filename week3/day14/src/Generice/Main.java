package Generice;

class Calc<T> { // 제너릭을 클래스에 써준다.

    T x;
    T y;

    public static void main(String[] args) {



        // 제네릭 <>
        // -<> 꺽쇠 안에 타입명을 기재한다
        // - 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
        // - 객체 자료형(타입)을 지정하여 지정된 타입만 객체를 저장하는 기능
        // - 클래스 정의시 클래스명 <타입>
        // - 제너릭은 기본자료형을 받지 않는다. 객체 타입으로 생성
    }
}

class Main{
    public static void main(String[] args) {
        Calc<Integer> calc1 = new Calc<Integer>();// 무조건 정수타입의 데이터만 받을 수 있다.
        Calc<Double> calc2 = new Calc<Double>();// 무조건 더블타입의 데이터만 저장할 수 있다.
    }
}