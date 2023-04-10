package Varable;

public class Hotel {

    static String master_key = "card"; // 마스터키와 고객 정보를 저장하는 아래의 배열은 인스턴스가 생성될 때마다 생성할 필요가 없기 떄문에
    // 스태틱 변수로 선언한다.

    // 고객의 정보를 저장하는 배열.
    static Hotel_cut [] list = new Hotel_cut[10];

    // 투숙객들의 정보를 교환
    static void ch(){}
}

class Hotel_cut{

    // 객체가 생성될떄마다 변수를 만들어줘야 한다.
    // 객체안에 변수가 여러개 생긴다 (인스턴스 변수니깐..)
    // 인스턴스 변수
    String name;    // 이름
    int roomnumber; // 방번호
}
// 변수의 크기가 유동적( 크거나 작거나 변경이 많이 된다. )
// heap 영역 - 프로그램이 시작하고 나서 변수를 선언했을 때 크기가 가변적인 것들은 heap 영역으로 보내진다 > 기본형은 다 고정변수?
// 따라서 가변적이지 않은 기본형 변수 같은 것들은 stack으로 가게 된다. 인스턴스 , 스태틱 변수 같은 경우에는 heap영역으로 넘어간다(?정확하지 않음)
// stack 영역 - 프로그램 시작전에 변수를 저장하는 공간 >> 즉 프로그램 실행전부터 이미 자료형을 선언해놓으니까 크기를 알 수 있기 때문에 미리 영역별로 변수를
// 나눌 수 있다는 것이다. 프로그램 상으로 중괄호가 시작되고 중괄호가 끝나면 삭제 된다.

// static영역
// 프로그램이 끝날때까지 전역변수 데이터가 유지된다.

class Main{

    public static void main(String[] args) {


        Hotel_cut h1 = new Hotel_cut();
        h1.roomnumber = 1001;
        Hotel_cut h2 = new Hotel_cut();
        h1.roomnumber = 1002;

        Hotel_cut h3 = new Hotel_cut();
        h1.roomnumber = 1003;

        Hotel h = new Hotel();
        Hotel.ch();
        h.ch();
        System.out.println(Hotel.master_key);
    }
}
