import java.util.Scanner;

public class ArrayEx03 {
    public static void main(String[] args){


        int [] hakbuns = {1001, 1002, 1003, 1004, 1005};
        int [] scores = {87,11,45,88,23};
        int idx = 0;
        int max = 0;
        //문제) 1등학생의 학번과 성적 출력
        //정답) 1004번 (98점)

        while(idx<hakbuns.length-1){
            if( scores[idx] > scores[idx+1] ){
                max = idx;
            }idx++;
        }
        System.out.printf("1등 학생의 학번은 %d, 성적은 %d입니다",hakbuns[max],scores[max]);

    }
}
