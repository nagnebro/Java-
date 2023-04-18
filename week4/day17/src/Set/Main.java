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
}


public class Main {

    public static void main(String[] args) {


        // set 계열의 자료형은 -> 어떤 자료형을 모아놓은 집합체나 클래스를 말하는 건가?
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

    }
}
