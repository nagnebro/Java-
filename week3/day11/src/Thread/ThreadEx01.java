package Thread;


import javax.swing.*;

import static java.lang.Thread.sleep;
// import static은 문장의 끝이 class로 끝난다 즉 클래스를 통해 메서드에 접근하는 것이 아닌 메서드명으로 바로 메서드에 접근한다.
// 클래스 이름으로 접근하려면 import java.lang.Thread; 로 선언하고 Thread.sleep();로 사용한다.

class Time{
    int i;


    void run(){
        for (i = 0; i<=10 ; i++){

            // 프로그램을 지연시키는 함수
            try {
                sleep(1000);
            }catch(InterruptedException e){

            }
            System.out.println(i+"");
        }
    }
}
public class ThreadEx01 {
    public static void main(String[] args) {


        Time t1 = new Time();
        t1.run(); // 여기서 run은 스레드에서 sleep 메서드만 사용하게 만들어줄 뿐이다. 즉 일반 메서드와 다름 없음.
        // 멀티태스킹이 안되고 단독으로 메서드만 실행되기 때문에 멀티태스킹을 하려면 start();를 사용해야한다.
        
        String msg = JOptionPane.showInputDialog("입력: "); // 입력창이 생성된다.
        System.out.println(msg); // 입력창에서 입력받은 값을 저장한 msg를 출력해준다.
        // 스레드
        // - 프로세스
        // - 실행중인 프로그램의 최소 단위
        // - 두가지 이상의 작업을 동시에 처리하는 것. 브라우저 켜놓고 다른 앱 실행하는등 백그라운드에서도 계속 다른 프로그램이 돌아가는 것
        // - 디스크에 있는 프로그램이 메모리에 적재되어 운영체제의 제어를 자신만의 자원을 가지기 때문에 프로세스끼리는 서로 독립적.

        // 멀티태스킹
        // - 두가지 이상의 작업을 동시에 처리하는 것.
        // - 스마트폰으로 카카오톡으로 대화를 하는 것( 여러명과 각각 대화 )

        // 스레드를 생성하는 방법
        // 1. 상속
        // 2. 인터페이스

        // 자바 Main Thread
        //  - 모든 자바 main() 메서드를 실행하면서 시작이 된다.
        // 프로세스(공장) 스레드(일꾼) 싱글쓰레드
        // 프로세스(공장) 스레드(일꾼들) 멀티쓰레드

        //멀티쓰레드의 장점
//         CPU의 사용률을 향상 시킨다.
//         자원을 보다 효율적으로 사용할 수 있다
//         사용자에 대한 응답성이향상된다
//         작업이분리되어 코드가 간결해진다.

    }
}
