package collection_test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FarmController {
        // 해쉬맵은 딕셔너리처럼 키:값 의 형태로 저장돼있는 자료형이며 중복을 허용하지 않는다
    // 따라서 여기 해쉬맵에서는 Farm의 객체가 key, 수량이 value로 저장돼있다. 이떄 Farm객체 끼리 비교한다는 것은..
    // 주소가 서로 다르기 때문에 contains key로 안되지 않나?셋

    private HashMap<Farm, Integer> h_map = new HashMap<Farm,Integer>(); // 농산물 종류 및 수량
    private ArrayList<Farm> list = new ArrayList<Farm>(); // 아마도 고객의 장바구니?

    boolean addNewKind(Farm f, int amount){
        if(true){ // 이렇게 비교하면 인스턴스끼리 비교하는 거 아닌가? 비교가 되나 이게? equasls나 해시코드 쓰는게 맞지않나?
            return false;
        }
        return true;
    }
    boolean removeKind(Farm f){

        return true;
    }
    boolean changeAmount(Farm f,int amount ){
        return true;
    }
    HashMap<Farm,Integer> printFarm(){
        return new HashMap<Farm,Integer>();
    }
    boolean buyFarm(Farm f){
        return true;
    }
    boolean removeFarm(Farm f){
        return true;
    }
    ArrayList<Farm> printBuyFarm(){
        return new ArrayList<>();
    }

}


class Test{
    String name;

    public Test(String name) {
        this.name = name;
    }
}

class TestMain{
    public static void main(String[] args) {
        HashSet<Test> h_ss = new HashSet<>();
        Test t1 = new Test("hi");
        Test t2 = new Test("hi");
        h_ss.add(t1);

        System.out.println(h_ss.contains(t1));

        System.out.println(h_ss.contains(t2));
        h_ss.add(t2);
    }
}