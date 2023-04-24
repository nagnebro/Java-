package BookMarket;

import java.util.HashMap;

public class UserDelivery{
    private String d_name;
    private String d_phone;
    private String d_address;

    private static HashMap<User,UserDelivery> d_list = new HashMap<>(); //고객들의 delievery list
    // 유저정보와 함꼐 유저가 입력한 배송자의 정보를 담아주는 Map을 생성. 그런면 고객객체와 고객의 배송정보가 담긴 객체를 함꼐
    // 저장 가능.


    public UserDelivery( String d_name, String d_phone, String d_address) {
        this.d_name = d_name;
        this.d_phone = d_phone;
        this.d_address = d_address;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_phone() {
        return d_phone;
    }

    public void setD_phone(String d_phone) {
        this.d_phone = d_phone;
    }

    public String getD_address() {
        return d_address;
    }

    public void setD_address(String d_address) {
        this.d_address = d_address;
    }

    public static void setD_list(HashMap<User, UserDelivery> d_list) {
        UserDelivery.d_list = d_list;
    }

    public static HashMap<User, UserDelivery> getD_list() {
        return d_list;
    }


    public UserDelivery(){
    }


}
