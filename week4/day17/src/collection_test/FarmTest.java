package collection_test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FarmTest {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Test> list2 = new ArrayList<>();

        list.add(3);
        list.add(5);
        list.add(1);
        System.out.println(list);
        int res = list.remove(2);
        System.out.println(res);
        System.out.println(list);
        Test t1 = new Test("gg");
        Test t2 = new Test("gg");
        Test t3 = new Test("gg");


        list2.add(t1);
        list2.add(t2);
        list2.add(t3);
        System.out.println(list2);
        boolean res1 = list2.remove(t2);
        System.out.println(list2);
        System.out.println(res1);


    }
}

