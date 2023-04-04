import java.util.Scanner;

public class MethodEx02 {


    public static int add(int a, int b){
        return a+b;

    }

    public static float div(int a, int b){
        return (float)a/b;
    }
    public static int multi(int a , int b){
        return a*b;
    }

    public static int sum(int a){
        int sum =0, i = 1;
        while (i<=a){
            sum+= i;
            i++;
        }
        return sum;
    }

    public static int maxNumber(int a, int b, int c) {
        int max = 0;
        if (a > b && a > c) {
            max = a;
        } else if (b > c) {
            max = b;
        } else {
            max = c;
        }
        //return a>b && a>c ? a: b>c ? b : c;  다음과 같이 3항 연산자로 간결하게 표현 가능.
        return max;
    }

    public static int minNumber(int a, int b, int c){
        int min = 0;
        if(a<b && a<c){
            min = a;
        }else if(b<c){
            min = b;
        }else{
            min = c;
        }
        //return a<b && a<c ? a: b<c ? b : c;
        return min;

    }

    public static boolean equals(String str1, String str2){
        return str1.equals(str2);
    }

    public static void method1(){
        int i = 0;
        String str = "aa";
        double j = 3.234;

        // 메서드는 다음과 같이 하나의 값밖에 리턴할 수 없다.

    }


    public static void main(String[] args) {

        int a = 10, b= 20;
        int res = add(a,b);
        float res1 ;
        System.out.println(res);
        res = multi(a,b);
        System.out.println(res);
        res1 = div(a,b);
        System.out.println(res1);

        // 1부터 매개변수까지의 값을 더한 다음 결과를 return하는 메서드 만들기
        int res3 = sum(10);
        System.out.println(res3);

        // 함수명 : maxNumber, minNumber
        // 3개의 정수를 매개변수로 받아서
        // 가장 큰 값과 가장 작은 값을 return하는 메서드  >>> 배열로 담아서 리턴?

        int max = 0, min = 0;
        System.out.println("max : "+maxNumber(190,1360,2140));
        System.out.println("min : "+minNumber(190,1360,2140));


        // 문자열을 비교하는 함수
        // equals
        // 매개변수 str1, str2
        // return true, false

        String str1 = "hello", str2 = "hello";
        System.out.println(equals(str1,str2));


    }

}

class MethodTest1{

    public static void main(String [] args){
        // 하나의 정수를 Scanner로 받아서 제곱하는 함수를 만드세요
        // 입력 () 정수, 함수명 sq, reutrn해도 되고 안해도 되고.
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요");
        int input= sc.nextInt();
        System.out.println(sq(input));
    }

    public static int sq(int input){
        return input*input;
    }
}

/*
 // 메서드 간의 인자값과 return값의 전달에 대한 개념을 설명해주는 코드.
    public static void main(String [] args){
        int age = 26;
        String name = null;
        name = getname(age); // 전달인자 main메서드의 age룰 getname메서드로 넘겨줌. getname메서드에서는 매개변수로 활용됨.
        System.out.println(name); //

    }

    public static String getname(int age){ // main 메서드로부터 받은 인자값이 매개변수 age로 다시 들어오게 됨.
        System.out.println(age);  메인 메서드의 getname()에서 인자로 전달받은 age를 출력하고 return으로 문자열을 돌려줌.
        String name = "김영찬"; // 문자열을 return함으로서 호출한 메서드에서 리턴값을 재사용 할 수 있게 됨.
        return name;
    }


 */