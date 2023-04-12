package KakaoBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Account extends KakaoBank{
    int accnum ;
    String username;
    int money;


    public Account(int accnum, String username, int money) {
        this.accnum = accnum;
        this.username = username;
        this.money = money;
    }
}
class KakaoBank{

    static ArrayList<Account>acclist = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    void insert(){
        System.out.println("계좌 번호를 입력하세요");
        int accnum = sc.nextInt();
        System.out.println("이름을 입력하세요");
        sc.nextLine();
        String username = sc.nextLine();
        System.out.println("예치금을 넣어주세요");
        int money = sc.nextInt();
        acclist.add(new Account(accnum,username,money));
    }

    void print(){
        System.out.println("계좌번호 입력하세요");
        int accnum = sc.nextInt();
        for ( Account tmp : acclist){
            if (tmp.accnum == accnum){
                System.out.printf("고객님의 계좌번호는 %d, 이름은 %s, 잔액은 %d입니다",tmp.accnum,tmp.username,tmp.money);
            }
        }
    }

    void array(){
        for (int j = 0; j <acclist.size()-1; j++) {
            for (int i = 0; i < acclist.size() - 1 - j; i++) {

                if (acclist.get(i).accnum > acclist.get(i + 1).accnum) { // 계좌번호 순서대로 정렬.
                    Account tmp = acclist.get(i);
                    acclist.set(i, acclist.get(i + 1)); // 0번쨰요소를 뒤의 요소로 바꿈.
                    acclist.set(i + 1, tmp);
                }
            }
        }
        for (int i = 0; i < acclist.size(); i++) {
            Account tmp = acclist.get(i);
            System.out.printf("%d번째 고객의 이름은 %s, 계좌번호는 %d, 잔액은 %d입니다 \n", i + 1, tmp.username, tmp.accnum, tmp.money);
        }
    }
}

public class KakaoMain {

    // 카카오뱅크
    // 카카오뱅크에서 계좌를 관리하는 list private
    //  메뉴를 제공하고 번호입력받을 것
    // 1. 고객계좌 등록   입력받고 고객 관리 리스트에 저장(뭐 이름이나 잔액이나 등등) -> 메서드화 insert()
    // 2. 고객 조회
    //   기준은 고객계좌번호
    // 맞는 계좌번호가 있다면 고객의 정보를 출력하는 메서드 toStrng, or 메서드
    // 3. 고객정렬 버블정렬을 이용해 정렬. 안에있는 고객정보 출력(뭘 기준으로 정렬?) 고객 id 추가 id를 기준우로 정렬할것
    // 0 .종료

    // 예외처리 입력이 0~3이 아니다 예외처리.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KakaoBank k = new KakaoBank();
        while(true){
            System.out.println("메뉴를 입력하세요\n1. 고객계좌등록\n2. 고객 조회\n3. 고객정렬");
            int input = sc.nextInt();
            if(input == 1){
                k.insert();
            }else if(input == 2){
                k.print();
            }else if(input == 3){
                k.array();
            }
        }

    }
}

class Test{
    public static void main(String[] args) {
        int [] list  = {5,3,2,6,1};
        for(int i = 0 ; i<list.length-1;i++){
            for(int j = 0; j<list.length-1-i;j++){
                System.out.println("hi");
                if(list[j] > list[j+1]){
                    int tmp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }
}