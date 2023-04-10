package Thread;

import javax.swing.*;
import java.util.Random;

// Thread 클래스는 java.lang.Object 클래스를 상속하고 있기 떄문에 import하지않아도 된다
// 즉 import java.lang.*이 생략돼있어서 그런 것.
class MyThread extends Thread{
    // 스레드를 상속받아서 실행하는 실행문을 작성하는 곳은 run이다


    @Override
    public void run() {
        int i;
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

public class ThreadMultiEx01 {
    public static void main(String[] args) {
        Thread m1 = new MyThread();

        m1.start(); // m1의 스레드는 계속 동작하고 있으나 main 메서드는 독립적으로 실행되는 흐름을 보여준다.
        // for문의 i가 출력되고 있는 도중에 아래의 입력창이 실행되는 모습.





        // 실제 스레드를 정의해서 객체를 생성하면 start() 함수를 실행해야한다. 자동적으로 run()메서드가 호출되며 실행되는 구조.
        System.out.println("메인 스레드 끝");

    }
}
//        String msg = JOptionPane.showInputDialog("입력: ");
//        System.out.println(msg);
