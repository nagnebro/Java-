package Problem;

import java.util.Scanner;

public class ShoppinMall {
//     * # 쇼핑몰 뒤로가기
//	 *
//             * 문제) 쇼핑몰메인메뉴에서 남성의류를 선택해서
//	 *      뒤로가기 누르기전까지 남성의류 페이지 를 유지할려고한다.
//            * 힌트) 개층 별로 반복문을 추가 해주면된다.
//	 * 1. 남성의류
//	 * 		1) 티셔츠
//	 * 		2) 바지
//	 * 		3) 뒤로가기
//	 * 2. 여성의류
//	 * 		1) 가디건
//	 * 		2) 치마
//	 * 		3) 뒤로가기
//	 * 3. 종료
//	 */
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean run = true;
        int input;
        while(run) {

            System.out.println("1.남성의류");
            System.out.println("2.여성의류");
            System.out.println("3.종료");

            System.out.print("메뉴 선택 : ");
            int sel = scan.nextInt();

            if(sel == 1) {

                do {// 입력값이 3이나오기 전까지는 무한 반복을 시켜야한다. 이떄 출력문을 먼저 나오게만들고
                    // 입력값을 받게되면 if문을 하나써서 while문을 빠져나갈 수 있다. 하지만 do while문을
                    // 작성하게 되면 다음과 같이 추가 조건없이 가능하다.
                    System.out.println("1)티셔츠");
                    System.out.println("2)바지");
                    System.out.println("3)뒤로가기");
                    System.out.println("원하는 메뉴를 입력하세요");

                }while((input = scan.nextInt())!=3);
                // do while문에 구조에 의해 우선 처음 1회는 무조건 블럭안의 문장이 실행되며 while 문의 조건으로 들어가게 된다
                // 이 떄 나는 입력을 받게되고 입력이 3이 아닐경우 계속 루프를 도는 식으로 구현했다. 비교연산자와 대입연산자의 우선순위가 있기 떄문에
                // 괄호를 통해 input에 먼저 입력값을 대입해준다.
            }
            else if(sel == 2) {
                do{
                    System.out.println("1)가디건");
                    System.out.println("2)치마");
                    System.out.println("3)뒤로가기");
                    System.out.println("원하는 메뉴를 입력하세요");
                }while((input = scan.nextInt())!= 3);
            }
            else if(sel == 3) {
                run = false;
                System.out.println("프로그램 종료");
            }
        }

    }
}
