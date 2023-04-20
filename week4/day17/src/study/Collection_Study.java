package study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Collection_Study {

    /*
        이제까지 난해했던 컬렉션 프레임워크에 대해 간단하게 개념 정리를 해보겠다.

        컬렉션 프레임워크는 인터페이스로 하위 4개의 인터페이스를 두고 있다. 각각 많이 들어봤던 List, Map, Set, Queue이다.
        이중 Queue 인터페이스를 제외한 3개의 인터페이스에 대해 좀 더 자세히 설명해보겠다.

        -List 컬렉션
          List 역시 인터페이스로 우리가 자주 사용하던 List 관련 클래스들이 이 List컬렉션에 포함돼있다.
          ArrayList, LinkedList, Vector, Stack이 있다
          List만의 공통적인 특징들과 각각의 클래스들의 개별적인 특징도 존재한다
          우선 List는 선형구조 자료형으로서 순서가 있다. 즉 인덱스번호가 있다는 것인데 ArrayList와 Vector는 일반적으로 우리가 알고 있는
          배열을 이용해 크기가 가변적인 리스트를 만들어준다. 따라서 인덱스가 있기때문에 값의 조회 및 수정에는 빠를 수 있지만 삭제 및 추가에는
          배열의 생성 및 삭제가 반복되기 떄문에 비효율적이다.

          - ArrayList는 쉽게 생각하면 Array(배열)와 LinkedList를 합친것이라 생각하면 된다.
          Linked List처럼 값의 추가 삭제도 가능하고 배열처럼 조회도 가능하기 떄문이다. 물론 그에 따른 장단점은 존재하지만.

          - LinkedList는 순서가 없다. 하나하나의 객체가 head를 가지고 그 head를 참조하며
          연속적으로 객체들이 꼬리를 물고 이어져있는 형식이다. 따라서 값의 조회에는 head를 계속 찾아가야 한다늦 점에서 오래걸리지만 추가 삭제에서는
          단순히 삭제나 추가후 앞뒤, 추가된 객체의 head 의 참조값만 바꿔주면 되기 떄문에 굉장히 효율적이다.
          - Vector클래스는 ArrayList와 유사한 기능을 제공하지만 만들어진지 오래됐으며 멀티스레드 환경에서 유리하다는 장점이외에는 일반적으로 사용되지 못하고 있다.
          Stack은 잚 모르겠다.


        -Set 컬렉션
          Set인터페이스는 아래로 HashSet,LinkkedHashSet, Treeset(SortedSet 인터페이스를 구현하는 클래스)로 이루어져있다
          set은 쉽게 말하자면 우리가 알고 있는 List에서 순서가 없고(TreeSet의 값의 저장은 순서에 관계없이 크기에 따라 오름차순 정렬됨 다만
          객체를 저장할때는 객체가 갖고 있는 인스턴스 멤버에 따라 오름차순 되지 않음(당연한말). 아마 주소값을 해시코드를 이용한다던지 그런 원리일 것 같은데
          자세히는 모르겠음. 아무튼 순서가 지 멋대로라는 것, HashSet은 저장순서, 값의크기에 관계없이 무작위로 저장됨)
          ** 순서가 없다는 것의 정확한 정의는 자료향에 값을 저장할 때 몇번쨰로 저장했는지 기억하지 않는다는 것. 다만 그냥 값의 크기를 비교해서 순서대로 넣어주는 것 뿐.
          중복을 허용하지 않고 값을 오름차순으로 정렬한다는 특징 이외에는 비슷하다고 보면 된다
          단 순서가 없기에 인덱스로 접근해서 값을 추출하는 메서드같은 것은 없으며 객체의 요소들을 확인하기 위해서는 for문이나 반복가능한 객체를 iterator를 이용해
          생성해주어야 한다.

        -Map 컬렉션
          Map컬렉션은 HashMap, LinkedHashMap, TreeMap, HashTable, TreeMap(SortedMap 인터페이스를 구현하는 클래스) 클래스들로
          구성돼있다. Map은 파이썬의 딕셔너리라고 생각하면 된다. 즉 키와 값을 같이 가질 수 있는 자료형이다.
          HashMap은 이러한 키와 value를 순서없이 저장하고 TreeMap은 TreeSet과 마찬가지로 키를 기준으로 정렬해준다.



     */

}

class TestMain {
    public static void main(String[] args) {

        HashSet<String> h1 = new HashSet<>();
        HashSet<Test> h2 = new HashSet<>();

        h1.add("3"); // 해쉬 셋은 중복추가가 안된다.
        h1.add("1");
        h1.add("2");
        h1.add("5");
        h1.add("6");
        h1.add("7");
        h1.add("8");
        h1.add("9");
        System.out.println(h1); // 이상하게 숫자 문자열은 오름차순 정렬되는데
        h1.add("1kiwi");
        h1.add("2apple");
        h1.add("3melon");
        h1.add("4melon");
        h1.add("5melon");
        h1.add("6melon");
        System.out.println(h1);
        // 여기서부터는 순서를 가지지 않는다.
        h2.add(new Test(100));
        h2.add(new Test(200));
        h2.add(new Test(300));
        h2.add(new Test(400));
        System.out.println(h2);

        Random r = new Random();

        int ran2 = (int)(Math.random()*4); // 0~temp의 길이-1만큼의 값을 저장 (win의
        ArrayList<Test> list = new ArrayList<Test>();
        list.add(new Test(2));
        System.out.println(list.size());
        System.out.println(list);
        list.add(new Test(3));
        list.add(new Test(4));
        System.out.println(list.size());
    }
}

class Test{
    int score ;

    public Test(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        //return ""+this.score;
        return super.toString();
    }
}