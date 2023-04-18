package Set;
import java.util.HashSet;

public class HashSetEx01 {




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

            if(!(obj instanceof Set.Person)){ // obj의 인스턴스가 person의
                return false;
            }

            Set.Person temp = (Set.Person) obj;
            return this.name.equals(temp.name) &&this.age == temp.age ;
        }

        @Override
        public int hashCode() {
            return (name+age).hashCode();  // -> 얘 동작원리 ? 해쉬코드가 같다면 같은 값으로 보겠다는 메서드
            // 괄호안의 변수값을 문다자열을 계속 바꿔도 같은 해쉬코드를 출력하는데 생성자를 통해 다른 값으로 초기화하면 다른코드가 나옴.
        }
    }

}

class HashSetEx01Test{

    public static void main(String[] args) {
        HashSet<Person> list = new HashSet<>();
        System.out.println(list);

        Person p1 = new Person("김영찬",30);
        int hashcode1 = p1.hashCode();
        int hashcode2 = p1.hashCode();

        System.out.println(hashcode1);
        System.out.println(hashcode2);

        Person p2 = new Person("김영찬",30);

        boolean b= p1.equals(p2);

        hashcode1 = p1.hashCode();
        hashcode2 = p2.hashCode();

        System.out.println(hashcode1);
        System.out.println(hashcode2);
        System.out.println(b);

        // equals() 비교한 결과가 false라도
        // haschcode 값이 같을 수도 있다.
    }
}
