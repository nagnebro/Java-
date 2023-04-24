package student;

import java.util.Scanner;

public class Menu {

    Scanner sc =  new Scanner(System.in);
    MenuController mc = new MenuController();
    String admin_id = "yasuo";
    String admin_pw = "gold";

    void mainmenu(){

        mc.booting(); // 유저정보가 담겨잇는 txt파일을 한번 읽어와서 유저 정보를 담는 리스트에 추가
        while(true){

            System.out.print("1. 회원가입  2. 로그인  3. id/pw 찾기 4. 종료");
            int input = sc.nextInt();
            switch(input){

                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    find();
                    break;
                case 4:
                    return;
                default :
                    System.out.println("제대로 입력하세요");
                    break;
            }
        }
    }

    void login(){ // 로그인
        System.out.print("아이디를 입력하세요");
        String id = sc.next();
        System.out.print("비밀번호를 입력하세요");
        String pw = sc.next();

        if(id.equals(admin_id) & pw.equals(admin_pw)){
            System.out.println("관리자 로그인에 성공했습니다");
            admin();
            return;
        }

        Student s = mc.login(new Student(id,pw));

        if(s == null){
            System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다..");
            return;
        }

        System.out.printf("반갑습니다 %s님! \n",s.getName());
        addLecture(s);


    }

    void admin(){
        while(true) {
            System.out.println("admin님 반갑습니다. 메뉴를 선택하세요");
            System.out.println("1. 수강과목관리  2. 전체학생조회  3. 초기화면");
            int input = sc.nextInt();
            switch(input){
                case 1:
                    mc.addSubject();
                    break;
                case 2:
                    mc.checkStudent();
                    break;
                case 3:
                    return;
            }
        }
    }
    void signUp(){  // 회원가입

        boolean res = mc.signUp();
        if(res){
            System.out.println("회원가입이 성공했습니다.");
            return;
        }
        System.out.println("회원가입에 실패했습니다."); // 현재 조건으로는 false가 나올 수는 없다
    }

    void find(){  //   id/pw 찾기


        System.out.print("1. id 찾기  2. pw찾기 \n");
        int input = sc.nextInt();
        Student s = null;
        String phone;
        String idorpw;

        if(input == 1){

            System.out.print("가입시 입력했던 이름을 입력하세요.");
            String name = sc.next();
            System.out.print("가입시 입력했던 폰번호를 입력하세요.");
            phone = sc.next();
            s = mc.findId(name,phone);

            if(s == null){
                System.out.println("이름과 폰번호에 해당하는 학생 정보가 없습니다..");
                return;
            }

            System.out.printf("찾으시는 id는 %s입니다. \n",s.getId());



        }else if(input == 2){

            System.out.print("가입시 입력했던 id를 입력하세요.");
            String id = sc.next();
            System.out.print("가입시 입력했던 폰번호를 입력하세요.");
            phone = sc.next();

            s = mc.findpw(id,phone);
            if(s == null){
                System.out.println("이름과 폰번호에 해당하는 학생 정보가 없습니다..");
                return;
            }
            System.out.printf("찾으시는 pw는 %s입니다.\n",s.getPw());

        }else{
            System.out.println("제대로 입력하세요");
            return;
        }


    }

    void addLecture(Student s)
    {
        mc.addLecture(s);
    }
}
