package BookMarket;

// 고객들의 정보를 저장하는 user class
// 이름 핸드폰 주소 모두 비공개.
// 장바구니 클래스를 생성해라 (아래의 정보는 모두 비공개)
// 책의 제목저장하는 배열 사이즈 7개 itemBook  -> 내가 산걸 저장하라는 거?
// 총 구매액 저장하는 totalPrice
// 책의 번호 bookID
// 책의 개수 quantity 저장

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Cart {
    private int totalPrice;
    private int bookNum;
    private int quantity;
    private String [] itempbook ;
    Scanner sc ;


    public Cart(int totalPrice, int bookNum, int quantity, String[] itempbook) {
        this.totalPrice = totalPrice;
        this.bookNum = bookNum;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String[] getItempbook() {
        return itempbook;
    }

    public void setItempbook(String[] itempbook) {
        this.itempbook = itempbook;
    }

    void menuCartAddItem(){
        sc = new Scanner(System.in);

        FileReader fr = null;
        try {
            fr = new FileReader("./book");
            BufferedReader br = new BufferedReader(fr);
            String str ;
            int i = 1;
            while ((str = br.readLine())!=null){ // br.readLine, 버퍼가 book 파일을 읽어왔을 때 null일떄까지 계속 반복하는 조건을 붙여준다.
                System.out.print(str+"|");

                if(i%7 ==0) { // 책의 정보는 총 7개로 구성돼있으니 다음과 같이 구분시켜준다.
                    System.out.println();
                    i=1;
                }i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }// 책의 정보를 출력해준다.
        System.out.println("구매하실 책의 번호를 입력해주세요. 첫번째부터 1, 2, 3번 책");
        int bookNum = sc.nextInt();


    }
    Cart(){}
}
