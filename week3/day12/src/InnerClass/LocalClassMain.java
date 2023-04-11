package InnerClass;


class Student{

    String name;
    int math,eng,kor;

    public Student(String name, int math, int eng, int kor){
        this.name = name;
        this.math = math;
        this.eng = eng;
        this.kor = kor;
    }

    void score(){ // 평균을 계산하는 메서드.

        int total = 3;
        class Avg{
            int sum = math+eng+kor; // 외부의 변수에 접근 가능

            void grade(){
                // total = 4; 값 변경이 불가능하다. 메서드 안의 클래스 함수에서 메서드 지역변수의 값 변경은 불가능하다(상수 취급)
                System.out.println(sum/total);
            }
        }
        Avg a1 = new Avg();
        a1.grade(); // 메서드 내의 내부클래스가 종료되기전에 실행돼야 결과를 얻을 수 있다.
    }// score()의 끝
}


public class LocalClassMain {
    public static void main(String[] args) {

        // 로컬 클래스
        // - 특정 메서드내에 내부클래스를 선언 ( 클래스 내에 클래스를 선언한 내부 클래스와 다르네? )
        // - 해당 메서드가 호출시 생성, 수행 종료하면 소멸된다.(지역변수로써 작용)
        // - 내부 클래스가 접근 할 수 있는 지역변수는 final 변수만 가능하다  -> ??

        Student s = new Student("김영찬",20,70,80);
        s.score();
    }
}
