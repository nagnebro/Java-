import java.awt.*;

// 주민등록증의 정보를 저장하는 자료형을 만들려고 할 떄 다양한 변수타입과 배열이 필요할 것이다.
//
// class
class 주민등록증{
    // 인스턴스 변수는 초기화 안해줘도 각 자료형마다 초기값으로 초기화 된다.
    String 이름 ;
    String 주민번호;
    String 주소;
    String 발급기관;
    int 발급일자;
    Image 사진;

}

class Card{
    String number;
    String cardname;
    String user;
    int cvc;
    String vip;

    // 자료형 관점에서 클래스를 본다는 건 이와 같이 동일하게 사용될 수 있는 변수들을 묶어서 사용할 수 있는 새로운 자료형이라는 것.
}

class GoormIDE{
    //  구름 IDE에 가입하기 위해 받아야 할 유저의 정보.
    String email;
    String firstpassword;
    String secondpassword;
    String nickname;
}

class ParkSystem{
    String intime;
    String outtime;
    int pay;
    boolean discount;

    void checnk(){ } // 위 인스턴스 변수(입출차 정보를 기반으로 동작하는 요금 정산 메서드)
}

/*
    객체
    -클래스를 통해 만들어진 프로그램의 구성요소

    클래스 멤버
     -필드 (정보/상태)
     -메서드(기능/동작)
 */


public class ClassEx01 {
    public static void main(String [] args){

        // 클래스를 2가지 관점으로 나누어 설명한다. 1. 사용자 정의 자료형  2. 객체 지향 프로그래밍


        //  1. 사용자 정의 자료형
        //  기본자료형 int, float , double, char
        // 프로그래머가 프로그램에 맞게 다양한 기존 자료형으로 새로운 자료형을 만든다.
        // - 타입이 다른 자료형을 묶는다.

        // 배열은 동일한 자료형(데이터 타입) 여러개를 선언, 클래스는 다른 자료형으로 여러개를 선언
        // 즉 객체를 만들어놓고 그때 그때 인스턴스를 생성해 정해놓은 자료형을 사용한다는 뜻이다.

        // 2. 객체 지향 프로그래밍
        // - 조립식 프로그래밍
        //  ex) 자전거(프로그램) = 몸체(객체) + 바퀴 + 핸들

        // 조립식 프로그램의 좋은 점 (즉 객체지향 프로그래밍의 강점)
        // - 코드의 재사용성 및 유지보수에 용이하다.
        // - 확정성이 좋고 관리가 쉽다.
    }
}
// 학생의 정보를 저장하는 클래스를 생성해라.
// 이름, 생년월일, 주소, 핸드폰번호, 성별

class Student{
    String name = "홍길동";
    int birthdate = 19000101; //0으로 시작할 경우 앞자리 생략되니 주의
    String address = "미정";
    String phone = "01012345678";
    boolean gender = true;

    public static void main(String[] args){
        Student s = new Student();
        System.out.printf("이름 : %s \n생일 : %d\n주소 : %s\n휴대폰번호 : %s\n",s.name,s.birthdate,s.address,s.phone);
        if(s.gender = true)System.out.println("성별 : 남자");
        else System.out.println("성별 : 여자");
    }

}