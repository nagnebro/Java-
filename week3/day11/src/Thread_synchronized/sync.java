package Thread_synchronized;

import java.util.Scanner;

public class sync extends Thread{
    sync2 s ;

    @Override
    public void run() {
        s.print();
    }
    sync(sync2 s){
        this.s = s;
    }
}

class sync2 extends Thread{
    static int count;
    synchronized void print(){
        System.out.println(count++ + "print실행 됨.");
        Scanner sc = new Scanner(System.in);
        System.out.println("입력을 받습니다.");
        sc.nextInt();
    }

}

class Test{
    public static void main(String[] args) {
        sync2 ss = new sync2();// 실행시켜야 할 메서드가 있는 sync2 클래스의 참조변수 ss가 있다. 이 떄 run메서드가
        // 오버라이딩 돼있는 클래스(sync)의 참조변수(s1,s2,s3)가 synchronized를 통해 서로 락을 건 상태로 동작하게 하고 싶다면
        // 같은 참조변수를 통해 메서드로 접근해야한다. 정확하진 않지만 내 생각에는 서로 같은 참조변수의 주소를 공유해야 들어오지 못하게 막을 수
        // 있는데 주소값이 다르다면 스레드입장에서는 그 메서드에 들어가지 않을 이유가 없는 것이다. 즉 싱크로나이즈의 원리는 서로 같은 참조변수의
        // 메서드로 접근할떄 (단순히 같은 메서드로 접근하는 것이 아니라 같은 주소를 가진 참조변수의 같은 메서드로 접근할때) 같이 스레드 되는 것을
        // 막아주는 것이다.
        sync s1 = new sync(ss);
        sync s2 = new sync(ss);
        sync s3 = new sync(ss);
        s1.start();
        s2.start();
        s3.start();
    }
}
