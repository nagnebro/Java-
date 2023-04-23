package BookMarket;

import java.util.HashMap;

public class UserDelivery {
    private String name;
    private int phone;
    private String address;

    private static HashMap<User,UserDelivery> d_list = new HashMap<>(); //고객들의 delievery list
    // 유저정보와 함꼐 유저가 입력한 배송자의 정보를 담아주는 Map을 생성. 그런면 고객객체와 고객의 배송정보가 담긴 객체를 함꼐
    // 저장 가능.


    public UserDelivery(String name, int phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public static HashMap<User, UserDelivery> getD_list() {
        return d_list;
    }

    public static void setD_list(User u , UserDelivery ud) {
        d_list.put(u,ud);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
