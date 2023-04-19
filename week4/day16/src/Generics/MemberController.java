package Generics;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MemberController {

    private HashMap<String, Member> map = new HashMap<>();

    boolean joinMembership(String id, Member temp) { // id = 입력된 id

        boolean res = map.containsKey(id); // 키가 있으면 true, 없으면false 반환  당연히 저장되는 거 아닌가? 위에서 대놓고 id로 저장했는데.
        // mapcontainsKey의 동작원리? 결국 키셋의 키 리스트에서 포문돌려서 찾는 원리?

        if(res){
            return res;
        }
        map.put(id,temp);

        return res;
    }



    String login(String id, String password) {

        Member temp = map.get(id);

        if (temp == null){ //map에 입력한 아이디가 있는지 먼저 검사한다.
            return null;
        }

        return temp.getPass().equals(password) ? map.get(id).getP_name() : null; //
        // 맵에서 아이디가 있으면 다음 조건연산을 진행. 그 아이디의 비밀번호와 입력한 비밀번호가 같으면 이름을 넘겨주며 다음화면으로 감.
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
            // 인스턴스의 값도 바꿔주고 해쉬맵의 value값을 나타내주는 key값도 변경해줘야 한다.
            // 여기서 map의 동작원리를 이해해야 한다. put은 key를 씹어먹으면서 중복되고 replace는 대체시키는거?
            // 그럼 결국에 내가 스스로 구현할 수 있다. 해쉬맵의 멤버의 id에 해당하는 부분은 바꿨다. 하지만
            // 여기서 맵의 요소를 바꿔야 한다. 비밀버호 변경은 같은아이디에 바꾸고자 하는 비밀번호를 집어넣었으면 됐다
            // 지금 같은 경우에는? 기존아이디로 비밀번호까지 찾아놓은 후에 newName과 새롭게 put하는 방법.
            // 기존아이디와 멤버를 삭제하고 새로운 아이디와 같은 값을 가진 멤버를 put하던지
            // 혹은 기존의 멤버에서 setName으로 변경하고 Map의 Id만 바꾸던지 -> 이게 더편하긴 함
            String tmp_pw = map.get(id).getPass();
            String p_name = map.get(id).getP_name();
            map.get(id).setPass(tmp_pw);

            map.remove(id,map.get(id)); // 만약에 id만 제거하면 id는 null이 되고 기존의 인스턴스는 잔재한 상태인가?
            map.put(newName, new Member(newName,tmp_pw,p_name));
            System.out.println(map.get(id));
            System.out.println(map);
        }


        TreeMap sameName(String name){
            TreeMap<String, Member> sort_list = new TreeMap<>();
            for ( Member m : map.values()){// 해쉬맵의 value값들을 돌려준다.

                if(m.getName().equals(name)){

                }
            }


            return new TreeMap<>();


        }


}

