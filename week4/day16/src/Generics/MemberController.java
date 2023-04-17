package Generics;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.TreeMap;

public class MemberController {

    private HashMap<String, Member> map = new HashMap<>();

    boolean joinMembership(String id, Member temp) {
        map.put(id, temp); // 해쉬맵에 아이디와 멤버 인스턴스를 저장

        boolean res = map.containsKey(id); // 키가 있으면 true, 없으면false 반환  당연히 저장되는 거 아닌가? 위에서 대놓고 id로 저장했는데.
        return res;
    }

    String login(String id, String password) {
        Member temp = map.get(id);

        if (temp == null){
            return null;
        }

        return temp.getPass().equals(password) ? id : null;
    }

        boolean changePassword (String id, String oldPw, String newPw) {
            String res = login(id, oldPw);
            if (res == null) { // 아이디나 비밀번호가 틀렸다는 것.

                return false;
            }else if(map.get(id).getPass().equals(oldPw)){
                map.get(id).setPass(newPw);
                return true;
            }
            return false;
        }
        void changeName (String id, String newName){
            map.get(id).setName(newName); // get id는 id를 가진 value값 즉 member의 인스턴스를 뜻한다
            System.out.println(id + newName);
            System.out.println(map.get(id).getName());
            System.out.println("이름 변경에 선공하였습니다");
        }

//    TreeMap sameName(String name){return TreeMap;}


}

