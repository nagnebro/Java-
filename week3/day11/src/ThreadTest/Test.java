package ThreadTest;

// 데몬스레드
//  - main 스레드가 끝나면 나머지 스레드들도 모두 종료하게 만드는 스레드.
//    setDaemon(boolean) true : 메인 메서드가 종료되면 스레드 역시 종료
//                      false : main 상관없이 실행된다.
//     ex) 게임 속 배경음악. 게임이(메인) 종료되면 배경음악(스레드)도 종료돼야 한다.

import static java.lang.Thread.sleep;

class Music extends Thread{

    @Override
    public void run() {

        while(true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("음악이 연주중입니다");
        }
    //    System.out.println("음악을 종료합니다");
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println("메인이 실행됐다.");
        Music m = new Music(); // setDaemon을 하지 않으면 메인 메서드와 관계없이 실행되는 스레드
        m.setDaemon(true); // 데몬스레드 설정은 무조건 start(); 이전에 작성해야한다.
        m.start();
        for ( int i = 0 ; i<10 ; i++){
            System.out.println("게임중");

            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if( i == 9){
                System.out.println("엄마가 왔으니 게임을 종료한다.");
                break;
            }
        }

    }
}


class Test2 extends Thread {
    @Override
    public void run() {
        int i = 0;
        while(i<4){
            System.out.println("hi");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }

    }
}
class Main{
    public static void main(String[] args) {
        System.out.println("메인 시작");
        Test2 t = new Test2();
        Music m = new Music();

        // m.setDaemon(true); 메인 메서드에 존재하는 스레드는 m과 t두개가 있다. 이 떄 하나의 스레드라도 setDaemon의 매개변수로 true가 주어지지 않을시
        // setDaemon을 설정한 스레드라 할지라도 메인이 종료된 후에 종료되지 않는다.
        m.start(); //

        t.setDaemon(true); // 메인이 종료되면 hi출력이 종료되며 스레드가 종료됨.
        t.start();

        try {
            sleep(5000); // 위쪽의 import 문 없이도 Thread.sleep()로 접근할 수 있다. 바로 사용할 수 있는 이유는 Thread클래스가 java.lang에 있고
            // 기본 import문으로 java.lang.*; 이 생략돼있기 때문이다.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("메인종료");
    }
}