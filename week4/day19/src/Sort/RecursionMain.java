package Sort;

public class RecursionMain {

    public static void function(int num){
        if (num ==0){
            return;
        }
        System.out.println("반갑습니다");
        num--;
        function(num);
    }

    public static void baekjoon(int num){


    }
    public static void main(String[] args) {
        // 재귀함수
        // -자기 자신을 다시 호출하여 문제를 해결해 가는 함수.
        // -StackOverFlow 에러가 발생할 수 있기 때문에 함수의 종료 조건을 잘 설정해줘야 한다.
        //
        try{

            function(5);
        }catch( StackOverflowError e){
            System.out.println("g");
        }

        System.out.println(function2(5));
    }

    // 1부터 5까지의 합을 구하는 재귀함수

    public static int function2(int num){
        if(num == 1){return 1;}
        return num+function2(num-1);
    }
}
