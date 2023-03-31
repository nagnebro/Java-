/*
    네이버 클래스
        고객들의 정보를 저장
 */

import java.util.ArrayList;

class Account{
    //정보는 id랑 패스워드만 저장
    String id, password;

    //기본 생성자
    Account(){} // 아래 코드로 짰을때는 기본 생성자 없앨 시 에러 발생한다.

    //생성자
    //객체를 생성할때 원하는 값으로 저장된다. 생성자는 인스턴스가 생성될 때마다 실행된다. 인스턴스 블럭도 마찬가지이지만 순서가 블럭이 더 빨랐던 것 같다.
    Account(String id, String password){
        this.id = id;
        this.password = password;
    }

}
class Naver{
    //필드(정보)
    //고객들의 정보를 저장하는 타입 <>
    ArrayList<Account> acclist = new ArrayList<>(); // 고객들의 정보가 담겨있는 참조변수들을 참조배열로 담겠다는 것.
}

public class ClassEx05 {
    public static void main(String [] args){
        Naver nav = new Naver();
        Account acc = new Account("yasuo","2679");

        //acc -> 네이버의 고객정보 변수에 저장
        nav.acclist.add(acc); // Account 타입의 ArrayList는 네이버 클래스에 있기 때문에 naver클래스의 참조변수 nav로
        //acclist에 접근한 뒤에 add 함수를 통해 Account타입의 참조변수 acc를 저장해준다.

        System.out.println(nav.acclist.get(0).id); // 참조변수의 인덱스로 접근해야 참조변수를 사용할 수 있고 그 이후에 다시 참조변수의
        // 인스턴스 변수를 사용할 수 있다.
        //ArrayList는 요소에 접근하기 위해 인덱스 번호를 사용할때 get(인덱스번호)와 같이 사용한다.
    }
}
