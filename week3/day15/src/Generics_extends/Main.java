package Generics_extends;


import java.util.ArrayList;

class Unit{}


// 계산기는 정수, 실수만 들어온다.
// 따라서 T 제네릭 타입을 정해서 제한을 주지 않으면 이상한 객체 타입으로 선언되다.
class Calc<T extends Number, T1 extends Number>{// 즉 제네릭 타입에 제한을 두는 법은 아래와 같다. Number(정수,실수) 클래스를 상속하면 이 클래스와 관련있는 타입들만
    // 제네릭 타입으로 받아오겟다는 것임.  -> 즉 상속받은 클래스 타입의 매개변수만 제네릭 타입으로 받아들이겠다는 것.
    // 위와 같이 제네릭 타입이 두개가 있을 떄 각각에 맞게 제한을 걸 수도 있다.

    void add(T a, T b){};
    void min(T a, T b){};
    void mul(T a, T b){};
    void div(T a, T b){};


}

// 자신을 기준으로 부모타입의 클래스가 들어오지 못하게 막는 방법도 있음. 와일드카드 라고도 하지만 다음에 다뤄야 할 문제,.
//class Calc2<T super Number>{
//
//
//    void add(T a, T b){};
//    void min(T a, T b){};
//    void mul(T a, T b){};
//    void div(T a, T b){};
//
//
//}
//

class Stu extends Unit implements Readable,Closeable{
    String name;
}

class Stu2{
    String name;
}

class School <T extends Unit & Readable & Closeable>{ //Stu2 클래스는 제네릭 타입으로 선언될 수 없다.
// 위와 같이 제네릭타입에 여러개의 제한을 둘 떄 클래스랑 인터페이스가 같이 있으면 클래스명 부터 작성해야 한다.
// 클래스명 & 인터페이스명 & 인터페이스명...의 형태여야 한다.
}

class School2 <T extends Stu2>{

}
public class Main {
    public static void main(String[] args) {

        // 타입 한정 키워드 extends -> 상속의 extends가 아닌건가??
        // <> extends 쓰이면 관련있는 타입들만 객체 타입으로 지정할 수 있다.
        // Number 클래스를 상속받은 클래스들은(Integer,Float,Double...)Number클래스를 상속받은 제네릭 타입에 들어올 수 있다.

        School2<Stu2> stu1 = new School2<Stu2>() ;
        Calc <Number, Number> cal1 = new Calc<>();
//        Calc <Number> cal2 = new Calc<>();// 제네릭 타입의 인자값이 2개로 선언됐기에 위와 같이 해줘야 함.
//        Calc <Number> cal3 = new Calc<>();
//        Calc <Number> cal4 = new Calc<>();
//        //Calc <Stu> cal5 = new Calc<Stu>(); 다음과 같이도 선언 불가능
        cal1.add(5,3);
        //cal1.add("sd","aa"); // 근데 이렇게 해서 못 들어오게 한다해도.. 컴파일전에만 알 수 있는 거 아닌가? 즉 추상메서드나 어노테이션의
        // 개념처럼 런타임 에러를 방지하기 위한 일종의 예방으로 제한을 거는 건가?

        ArrayList<Stu> list = new ArrayList<>();
        list.add(new Stu()); // Stu타입의 참조변수를 저장하는 list에 Stu인스턴스 저장
        //list.add(new Stu2()); 다음과 같이 불가능하다. 인터페이스가 구현되지 않았기 때문.


    }
}
