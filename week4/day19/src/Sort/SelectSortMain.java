package Sort;

import java.util.Arrays;
import java.util.Random;

public class SelectSortMain {

    static int[] nums;
    static Random ran = new Random();
    public static void main(String[] args) {
        // 선택정렬
        // - 하나의 배열에서 기준 최대값을 이용해서 정렬
        //   최소값을 이용해서 정렬을 할 건지 정한다

        nums = new int[10];

        for(int i = 0; i<nums.length; i++){
            nums[i] = ran.nextInt(20);
        }
        System.out.println(Arrays.toString(nums));
        // 정렬 전의 배열 출력



        //선택 정렬 시작
        // 기준은 가장 작은 값을 기준으로 정렬ㄹ
        for (int i = 0; i < nums.length ; i++){
            // 현재 탐색에서 가장 앞의 원소를 초기값으로 설정한다.
            // 각각의 반복이 진행될때마다 min이 초기화돼야한다.
            int minIndex = i; //현재 찾고있는 인덱스.
            for(int j = i+1 ; j<nums.length; j++){
                if(nums[minIndex]>nums[j]){
                    minIndex = j; // 최소값을 가지고 있는 값의 인덱스를 저장하는 곳에 현재 j의 인덱스값이 더 작으면
                    // 그 인덱스번호를 저장한다.
                }
            }
            int temp = nums[minIndex]; // 그리고 현재 인덱스 자리인 i랑 바꿔준다.
            nums[minIndex] = nums[i];
            nums[i] = temp;
            // 탐색이 완료되면 가장 작은 값을 가장 앞의 원소와 위치를 바꿔준다.
        }
        System.out.println(Arrays.toString(nums));


        for(int i = 0; i<nums.length; i++){
            nums[i] = ran.nextInt(20);
        }
        System.out.println("정렬전 : " + Arrays.toString(nums));
        // 가장 큰값을 기준으로 정렬하기
        for (int i = 0; i<nums.length-i ; i++){
            int maxIndex = nums.length -i;
            for (int j = i+1; j<nums.length; j++){ // 굳이 자기자신인 i부터 비교를 시작할 필요가없다.
                if(nums[maxIndex]<nums[j]){
                    maxIndex = j;
                }
            }
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[i];
            nums[i] = temp;
        }
        System.out.println("정렬후 : " + Arrays.toString(nums));
    }


}
