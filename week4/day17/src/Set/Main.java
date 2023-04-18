package Set;


import java.util.HashSet;

class Person{
    String name;
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    // 인스턴스가 가지고 있는 값이 같을 떄 같은 것으로 보겠다고 판별하기 위한 equals 메서드이다.
    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Person)){ // obj의 인스턴스가 person의
            return false;
        }

        Person temp = (Person) obj;
        return this.name.equals(temp.name) &&this.age == temp.age ;
    }

    @Override
    public int hashCode() {
        return (name+ age).hashCode();  // -> 얘 동작원리? 해쉬코드가 같다면 같은 값으로 보겠다는 메서드
    }
}


public class Main {

    public static void main(String[] args) {


        // set 계열의 자료형은 -> 계열이란 말이 어떤 자료형을 모아놓은 집합체나 클래스를 말하는 건가?
        // - 순서가 없고 중복을 제거한다.

        //set계열은 순서가 없고 중복을 제거한다

        /*
           hash set
            -set 인터페이스를 구현한 대표적인 컬렉션 클래스
            -순서를 유지하고 싶을 때 LinkedHashSet 클래스 사용

            treeset
            - 범위 검색과 정렬에 유리한 클래스
            - hashset 보다 데이터를 추가, 삭제하는데 시간이 더 걸린다. -> linkedlist같은 느낌?
         */
        HashSet<Integer> hs = new HashSet<>();

        // 추가
        // set.add() 함수를 실행하고 나면 결과값으로 true, false가 반한됨
        hs.add(1);// 컬렉션 계열이기 때문에 Arraylist와 마찬가지로 동일한 add 함수를 쓴다
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);
        System.out.println(hs);
        hs.remove(1);
        System.out.println(hs);
        hs.clear(); // 전체삭제, 뭐 이러한 기능들이 있다고만 알아두자. 사용하는데에는 크게 어려움이 없으니까.
        System.out.println(hs);
        // set계열은 값을 중간에 삽입하는 것이 불가능하다. 자료형 내부의 값들이 순서가 없기 떄문이다.


        HashSet <Person> list = new HashSet<>();

        // 객체를 저장하기 전에 기존에 같은 객체가 있는 확인

        list.add(new Person("감영천",10));
        list.add(new Person("감영천",20));
        list.add(new Person("감영천",30));
        // 중복된 값이 들어올 우려가 있기 때문에 값을 더하기 전에 체크해줘야 하낟.


        System.out.println(list);

    }
}
