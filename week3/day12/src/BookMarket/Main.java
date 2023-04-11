package BookMarket;

import java.util.Scanner;

class Book{


    String[] menulist = {"1. 고객정보 확인하기","2. 장바구니 상품 목록 보기","3. 장바구니 비우기","4. 영수증 표시하기",
            " 5. 바구니에 항목 추가하기","6. 장바구니의 항목 수량 줄이기"," 7. 장바구니의 항목 삭제하기"," 8. 종료"
    };
    void printstar(){
        for(int i = 0; i< 40; i++){
            System.out.print("*");

        }
        System.out.println();
    }
    void printmenu(){
        for(int i = 0; i< menulist.length/2; i++){
            System.out.printf("%-20s",menulist[i]); // 포매팅할시 한글의 문자폭이 더 큼을 고려하지 않고
            // 출력되기 때문에 한글의 글자수가 다르면 정렬을 하더라도 밀림 현상이 발생한다
            System.out.printf("%-20s",menulist[i+4]);
            System.out.println();
        }
    }
    void menuGuestInfo(String name, int id){
        System.out.printf("이름 : %s , 아이디 : %d\n",name,id);
    }
    void menuCartItemList(){}
    void menuCartClear(){}
    void menuCartAddItem(){}
    void menuCartRemoveItemCount(){}
    void menuCartRemoverItem(){}
    void menuCartBill(){}
    void menuexit(){}
}


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.println("이름을 입력하세요");
        String name = sc.nextLine();
        System.out.println("연락처를 입력하세요");
        int id = sc.nextInt();
        Book b=  new Book();
        b.printstar();
        System.out.println("\t\t Welcome to Shopping Mall");
        System.out.println("\t\t Welcome to Book Market!");
        b.printstar();
        b.printmenu();
        b.printstar();
        b.menuGuestInfo(name,id);
        b.printstar();
        while(true){
            System.out.println("메뉴 번호를 선택해주세요.");
            id = sc.nextInt();
            switch(id) {

                case 1:
                    System.out.println(b.menulist[id - 1]);
                    b.menuGuestInfo(name,id);
                    break;
                case 2:
                    System.out.println(b.menulist[id - 1]);
                    break;
                case 3:
                    System.out.println(b.menulist[id - 1]);
                    break;
                case 4:
                    System.out.println(b.menulist[id - 1]);
                    break;
                case 5:
                    System.out.println(b.menulist[id - 1]);
                    break;
                case 6:
                    System.out.println(b.menulist[id - 1]);
                    break;
                case 7:
                    System.out.println(b.menulist[id - 1]);
                    break;
                case 8:
                    System.out.println(b.menulist[id - 1]);
                    break;
            }
        }
    }
}

class Test{

    public static void main(String[] args) {
        //String str = "1. 고객정보 출력하기";
        System.out.printf("%20s\n","김영찬");
        System.out.printf("%20s\n","sdsd김영찬찬찬찬");
        System.out.println();

        System.out.printf("%20s\n","h sfas asi");
        System.out.printf("%20s\n","hi dsf");
        System.out.println();
    }
}

