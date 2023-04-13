package String;

public class Main {



    public static void main(String[] args) {
        // String 클래스에는 데이터를 char[]형태로 받고 이 char형태의 배열을 메서드로 문자열을 만드는 형태의 기능을 제공하는 클래스라고 보면 된다
        /* - 문자배열로 이뤄진 클래스
            - 참조형 변수로 분류
            - 스택 영역이 아닌 객체와 heap(힙)에서 문자열 데이터가 생성되고 다뤄진다.
            - 스택에는 중괄호 안에 있는 지역변수(인스턴스 변수는??)들만 들어가게 된다. 컴파일 이전부터 메모리에 올라가있는? 상태
            - 힙 영역에 있는 변수는 실행 후에 메모리에 올라가게 된다. 그걸 stack에서 사용할때는 힙 영역을 참조하는 것이다. 우선은 이렇게 알아놓자
            - String 타입의 참조변수 두개가 서로 같은 "hello"라는 문자열값을 저장하게 된다면 서로 같은 주소값을 가지게 된다. (new String())하지 않았기 떄문.


            String 불변 (Immutable)
            기본적으로 객체의 값을 변경하지 못하게 해놨다. 그래서 가지고 있는 문자를 공유해서 주소값을 준다.


            상수만 저장하는 영역에 문자 상수가 올라가면 똑같은 내용은 저장 안된다.
            문자열 리터럴(상수)은 프로그램 실행 시 자동으로 생성된다. 즉 우리가 그냥 new 연산자 없이 생성한 문자열들은 상수와 같은 영역에 저장되고
            상수와 같은 취급을 하게된다.
            그러한 문자열 리터럴은 constant pool에 저장.
            String constant pool이란 heap영역내에 있는 메모리 공간 같은 걸로 생각하면 된다. new연산자로
            String을 생성하면 같은 값을 가진 문자열이라도 중복해서 객체를 생성하기 때문에 효율적이지 못하게 된다.
            문자열을 리터럴로(new없이 그냥) 생성하게 되면 String constant pool에 저장되며 이후에 참조변수로 같은 값을
            가지게 될 경우 constant pool의 같은 값을 가르키게 되며 같은 주소값을 가지게 된다.
            그러나 생성자를 통해 생성하면 heap 영역에 독립적인 객체로서 문자열을 저장하게 된다.
        * */

        // hashcode() String타입은 toString으로 인해 주소값이 아닌 값이 출력되는데 해쉬코드 메서드를 이용시 주소를 알 수 있음.

        //===================================hashcode랑 주소는 다른 것 같다 정리필요ㅍ=======
        int num = 35;
        String name = "홍길동"; // name1 과 name2는 현재 같은 주소값을 가지고 있다. 홍길동이라는 문자열을 가진 주소값 한개를 공유하고 있음.
        String name2 = "홍길동";
        System.out.println(name==name2);
        System.out.println(name.hashCode()); // 그떄 이 둘의 주소값이 같다는 것을 알 수 있음.
        System.out.println(name2.hashCode());
        name = name+"의적"; // 그러나 다음과 같이 홍길동의적이라는 문자열을 name에 저장시키면 아마 heap영역에 홍길동의적이라는 문자열을
        // 갖는 데이터가 하나 더 생기며 주소값을 name에 새롭게 저장시켜줄 것이다.
        System.out.println(name);
        System.out.println("name의 주소" + name.hashCode());
        System.out.println(name2);
        System.out.println("name2의 주소 :"+ name2.hashCode());// 그래서 홍길동의적이라는 새로운 값을 가지게 된 name은 이전과 다른 주소값을 가지게 된다
        String name3 = "홍길동의적";
        System.out.println("name3의 주소 : "+ name3.hashCode());// 이 때 또 홍길동의적이라는 값을 가지는
        // 참조변수를 생성하게 되면 역시 name과 같은 주소값을 출력한다.
        Main m =new Main();
        System.out.println(name);
        System.out.println(name2);
        System.out.println(name3);
    }
}


class Test{
    public static void main(String[] args) {
        String [] list = {""};
        System.out.println(list.length);
    }
}