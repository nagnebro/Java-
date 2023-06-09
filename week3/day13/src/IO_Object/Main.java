package IO_Object;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    Person(){}
    @Override // Object 클래스에서 오버라이딩.
    public boolean equals(Object obj) { // 내가 저번에 자손 인스턴스로 조상 인스턴스와 비교한 것과 비슷한 구조. 매개변수로
        // 실행한 쪽의 메서드의 this를 넘겨주고 매개변수로 비교하려는 인스턴스의 주소를 넘겨주면 서로 비교가 가능하다.

        // 만약 현 객체와 매개변수 객체가 같을 경우 true이면 비교값의 결과로 참을 리턴한다.
        if (obj == this) {
            return true;
        }

        // 만약 Person 타입이 아니다 ! 호환되지 않으면 에러!
        // true 객체 참조가 가능하다. false 객체랑 관계없다!
        // false 그대로 집어넣으면 if문이 실행되지 않는다.
        // not 거짓을 참으로 변경했다.

        if (!(obj instanceof Person)) { // 이 조건을 풀어서 말하자면 obj의 인스턴스가 Person보다 상위의 클래스인 경우를 말하는것이다.
            Person person = (Person) obj; // 이 코드는 에러가 발생할 수 밖에 없는 것 같은데.. 무슨 의도인지 모르겠다. 그러니까
            // 애초에 Person보다 조상이면 애초에 이 메서드에 들어올 수 없고 다형성을 가진 Person의 조상 타입의 참조변수를 가진 Person인스턴스가
            //왔다고 해도 어차피 instance of 에 의해 저 조건문은 실행되지 않는다.
        }
        Person person = new Person("hi");

        if (person.name == this.name){ // 인스턴스 값이 같은지 비교..?
            System.out.println("같다");
            return true;
        }else{
            return false;
        }



    }

}


class PersonTest{
    public static void main(String[] args) {
        Person p1 = new Person("hi");
        Person p2 = new Person("hi");


        System.out.println(p1.equals(p2));
    }
}



public class Main {
    public static void main(String[] args) {

        // Objects 클래스


        // 문자열 생성할때 new 연산자를 사용하지 않고 생성시에는 그 문자열을 가진 메모리의 주소를
        // 모두에게 공유시켜준다. 굳이 같은 문자열 값을 가진 참조변수를 일일히 만들필요가 없다고 판단하는 것이다
        // 그러나 new 연산자를 사용시에는 서로 다른 주소값을 가지고 있기 때문에 비교시 false가 나오는 것을 확인할 수 있다.
        // 정확히 말하면 같은 문자열 값을 가진 문자열 2개가 서로의 값이 같아서 true가 나오는 것이 아닌 같은 주소의 문자열을 같이
        // 참조하고 있기 때문에 주소값이 같기 떄문이다.
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println(s1==s2);
        System.out.println(s3==s2);
        Object obj1 = new Object();
        Person p =new Person();
        PersonTest p2 = new PersonTest();
        int x =20;
        int y= 10;
        System.out.println(++x+y--);

    }
}
