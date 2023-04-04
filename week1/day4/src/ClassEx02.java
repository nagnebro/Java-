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

    void printscore(Stu s){ // 굳이 매개변수로 참조변수를 넘겨줄 필요가 없다. 어차피 인스턴스 메서드를 실행한 참조변수의 값으로 객체를 이용하기 때문에
        // 그 자체로 인스턴스 변수나 메서드를 사용해도 무방하다.
        // StuTest 클래스에서 참조변수 s와 ss를 다르게 선언했음에도 불구하고 실행결과가 다른 것을 알 수 있음.
        System.out.println("학생의 이름은  "+name+" 학생의 학번은 "+hakbun+"  학생의 점수는"+scores); //여기서도 굳이 s라는 참조매개변수로
        // 인스턴스 변수에 접근할 필요가 없다.
        // ArrayList는 출력시 배열처럼 그 배열의 주소값이 나오는 것이 아닌 리스트의 형태로 요소값들을 돌려준다.
        for ( int tmp : scores){ // 굳이 s.scores와 같이 할 필요가 없다는 것.
            System.out.print(tmp); // 요소들을 어레이리스트에서 하나씩 뽑아내기 위해 foreach문 사용
        }
    }

}

class StuTest{
    public static void main(String [] args){
        Stu s = new Stu();
        s.scores.add(20);
        s.scores.add(30);
        s.scores.add(60);
        s.name = "홍홍홍";
        s.hakbun = 100;
        Stu ss = new Stu();
        ss.scores.add(120);
        ss.scores.add(130);
        ss.scores.add(160);
        ss.name = "a미미미";
        ss.hakbun = 1000;
    }
}
