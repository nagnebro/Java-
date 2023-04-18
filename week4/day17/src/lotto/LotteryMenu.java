package lotto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class LotteryMenu {

    private Scanner sc = new Scanner(System.in);
    private LotteryController lc = new LotteryController();

    void mainMenu(){
        int input;
        while(true){
            System.out.println("******메인 메뉴******");
            System.out.println("1. 추첨 대상 추가");
            System.out.println("2. 추첨 대상 삭제");
            System.out.println("3. 당첨 대상 확인");
            System.out.println("4. 정렬된 당첨 대상 확인");
            System.out.println("5. 당첨 대상 검색");
            System.out.println("9. 종료");
            System.out.print("메뉴 번호 선택 : >>");
            input = sc.nextInt();
            switch(input){

                case 1:
                    insertObject();
                    break;
                case 2:
                    deleteObject();
                    break;
                case 3:
                    winObject();
                    break;
                case 4:
                    sortedWinObject();
                    break;
                case 5:
                    searchWinner();
                    break;
                case 9:

                    return;
            }
        }
    }
    void insertObject(){
        System.out.print("추가할 추첨 대상 수 입력 : ");
        int input = sc.nextInt();
        int count = 0;
        while(count<input){

            System.out.print("이름을 입력하세요 : ");
            String name = sc.next();
            System.out.print("폰번호를 입력하세요 (-빼고) : ");
            String phone = sc.next();
            boolean res = lc.insertObject(new Lottery(name,phone));
            if(res) { // 참이라는 것은 중복된 값이 있다는 것.
                System.out.println("중복된 명단입니다 다시 입력하세요");
                continue;
            }
            count++;
        }

        System.out.println(input+"명 추가 완료됐습니다");

    }
    void deleteObject(){
        System.out.print("이름을 입력하세요 : ");
        String name = sc.next();
        System.out.print("폰번호를 입력하세요 (-빼고) : ");
        String phone = sc.next();
        boolean res = lc.deleteObject(new Lottery(name,phone));
        if(res) { // 삭제 성공시 true반환
            System.out.println("삭제 완료됐습니다");
            return;
        }
        System.out.println("존재하지 않는 대상입니다."); // else써도 되고 안써도 되고.

    }
    void winObject(){

        HashSet hs = lc.winObject();
        if(hs == null){
            System.out.println("당첨자를 뽑을만한 추첨자 수가 부족합니다.");
            return;
        }
        System.out.println(hs);

    }
    void sortedWinObject(){
        TreeSet<String> ts = lc.sortedWinObject();
        for(String str : ts){
            System.out.println(str);
        }

    }
    void searchWinner(){
        System.out.print("이름을 입력하세요 : ");
        String name = sc.next();
        System.out.print("폰번호를 입력하세요 (-빼고) : ");
        String phone = sc.next();
        boolean res = lc.searchWinner(new Lottery(name,phone));
        if (res) {
            System.out.println("축하합니다 당첨자 목로에 존재합니다");
            return;
        }
        System.out.println("안타깝지만 당첨자 목록에 없습니다.");
    }
}
