import java.util.Arrays;
import java.util.Scanner;


public class StringEx {
    public static void main(String [] args){
        String [] arr = {
                "박효신","홍길동","초롱초롱","java","python","군고구마","컴퓨터","안녕"
                ,"포스트맨","노트북","애플","아이폰", "삼성"
        };
        Arrays.sort(arr);  // 문자열 배열이 정렬이 가능은 하다.
        System.out.println(Arrays.toString(arr));

        // 문자열끼리 같은지 다른지 판별하는 메서드  String.equals(String);
        "abvc".equals("abcc"); // 반환 타입은 boolean

        //compareTo()
        /*
        숫자일때는 비교했을 때 같으면 0    ??? 메서드가 매개변수로 String타입만 받는 것 같은데 확인 필요.
        다르면 다음과 같다.   기준이 되는 값 > 비교하는 값 보다 클때는 1.(양수)
                         기준이 되는 값 < 비교하는 값 보다 작을때 -1(음수)


        문자열일때는 아스키코드값이나 유니코드값을 이용해 절대적으로 메모리를 차지하는 크기를 비교한다.
        사용법 : 기준값.compareTo(비교값)
         */
        String str1 = "가";
        String str2 = "나";
        String str3 = "가";

        int res1 = str1.compareTo(str2);
        int res2 = str2.compareTo(str3);
        int res3 = str1.compareTo(str3);

        System.out.println(res1); // 기준값(가)의 코드가 비교값(나)의 코드보다 작기 때문에 -가 출력
        // 현 예제에서는 한글을 이용한 유니코드기 때문에 출력값이 이상한 듯.
        System.out.println(res2); // 기준값 나의 값이 가보다 크기 떄문에 +가 출력
        System.out.println(res3); // 기준값 가와 가가 같으니 0이 출력.

        String str = "hello";
        char ch = str.charAt(2);
        System.out.println(ch);
        str = "python java html jsp spring";

        // charAt처럼 char타입의 문자 1개만 받아오는 것이 아닌 문자열 여러개를 추출하는 메서드(슬라이싱)
        // substring(시작번호, 끝번호) 파이썬과 마찬가지로 끝의 인덱스 번호는 포함하지 않는다. 그리고 공백도 역시 문자열로 간주한다.
        str = str.substring(3,6);
        System.out.println(str);

        str ="python,java,html,jsp,spring";
        // 구분자를 이용해서 문자열을 잘라내는 메서드
        // split() 파이썬과 동일
         // 문자열에서의 구분자를 의미하기 때문에 외따옴표가 아닌 쌍따옴표를 사용해야 한다.
        String [] arr1 = str.split(",");
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);

        System.out.println(str.length());
        // 주민번호로 여자인지 남자인지 판별하는 문제

        String jumin = "890101-2012932";
        if(jumin.charAt(7)=='2'){
            System.out.println("여성입니다");
        }else{
            System.out.println("남성입니다");
        }
        //이 방법이 아니고 -를 기준으로 split시킨 후 인덱스번호가 1인(2번째)문자열을 저장한 뒤 그 두번째 문자열의 첫번째 인덱스(0번)를
        //판별해서 2가나오면 여자인 것으로도 판별이 가능함.
        String test = "avx,cc";
        String [] testarr;
        testarr = test.split(",");
        System.out.println(testarr[1]+"   "+testarr[0]);

        //이메일을 입력받고 9글자 이상 가입가능, 미만은 가입이 불가능한 프로그램 만들어라.
        //구분자를 이ㅛㅇ해서 아이디와 도메인주를 분리
        //.com 인지 .net인지에 따라 가입이 가능한지 불가능한지 판별.

        /*
        숫자를 정수로 바꾸는 법은 그냥 숫자랑 빈 문자열을 더해주면 되긴 하지만 정석은 다음과 같다.
        String str = String.valueOf(숫자);
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("이메일을 입력하세요 : ");
        String email = sc.nextLine();
        String name = null, domain = null;
        String [] emailarr = email.split("@"); //email을 @을 기준으로 앞뒤로 나눔.
        name = emailarr[0]; //@앞의 문자열을 아이디로 저장.
        String [] emailarr2 = emailarr[1].split("\\."); //@뒤의 문자열을 다시 컴마를 기준으로 문자열 배열로 나눠준다.
        // 단 콤마를 기준으로 나누기 위해서는 이스케이프 코드를 써서 다음과 같이 나타내야한다.
        domain = emailarr2[1]; // @뒤의 도메인 문자열에서 다시 .을 기준으로 문자열을 나눈 후 뒤쪽의 주소 형식을 저장.
        System.out.printf("%s , %s",name,domain);

    }
}
