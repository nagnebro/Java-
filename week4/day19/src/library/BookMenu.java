package library;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu {

    private Scanner sc = new Scanner(System.in);
    private BookController bc = new BookController();

    void mainMenu(){
        while(true){
            System.out.println("**********메인 메뉴************");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 검색 조회");
            System.out.println("4. 도서 삭제");
            System.out.println("5. 도서명 오름차순 정렬");
            System.out.println("9. 종료");
            System.out.printf("메뉴 번호 선택 : >>");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    insertBook();
                    break;
                case 2:
                    selectList();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    ascBook();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("다시입력하세요"); // default문 말고 밖에서 작성하면 다른 case문에서 break한 후에도 실행된다.
            }
        }
    }
    void insertBook(){
        System.out.printf("도서명을 입력하세요 : ");
        String title = sc.next();
        System.out.printf("저자명을 입력하세요 : ");
        String author = sc.next();
        System.out.print("장르를 입력하세요 1) 인문  2) 자연과학 3)의료  4) 기타");
        int category = sc.nextInt();
        String category2 = category == 1 ? "인문": category == 2 ? "자연과학" : category == 3 ? "의료" : category == 4 ? "기타" : null;
        System.out.println("가격을 입력하세요");
        int price = sc.nextInt();
        bc.insertBook(new Book(title,author,category2,price));
    }
    void selectList(){
        ArrayList<Book> list = bc.selectList();
        if (list == null){
            System.out.println("존재하는 도서가 없습니다");
            return;
        }
        for ( Book b : list){
            System.out.println(b);
        }
    }
    void searchBook(){
        System.out.printf("검색할 도서명을 입력하세요");
        String name = sc.next();
        ArrayList<Book> list = bc.searchBook(name); // 키워드를 포함하는 도서명이 저장된 리스트가 반환됐음.
        if(list.size()>0) {
            for (Book b : list) {

                System.out.println(b);
            }
        }
        else if(list.size()==0) {
            System.out.println("찾는 도서가 없습니다");
        }
    }
    void deleteBook(){
        System.out.println("삭제할 도서명을 입력하세요");
        String title = sc.next();
        System.out.println("삭제할 저자명을 입력하세요");
        String author = sc.next();
        Book b = bc.deleteBook(title,author);
        if (b == null){
            System.out.println("도서를 찾을 수 없습니다.");

        }else if(b instanceof Book) { // 굳이 조건 이렇게 안넣어도 되긴 하는데. 얘를 가져왔으면 이름 출력하면ㄴ서 쓰기라도 해야지.

            System.out.println("다음 도서의 삭제에 성공했습니다.");
            System.out.println(b);
        }


    }
    void ascBook(){

        bc.ascBook();
        System.out.println("정렬성공함.");
    }

}
