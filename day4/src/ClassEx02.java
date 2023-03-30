import java.util.ArrayList;
import java.util.Arrays;

class Cat{ //클래스의 첫글자느 대문자여야한다. 암묵적
    // 필드(정보, 상태) 영역
    String name; //이름
    String breeds; // 품종
    double weight; // 몸무게

    // 메서드(동작,기능) 영역
    void claw(){
        System.out.println("할퀴기");
    }
    void meow(){
        System.out.println("야옹!");
    }
}

public class ClassEx02 {
    public static void main(String [] args){
        // 번외로 같은 패키지 내에서 같은 이름을 가진 클래스를 생성하면 서로 충돌하기 때문에 구분해야한다.

        //객체를 생성하면 자동으로 초기화 된다. 그리고 자료형마다 다른 값으로 초기화가 된다
        //String은 null, int는 0, double은 0.0, boolean은 false(0은 false, 나머지 값은 true이기 떄문에 다른 숫자들의
        //기본값이 0이라는 것은 boolean타입의 기본값도 false라는 것을 의미한다.
        Cat c = new Cat();
        c.name = "냐옹이";
        c.breeds = "러시안블루";
        c.weight = 1.43;
        c.claw();
        System.out.printf("이름 : %s \n품종 : %s\n 몸무게 :%.2f",c.name,c.breeds,c.weight);

    }
}

class Stu{

    String name;
    int hakbun;
    //int [] scores = new int[3];
    ArrayList<Integer> scores = new ArrayList<>(); // 배열이 추가되고 삭제될 수 있는 arraylist. 배열과는 다름.
    // velog에 java에서의 list와 array정리 필요(개념 및 관련 메서드, 그냥 Array랑은 어떻게 다른지). 또한 메모리 관리의 중요성도.

    void printscore(Stu s){
        System.out.println("학생의 이름은  "+s.name+" 학생의 학번은 "+hakbun+"  학생의 점수는"+s.scores);
        for ( int tmp : s.scores){
            System.out.print(tmp);
        }
    }

}

class StuTest{
    public static void main(String [] args){
        Stu s = new Stu();
        System.out.println(s.toString());
        s.scores.add(20);
        s.scores.add(30);
        s.scores.add(60);
        s.name = "홍홍홍";
        s.hakbun = 100;
        s.printscore(s);
    }
}
