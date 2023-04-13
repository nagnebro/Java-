package Problem;

import java.util.Random;
import java.util.Scanner;

public class KakaoT{
//     	 * # 카카오 택시
//	 * 1. 손님을 태워 목적지까지 이동하는 게임이다.
//	 * 2. -10~10 사이의 랜덤 숫자 2개를 저장해 목적지로 설정한다.  //동서남북의 x y 좌표를 뜻하는건가?
//         * 3. 메뉴는 아래와 같다.
//	 * 		1) 속도설정 : 1~3까지만 가능  // 좌표 칸수
//	 * 		2) 방향설정 : 동(1)서(2)남(3)북(4) // 좌표 방향? 동쪽이면 +x 서쪽이면 -x>
//         * 		3) 이동하기 : 설정된 방향으로 설정된 속도만큼 이동
//	 * 4. 거리 1칸 당 50원씩 추가되어 도착시 요금도 출력한다.
//	 *
//             */


     Scanner scan = new Scanner(System.in);
     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);

         // 목적지(destination)
         int desX = new Random().nextInt(21)-10; //0~20 사이의 랜덤한 숫자가 나오는데다가 -10을 뺴서 -10~10사이의 숫자를 뽑음
         int desY = new Random().nextInt(21)-10;

         // 현재 위치
         int x = 0;
         int y = 0;

         // 방향(direction)
         int dir = 0;

         // 속도
         int speed = 0;

         // 요금
         int fee = 0;

         // 방향 리스트
         String [] dir_list = {"방향없음","동","서","남","북"};

         int input ; // 사용자의 입력값을 저장하는 변수
         boolean run = true;
         while(run) {

             System.out.println("= 카카오 택시 =");
             System.out.println("목적지 : " + desX + "," + desY);
             System.out.println("현위치 : " + x + "," + y);
             System.out.println("방   향 : " + dir+" , "+ dir_list[dir]);
             System.out.println("속   도 : " + speed);
             System.out.println("============");

             System.out.println("1.방향설정");
             System.out.println("2.속도설정");
             System.out.println("3.이동하기");

             System.out.print("메뉴 선택 : ");
             int sel = scan.nextInt();

             if(sel == 1) {
                 System.out.println("좌표를 입력하세요 1. 동쪽 2. 서쪽 3. 남쪽 4. 북쪽");
                 input = scan.nextInt();
                 dir = input;
                 System.out.println("방향이 설정됐습니다.");
             }else if(sel == 2) {
                 System.out.println("방향을 입력하세요 1~3만 설정가능합니다.");
                 input = scan.nextInt();
                 if(1<=input && input <=3){
                     speed = input;
                     System.out.println("속도가" + speed + "로 설정됐습니다");
                     continue;
                 }
                 System.out.println("속도 설정 가능 범위가 초과했습니다.");
             }
             else if(sel == 3) {
                 System.out.printf("고객님이 입력하신 방향은 %s, 속도는 %d입니다. \n",dir_list[dir],speed);
                 System.out.printf("현재좌표    x : %d, y : %d\n",x,y);
                 switch(dir){
                     case 1:
                         x+=speed; // 나중에 수정하자 더 좋은 방법 있음.
                         break;
                     case 2:
                         x -= speed;
                         break;
                     case 3:
                         y-= speed;
                         break;
                     case 4:
                         y+=speed;
                        break;
                 }
                 System.out.printf("이동 후 좌표   x : %d y : %d \n",x,y);
             }

             if( x == desX && y==desY) {
                 System.out.println("목적지에 도착했습니다.");
                 run = false;
             }
         }
     }
}
