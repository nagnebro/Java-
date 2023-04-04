import java.util.*;
public class ArrayEx04 {
    public static void main(String [] args){

//        * # 숫자이동[1단계]
//		 *  1. 숫자2는 캐릭터이다.
//		 *  2. 숫자1을 입력하면, 캐릭터가 왼쪽으로 숫자2를 입력하면,
//		 *  캐릭터가 오른쪽으로 이동한다.
//                *  3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
//                *  4. {0, 0, 2, 0, 0, 0, 0}; ==> 왼쪽 ==>
//		 * {0, 2, 0, 0, 0, 0, 0};
//		 *
//		 */

        Scanner scanner = new Scanner(System.in);
        int [] game = {0,0,0,0,0,0,2};
        int idx = 6;
        int num = 0;
        while(true){
            System.out.print("좌로 이동하시려면 1, 우로 이동하시려면 2를 입력해주세요");
            num = scanner.nextInt();
            if(num == 1 && (0!=idx)){
                game[idx]=0;
                idx-=1;
                game[idx]=2;

                System.out.println(Arrays.toString(game));
            }else if(num == 2 && game.length-1!=idx){
                game[idx]=0;
                idx+=1;
                game[idx]=2;
                System.out.println(Arrays.toString(game));
            }else{
                System.out.println("다시 입력하세요");
            }
        }
    }
}
