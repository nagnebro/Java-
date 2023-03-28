import java.util.Arrays;
import java.util.Random;
class ArrayEx01 {

    public static void main(String[] args) {
        //배열 동일한 타입의 변수를 여러개 묶었다.

        //학생분들의 점수를 저장하는 배열 25명

        // 단점 삭제x 추가x (공간);

        //숫자(인덱스) 0부터

        int[] scorelist1 = new int[25];
        int[] scorelist2 = {};
        int[] scorelist3;
        // 다음과 같이는 선언이 불가능하다 scorelist3 = {};

        //배열의 길이
        System.out.println(scorelist1.length);

        //문제1) 10부터 50까지  arr배열에 저장
        //정담1) 10 20 30 40 50

        int[] arr = {10, 20, 30, 40, 50};
        //문제2) 전체 합 출력
        int sum = 0;
        sum = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
        //정답2) 150
        System.out.println(sum);

        int count = 0;
        //문제3) 4의 배수의 개수 출력
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 4 == 0) {
                count++;
            }
        }


        System.out.println(count);

        String[] menu = {"마라탕", "돈까스", "김밥", "컵밥", "라면"};
        Random r = new Random();
        int rannum = r.nextInt(5);
        System.out.println(menu[rannum]);

        //로또 프로그램을 작성
        //1~45개 중 하나를 뽑는다.
        int []lotto = new int[6];

        //중복 상관 없음 하나씩 뽑아서 각각의 배열에 저장출력
        for (int i = 0 ; i<lotto.length ; i++){
            lotto[i] = r.nextInt(45)+1;
        }

        System.out.println(Arrays.toString(lotto));

        //중복을 제거하는 명령문을 추가
        //45번까지 배열을 만들어서 거기서 랜덤으로 뽑는 방법이 있고 위 코드에서 크게 수정없이 만들기 위해서는
        //if문으로 조건을 추가해서 배열안에 추가하려는 번호가 있다면 배열에 안넘겨주고 다른 값 넘겨줘야하는데 해당하는
        //적절한 메서드가 뭐가 있는지 생각이 나지 않음. 
    }
}