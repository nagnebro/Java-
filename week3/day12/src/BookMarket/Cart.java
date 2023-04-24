package BookMarket;


// 수정해야할 사항 -> 수량, 가격수정 , 객체정보를 확실히 수정할 것. 가라로 하면 안됨

import javax.lang.model.type.IntersectionType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {// 유저의 카트
    private int totalPrice;
    private String bookNum;
    private int quantity=1;
    private String [] itembook ;
    private  static int count=-1; // 책을 몇권샀는지 체크하기 위한 카운터, 공통적으로 사용돼야함
    private ArrayList <Cart> u_cart = new ArrayList<>(); // 유저의 장바구니를 저장할 곳
    Scanner sc = new Scanner(System.in);


    public Cart(String bookNum,  int quantity, int totalPrice) {
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

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String[] getItempbook() {
        return itembook;
    }

    public void setItempbook(String[] itempbook) {
        this.itembook = itempbook;
    }


    int carttotalprice(){
        int totalprice = 0;
        for(Cart b : u_cart){
            if(b!=null) {
                totalprice += b.getTotalPrice();
            }
        }
        return totalprice;
    }

    void menuCartItemList(){ // 2. 장바구니 상품 목록보기
        System.out.println("------------------------");
        System.out.printf("  도서ID   |  수량 |  합계 ");
        System.out.println();
        for(Cart c : u_cart){

            System.out.println(c); //내 장바구니의 도서목록을 출력한다


        }
        System.out.println("------------------------");
    }
    void menuCartClear(){ // 3. 장바구니 비우기

        u_cart.clear();

    }

    boolean menuCartAddItem(String [][] b_list, String bookId){ // 4. 바구니의 항목 추가하기
        // 도서추가시 같은 이름일 경우 수량만 증가하게끔 해야한다.
        // id 입력받고 비교하기 구매할 수 있는 도서의 목록을 이용한다.
        out : for (String [] list : b_list){ // 내 장바구니 말고 구매할 수 있는 도서목록
            for(int i =0 ; i<1; i++){ // 1. 우선구매하고자 하는 입력한 책 이름이 도서목록에 있는지 확인 후 있다면 내 장바구니 목록에 있는지 없는지 확인한다.
                // 더할떄 리스트 돌려서 찾아서 추가하나, 그냥바로 추가하고 나중에 개수랑 수량셀떄 돌려서 찾나더 나은방법으로.
                if(list[i].equals(bookId)) {// 도서목록중 첫번쨰 요소만 검색하면됨, 그게아이디값임.
                    System.out.print("장바구니에 추가하시겠습니까? Y|N");
                    String input = sc.next();
                    if(input.equalsIgnoreCase("Y")){
                        // 다시 카트에 같은 책이 있는지 없는지 검사해야한다.
                        int price = Integer.parseInt(list[2]);
                        for(Cart c : u_cart){
                            if(c.getBookNum().equals(list[0])){ //도서 id가 같다는 것은 같은 책이라는 뜻이다.
                                c.quantity++;
                                c.totalPrice += price;
                                return true; // 기존 객체에서 수량과 가격만 추가됨. 반복문 돌리기 귀찮아서 리턴.
                            }

                        }
                        u_cart.add(new Cart(list[0],1, price));
                        return true;
                    }
                    return false;

                }
            }
        }
        return false;

    }

    boolean  menuCartRemoveItemCount(String bookNum){ // 5 장바구니항목 수량 줄이기.

        Cart c = findBook(bookNum);
        if( c == null) return false; // 여기서 좀더 깔끔하게 처리해보기. 수량이나 가격 처리하는 부분이 좀 애매하다.
        // 사용자에게 입력값을 받기에는 예외처리 해야할 것이 너무많다.

        System.out.println("줄이실 수량을 입력하세요 (1개 이하의 수량은 줄일 수 없습니다.)");
        int amount = sc.nextInt();
        if( amount < 1 | c.quantity<amount ){ // 입력으로는 1이상만 들어올 수 있고 내 책의 수량보다 큰 값이 들어올 수가 없다
            System.out.println("수량을 획인 후 제대로 입력해주세요");
            return false;
        }
        int price = c.totalPrice / c.quantity; // 책의 개당 가격
        c.totalPrice -= price;
        c.quantity -= amount;
        return true;
    }

    Cart findBook(String bookNum){

        for (Cart c: u_cart){
            if(c.bookNum.equals(bookNum)){
                return c;
            }
        }
        return null;
    }



    boolean menuCartRemoverItem(String bookNum) {// 6. 장바구니 항목 삭제하기 애초에 컬렉션쓰면 엄청 편할 문제를 배열을 쓰니까 되게 귀찮네.
        menuCartItemList();
        Cart c = findBook(bookNum);
        if (c != null) {

            u_cart.remove(c);
            return true;

        }
        return false;
    }
    UserDelivery menuCartBill(User u){
        boolean check = false;
        for(Cart b : u_cart){
            if(b!=null){
                check = true;
            }
        }
        while(check) {
            System.out.print("배송받을 분의 고객정보가 가입정보와 일치합니까? Y|N  ");
            String input = sc.next();
            String address = null;

            if (input.equals("Y")) {
                System.out.print("배송지를 입력해주세요.");
                address = sc.next(); // 배송지는 그냥 새로 입력받자.
                return new UserDelivery(u.getName(),u.getPhone(),address); // 로그인 정보와 배송자 정보가 일치하면 주소만 입력받고 그 값을 생성자에 대입
            } else if(input.equals("N")){
                System.out.print("배송받을 고객명을 입력하세요 : ");
                String name = sc.next();
                System.out.print("배송받을 고객의 연락처를  입력하세요 : ");
                String phone = sc.next();
                System.out.print("배송받을 고객의 배송지를 입력하세요 : ");
                address = sc.next();
                return new UserDelivery(name,phone,address); // 로그인 정보와 배송받을 사람으 정보가 다르면 다시 입력받음.
            }else{
                System.out.println("다시 입력해주세요.");
            }

        }
        System.out.println("장바구니에 도서가 없어 배송신청을 할 수 없습니다");
        return null;
    }




    Cart(){}

    @Override
    public String toString() {
        return String.format("%s  |  %d  |   %d ",bookNum,quantity,totalPrice);

    }
}
