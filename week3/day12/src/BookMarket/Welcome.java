package BookMarket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


// 고객들의 정보를 저장하는 user class
// 이름 핸드폰 주소 모두 비공개.
// 장바구니 클래스를 생성해라 (아래의 정보는 모두 비공개)
// 책의 제목저장하는 배열 사이즈 7개 itemBook  -> 내가 산걸 저장하라는 거?
// 총 구매액 저장하는 totalPrice
// 책의 번호 bookID
// 책의 개수 quantity 저장


// 주요기능은 모두 Book에 몰아넣고 welcome은 고객 쪽엣2ㅓ 처리되는 화면위주로.
public class Welcome {
    Scanner sc = new Scanner(System.in);
    String[] menulist = {"1. 고객정보 확인하기           2. 장바구니 상품 목록 보기",
                         "3. 장바구니 비우기            4. 바구니의 항목 추가하기",
                         "5. 장바구니 항목 수량 줄이기     6. 장바구니의 항목 삭제하기",
                         "7. 주문하기                 8. 종료",
                        "9. 관리자 로그인"
    };
    Book b = new Book();

    void printstar(){
        for(int i = 0; i< 40; i++){
            System.out.print("*");

        }
        System.out.println();
    }
    void printmenu(){
        for(int i = 0; i< menulist.length; i++){
            System.out.println(menulist[i]); // 포매팅할시 한글의 문자폭이 더 큼을 고려하지 않고
            // 출력되기 때문에 한글의 글자수가 다르면 정렬을 하더라도 밀림 현상이 발생한다
        }
    }

    void welcome(){

        int id ;
        Scanner sc = new Scanner(System.in) ;
        System.out.print("이름을 입력하세요");
        String name = sc.nextLine();
        System.out.print("연락처를 입력하세요");
        int phone = sc.nextInt();

        System.out.println("주소를 입력하세요");
        String address = sc.next();
        b.addBookList(); // 시작할떄 책 정보를 한번 읽어오고 이후부터는 관리자가 수정할떄마다 접근해서 추가한다.
        User u = new User(name,address,phone);
        System.out.println("환영합니다 "+u.getName()+"님!");
        while(true){

            //sc.nextLine();
            printstar();
            System.out.println("\t\t Welcome to Shopping Mall");
            System.out.println("\t\t Welcome to Book Market!");
            printstar();
            printmenu();
            printstar();
            System.out.println("메뉴 번호를 선택해주세요.");
            id = sc.nextInt();
            switch(id) {

                case 1:
                    u.menuGuestInfo();// 1, 고객정보확인하기
                    break;
                case 2:
                    b.menuCartItemList(); // 장바구니 상품 목록 보기
                    break;
                case 3:
                    b.menuCartClear(); // 3. 장바구니 비우기
                    break;
                case 4:
                    b.menuCartAddItem(); //4.바구니의 항목 추가하기
                    break;
                case 5:
                    b.menuCartRemoveItemCount();// 5. 장바구니의 항목수량 줄이기
                    break;
                case 6:
                    b.menuCartRemoverItem();// 6. 장바구니의 항목 삭제하기
                    break;
                case 7:
                    b.menuCartBill(u);//7. 영수증 표시하기
                    break;
                case 8:
                    b.menuexit(); //8. 종료.
                    return;
                case 9:
                    b.adminLogin();
            }
        }
    }
}


