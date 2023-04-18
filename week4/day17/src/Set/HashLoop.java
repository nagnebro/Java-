package Set;

import java.util.HashSet;
import java.util.Iterator;

public class HashLoop {
    public static void main(String[] args) {

        HashSet<String> hset1 =new HashSet<>();

        hset1.add("1");
        hset1.add("2");
        hset1.add("3");
        System.out.println(hset1);

        HashSet<String> hset2 = new HashSet<>();
        hset2.add("야구공");
        hset2.add("나나나나");
        System.out.println(hset2);
        hset2.addAll(hset1);
        System.out.println(hset2); // 역시나 순서는 섞이게 된다.


        // 컬렉션 - > 맵, 해쉬 , 어레이리스트
        /*

            hashmap = 키와 값을 가짐
            hashset = 어레이라 생각하면 됨.
            컬렉션에서 순서가 없는 데이터를 뽑아서 반복시키는 반복자로 iterator()가 있었다.

            hasNext() -> 다음 데이터가 있으면 true를 반환 없으면 false를 반환
            next() : 데이터 반환
            remove() : next로 읽어온 데이터를 삭제.

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
