package Thread_synchronized;

class Washroom extends Thread{
    synchronized void openDoor(String name){ // synchronized 제어자를 사용하면  같은 스레드에 여러 객체가 접근할떄는 그 스레드가 끝날떄까지
        // 기다리게끔 만든다. 이렇게 되면 그냥 멀티태스킹이 아니고 싱글스레드인거 가아닌가?
        System.out.println(name+" 입장");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        for( int i = 0 ; i< 100000; i++){
//            if ( i == 10000){
//                System.out.println("뿅");
//            }
//
//        }
        System.out.println(name+ " 이 화장실을 나왔다.");
    }
}

public class Main {

    public static void main(String[] args) {

        // 스레드 동기화
        // - 멀티스레드 환경에서 여러 스레드가 하나의 공유자원에 동시에
        // - 접근 못하게 막는 것!

        Washroom wr = new Washroom(); // 이렇게 안하면 싱크로나이즈가 안된다 왜 안되는진 모르겠다.
        Washroom wr2 = new Washroom();
        Washroom wr3 = new Washroom();
        Washroom wr4 = new Washroom();
        FamilyThread father = new FamilyThread("아빠",wr);
        FamilyThread mother = new FamilyThread("엄마",wr2);
        FamilyThread sister = new FamilyThread("누나",wr3);
        FamilyThread me = new FamilyThread("나",wr4);
        // 현재 스레드가 접근해야 할 openroom메서드의 클래스인 WashRoom
        // 클래스의 참조변수를 모두가 같은 매개변수로 줘야한다. 그러지 않을 경우 스레드의 싱크로나이즈가 되지 않는다.

        father.start();
        mother.start();
        sister.start();
        me.start();
        // 위의 순서대로, 즉 아빠,엄마,누나,나의 순서대로 메서드가 실행되는 것은 아니다.그러나 opendoor 메서드는 하나의 객체에 해당하는
        // 스레드 동작이 완전히 수행될때까지 스레드에 다룬 객체가 접근하는 것을 허용하지 않는데에 의의가 있다.

//        father.run();
//        mother.run();
//        sister.run();
//        me.run();

    }
}

