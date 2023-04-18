package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class LottoTest {
    public static void main(String[] args) {

        HashSet h1 = new HashSet();

        h1.add("3"); // 해쉬 셋은 중복추가가 안된다.
        h1.add("1");
        h1.add("2");
        h1.add("5");
        h1.add("ㅂㅂ");
        System.out.println(h1);
        System.out.println(h1.contains("ss"));
        System.out.println(h1.remove("sss"));
        System.out.println(h1);
        Random r = new Random();

        int ran2 = (int)(Math.random()*4); // 0~temp의 길이-1만큼의 값을 저장 (win의
        ArrayList<Test> list = new ArrayList<Test>();
        list.add(new Test());
        System.out.println(list.size());
        System.out.println(list);
        list.add(new Test());
        list.add(new Test());
        System.out.println(list.size());
    }
}

class Test{}