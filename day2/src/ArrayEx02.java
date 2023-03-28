import java.util.*;
public class ArrayEx02 {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        int [] hakbuns = {1001, 1002, 1003, 1004, 1005};
        int [] scores = {87,11,45,88,23};
        System.out.print("성적을 조회하고 싶은 학번을 입력하세요");
        int input = scanner.nextInt();
        first: while(true) {
            for (int i = 0; i < hakbuns.length; i++) {
                if (hakbuns[i] == input) {
                    System.out.println("조회하신 학번의 성적은 " + scores[i] + "입니다");
                    break first;
                }
            }
            System.out.println("죄송합니다. 조회하신 학번의 성적이 없습니다.");
            break;
        }// 원하는 결과값이 나오지 않았을때 , 즉 else 조건에 해당하는 출력문을 else나 else if없이 바깥의 무한 루프문으로 구현

    }
}
