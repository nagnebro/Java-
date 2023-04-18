package Generics;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberController mc = new MemberController();

    //	사용자가 직접 메인 메뉴를 선택 할 수 있음.
//	종료 전까지 반복 실행. 각 메뉴를 누를 시 해당 메소드로 이동.
    void mainMenu() {


        while (true) {
            System.out.println("=======KH 사이트=======");

            System.out.println("*******메인 메뉴*********");

            // joinMembership() 실행
            System.out.println("1. 회원 가입 ");
            System.out.println("2. 로그인"); // login()실행 후 memberMenu() 실행
            System.out.println("3. 같은 이름 회원 찾기"); // sameName()
            System.out.println("9. 종료!"); // 프로그램 종료 후 main()

            System.out.print(">");
            int key = sc.nextInt();
            switch (key) {

                case 1: {
                    joinMembership();
                    sc.nextLine();
                    break;
                }
                case 2: {
                    login();
                    System.out.println("멤버");
                    break;
                }
                case 9: {
                    System.out.println("프로그램 종료!");
                    return;
                }
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }

    }

    void memberMenu() {
        Dan : while(true) {
            System.out.println("*******회원 메뉴********");
            System.out.println("1. 비밀번호 바꾸기");
            System.out.println("2. 이름 바꾸기");
            System.out.println("3. 로그아웃");
            System.out.print("메뉴 번호 선택 >>");
            int input = sc.nextInt();
            switch(input){
                case 1:
                    changePassword();
                    break;
                case 2:
                    changeName();
                    break;
                case 3:
                    System.out.println("로그아웃 되었습니다.");
                     break Dan;
            }
            return;
        }
    }

    void joinMembership() {
        while(true) {
            System.out.print("id > ");
            String input1 = sc.next();
            System.out.print("pw > ");
            String input2 = sc.next();
            System.out.print("이름 > ");
            String input3 = sc.next();

            Member temp = new Member(input1, input2, input3);
            boolean res = mc.joinMembership(input1, temp); // 아이디로만 중복을 검사한다.

            if (res) {
                System.out.println("중복된 아이디입니다 다시 입력하세요");

            } else {
                System.out.println("가입완료");
                return;
            }
        }
    }

    void login() {
        while(true) {
            System.out.print("id > ");
            String input1 = sc.next();
            System.out.print("pw > ");
            String input2= sc.next();

            String result = mc.login(input1, input2);
            if(result==null){
                System.out.println("틀린 아이디 혹은 비밀번호다");
                continue;
            }else{
                System.out.println(result+"님 환영합니다!");
            }
            memberMenu();
            return;
        }
    }

    void changePassword() {
        while(true) {
            System.out.println("현재 아이디 입력");
            String input1 = sc.next();
            System.out.println("현재 비번 입력");
            String input2= sc.next();
            System.out.println("변경할 비번 입력");
            String input3= sc.next();

            boolean res = mc.changePassword(input1, input2, input3);
            if (res) {
                System.out.println("비밀번호가 변경 완료 됐습니다");
                return;
            } else {
                System.out.println("비밀번호 변경에 실패했습니다 다시 입력하세요");

            }
        }
    }

    void changeName() {
        while(true) {
            System.out.println("현재 아이디 입력");
            String input1 = sc.next();
            System.out.println("현재 비번 입력");
            String input2= sc.next();

            String result = mc.login(input1, input2); // 나의 id
            if (result != null) {
                System.out.println("새 이름을 입력하세요");
                String newName = sc.next();
                mc.changeName(input1,newName); // 나의 아이디와 새로운 이름? 아이디를 입다
                return;
            } else {
                System.out.println("이름 변경에 실패했습니다. 다시 입력하세요");

            }
        }

    }

    void sameName() {

        System.out.print("검색할 이름을 입력하세요 : ");
        String input = sc.next();
        mc.sameName(input);


    }
}