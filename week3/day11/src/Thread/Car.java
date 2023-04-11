package Thread;

public class Car extends  Thread{
    String name;

    int time;

    Car(String name, int time){
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() { // 스레드의 run 메서드를 오버라이딩.
        int i;
        for (i = 0; i<=10 ; i++){

            // 프로그램을 지연시키는 함수
            try {
                sleep(time);
            }catch(InterruptedException e){

            }
            System.out.println(name+"돌격합니다");
        }
    }

    public static void main(String[] args) {
        System.out.println("몬스터 출현 시작");

        Monster m1 = new Monster("오크",3000);
        Monster m2 = new Monster("골램",1000);
        Thread m3 = new Monster("김영찬",2000);
        //동작 원리를 설명하면 Thread클래스의 start()가 실행되고
        // 그 start 메서드는 run()메서드를 실행시키는데 참조변수 타입이 자손이기 때문에 자손의 오버라이딩 된 메서드 (run 메서드)가 실행될거고
        // 그때 인스턴스변수는 당연히 자손의 것이 사용되기 떄문에 문제가 되지 않는다. 이렇게 다형성을 가질때 접근성에 문제가 생길 수 있는 경우는
        // 조상타입의 참조변수로 자손의 오버라이딩 된 메서드에 접근할 때가 아닌, 자손의 인스턴스 멤버 그 자체에 접근하려고 할 떄이다.
        m3.start();
        m1.start();
        m2.start();
        // 메인 메서드의 시작 후에 스레드가 실행되는 것은 당연하나 종료는 메인 메서드에서 관여할 수 없는 모습
        System.out.println("메인메서드 종료");

    }
}
//        Thread m1 = new MyThread(); // 아까 작성했던 MyThread 클래스의  0~9 1초 간격으로 출력하는 스레드
//        Car c1 = new Car("소나타",1000);
//        Car c2 = new Car("그랜저",3000);
//
//        // 스레드 시작점( start 메서드 호출)
//
//        m1.start();
//        c1.start();
//        c2.start();
//        System.out.println("메인 스레드 끝");
