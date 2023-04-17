package treeMap;

import java.util.TreeMap;

public class TreeMapMain {
    public static void main(String[] args) {

        TreeMap<Integer, String> cats = new TreeMap<>();

        cats.put(7,"페르시안");
        cats.put(3,"러시안블루"); // 데이터를 추가할떄 키값을 비교하고 오름차순으로 데이터를 저장한다.
        cats.put(5,"냐옹이");
        System.out.println(cats); // int형 키값으로 정렬된 것을 알 수 있음.
    }
}
