package collection_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class FarmMenu {
    private Scanner sc = new Scanner(System.in);
    private FarmController fc = new FarmController();

    void mainMenu(){
        while(true){
            System.out.println("===========KH 마트============");
            System.out.println("***********메인 메뉴***********");
            System.out.println("1. 직원 메뉴");
            System.out.println("2. 손님 메뉴");
            System.out.println("9. 종료");
            System.out.print("메뉴 번호 입력 :  >> ");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다 다시 입력하세요.");
                    break;
            }
        }
    }
    void adminMenu(){
        while(true) {
            System.out.println("*************직원 메뉴***************");
            System.out.println("1. 새 농산물 추가");
            System.out.println("2. 종류 삭제");
            System.out.println("3. 수량 수정");
            System.out.println("4. 농산물 목록");
            System.out.println("9. 메인으로 돌아가기");
            System.out.print("메뉴 번호 선택 : >>");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    addNewKind();
                    break;
                case 2:
                    removeKind();
                    break;
                case 3:
                    changeAmount();
                    break;
                case 4:
                    printFarm();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다 다시 입력하세요.");
                    break;
            }
        }
    }
    void customerMenu(){
        while(true) {
            System.out.println("*************고객 메뉴***************");
            System.out.println("1. 농산물 사기");
            System.out.println("2. 농산물 빼기");
            System.out.println("3. 구입한 농산물 보기");
            System.out.println("9. 메인으로 돌아가기");
            System.out.print("메뉴 번호 선택 : >>");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    buyFarm();
                    break;
                case 2:
                    removeFarm();
                    break;
                case 3:
                    printbuyFarm();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다 다시 입력하세요.");
                    break;
            }
        }

    }
    Farm select(){
        while(true) {
            System.out.println("1. 과일 / 2. 채소 / 3. 견과");
            System.out.print(" 종류 번호 :");
            int input = sc.nextInt();
            System.out.println("과일 이름을 입력하세요");
            String name = sc.next();
            // 선택받는 123 번호에 따라서 넘겨줘야할 객체가 다르다. vegetable, fruit ,nut
            Farm f = input == 1 ? new Fruit("과일", name) : input == 2 ? new Vegetable("채소", name) : input == 3 ? new Nut("견과", name) : null;
            if (f == null) {
                System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력하세요");
                continue;
            }
            return f;
        }
    }
    void addNewKind(){
        while(true) {

            Farm f = select();
            System.out.println("수량을 입력하세요");
            int amount = sc.nextInt();

            boolean res = fc.addNewKind(f, amount);
            if(res){
                System.out.println("새 농산물이 추가됐습니다");
                return;
            }
            System.out.println("새 농산물 추가에 실패했습니다 다시 입력해주세요");
        }
    }
    void removeKind(){ // 얘는 제거할떄 수량 필요없으나 change나 add시 수량때문에 메서드내에 입력순서를 조금 바꿔줘야 한다.
        while(true) {
            Farm f = select();
            boolean res = fc.removeKind(f);
            if(res){
                System.out.println("농산물 삭제에 성공했습니다");
                return;
            }
            System.out.println("농산물 삭제에 실패했습니다. 다시 입력해주세요");
        }
    }
    void changeAmount(){
        while(true) {
            Farm f = select();
            System.out.println("수량을 입력하세요");
            int amount = sc.nextInt();
            boolean res = fc.changeAmount(f,amount);
            if(res){
                System.out.println("농산물 수량이 수정됐습니다");
                return;
            }
            System.out.println("농산물 수량 수정에 실패했습니다. 다시 입력해주세요");
        }
    }

    void printFarm(){
        HashMap<Farm, Integer> hs = fc.printFarm();
        for(Farm f : hs.keySet()){ // ㅌ타입만 Farm이지 실제 인스턴스는 Fruit나야채나 그런것들임. 그러므로 이름에도 접근가능.
            System.out.println(f.getKind());// farm에 접근해서 종류랑 이름? 이름은 어떻게 접그근하지?
        }
    }
    void buyFarm(){
        while(true) {
            Farm f = select(); // 다형성으로 자손의 인스턴스를 갖고 있음.

            boolean res = fc.buyFarm(f);
        }
    }
    void removeFarm(){
        while(true){
            Farm f =select();
            boolean res = fc.removeFarm(f);
            if(res){
                System.out.println("구매에 성공했습니다");
                return;
            }
            System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요");
        }
    }

    void printbuyFarm(){
        ArrayList<Farm> list = fc.printBuyFarm();
        Iterator<Farm> iter = list.iterator();
        while(iter.hasNext()){
            iter.next();
        }
    }
}
