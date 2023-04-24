package BookMarket;

import java.util.ArrayList;
import java.util.HashMap;

// 고객들의 정보를 저장하는 user class
// 이름 핸드폰 주소 모두 비공개.
// 장바구니 클래스를 생성해라 (아래의 정보는 모두 비공개)
// 책의 제목저장하는 배열 사이즈 7개 itemBook  -> 내가 산걸 저장하라는 거?
// 총 구매액 저장하는 totalPrice
// 책의 번호 bookID
// 책의 개수 quantity 저장
public class User {
    private String name;
    private String address;
    private String phone;

    private static HashMap<User,UserDelivery> d_list = new HashMap<>(); //고객들의 delievery list
    // 유저정보와 함꼐 유저가 입력한 배송자의 정보를 담아주는 Map을 생성. 그런면 고객객체와 고객의 배송정보가 담긴 객체를 함꼐
    // 저장 가능.

    private static ArrayList<User> u_list = new ArrayList<>();

    public static ArrayList<User> getU_list() {
        return u_list;
    }

    public static void setU_list(User u) {
        u_list.add(u);
    }

    void menuGuestInfo(){
        System.out.printf("이름 : %s , 주소 : %s, 연락처 : %s\n",name,address,phone);
    }

    public User(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public User(User u , String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public User finduser(){
        for (User u : u_list){

            if(this.equals(u)){
                return u; // equals 메서드를 통해 비교한 유저 정보가 db에 존재하는 유저라면 db에 있는 인스턴스를 반환한다.
            }
        }
        u_list.add(this); // 없는 유저라면 db에 유저정보 추가하고 이 메서드를 실행시킨 인스턴스를 반환한다.
        return this;


    }


    public User(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static HashMap<User, UserDelivery> getD_list() {
        return d_list;
    }

    public static void setD_list(HashMap<User, UserDelivery> d_list) {
        User.d_list = d_list;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj != this)){
            return false;
        }
        User u = (User)obj;

        return u.getName().equals(this.name) && u.getPhone().equals(this.phone) && u.getAddress().equals(this.address);
    }
}
