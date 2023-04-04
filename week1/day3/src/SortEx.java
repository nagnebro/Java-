import java.util.Arrays;

public class SortEx {
    public static void main(String [] args){
        //정렬
        //버블정렬

        //값 교체
        int a = 10 ;
        int b = 20 ;
        int tmp = 0;
        tmp = a;
        a= b;
        b = tmp;
        tmp = 0;
        System.out.printf("교체후  a : %d b: %d \n",a,b);
        int [] arr = {1,4,3,23,6,1,2,6,10,100,66,7,8};

        for( int i = 0; i< arr.length-1; i++){
            for( int j = 0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= tmp;
                }
            }
        }System.out.println(Arrays.toString(arr));

        //순서가 없는 자료형에 접근하는 방법(여러개를 저장하는 자료형)
        //인덱스 번호가 없는 자료형들을 말하는 거임. 아래와 같이 foreach문으로 접근 가능.
        //?쟤네도 인덱스가 있는데? immutable 타입의 객체를 말하는 건지. (iterable = 반복 가능 객체, immutable = 반복 불가 객체)
        String [] list = {"python","c++","java"};
        for(String str : list){
            System.out.println(str);
        }
    }//main의 끝
}

class StarEx02{
    public static void main(String [] args){
        for(int i = 1; i<=5; i++){
            for(int j = 1 ; j<=i; j++){
                System.out.print("*");// 파이썬에서는 문자열에 *연산으로 횟수를 늘릴 수 있기 때문에 한번으로 가능하지만
                // java에서는 이중포문을 사용해야 가능함.
            }
            System.out.println();
        }

        //1찍기
//            1
//           111
//          11111
//         1111111
//          11111
//           111
//            1

        // 전체 행 포문 1개, 공백에 해당하는 포문 거기서 1도바로 출력, 다만 공백의 방향성을 어떻게 바꿀것인가.
        // 처음에는 증감식에서 --로 시작할거고
        for (int i = 1; i<=5 ; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i * 2 - 1; k++) {
                System.out.print("1");
            }
            System.out.println();
        }
        for (int i = 1; i<=5 ; i++){
                for (int j = 1; j<=i; j++){
                    System.out.print(" ");
                }
                for( int k = 9-(i*2) ; k>=1; k--){
                    System.out.print("1");
                }
                System.out.println();
            }


        /*
        * *      *
        * **    **
        * ***  ***
        * ********
        *
         */

    }//main의 끝
}