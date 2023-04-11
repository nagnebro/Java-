package InnerClass;

import javax.swing.*;

class Outer1{
    private  int num = 0; // private이면서 스태틱이면...? 외부에서는 접근 못하지만 내부에서는 static이니까
    // 참조변수없이 어디서든 접근이 가능하다는 뜻.

   class Member{
       void add(int n){ num += n;}
       int get() {return num;}
   }
}

public class MemberClass {
    public static void main(String[] args) {

        // 멤버클래스
        // -외부 인스턴스를 생성하고 그 다음에 내부 클래스를 생성해야 한다 > 내가 static Inner 클래스에 정의해놓은 것과 같음.

        // 외부 클래스 생성 먼저 해주고
        Outer1 out = new Outer1();
        Outer1 out2 = new Outer1();

        // 내부클래스를 생성하는 법은 일반적인 방법과 다르다.
        Outer1.Member o1 = out.new Member();
        Outer1.Member o2 = out2.new Member();

        // 실제 내부클래스의 메서드를 이용해서 데이터를 저장
        o1.add(100);

        int res1 = o1.get();
        int res2 = o2.get();
        System.out.println(res1);
        System.out.println(res2);
    }

}
