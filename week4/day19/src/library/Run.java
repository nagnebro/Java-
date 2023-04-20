package library;

import java.util.TreeSet;

public class Run {
    public static void main(String[] args) {
        BookMenu b = new BookMenu();
        b.mainMenu();
    }
}



class RunTest{
    public static void main(String[] args) {

        String str1 = "abcd";
        String str2 = "avc";
        TreeSet <Run> tr = new TreeSet<>();

        System.out.println(str1.contains("a")); // 헷갈리네  str에 a가 있는건지 검사하는거고 이거는
        System.out.println("a".contains(str1)); // 이거는 a에 str1의 값인 abcd가 있는지 검사하는 거고
        System.out.println(str1.compareTo(str2));
    }
}