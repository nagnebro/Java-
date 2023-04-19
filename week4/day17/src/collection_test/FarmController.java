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

    Farm check(Farm f){// 단순히 내가 더하고자, 삭제하고자, 수정하고자 하는 값이 있는지 반환만해주고  수정은 각 메서드에서 한다.

        for ( Farm tmp : h_map.keySet()){ // 과일의 사과인지 야채의 사과인지는 비교하지 않는다.  그걸 비교하기 위해서는 그냥 f의 f.getnmae()이 tmp.getname과 같은지 equals하면 된다.
            // 그럼 kind(종류) 상관없이 추가가 안될 것이다. 그러나 여기서는 다른 종류끼리 같은 이름은 허용하되 equals메서드를 오버리이딩 해서 그 안에서 name이 같은지를 비교하는 것.
            if(tmp.equals(f)){ // 동일한 종류가 없으면 값을 수정하고 return true, !(tmp.equals(f))와 같이 작성하면 이름이 없을떄를 비교하는건데 이는 for문이 끝난 후 수행돼야하는 문장이기 떄문에
                // 조건을 같은 이름이 있을떄 메서드를 끝내는 것으로 해야한다. ++추가 euqals를 실행시키는 인스턴스의 순서는 관계없는 듯하다.
                return tmp; // 같은 값을 가진 인스턴스를 반환함. 후에 추가 삭제 수정에 용이
            }
        }
        return null; // for문이 끝나면 같은 이름을 가진 문자여링 없는것이므로 true를 반환한다.
    }

    boolean addNewKind(Farm f, int amount){
        Farm res = check(f);
        if (res == null){ // 같은 이름을 가진 값이 없으면 추가하는식
            h_map.put(f,amount);// res,amount 넣으면 당연히 null 떠서 에러뜨겠지.
            return true;
        }
        return false;
    }
    boolean removeKind(Farm f){
        Farm res= check(f);
        //add와 반대로 res 가 null이 아닐시에 값을 삭제해야함
        if(res != null){
            h_map.remove(res); // 제거할떄 인자로 f넣으면 당연히 안된다. 값만 똑같이 가지고 있는 새로운 인스턴스 이기 때문에 리턴값으로 받은
            // 실제 인스턴스의 주소를 h_map에서 삭제해줘야된다.
            return true;
        }
        return false;
    }
    boolean changeAmount(Farm f,int amount ){

        Farm res = check(f);
        if(res != null){ // 변경할 값이 있다는 것
//            h_map.remove(res); //기존의 값을 삭제하고
//            h_map.put(f,amount); // 새로운 인스턴스를 생성해서 추가해준다.
            // set으로 다시 수정하기 위해서는 자손의 인스턴스로 직접접근해야하는데.. 형변환을 뭘로해줘야하는지 문제가 생긴다.
            // instanceof 로 비교하고 인스턴스에 맞게 참조변수 다운캐스팅 해주고 setName amount로 접근해도되긴 하겠다만 더 귀찮은듯.
            // 근데 여기서 인스턴스를 삭제하고 새로 생성하는 게 더 문제가 될 수 있는 방법인 듯하다.
//            if(f instanceof Fruit){
//                Fruit fr_base = (Fruit)res; // 자손의 인스턴스에 맞게 형변환 시켜준다. 기존값을 변경하기 위해 형변환(set name사용)
//                Fruit fr_user = (Fruit)f; // 사용자에게 입력받은 값으로 기존값을 변경하기 위해 사용될 인스턴스(get name사용)
//                fr_base.setName(fr_user.getName());
//                // fr_base.setName(fr_user.getKind()); 종류는 어차피 입력에서 똑같이 받았을 거기 떄문에 셋팅안해줘된다.
//                return true;
//            }
//            else if(f instanceof Nut){안해줘된다.
//                return true;스(get name사용)
//                Fruit fr_base = (Fruit)res; // 자손의 인스턴스에 맞게 형변환 시켜준다. 기존값을 변경하기 위해 형변환(set name사용)
////                Fruit fr_user = (Fruit)f; // 사용자에게 입력받은 값으로 기존값을 변경하기 위해 사용될 인스턴팅
////                fr_base.setName(fr_user.getName());
////                // fr_base.setName(fr_user.getKind()); 종류는 어차피 입력에서 똑같이 받았을 거기 떄문에 셋
//            else if(f instanceof Vegetable){//            }
//                Fruit fr_base = (Fruit)res; // 자손의 인스턴스에 맞게 형변환 시켜준다. 기존값을 변경하기 위해 형변환(set name사용)
//                Fruit fr_user = (Fruit)f; // 사용자에게 입력받은 값으로 기존값을 변경하기 위해 사용될 인스턴스(get name사용)
//                fr_base.setName(fr_user.getName());
//                // fr_base.setName(fr_user.getKind()); 종류는 어차피 입력에서 똑같이 받았을 거기 떄문에 셋팅안해줘된다.
//                return true;
//            }
//

            h_map.remove(res); // 기존에 있던 객체를 제거하고
            h_map.put(f,amount); // 사용자에게 입력받은 새 인스턴스 f와 amount를 함꼐 준다. 그러면 키는 중복이 되기 떄문에 값만 바뀌는 것과 같음.
            return true;
            }
            return false;
        }



    HashMap<Farm,Integer> printFarm(){ // 농산물 목록, 직원 메뉴

        return h_map;
    }
    boolean buyFarm(Farm f){ // 여기서부터 고객의 메뉴
        // 고객이 입력한 f를 전달받고 이 f가 h_map에 없으면 false반환, 있으면 amoount-1d이후 true 반환

        Farm res = check(f);

             // 만약에 아래 if문의 조건으로 res!=null && h_map.get(res)>0을 같이 선언하게 되면 res!=null
            // 조건을 먼저 비교하면 if문을 나가는 것이 아니라 그 옆에 조건문도 같이 검사하기 떄문에 null이면 get메서드에서
            // 에러가 발생함. 따라서 null일떄 프로그램 종료가 되도록 선행적으로 처리해줘야함.
            // 혹은 아래 조건문 안에 get 비교 부분을 안쪽 조건문으로 넣던지.

        if(res!=null){ // 입력한 과일의 종류가 h_map에 있다는 소리., 있으면서 그 수량이 0이상일떄만 고객의 장바구니에 추가되며
            if(  h_map.get(res)>0 ) {
                // 상품목록에서 -1이됨.
                list.add(f); //고객의 장바구니에 추가
                int amount = h_map.get(res) - 1; // res가 가지고 있는 수량에 1을 뺸 값을 새로 저장해야함
                h_map.put(res, amount); // 이게 효율적인 프로그래밍인지는 모르겠다.
                System.out.println(list);
                return true;
            }
        }
        return false;
    }
    boolean removeFarm(Farm f){
        Farm res = check(f);
        // 문제의 조건이 좀 이상해서 아마 같은 과일을 사면 리스트에는 과일:사과 과일:사과 과일:사과의 형태로 중복해서 추가돼야
        //하는듯하다. 애초에 고객 장바구니도 hashmap써서 Farm타입이랑 integer같이 써서 종류랑 수량 나오게햿으면 깔끔하긴한데
        // 어쩄든 이런 이유떄문에 remove를 사용하면 중복된 apple이 모두 제거되고 h_map의 수량도 부족해지게 된다
        // 따라서 사용자가 같은 종류와 이름을 가진 과일은 딱 1개밖에 못사게 하던지 혹은 그냥 많이 살 수 있게 하는대신
        // list에서 제거하는 조건을 내가 바꿔주던지.

//        if(list.remove(res)) { // 삭제됐으면
//            int amount = h_map.get(res) + 1;
//            h_map.put(res, amount); // 수량을 1추가한 후 장바구니에 다시 추가.
//        }
//        return list.remove(res); //위 조건문과 관계없이 제거에 성공하면 true반환할거고 실패하면 false 반환할 거임.
        // 위에서 작성된 코드를 사용하려면 사용자에게 같은 종류의 과일은 구매하지 못하게 막아줘야 함.

        for(int i = 0 ; i<list.size() ; i++){ // remove메서드를 인데스로 제거시 1개만 제거할 수 있다.
            if(res.equals(list.get(i))){ // 제거하려는 농산물과 arraylist에 있는 농산물이 같은 이름일떄
                list.remove(i);
                int amount = h_map.get(res) + 1;
                h_map.put(res, amount); // 수량을 1추가한 후 장바구니에 다시 추가.
                return true;
            }
        }
        return false;
    }
    ArrayList<Farm> printBuyFarm(){

        return list;
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