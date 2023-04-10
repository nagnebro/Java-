public class Main {
    public static void main(String[] args) {

        String str1 = "김영찬1";
        String str2 = "김영찬1;;";
        int idx = 0;
        idx = str1.indexOf(str2); // 괄호안의 문자열이 앞의 문자열에 있는지 없는지 확인하는 메서드.
                                  // str2가 str1에 속해있는지 확인하는 것. 아닐시 -1 리턴.
        System.out.println(idx);
    }
}