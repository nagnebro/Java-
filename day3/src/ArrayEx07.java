import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class ArrayEx07 {
    public static void main(String[] args) {

        // ============2차원 배열 시작================

        // 3개의 반에서 5명의 학생의 점수의 평균을 구하여라

        int[][] arr = {
                {40, 50, 60, 20, 30},
                {60, 58, 90, 99, 23},
                {58, 28, 11, 40, 50}
        }; // 이렇게 2차원 배열로 선언할 경우 가시성은 좋으나 2차원 배열에 접근하기 위해서는 For문을 2개를 사용해야 하는데
        // 1차원 배열에 접근하려면 for문 1개만 놓고 한 번 돌때 인덱스로 다 같이 계산해버리면 된다.
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            System.out.printf("%d반의 점수 합계는 %d입니다 \n", i + 1, sum);
            sum = 0;
        }
        //1차원 배열에서 length는 열의 길이를 뜻하고 2차원 배열에서 length는 행의 길이를 뜻한다.
        //1차원 배열에서는 1행에 열이 몇열이냐가 다른 것이고 2차원부터는 몇행이 있고 그 행에 몇열이 있냐이다.
//        for (int[] arr1 : arr){
//            for(int arr2 : arr1){
//                System.out.println(arr2);
//            }
//        }
        //부분 출력 (원하는 값만 하나 출력)
        // 배열명[행][열] 의 형태로 행열의 인덱스를 통해 배열의 값에 접근이 가능하다.


        int[][] arr3 = new int[3][3];

        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr3[i][j] = 10 * k;
                k += 1;
            }
        }

        // 문제 1) 인덱스 2개를 입력받아 값 출력
        // 예    1) 인덱스1 입력 : 1	인덱스2 입력 : 2
        //		   값 출력 : 60
        int input1, input2;
        Scanner sc = new Scanner(System.in);
        System.out.print("2차원 배열의 인덱스를 입력하시오");
        input1 = sc.nextInt();
        input2 = sc.nextInt();
        System.out.printf("입력하신 배열의 값은 %d입니다", arr3[input1][input2]);

        // 문제 2) 값을 입력받아 인덱스 2개 출력
        // 예    2) 값 입력 : 60
        //		   인덱스1 출력 : 1	인덱스2 출력 : 2
        System.out.print("2차원 배열의 값을 입력하시오");
        input1 = sc.nextInt();

        int row = 0;
        int column = 0;
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                if (arr3[i][j] == input1) {
                    row = i;
                    column = j;
                }
            }
        }
        System.out.printf("입력한 값의 인덱스 번호의 행은 %d, 열은 %d입니다 \n", row, column);

        //문제 3) 입력받은 값 2개의 인덱스 위치(행,열)를 서로 바꾸어라.
        System.out.print("2차원 배열의 값 2개를 입력하시오");
        input1 = sc.nextInt();
        input2 = sc.nextInt();
        int row1 = 0, row2 = 0, tmp;
        int column1 = 0, column2 = 0;
        for (int i = 0; i < arr3.length; i++) { // 배열의 행을 돌리는 for문
            for (int j = 0; j < arr3[i].length; j++) { // 배열의 행에 들어와서 열을 돌리는 for문
                if (arr3[i][j] == input1) { // 입력값과 배열의 값이 같은지 비교
                    row1 = i;
                    column1 = j;
                } else if (arr3[i][j] == input2) {
                    row2 = i;
                    column2 = j;
                }
            }
        }

        for(int [] arr1 : arr3){
            System.out.println("바뀌기전의 배열은 "+Arrays.toString(arr1));
        }
        tmp = arr3[row1][column1];
        arr3[row1][column1] = arr3[row2][column2];
        arr3[row2][column2] = tmp;
        for (int [] arr1 : arr3){

            System.out.println("바뀐후의 배열은 "+ Arrays.toString(arr1));
        }
        /*
        배열을 정리하는 메서드
        sort(배열명);
         */
        int [] testarr = {30,50,10,20,2,5,99};
        Arrays.sort(testarr);
        // 배열을 오름차순으로 정렬해주는 메서드 Arrays.sort(배열명)
        // 내림차순으로 정렬하기 위해서는 Arrays.sort(testarr,Collections.re) 다음과 같이 작성
        Integer [] testarr2 = {30,50,10,20,2,5,99};
        Arrays.sort(testarr2, Collections.reverseOrder()); //collection클래스에서는 기본 타입을 인자로 받지 않기 떄문에
        // 윗줄과 같이 코드를 조금 변경해줘야 한다. 참고만 할 것.
        System.out.println(Arrays.toString(testarr));
        System.out.println(Arrays.toString(testarr2));
    }
}