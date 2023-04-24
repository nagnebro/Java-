package BookMarket;

import bookMarketGui.ChatClient;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Scanner;

public class Book{
    String [][] b_list = null; // 도서 항목을 저장할 리스트.
    // 그걸로 조건문 처리하라는 것.
    Scanner sc = new Scanner(System.in);
    Cart c = new Cart();
    UserDelivery delivery = new UserDelivery();
    private String adminId = "goldfish";
    private String adminPw = "mine";




    void initBookList(){ // 구매할 수 있는 책 목록을 나열해놓는 메서드
        //2차원배열을 어떻게 처리할지 몰라서 일단 나둔다.
        sc = new Scanner(System.in);
        // 책의 정보는 1번째가 제목 그다음8번쨰가 다시 제목이다 따라서
        // 제목은 2차원배열의 리스트의 첫번쨰요소, 내용은 2차원배열 리스트의 두번쨰 요소로 저장하라는 것.
        String str ;
        int i = 1; // 개수7개를 저장하기 위한 카운터.
        int amount = 0; // 행을 바꾸기 위한 카운터
        int length = 0; // 책을 저장할 배열의 길이를 측정하는 카운트
        FileReader fr = null;
        try {
            fr = new FileReader("./book");
            BufferedReader br = new BufferedReader(fr);
            while(br.readLine()!= null){ // 배열을 생성하기 위해 길이측정하는 for문
                if(i%7==0) {
                    length++;
                }i++;
            }
            br.close();
            fr.close();// 닫아주지 않으면 처음부터 읽지를 못함.
            // 제일 베스트는 길이 확인하면서 그때그떄 저장하는 건데.. 그러긴 힘듬

            fr = new FileReader("./book");
            br = new BufferedReader(fr);
            b_list = new String[length][7];
            i=1;
            while ((str = br.readLine())!=null){ // br.readLine, 버퍼가 book 파일을 읽어왔을 때 null일떄까지 계속 반복하는 조건을 붙여준다.

                b_list[amount][i-1] = str;
                if(i%7 ==0) { // 책의 정보는 총 7개로 구성돼있으니 다음과 같이 구분시켜준다.
                    amount ++;
                    i=1;
                    continue; // 아래 i의 증감을 막기위해 continue
                }
                i++;
            }
            fr.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }// 책의 정보를 출력해준다.

    }


//        System.out.print("도서 ID : ");
//        String bookId = sc.next();
//        System.out.print("도서 ID : ");
//        String bookName = sc.next();
//        System.out.print("도서 ID : ");
//        String price = sc.next();
//        System.out.print("도서 ID : ");
//        String author = sc.next();
//        System.out.print("도서 ID : ");
//        String bookId = sc.next();
//        System.out.print("도서 ID : ");
//        String bookId = sc.next();
//        System.out.print("도서 ID : ");
//        String bookId = sc.next();




    void showList(){
        initBookList();
        for(String [] list : b_list){
            for (String str1 : list){
                System.out.print(str1+" | ");
            }
            System.out.println();
        }
    }



    void menuCartItemList(){ // 내 장바구니의 목록 리스트
        c.menuCartItemList();
    }
    void menuCartClear(){

        c.menuCartClear();
        System.out.println("장바구니 초기화가 완료됐습니다");
    }

    void menuCartAddItem(){
        showList();// 구매할 수 있는 책 목록을 출력
        System.out.print("구매하실 책의 ID를 입력하세요");
        String bookId = sc.next();
        boolean res = c.menuCartAddItem(b_list, bookId);

        if(res){
            System.out.println("장바구니에 도서를 추가했습니다");
            return;
        }
        System.out.println("도서 추가에 실패했습니다");



    }

    void menuCartRemoveItemCount(){
        c.menuCartItemList();
        System.out.print("수량을 줄일 도서명을 입력하세요");
        String input = sc.next();
        boolean res = c.menuCartRemoveItemCount(input);
        if(res){
            System.out.println("도서 수량 조절을 완료했습니다");
            return;
        }
        System.out.println("도서 수량 조절에 실패했습니다. 도서명을 확인하세요.");
    }
    void menuCartRemoverItem(){
        System.out.printf("삭제할 도서의 ID를 입력하세요 : ");
        String bookNum = sc.next(); // 삭제하고자 하는 책의 이름

        boolean res = c.menuCartRemoverItem(bookNum);

        if( res) {
            System.out.println("장바구니에서 도서 제거에 성공했습니다.");
            return ;
        }
        System.out.println("도서 항목 제거에 실패했습니다. ");
    }

    void menuCartBill(User u){ // delivery, 장바구니에 있는 물품을 배송주문.
        UserDelivery ud  = c.menuCartBill(u); // 장바구니에 추가하기 위해 고객이 입력한 배송정보를 가져옴.
        if(ud != null){
            /////; // 현재 로그인된 유저의 인스턴스와 그 유저가 배송한 정보가 담긴ud 인스턴스를 고객들의 배송정보가
            // 당긴 해쉬맵에 저장.

            System.out.println("고객님의 배송목록은 다음과 같습니다."); // 이렇게 체크해도 되고 아니면 컨트롤러에서 책없으면 바로 리턴하게끔해도 되고
            System.out.println("----------배송 받을 고객 정보-----------");
            System.out.printf("고객명 :  %s           연착처 : %d\n" , ud.getD_name(),ud.getD_phone());
            System.out.printf("배송지 :  %s           주문일 : %s\n" , ud.getD_address(),"2023/04/24");//날짜 반환하는 클래스 import 사용
            System.out.println("장바구니 상품 목록 : ");
            c.menuCartItemList();
            System.out.printf("%-20s : %d원\n"  ,  "주문금액",c.carttotalprice());
            HashMap<User,UserDelivery> d_list = User.getD_list();
            d_list.put(u,ud);
        }

    }
    void menuexit(){
        System.out.println("로그아웃을 실행합니다.");

    }
    void adminLogin(){ // 로그인할떄 GUI로 구현할떄 비밀번호 ***표시 나게끔 할 수도 있음.

        System.out.print("관리자 ID를 입력하세요 : ");
        String id = sc.next();
        System.out.print("관리자 Pw를 입력하세요 : ");
        String pw = sc.next();

        if( id.equals(this.adminId) & pw.equals(this.adminPw)) { // 스캐너로 받은 입력값은 객체가 아닌 리터럴이 맞긴하나 스캐너로 받았기 떄문에 또 다른 구분자가 들어가서 ==연산자로 비교하면 false를 반환한다.
            System.out.println("관리자 로그인에 성공했습니다");
            addBookList();
            return ;
            //void adminmenu();
        }
        System.out.println("관리자 로그인에 실패했습니다.");
    } // 관리자 로그인


    void addBookList() {

        System.out.print("도서 정보를 추가하시겠습니까? Y|N");
        String input = sc.next();
        boolean res = input.equalsIgnoreCase("y");
        if (!res) return;
        FileWriter fw = null;
        String [] list = new String[7];
        System.out.print("도서Id : ");
        list[0] = sc.next();
        System.out.print("도서명 : ");
        list[1]  = sc.next();
        System.out.print("도서가격 : ");
        list[2] = sc.next();
        System.out.print("저자 : ");
        list[3] = sc.next();
        System.out.print("설명 : ");
        list[4] = sc.next();
        System.out.print("분야 : ");
        list[5] = sc.next();
        System.out.print("출판일 : ");
        list[6] = sc.next();

        try {

            fw = new FileWriter("./book", true);
            for (String str : list){
                fw.write(str+"\n");
            }


            System.out.println("추가 완료됐습니다");
            fw.close();


        } catch (IOException e) {

        }
    }

    void inquireOrder(User user){ // welcome 페이지를 실행시킨 유저의 정보가 매겨변수로 주어진다.
        HashMap<User, UserDelivery> order_list = User.getD_list();
        for (User u : order_list.keySet()){ // 유저들의 주문목록이 현재 로그인한 유저와 같은 사람이면 주문목록을 출력한다.
            // 이렇게 구현하려면 로그아웃 및 로그인, 회원가입 기능을 구현해야한다.
            if(u.equals(user)){
                user.menuGuestInfo(); //
                UserDelivery ud = order_list.get(u);
                System.out.println(ud.getD_name());
                System.out.println(ud.getD_phone());
                System.out.println(ud.getD_address());
                // toString 쓰는게 깔끔하긴 한데 우선은 이렇게 처리.

            }
        }

    }

    void logout(User u){

        System.out.println(u.getName()+"님 로그아웃합니다.");
    }
    void chat(){

        ClientEx.clientex();

//        BufferedReader in = null;
//        BufferedWriter out = null;
//        System.out.println("클라이언트 메인메서드 실행");
//        Socket socket = null;
//        Scanner sc = new Scanner(System.in); // 키보드에서 읽을 내용
//
//        try {
//            // 클라이언트 소캣 생성 , 서버에 연결 (자동연결됨)
//            // 둘 중 하나라도 없으면 연결X 소캣은 생성된다!
//            socket = new Socket("localhost",1111); // 서버와 클라이언트의 포트 내용이 다르면 실행되지않는다.
//
//            in = new BufferedReader(new InputStreamReader(
//                    socket.getInputStream()));
//
//            out = new BufferedWriter(new OutputStreamWriter(
//                    socket.getOutputStream()));
//
//            while(true) {
//                System.out.print("클라이언트 >");
//
//                // 클라이언트로 부터 한 행 씩 읽기!
//                // 클라이언트가 먼저 시작!
//                String outputMessage = sc.nextLine(); // 클라이언트가 입력을 시작해야 서ㅈ버쪽에서 소켓의 요청을 받아들이며 대화가 시작된다.
//
//                if(outputMessage.equalsIgnoreCase("bye")) {
//                    out.flush();
//                    break; // 서버로 전송 후 끝내기!
//                }
//                out.write(outputMessage +"\n"); //
//                out.flush(); // 만약 bye 안해도 전송 , 사용자가 엔터키를 누른 것은 버퍼에 저장한다는 뜻에서 입력만 끝낸거고 버퍼에서
//                // 넘겨줘야하기 떄문에
//
//                // 서버에서생 한 행 수신
//                String inputMessage = in.readLine();
//                System.out.println("서버:" + inputMessage);
//
//            }
//        } catch (IOException e) {}
//        finally {
//            sc.close();  // 스캐너 닫기
//            try {
//
//                if(socket != null) socket.close();   // 통신용 소캣 닫기
//
//            } catch (IOException e) {
//                System.out.println("서버와 채팅 중 오류가 발생했다!");
//            }
//        }// finally 끝



    }

        @Override
    public String toString() {
        return null;
        //저장된 책 배열을 출력하는 toString 만들던지
    }
}