import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Movie {
        /*
         * # 영화관 좌석예매 : 클래스 + 변수
         * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
         * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
         * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
         * 4. 한 좌석당 예매 가격은 12000원이다.
         * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
         * 예)
         * seat = 0 0 0 0 0 0 0
         *
         * 좌석선택 : 1
         * seat = 0 1 0 0 0 0 0
         *
         * 좌석선택 : 3
         * seat = 0 1 0 1 0 0 0
         *
         * 좌석선택 : 3
         * seat = 0 1 0 1 0 0 0
         * 이미 예매가 완료된 자리입니다.
         * ----------------------
         * 매출액 : 24000원
         */
    public static void s_print(ArrayList<Integer> s_list){ // 만약에 어레이리스트를 메인 메서드에 선언하지 않고 새로운 클래스에 생성한 후에
        // 그 클래스의 참조변수로 접근한다면 매개변수로 일일히 이렇게 넘겨주지 않아도 돼서 편하긴하다. 다만 메서드에 접근할때 마다 참조변수로 접근해야 하니
        // 그게 좀 귀찮을 순 있지만 매개변수로 어레이리스트 계속 넘기는 것 보다는 나은 것 같다.
        String str = "";
        for (int i = 0 ; i<s_list.size(); i++){
            str += " "+s_list.get(i); // 문자열과 정수 더하면 문자열이된다.
        }
        System.out.println(str);
    }

    public static int showSales(

    ){



        return 3;
    }
    public static void main(String[] args) {
        ArrayList<Integer> s_list = new ArrayList(Arrays.asList(0,0,0,0,0,0,0,0)); // seat list
        Scanner sc = new Scanner(System.in);
        int price = 0;
        while(true){
            s_print(s_list);
            System.out.println("현재매출 : "+price);
            System.out.println("예약할 좌석을 입력하세요");
            int input = sc.nextInt();
            if(input == 99) {
                System.out.println("종료합니다.");
                break;
            }
            else if (s_list.get(input-1) == 0){ // 0번 자리를 없애기 위해 1을 빼준다. 즉 1번 자리를 입력받으면 인덱스 0번이 수정되게끔.
                s_list.set(input-1,1); // ArrayList의 요소값을 변경하기, 얘 역시 입력받은거에 1을 뺀만큼의 인덱스 요소를 수정해줘야 한다.
                System.out.printf("%d번 자리가 예매완료됐습니다.",input);
                price += 4000;
            }else{
                System.out.println("이미 예매가 완료된 자리입니다.");
            }

            }
        }
    }

