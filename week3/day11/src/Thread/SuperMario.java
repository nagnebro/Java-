package Thread;

import com.sun.security.jgss.GSSUtil;

import java.util.Random;

// runnable 인터페이스는 run 메서드만 오버라이딩 해주면 된다.
// 그러면 start 메서드를 실행시킬 수 없다. 즉 무슨 말이냐면 원래 start() 후 run()이 실행되는 것이 정상인데 스레드 인터페이스에는
// run밖에 없으니 start가 안된다. (? run만 시키면 안되나? 애초에 start 후에 run하려는건데)
// 스레드의 run 은  멀티스레드로 실행ㅇ되지 못하고 일반 메서드처럼 단독으로만 실행된다? (확인 필요)

// Thread 클래스의 도움을 받아야 한다.
// 다른 상속을 받은 클래스들은 Thread한테 객체생성시 인터페이스로 구현한 run()가 들어있는 객체를 넘겨준다.

/*
class Ex implements Runnable{  // 스레드는 클래스말고 인터페이스도 있다.
    public static void main(String[] args) {
        Mario mario = new Mario("rla"); //이 마리오 객체가 현재 Thread 인터페이스를 구현했기 때문에 위에서 언급했듯이 start()를
        // 실행시킬 수는 없다. 따라서 다음과 같이 스레드의 생성자로 본인의 참조변수를 주고 실행시키면된다 (다형성을 가진다는 것이 중요한 포인트)
        // -> 아직은 이게 왜 중요한지 모르겠다. 그냥 애초에 인터페이스 구현한다는 이유 자체가 어떤걸 상속받아서 그렇단건데 그럼 그 클래스에
        // Thread 상속받으면 안되나 이번에 내가 작성한 것처럼?>
        // 이번의 Hero 클래스는 아무것도 상속받고 있지 않기 때문에 Thread 클래스를 상속받았지만 혹시 걔가 다른 클래스를 상속받고 있을
        // 경우에는 불가능하기 때문에 그 밑의 자손들에 일일히 Thread 인터페이스를 구현시켜주는 수 밖에 없다. 또한 멀티스레드로 동작시키기 싫고
        // 단순히 스레드 한번으로 동작시키고 싶은 클래스들도 있을 수 있기 때문이다.
        Thread m1 = new Thread(mario);
        m1.start();
    }

    @Override
    public void run() {

    }
}
*/


class Cooper extends Thread{
    static  int cooper_hp = 100;
    int attack =  50;
    Hero [] hero_list = new Hero[4];
    Random r = null;
    void fire(){
        r= new Random();
        System.out.printf("쿠퍼의 불기둥 공격!!\n");

        int idx =  r.nextInt(hero_list.length);
        Hero h = hero_list[idx]; // 감소시킬 히어로의 hp
        h.hp -= attack;
        System.out.printf("%s의 캐릭터의 체력이 %d만큼 감소해 %d가 됐습니다.\n",h.name,attack,h.hp);
    }


    public void run() {

        while (true) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            fire();
        }
    }

    Cooper(Hero h1,Hero h2,Hero h3,Hero h4){
        hero_list[0] = h1;
        hero_list[1] = h2;
        hero_list[2] = h3;
        hero_list[3] = h4;
    }

}
abstract  class Hero extends Thread {
    String name;
    int hp = 300;
    Random r = new Random();
    public Hero(String name) {

        this.name = name;
    }

    @Override
    public void run() {

    }

    abstract void attack();

}
class Mario extends Hero{
    final int attack = 35;

    @Override
    void attack() {
        System.out.printf("유저 %s의 마리오의 펀치공격! \n",name);
        Cooper.cooper_hp -= attack;
        System.out.printf("쿠퍼의 체력이 %d만큼 깎여 %d가 됐습니다!\n",attack,Cooper.cooper_hp);

    }

    @Override
    public void run() {

        while (true){
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            attack();
        }
    }


    public Mario(String name) {
        super(name);
    }
}
class Marige extends Hero{
    final int attack = 20;

    @Override
    void attack() {
        System.out.printf("유저 %s의 메리지의 폭탄공격! \n",name);
        Cooper.cooper_hp -= attack;
        System.out.printf("쿠퍼의 체력이 %d만큼 깎여 %d가 됐습니다!\n",attack,Cooper.cooper_hp);
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            attack();
        }
    }

    public Marige(String name) {
        super(name);
    }
}
class Peach extends Hero{
    final int attack = 10;

    public Peach(String name) {

        super(name);
    }

    @Override
    public void run() {

        while (true){
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        attack();
        }
    }

    @Override
    void attack() {
        System.out.printf("유저 %s의 피치의 물건 던지기 공격! \n",name);
        Cooper.cooper_hp -= attack;
        System.out.printf("쿠퍼의 체력이 %d만큼 깎여 %d가 됐습니다!\n",attack,Cooper.cooper_hp);
    }
}
class Mushroom extends Hero{
    final int attack = 15;

    @Override
    void attack() {
        System.out.printf("유저 %s의 버섯도리의 버섯던지기 공격! \n",name);
        Cooper.cooper_hp -= attack;
        System.out.printf("쿠퍼의 체력이 %d만큼 깎여 %d가 됐습니다!\n",attack,Cooper.cooper_hp);
    }

    @Override
    public void run() {

        while (true){
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        attack();
        }

    }

    public Mushroom(String name) {
        super(name);
    }
}


class SuperMarioTest extends Thread{
    public static void main(String[] args) {
        // 마리오 클래스, 마리지 클래스, 피치공주, 버섯돌이
        // 이름, 목숨, 기본 레벨 10

        //마리오는 체력 3000 펀치공격 (35씩 감소) 1초에 한번씩
        //마리지는 300폭탄공격 (20씩 감소) 0.5초에 한번씩
        //피치공주는 300물건던지기 (10씩 감소) 1초에 한번씩
        //버섯도리는 300 버섯던지기  (15씩 감소) 1.5초에 한번씩
        // hero 클래스를 상속받는 얘네 객체 각 4개 두고 독립적으로 이름과 데미지를 갖는 걸로 할까..?
        // 아니야 공격력은 고정이니ㅏㄲ final로 하고
        // 문제는 얘네의 공격 이름이 다 달라야한다는 건데 그럴려면 인스턴스 생성시 공격 이름을 생성자로 넣어줘야하는데
        // 그건 좀 없어보이고..제대로 된 객체화도 아닌 것 같다. 최대한 많은 유저들, 반복이 생길 수 있다고 생각하고 구상해보자.
        //쿠파의 체력이 0이되거나 마이너스가 되거나 어쩄든 죽은 경우에도
        // 마리오랑 마리지 피치공주는 계속 공격을 하고 있을 것이다.
        // 따라서 각각 무한 반복하는 곳에 주인공들의 스레드를 setDaemon을 이용해
        // main이 종료되면 나머지 주인공들도 종료될 수 있게끔 설정.



        // 쿠파의 목숨은 인스턴스들이 접근을 할 수 있도록 공유가 돼야한다.
        // 이름, 목숨 1000, 기본레벨 30
        // 쿠파는 불기둥 공격! 공격시간 랜덤.즉 스레드 사용.전체공격 30이 깍임
        // 메서드 매개변수로 쿠파 넣으면 되지
        // 공유!
        System.out.println("게임이 시작됐습니다");


        Mario mario = new Mario("김영찬");
        Marige marige = new Marige("김영찬2");
        Mushroom mushroom = new Mushroom("김영찬3");
        Peach peach = new Peach("김영찬4");
        Cooper cooper = new Cooper(mario,marige,mushroom,peach);

        mario.setDaemon(true);
        marige.setDaemon(true);
        mushroom.setDaemon(true);
        peach.setDaemon(true);
        cooper.setDaemon(true); // 내 생각으로는 위의 4개만 설정해주면 4개는 종료되야 하는데 이 문장을 추가해주지 않으면
        // 그냥 스레드 전부다 같이 도는 모습이다. 스레드간의 어떠한 연관성이 있는 듯 하다.

        mario.start();
        marige.start();
        mushroom.start();
        peach.start();
        cooper.start();
        while(true){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            if (Cooper.cooper_hp < 0 ){
//                System.out.println("쿠퍼가 쓰러졌습니다.");
//                break;

            if (Cooper.cooper_hp < 0 ) {
                System.out.println("쿠퍼가 쓰러졌습니다.");
                break;
            }
            // setDaemon을 해서 메인이 종료되야 스레드 4개가 모두 종료가 되는 구조인데 위와 같이 메인에서 스레드를 실행시킨 후 무한루프를 돌다가
            // 스레드로 인해 특정조건이 충족(여기서는 쿠퍼의 체력이 0아래일때)됐을 때 무한반복문을 탈출하고 그러면 메인이 종료되는 것이 정상이다.
            // 그러나 위의 코드를 sleep와 예외 구문 없이 실행해보면 조건이 됐음에도 계속 실행되는 걸 알 수 있는데 아마도 무한반복문의 스케쥴링?
            // 텀이 굉장히 짧기 떄문에 조건을 검사도 안하고 그냥 지나가는 것 같다. (스레드 역시 sleep()로 지연을 안시켜줬다면 무한반복과 마찬가지의 개념이다.)
            // 그래서 print문을 한개 넣던지 혹은 위와 같이 스레드로 지연을 시켜주면 정상적으로 조건을 탈출하며 메인이 종료되고
            // 스레드 역시 종료됨을 확인할 수 있다. (for문으로 반복시켜서는 멈추지 않는다.)

        }
        System.out.println("메인이 종료됐습니다.");
    }

}
