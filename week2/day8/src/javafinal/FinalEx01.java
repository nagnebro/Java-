        /*
            상수 (final)
            - 변수처럼 값을 저장하지만 한번 값을 저장하면 변경할 수 없다.
            - 변수 생성과 동시에 초기화까지 진행되야한다.
            - 상속을 했을 때 오버라이딩을 불가능하게 한다. (메서드에 final이 붙은 경우를 말하는 듯)
            - class에 final 제어자가 붙으면 클래스 상속이 불가능하다.

            클래스 안에 final 상수값을 줄때 생성자를 이용하면 객체를 생성할 때마다 설정한 값으로 초기화 한 후
            상수화 시켜 각기 다른 상수값을 가질 수 있다.
         */
package javafinal;


class Person{
    final int hp = 100;
    final int age = 0;
}

class Tank{
    final int hp ;// 제어자는 값이 변경된 후에 최종적으로 검사하며 변경될 수 있는 값인지 아닌지를 판별하기 때문에 아래와 같이 생성자를 통해
    // 인스턴스 별로 다른 상수값을 가지게 하는 것이 가능하다.
    Tank(int hp){
        this.hp = hp;
    }
    public String toString(){
        return String.format("This is Tank, hp : %d",hp); // 매개변수로서 hp를 받지 않았으니 당연히 여기서 hp는 인스턴스 변수 hp이다.
        // 굳이 this.hp로 표현할 필요가 없..지 않나?
    }
}
public class FinalEx01 {
    public static void main(String[] args) {
        Tank t = new Tank(200);
        System.out.println(t);
        final int num = 10; // 선언과 동시에 초기화.
        // num = 1000; 다음과 같이 불가능.
    }
}

class Company{
    final static String name = "kh 회사"; // 어차피 공통의 요소고 변경되지 않을 값이라면 final static을 붙여준다.
    // static은 프로그램 시작전에 이미 메모리에 생성이 되기 때문에 상수 final이라고 해도 값을 초기화하지 못한다.
    // 즉 final 상수는 생성자를 통해 초기화가 가능하긴 했는데 static은 진짜 안된다는 것.
    final void print(){
        System.out.println(name);
    }
    void setInfo(final int temp){ // 이렇게 사용하는 경우는 드물다.
        // 매개변수의 값을 변경할 수 없다.
    }
    Company(String name){

    }
    Company(){}
}

 class Company_SBS extends Company{

    // final void print(){} , 조상에서 메서드에 final 붙으면 자손에서 오버라이딩이 안된다. 사용이 안되는 것이 아니고 자손에서 오버라이딩이 안된다.
 }   //  class Company에 fianl이 붙으면 다음과 같이 상속이 불가능하다. 위로 상속받는 게 안된다는 게 아니고
// 아래로 상속해주는 것이 안된다는 뜻.
//==============================================주석 넣으며 직접 비교해볼 것==============================================



class CompanyTest{
    public static void main(String[] args) {
        final Company c = new Company(); // 참조변수에 final을 붙인다면?
        final Company cc =new Company();
        // c = new Company(); 다음과 같이 작성이 불가능하다. 그 이유는 하나의 참조변수로 인스턴스를 한 번 생성한 후에는 더 생성할 수 없게끔
        // final 제어자가 막기 떄문이다.
       // c.name = "회사";
        Company_SBS cs = new Company_SBS();
        cs.print();
    }
}
