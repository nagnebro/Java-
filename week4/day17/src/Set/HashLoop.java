package Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class HashLoop {
    public static void main(String[] args) {

        HashSet<String> hset1 =new HashSet<>();

        hset1.add("3");
        hset1.add("1");
        hset1.add("2");
        hset1.add("2");
        hset1.add("2");
        // 값의 중복을 허용하지 않고 오름차순으로 정렬해서 저장한다는 사실을 알 수 있음. 중복을 허용하지 않고 값의 정렬이 필요한 곳에서 유용한 자료형
        System.out.println(hset1);


        // # 해쉬셋 예제

        HashSet<String> hset2 = new HashSet<>();
        hset2.add("야구공");
        hset2.add("나나나나");
        System.out.println(hset2);
        hset2.addAll(hset1);
        System.out.println(hset2); // 역시나 순서는 섞이게 된다.


        // # 해쉬맵 예제

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1233,3);
        hm.put(221,3);
        hm.put(33332,3);
        hm.put(333322,5);
        hm.put(33332112,5);

        hm.put(2,3);
        System.out.println("hm : " + hm); // 위 예제를 통해서 해쉬맵은 키나 값을 저장할떄 순서에 관계없다는 사실을 알 수 있다.

        // 컬렉션 - > 맵, 해쉬 , 어레이리스트
        /*

            hashmap = 키와 값을 가짐
            hashset = 어레이라 생각하면 됨.
            컬렉션에서 순서가 없는 데이터를 뽑아서 반복시키는 반복자로 iterator()가 있었다.

            hasNext() -> 다음 데이터가 있으면 true를 반환 없으면 false를 반환
            next() : 데이터 반환
            remove() : next로 읽어온 데이터를 삭제.

            >> 내 방식대로 다시 정리하자면
            map은 파이썬의 딕셔너리, 즉 키와 값을 가지며 얘는 진짜로 저장 순서나 자료형의 오름차순에 관계없이 무작위로 저장된다. 물론 거기에도 일정한 ? 기준이 있겠지만.
            set은 리스트이면서 비선형구조의 자료형이다. 즉 값의 순서가 없기 떄문에 index로써 값에 접근할 수 없다. 다만 중복을 허용하지 않고
            기본 자료형의 경우 자동으로 오름차순 시켜 저장한다. 단 객체(인스턴스)를 저장하는 경우 오름차순이라 할지라도(주소값의 해시코드인지 뭔지..)
            그 인스턴스 멤버의 값을 기준으로 오름차순 되는 것이 아님을 혼동하면 안된다(당연한 소리인가?)


            //반복자 (iterator) 사용하기, iterator는 인터페이스이다. 따라서 자료형 (set,map등)에 따라 메서드가 오버라이딩 구현돼있음.

         */
        Iterator<String> iter = hset2.iterator();
        HashSet<Integer> h1 = new HashSet<>();
        Iterator<Integer> ii = h1.iterator();


        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        for ( String str : hset2){
            System.out.println(str);
        }
    }
}
