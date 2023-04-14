package collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void info(ArrayList<String> arr){

    }

    public static void main(String[] args) {

        LinkedList<String> list2 = new LinkedList<>();



        // add() : 값을 추가하는 arraylist의 메서드
        // 어레이시트는 벡터와 비슷한 원리이다. 추가할떄마다 배열 늘리고 추가하고 기존 거 삭제하고 그런식. 그렇기 떄문에 값의 추가 삭제 시
        // 배열의 생성 복사가 계속 일어나기 때문에 효율이 떨어짐. 그러나 인덱스번호를 갖고 있기 때문에 조회가 빠르다.
        // LinkedList는 노드를 통해 다음 참조변수의 주소값을 계속 참조하는 식. 그래서 값의 추가 삭제가 용이하지만 인덱스 번호없이
        // 값을 찾기 위해서는 서로의 주소값을 계속 타고 들어가기 떄문에 조회 시 느림.
        ArrayList<String> list = new ArrayList<>();
        list.add("김영찬");
        list.add("김영찬2");
        list.add("김영찬3");

        System.out.println(list);
        // 메서드를 이용해서 안에 있는 데이터를 출력하는데 메서드 작성.

    }
}

        // 컬렉션 - 여러 객체를 모아 놓은 것!
        // 프레임웍 - 표준화, 정형화된 체계적인 프로그래밍 방식
        // 컬렉션 프레임워크
        //  - 다수의 객체를 다루기 위한 표준화된 프로그래밍 방식
        //  - 데이터를 쉽고 편하게 다룰 수 있도록 미리 만들어놓은 자료형
        // 배열타입의 자료구조
        // ArrayList 클래스

        // 컬렉션 (인터페이스로 나눠져있다.)
        // - 아래의 3개로 정리한 계열들의 공통적인 메서드를 모아놓은 인터페이스이다.

        // List
        // - 순서가 있는 데이터의 집합, 자료형 (인덱스 번호 부여된다.)
        // - 데이터 중복을 허용한다

        // set
        // - 순서가 없는 데이터의 집합, 자료형 (인덱스 번호 부여 안된다.)
        // - 로또같이 중복적인 내용을 제거해야 될 떄 구현하는 것!

        // map
        // - key , value를 이용해서 쌍(pari)으로 데이터의 집합, 자료형
        // - 순서가 없으며, 키는 (리스트 인덱스) 중복 허용x, 값은 중복 허용 된다.
