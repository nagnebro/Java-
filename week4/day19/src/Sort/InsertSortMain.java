package Sort;

import java.util.Arrays;
import java.util.Random;

public class InsertSortMain {
    // 삽입정렬
    // -값을 하나하나 비교해서 앞에 데이터와 비교해서
    // 작으면 왼쪽으로 크면 오른쪽으로
    // -초기에는 정렬이 돼있지 않다.
    // -가장 첫번쨰 원소는 정렬이 돼있는 상태다 가정을 하고 시작.
    // -자료 배열의 모든 요소를 차례대로 이미 정렬된 배열의 부분과 비교하여 자신의 위치를 찾아서 삽입함.

    // 기본정렬
    // 삽입, 선택, 버블

    // 고급정렬
    // 퀵, 병합, 셉 정렬, 힙 정렬

    static int[] nums;
    static Random ran = new Random();

    public static void main(String[] args) {

        nums = new int[10];

        for(int i = 0; i<nums.length; i++){
            nums[i] = ran.nextInt(20);
        }
        System.out.println(Arrays.toString(nums));
        // 정렬 전의 배열 출력
        // [5,2,1,4,7,8]

        for(int i = 1; i<nums.length; i++){ // 인덱스1번부터 배열의 길이-1(끝)까지 검사한다.
            // 현재 선택된 원소의 값을 임시 변수에 저장 해준다
            int temp = nums[i]; // 현재인데스를 저장하는값

            // 현재 원소를 기준으로 이전 원소를 탐색하기 위한 Index 변수
            int prev = i -1; // 현재 인덱스의 이전값의 인덱스

            //현재 선택된 원소가 이전 원소보다 작은 경우까지만 반복
            while(prev>= 0 && nums[prev]>temp){ //prev>=0 조건이 먼저 있어서 오른쪽의 조건에서 index에러가 발생안한다?
                // 매번 인덱스 0번까지 검사하지는 않는다. 애초에 앞에서부터 정렬을하고 오기 때문에 현재값이 이전값보다 크면nums[prev]<temp
                // 그냥 다음값으로 넘어간다.
                nums[prev+1] = nums[prev];
                prev--;
            }
            System.out.println(prev);
            // 탐색이 종료된 지점에 혀냊 선택돼있던 변수값을 삽입해준다
            nums[prev+1] = temp; // 밀다가 while문이 끝나면 저장하고 있던 값을 1번쨰 숫자(인덱스0번)로 옮긴다
            // 그래서 첫번째 숫자는 정렬돼있다고 가정을 하는 것.
        }

        System.out.println(Arrays.toString(nums));

    }
}
