import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.TreeMap;

class User{

    private String id;
    private String pw;


    User(){}

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
    //getter setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaw() {
        return pw;
    }

    public void setPaw(String paw) {
        this.pw = paw;
    }

    @Override
    public boolean equals(Object obj) { // 오버라이딩은 선언부가 같아야 한다. 접근제어자는 변경이 가능하다. 그러나 제어자의 범위는
        // 조상의 제어자와 같거나 더 커야한다.
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("id = [%s] pw!!= [%s]",id,pw);
    }
}

public class UserMain {

    public static void main(String[] args) {

        //id pw 3개 정도 저장
        User p =new User("김영찬","1111");
        User p2 =new User("김영찬2","2222");
        User p3 =new User("김영찬3","3333");

        // keyset, value 는 키와 값을 가져온다.

        HashMap<String,User> list = new HashMap<>();

        list.put(p.getId(),p); // 유저 p의 아이디를 가진 p 인스턴스를 list에 넣어준다.
        list.put(p2.getId(),p2); // [유저1 인스턴스, 유저1인스턴스ㅡ가 갖고 있는 id 문자열 저장]
        list.put(p3.getId(),p3);

        String find = "김영찬";

        for( String key: list.keySet()){ // list의 key를 배열로 반환해줌. 즉 여기에서는 키값이라고 보면됨. 해쉬맵 list의 키값은 해당 인스턴스의 id값이다.
            if ( find.equals(key)){
                list.get(key).setId("ssss"); // get 메서드는 해쉬맵의 키를 가져오는 메서드이다.
                System.out.println("찾음.");
                break;
            }
        }
        System.out.println(list);

        TreeMap<String, String> list2 = new TreeMap<>();
        list2.put("이서희","010-1234");
        list2.put("김영찬","010-1234");
        list2.put("박수수앙","010-1234");
        System.out.println(list2); // 문자열의 순서대로 정렬 된것을 알 수 있음
    }



}
