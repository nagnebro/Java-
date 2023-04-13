package String;

import java.util.StringTokenizer;

public class StringTokenMain {

    public static void main(String[] args) {

//  문자열을 구분자를 기준으로 토큰(token) 이라는
        //  여러 개의 문자열로 잘라내는데 사용
        //  구분자를 넘겨 주지 않을 경우 공백으로 설정

        // 문자열을 공백 문자를 구분자로 자리기
        //new StringTokenizer();

        // 문자열을 매개변수로 지정된 구분자로 자르기
        //new StringTokenizer(String sr,String delim);

        // 문자열을 매개변수로 지정된 구분자(delim)로 자르기
        // returnDelims 의 값을 true로하면 구분자도 토큰으로 간주
        //new StringTokenizer(String sr,String delim,boolean returnDelims);

//        먼저 split 메소드는 String클래스에 속해있는 메소드이고, StringTokenizer는 java.util에 포함되어 있는 클래스이다.
//        구분자를 split는 정규 표현식으로 구분하고, StringTokenizer는 문자로 받는다.
//        split는 결과 값이 문자열 배열이지만, stringtokenizer는 객체이다.
//                split는 빈문자열을 토큰으로 인식하는 반면, StringTokenizer는 빈 문자열을 토큰으로 인식하지 않는다. (뒤에 코드 예제)
//        성능은 split 보다 StringTokenizer 가 좋다.
//        split은 데이터를 토큰으로 잘라낸 결과를 배열에 담아서 반환하기 때문에 StringTokenizer 보다 성능이 떨어진다.
//                그러나 데이터의 양이 많은 경우가 아니라면 별 문제가 되지 않는다.

        String str1 = "Welcome to The Java HelloWorld";
        String str2 = "Wellc%ome/&to/the&%java*helloworld";

        StringTokenizer st = new StringTokenizer(str2,"&*/",true); // 다음과 같은 문자열이 있다면 그 구분자들로 다 잘라줌.
        System.out.println(st.countTokens()); // 구분자로 나눈 문자열의 개수.
        StringTokenizer st2 = new StringTokenizer(str2,"&",true); // 다음과 같은 문자열이 있다면 그 구분자들로 다 잘라줌.
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken("%"));
        System.out.println(st2.nextToken());



        }
    }



//
//        //문자열 토큰이 남아있다면 true, 없다면 false를 반환
//        while(st.hasMoreTokens()){
//
//            System.out.println(st.nextToken());
