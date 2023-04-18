package Generics;



public class FruitBox<T,U>{
    public <T,U> void printBox(T x, U y){ // -> 다음과 같이 제네릭 타입을 여러가지로 지정할 수도 있다.

        System.out.println(x.getClass());
        System.out.println(y.getClass());
    }
}








//public class FruitBox<T> {
//
//    public T addBox(T x, T y){
//        return y;
//    }
//
//    //static 으로 선언을 해도 독립적으로 타입을 할당해서 사용할 수 있도록 제네릭 메서드를 정의해보자.
//
//    // 처음 제네릭 클래스로 인스턴스화하면 클래스 타입 매개변수가 전달한 타입에 따라서 제네릭 메서드도 타입을 정한다.
//    // 제네릭 메서드를 직접 호출할때 타입 파라미터를 다르게 지정하거나 다른 타입의 데이터를 매개변수에 넘긴다면
//    // 독립적인 타입을 가진 제네릭 메서드로 운용할 수 있다. -> 뭔소리야?
//    public static <T>T addBoxstatic(T x, T y){  // -> 일반 메서드와 선언부가 좀 다른듯?
//        // <> 기호 안에 들어있으면 그냥 명시적으로 이 클래스, 메서드, 변수가 제네릭에 속해있다라는 걸 나타내는 것 같고 그냥 T x, T y,이런식으로
//        //쓰면 우리가 일반적으로 쓰는 자료형이나 타입 대신 T의 값이 들어가는 것.
//
//        return y;
//    }
//}
