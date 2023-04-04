import java.util.Scanner;
class LoopEx01 {
    public static void main(String[] args) {

        /*
         * # 반복문 for
         * 1. 반복문의 조건 3가지
         * 1) 초기식
         * 2) 조건식
         * 3) 증감식
         * 2. for문의 구조
         * for(초기식;조건식;증감식){
         * 		조건식이 참일 동안 실행할 문장;
         * }
         * 3. for문의 실행순서
         * 초기식 → 조건식 → 실행문 → 증감식 → 조건식 → 실행문 → 증감식 ...
         */
        // for( int i = 0; i<10 ; i++)의 형태로 있을 때 정수형태 변수 i의 초기값을 0으로 선언해준 후
        // i가 10이하일때 계속 실행하는데 실행 후에는 증감식 i++을 통해 i의 값이 1증가되고 다시 조건을 비교하고 실행문을 반복하는 형태임.

        // 1부터 10까지 반복해 3미만 7이상 출력
        for (int i = 1; i<=10 ; i++){
            if (3<=i && i<=7) {
                System.out.println(i);
            }
        }

        // 1부터 100까지 반복 홀수와 짝수의 합을 각각 출력
        int jjak = 0;
        int hol = 0;
        for (int i = 1 ; i<=100 ; i++){
            if(i%2==0){
                jjak+=i;
                continue;
            }
            hol+=i;
        }
        System.out.printf("짝수는 %d 홀수는 %d입니다 \n",jjak,hol);

        // 1. 5회 반복하면서 정수를 입력받는다.
        // 2. 입력받은 정수의 합을 출력한다.
        // 3. 만약에 입력받은 합이 100이상이면 반복이 5회가 아닐지라도 즉시 종료
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int i = 1;
        for( i=1; i<=5  ; i++){
            if(sum>=100){
                break;
            }
            System.out.println(i);
            System.out.printf ("값을 입력하세요 현재 총합 : %d",sum);
            sum += sc.nextInt();
        }
        System.out.println(sum);


    }
}