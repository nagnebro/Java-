package lotto_test;

import java.util.*;

public class LotteryController {

    private HashSet<Lottery> lottery = new HashSet();// 사용자가 추가한 추첨자 목록
    private HashSet<Lottery> win = new HashSet(); // 추첨자 목록 중 랜덤으로 당첨자 목록 4명

    // 해쉬에는 실제로 들어가는 값이 lottery 클래스의 이름과 폰번호를 합친 문자열이다. 그럼 이 문자열을 포함하고 있으면 아노딘다.
    boolean insertObject(Lottery l) {
        // 얘는 해시셋
        for (Lottery lotto : lottery) { // for each문은 컬렉션 없으면 타입을 미리 지정해줄 수 없어서 에러발생함.
            if (lotto.equals(l)) { //로터리의 인스턴스인 로또와 매개변수로 들어온 l간의 name과 phone이 같을때 가입제한,
                // 혹은 다른 메서드에서 사용자 조회 용도로 사용가능

                return true; // 같은 이름과 휴대폰번호를 가진 사람이 있다는 것.
            }
        }
        lottery.add(l); // 사용자의 이름과 폰번호를 포함하고 있지 않을시에는 추첨자명단에 추가

        return false;
    }

    boolean deleteObject(Lottery l) {

        for (Lottery lotto : lottery) { // for each문은 컬렉션 없으면 타입을 미리 지정해줄 수 없어서 에러발생함.
            if (lotto.equals(l)) { // 로또가 l과 같 /Lotto 클래스에 equals 오버라이딩으로 name과 폰을 비교
                lottery.remove(lotto);
                win.remove(lotto);
                winObject(); //삭제됐으니 빈칸을 추가하기 위해 다시 당첨자 뽑는 메서드 접근.
                return true; // true = 삭제성공
            }
        }
        return false;
    }

    HashSet winObject() {
        if(lottery.size()<4){
            return null;
        }
        //어차피 중복은 허용안하니까 추첨대상을 추가한다고 해도 문제될 것은 없다.
        ArrayList<Lottery> temp = new ArrayList<Lottery>();
        for (Lottery l : lottery) { // 그냥 이상태로 당첨자 바로 저장하면? 순서가 그대로 저장된다.
            //그러니까 지금 해쉬에서는 인덱스를 바꿔서 저장할 수 없ㅅ으니 어레이리스트에 고대로옴ㄹ겼ㄷ가
            // 인덱스 랜덤으로 생성해가지로 순서 썩고 win 해시에 담으라는 것.
            temp.add(l); // 어레이리스트 temp에 저장.
        }
        for (; 4 > win.size(); ) { // 추첨자수가 4명미만일떄는 돌리면 안된다. 해쉬에는 중복된 값이 안들어가서 길이가 3인 어레이리스트의 요소를 추가한다해도
            // win의 사이즈는 증가되지 않는다.
            int ran2 = (int)(Math.random()*temp.size()); // 0~temp의 길이-1만큼의 값을 저장

            if(win.size()==temp.size()){ // 길이가 같아졌다는 건 lottery가 4이하일떈 복사가 끝났다는 말이고 4초과일땐 어차피 위쪽의 조건식에 의해종료됨 ->이 코드는 무한반복을 막기위해있음.
                return win;
            }
            System.out.println(win.size());
            win.add(temp.get(ran2)); // 어차피 win에는 중복된 값이 들어가지 못하니까 길이가 4가될떄까지
            // 무한반복으로 array 리스트의 요소들을 넣어주면 된다.
            // lottery의 길이가 4보다 아래이면 그냥 당첨자를 선정하지말던가 있는 사람한해서만 하던가 해야한다 . 나는 그냥 후자로했다.

        }
        //
        //Iterator<String>iter = hs.iterator(); // 해쉬셋을 반복가능한 객체?
        // 반복자를 iterator()를 이용해 출력하기 위함, 그러나 여기서 해쉬를 컬렉션으로 생성하지 않았기
        // 떄문에 iterator가 사용이 안되는 듯 하다.  >> 추가공부필요

        return win;
    }

    TreeSet sortedWinObject() { // toString 써서 그렇지 실제로 해시에는 참조변수의 주소가 저장돼있기 때문에 오름차순으로 정렬될 수가 없는 것.그래서 이 메서드가 필요함

        //Iterator<Lottery> iter = win.iterator();//hasnext랑 next쓸거면 다음과 같이 iterator사용.
        TreeSet<String> ts = new TreeSet<>(); // treeset은 추가만 해도 그냥 오름차순 되는듯? hashset과 다른점은? -> 그게 아니고 hashset도 단순히 기본자료형일때는 값의 오름차순이 적용된다
        // 하지만 앞의 예제들에서 우리는 set이나 map에 객체를 넣어서 순서가 섞였던 거고 지금은 내가 단순히 문자열로 treeset을 반환하니 오름차순이 되는 것.
        // 단 나는 이름이 같을경우 휴대폰 번호까지 비교 후 오름차순을 적용하는 것은 하지 않았음. 그리고 이 코드의 문제점은 중복된 이름이 있을 경우 1명만 추가된다는 것이다.
        for (Lottery l : win) {
            // 동명이인에 대한 오름차순은 우선 나중에 구현해보자.
            ts.add(l.getName());
        }
        return ts;
    }

    boolean searchWinner(Lottery l) {

        return insertObject(l); // 가입할떄 같은 이름과 폰번호 가진 사람 조회하는 메서드를 이용 => 애초에 가입할떄 중복을 받지 않았기 때문에
        // 가능한 것이며 사실상 참조변수는 다름. 이래서 오버라이딩해서 인스턴의 값끼리만 비교하는 equals 메서드를 사용하는 것.

    }
}



