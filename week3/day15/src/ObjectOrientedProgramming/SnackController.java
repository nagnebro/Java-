package ObjectOrientedProgramming;

public class SnackController {
    private Snack s = new Snack();

    SnackController(){

    }
    public String savedata(String kind, String name, String flavor, int numOf, int price){


        s.setKind(kind); // 제어자 private에 접근 가능한 원리.
        // -> 정확하진 않으나 개인적인 생각으로 제어자에 따른 접근방법에 차이를 두는 것은 그 메소드가 실행된 주소가 어디냐에 따라 다른 것 같다.
        // 예를 들어 게터 세터 없이 메인에서 특정 클래스의 private 멤버에 접근하게 되면 참조변수는 접근하고자 하는 클래스의 타입이라 할지언정
        // 실행된 주소값이 본인의 클래스가 아니기 때문에 접근을 못하게 막는 것이다. 그래서 게터세터를 거치게 되면 게터세터의 위치는 그 클래스이기
        // 떄문에 접근 가능한 것이고. 아마 protected의 원리 역시 비슷해서 proteceted에 접근한 멤버의 instance 타입을 비교해 접근이
        // 가능하게 하냐 못하냐로 만들지 않을까?
        s.setName(name);
        s.setFlavor(flavor);
        s.setNumOf(numOf);
        s.setPrice(price);



        return "저장완료";
    }
    public String confirmData(){


        return s.information();
    }
}
