package diagram;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {

        MusicView m = new MusicView();
        m.mainMenu();

//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(list.size());
//        System.out.println(list);
//        list.add(null);
//        System.out.println(list.size());
//        list.set(0, 55);
//        System.out.println(list);
        // arrayList 는 다음과 같이 길이가 0일떄 set쓰면 값이 들어가지 않는데 null을 쓰면 안에 값은 없지만 길이는 1이 늘어남으로서
        // 반복문에도 들어갈 수 있게 되고 인덱스 에러가 발생할 확률이 줄어든다. 쓸 일이 거의 없겠지만 하나의 편법이다.

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(5);
        list.add(1);
        list.add(3);
        System.out.println(list);
        String a = "aaa";
        String b = "bbb";
        char ch = a.charAt(0);
        int num1 = (int)ch;
        System.out.println((int)a.charAt(0));
        System.out.println(b.charAt(0));
        String abc = "abcl";
        //Music m2 = (Music)abc;

    }
}
