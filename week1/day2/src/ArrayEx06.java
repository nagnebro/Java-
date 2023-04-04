import java.util.ArrayList;

public class ArrayEx06 {
    public static void main(String[] args) {

        // 공간을 자동으로 추가 삭제하고 조히가 가능함.
        // 배열을 쓰는데 편하게 여러개의 데이터를 저장하고 싶다!
        // ArrayList(자료형)

        //정수를 저장하고 싶다!
        ArrayList<Integer> list1 = new ArrayList<>();
        //generic, 제너릭을 이용해 ArrayList로 배열 저장.배열의 길이가 정해지지 않고 값을 추가하면 추가하는 만큼 늘어남. +1씩 증가하는진 모름.
        //추가 add()
        list1.add(10);
        list1.add(20);
        list1.add(30);

        System.out.println(list1); //

        //실수를 저장하는 배열
        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(1.562353);
        list2.add(1.5622452453);
        list2.add(5.12431513);
        list2.add(5.12431513);
        list2.add(200.2);
        System.out.println(list2);
        //200.2 '찾아서' 삭제
        //indexOf()
        //remove()
        int findnum = list2.indexOf(200.2);
        list2.remove(findnum);
        System.out.println(list2);
        ArrayList<String> list3 = new ArrayList<>();

        list3.add("hi");
        list3.add("bye");
        list3.add("you");
        System.out.println(list3);

        //ArrayList의 길이
        System.out.println("길이 : " + list1.size());
        list1.remove(1); // remove메서드는 매개변수로 인덱스 번호를 원하는 애가 있고 값을 원하는 애가 있다.
        // 값을 이용해 인덱스 번호를 찾으려면 indexOf();
        System.out.println(list1);

        //안에 있는 내용을 전부 삭제!
        list1.clear(); // 리스트의 내용 모두 삭제.
        list2.clear();
        list3.clear();
        System.out.println(list1 + "" + list2 + "" + list3);

        String str = "h";
        char chr = 'a';

    }
}