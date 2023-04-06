
package javafinal;


class Person{
    final int hp = 100;
    final int age = 0;
}

class Tank{
    final int hp ;// 제어자는 값이 변경된 후에 최종적으로 제어자 여부를 검사하며 변경될 수 있는 값인지 아닌지를 판별하기 때문에 아래와 같이 생성자를 통해
    // 인스턴스 별로 다른 상수값을 가지게 하는 것이 가능하다.
    // static final int mp ; 다음과 같이 상수에 final 제어자가 붙게 되면 생성자에서도 초기화 못한다. 메모리에 미리 올라가는 변수이기 때문에
    // 여기서 바로 초기화해줘야 한다.
    Tank(int hp){
        this.hp = hp;
        //this.mp = 5;
    }
    Tank(){
        this.hp = 0;
        //this.mp = 0;
    } // 메인에서 Tank 인스턴스를 전달 인자 없이 생성하기 위해서는 기본 생성자를 만들어야 하는데 그렇게 되면 기본 생성자로 인스턴스를 생성했을때
    // 상수 hp가 초기화 되지 않으니 이 경우에도 상수값은 초기화 해줘야 한다.

    public String toString(){
        return String.format("This is Tank, hp : %d",hp); // 매개변수로서 hp를 받지 않았으니 당연히 여기서 hp는 인스턴스 변수 hp이다.
        // 굳이 this.hp로 표현할 필요가 없을 것 같다.
    }
}
public class FinalEx01 {
    public static void main(String[] args) {
        Tank tt = new Tank();
        Tank t = new Tank(200);
        System.out.println(t);
        final int num = 10; // 상수는 선언과 동시에 초기화하는 것이 원칙.
        // num = 1000; 다음과 같이 불가능.
    }
}

class Company{
    final static String name = "kh 회사"; // 어차피 공통의 요소고 변경되지 않을 값이라면 final static을 붙여준다.

    // static멤버는 프로그램 시작전에 이미 메모리에 생성이 되기 때문에 상수 final이라고 해도 값을 초기화하지 못한다.
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
        // final 제어자가 막기 떄문이다. 그 인스턴스를 다시 생성할 수 없다는 것이 아니고 그 참조변수로 다시 인스턴스 생성이 안된다는 것이다.

        //final Object o = new Object();
        //o = new Company(); 같은 인스턴스를 두 번 못 받는 것이 아닌 참조변수의 값이 변경될 수 없다는 것을 보여주는 코드. Object 참조변수면
        // Object 인스턴스 받았다가 자손인 Company 인스턴스 받을 수 있나 테스트 해봤는데 안됨.

       // c.name = "회사"; 마찬가지로 상수인 name도 변경불가.
        Company_SBS cs = new Company_SBS();
        cs.print();
    }
}
