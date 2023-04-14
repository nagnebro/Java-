package Generics;


// 인터페이스 추상메서드들의 제네릭 타입을 지정할 수 있다.
// 인터페이스, 추상클래스는 객체 생성이 안된다
// 객체를 1번만 생성시키기 위해서 익명클래스를 작성하면 된다.  -> ..?

class Main{
    public static void main(String[] args) {

        //public static 객체 생성 클래스명으로 접근 -> 제어자 신경쓰라는 말?
        //FruitBox.addBoxstatic(1,2); // static 메서드기 때문에 클래스명으로 접근 가능.
        // 위와 같이 FruitBox의 인스턴스를 생성하면서 제네릭의 매개변수 타입을 지정해주지 않았음에도 매개변수로
        // 정수형이 들어왔다면 래퍼클래스가 매개변수 타입을 추측하면서 제네릭 타입에 알아서 알맞은 타입, 여기서는 정수형 타입을 넣어준다.

        FruitBox<Integer,Long> box1 =  new FruitBox<>();

        //인스턴스화에 지정된 타입 파라미터는 Integer와 Long이라고 했을떄 다음과 같이 메서드를 실행해보자.
        box1.printBox(1,1);

        // 제네릭 메서드에서 매개변수를 서로 다른 타입으로 정의하고 싶다면
        box1.<String,Double>printBox("hello",5.55); // 제네릭 타입 선언부분은 생략 가능.
    }
}



/*

interface Isample<T> {

    public void addElement(T t, int index);
    public T getElement(int index);

}

class Sample<T> implements Isample<T>{
    private T[] array; // new를 사용할 수 없는건가?

    // 기본 생성자
    public Sample(){
        array = (T[])new Object[10]; //  이게 뭔소리야?

    }

    // T 타입으로 들어온 객체의 주소를 저장한다.
    // index 변수의 숫자를 이용해서 방 번호에 저장한다.
    @Override
    public void addElement(T t, int index) {
        array[index] = t;
    }

    @Override
    public T getElement(int index) {
        return array[index];

        // return으로 Main이든 내가 호출한 메서드든 콘솔창에 출력하기 위해서는 prin
    }
}

*/

//// 제네릭 많이 사용되는 람다 표현식의 함수형 인터페이스
//// 두 매개변수를 받아서 더하는 메서드
//interface IAdd<T>{
//    public T add(T x, T y);
//        }
//
//
//class Main{
//    public static void main(String[] args) {
//        Sample<String> sa = new Sample<>(); // new Sample<>():에서 꺽쇠는 생략해도 되지만 관례상 적는 것이 낫다
//        // 컴파일 하는 순간 <> 제네릭 부분이 String으로 변하게 된다. <T> -> <String> 으로 변하는 것.
//
//
//        sa.addElement("This is string",5);
//        System.out.println(sa.getElement(5));
//
//        //람다 사용
//        Integer i = new Integer(10);
//
//        // 제네릭은 람다에서 많이 사용된다.
//        // 일반변수를 객체화 시켜주는 래퍼 클래스
//        // 그 클래스가 데이터를 뭐 객체화 시켜주는 듯? -> 정확히 감이 안잡힌다
//        // 매개변수 x와 y 그리고 반환형 타입이 int형으로 설정된다.
//        IAdd<Integer> o = (x,y) -> x+y;// -> 람다??
//        int result = o.add(10,25);
//        System.out.println(result);
//    }
//
//}

//class Sample<T> {
//
//    void method(){
//        // T t = new T(); 다음과 같은 생성은 안된다 -> 아직은 저게 왜 잘못됐는지도 이해 못하는 수준.
//        // new 연산자 뒤에 제네릭 타입 파라미터<T>기 올 수 없다.
//    }
//    // static 멤버는 클래스가 동일하게 공유하는 변수로서 제네릭 객체가 생성되기 전에 이미 자료
//    // 타입이 정해져 있어야된다.
//    // ->  제네릭은 아직 메모리에 올라가있는 상태가 아니기 때문에 static 멤버로 사용할 수 없다. static은 시에 메모리에 올라가기 떄문.
//    // public static T addAge(int n){}
//
//      프로그램 실행을 정확히 설명하면 컴파일 단계와 실행단계로 나누어진다. 컴파일에서는 syntax오류만 검사하게 되는데
//      이떄 오류가 없을시 컴파일러가 class파일을 생성하게 된다. 이때 static 선언된 멤버들이나 상수값 같은 것들이 메모리에 올라가있게 되는데
//      그래서 컴파일 전에 메모리에 올라가 있어야 할 static멤버에 객체와 함꼐 사용할 수 없다.

//}
//class Main{
//    //    public static void main(String[] args) {
////
////        // 제네릭으로 배열을 선언하는 경우에는
////        // 기본적으로 제네릭 클래스 자체로는 배열로 만들 수 없다.
////        // Sample<Integer> [] arr1 =  new Sample<>[10]; //이렇게 작성할 수 없다.
////        // 제네릭 배열을 선언하고 저장하고 싶다면 다음과 같이 한다
////        Sample<Integer>[] list = new Sample[10];
////        list[0] = new Sample<Integer>();
////        list[1] = new Sample();
////        // 근데 이렇게 저장하면 타입이 어떻게 되는 거지..?
////
////        // 제네릭은 타입을 지정해준다. -> 그래서? 그 외의 타입이 들어오면 에러가 난다.
////        // 근데 Sample타입의 참조변수 배열 list가 있는데 그 안의 요소들이 Integer타입이라는 건가..?
////        list[2] = new Sample<>();
////    }
//}