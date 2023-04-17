package programmers;

import java.util.Arrays;

class Solution {
    public static  int[] solution(int[] array, int[][] commands) {
        int [] result = new int[commands.length]; // 2차원 배열 커맨드의 길이만큼 배열을 생성, 그게 어차피 리턴의 개수랑 같다.
        int [] b_list = null; // before sort list
        int idx = 0;
        for (int i = 0; i< commands.length ; i++){
            b_list = new int[commands[i][1]-commands[i][0]+1]; // 커맨즈 배열의 요소들이 들어올떄 그 길이만큼 새로 배열을 생성함.
            for( int j = 0 ; j< (commands[i][1]-commands[i][0]+1)  ;j++ ){ // 여기서 j는 총반복해야하는 반복횟수 범위를 뜻한다 그떄 우리가 저장해야할 array인덱스의 시작번호는 어떻게 정할까?
                b_list[idx] = array[commands[i][0]-1+j]; // 커맨드의 [i][1]번쨰 숫자-1은 array의 시작인덱스가 된다 거기서 j만큼 더해져야
                System.out.println(array[j]);
                idx++;
            }
            result[i] = sort(b_list,commands[i][2]);
            idx = 0;
        }

      return result;
    }

    public static int sort(int [] list, int idx){

        if(list.length<=1){return list[0];}
        for(int i = 0; i<list.length-1 ; i++){
            for(int j = 0; j<list.length-1-i; j++){
                if(list[j]>list[j+1]){
                    int tmp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(list));


        return list[idx-1];
    }

    public static void main(String[] args) {
        int []  array = {1, 5, 2, 6, 3, 7, 4};
        int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int [] result = solution(array,commands);
        System.out.println(Arrays.toString(result));

    }
}