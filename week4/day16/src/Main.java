import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // map
        // 키(key) 값(value) 쌍으로 구성된 객체를 저장하는 자료구조 -> 파이썬의 딕셔너리.
        // 연락처(이름, 전화번호) 의 형태
        // 기본 타입이기 떄문에 제네릭타입에서 사용할 수 없다. >> 따라서 래퍼클래스와 같이 사용해야 된다
        // 배열과 리스트는 배열 공간의 번호가 자동으로 부여된다 따라서 이같은 자료형의 장점은 인덱스 순서가 있다는 것.

        // map은 공간의 이름을 내가 마음대로 작성할 수 있다(key값이 곧 방번호니까) 그대신 인덱스 번호가 부여되지 않는다.
        // 반복문을 쓸 수가 없다. 따라서 일반적 for문으로 인덱스 번호로 접근하는 것이 아닌 for each문으로 요소에 접근할 수 있다.

        // 기준이 되는 key는 중복가능하다. 그러다 value는 중복 가능하다(파이썬과 동일), 그니까 나 : 30, 너 : 30은 되는데
        // 나 : 30, 나 : 50의 형태는 안된다는 것.

        // hashmap
        // treemap

        HashMap<String, Integer> map = new HashMap<>(); // java.util에 클래스 존재.
        // put()으로 요소들을 저장할 수 있다. ArrayList는 add
        map.put("thirty",30);
        map.put("ten",10);
        map.put("fourty",40);
        map.put("fifty",50);
        map.put("ten",500); // 키값이 동일하게 주어지면 마지막에 추가된 요소가 기존의 값을 덮어씌운다.

        // 출력해보면 순서가 없다는 것을 알 수 있다. 그러나 재실행마다 바뀌지는 않는다.
        // 인자를 둘다 String 타입으로 설정하고 이름, 폰 번호를 입력하는 해쉬맵
        HashMap<String, String> map2 = new HashMap<>();

        map2.put("기명찬","1234 1234");
        map2.put("나나","5678 5678");

        System.out.println(map); // 컬렉션들은 출력 시 toString으로 알아서 요소값들이 출력됨 -> ArrayList처럼.
        System.out.println(map2);

        // map을 원하는 값만 가져오기.

        System.out.println(map.get("ten"));
        System.out.println(map2.get("기명찬"));

        // map에서 key만 출력

        System.out.println(map.keySet()); // 키만 갖고오는 메서드
        System.out.println(map.values()); // 값만 갖고오는 메서드.

        for ( String tmp : map.keySet()){ // map 그 자체로 포문에 들어갈 수 없고 배열형태의 키와 값을 반복할 수 있다.
            System.out.println(tmp); // 이 때 key와 value의 타입을 잘 확인하고 요소의 타입을 선언해줄 것.
        }
        for ( int tmp : map.values()){
            System.out.println(tmp);
        }

        String q = "ten";

        for(String key : map.keySet()){
            if( q.equals(key)){
                System.out.println("찾는 키가 있습니다.");
                break;
            }
        }

        System.out.println(map.get("ten")); // get 메서드는 한개만 가져옴. 아마 밸류값으로 키에 접근이 불가능한 것은 파이썬과 동일한 듯.


    }
}