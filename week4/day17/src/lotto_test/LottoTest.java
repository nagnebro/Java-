package lotto_test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class LottoTest {
    public static void main(String[] args) {

        HashSet<String> h1 = new HashSet<>();
        HashSet<Test> h2 = new HashSet<>();

        h1.add("3"); // 해쉬 셋은 중복추가가 안된다.
        h1.add("1");
        h1.add("1");
        h1.add("1");
        h1.add("2");
        h1.add("5");
        h1.add("ㅂㅂ");
        h2.add(new Test(100));
        h2.add(new Test(200));
        h2.add(new Test(300));
        h2.add(new Test(400));
        System.out.println(h2);

        System.out.println(h1);
        System.out.println(h1.contains("ss"));
        System.out.println(h1.remove("sss"));
        System.out.println(h1);
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