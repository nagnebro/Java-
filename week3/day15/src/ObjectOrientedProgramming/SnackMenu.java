package ObjectOrientedProgramming;

import java.util.Scanner;

public class SnackMenu {


    private Scanner sc = new Scanner(System.in);
    SnackController scr = new SnackController();

    void menu(){
        System.out.print("스낵류를 입력하세요\n");
        System.out.print("종류 : ");
        String kind = sc.next();
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("맛 : ");
        String flavor = sc.next();
        System.out.print("개수 : ");
        int numOf = sc.nextInt();
        System.out.print("가격 : ");
        int price = sc.nextInt();


        System.out.println(scr.savedata(kind,name,flavor,numOf,price)); // 메서드 내부에서 세터로
        // 매개변수값 저장하고 완료됐다는 메시지를 리턴.

        String result = scr.confirmData(); //저장된 데이터 확인
        System.out.println("확인하겠냐?");
        String input = sc.next();
        if(input.equals("y")){
            System.out.println(result);
        }else if(input.equals("n")){
            System.out.println("종료");
        }

    }
}
