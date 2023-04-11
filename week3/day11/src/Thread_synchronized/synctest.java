package Thread_synchronized;

public class synctest extends Thread {

    private threadmethod t;
    synctest(threadmethod t){
        this.t = t;
    }

    @Override
    public void run() {
        t.test();
    }
}



// 스레드는 스레드 클래스를 상속받은 서로 다른 두 클래스가 필요하다. 한개의 클래스에서는 run메서드를 오버라이딩 하고, 그 run에 실행시킬 메서드를 작성
// 나머지 하나의 클래스에서는 그 메서드의 내용을 작성하면 된다. 이때 주의할 사항은 호출할 메서드의 클래스
class Test2 {
    public static void main(String[] args) {
        threadmethod t = new threadmethod();
        synctest sc = new synctest(t);
        synctest sc2 = new synctest(t);
        synctest sc3= new synctest(t);
        synctest sc4= new synctest(t);
        sc.start();
        sc2.start();
        sc3.start();
        sc4.start();
    }
}

class threadmethod extends Thread{
    synchronized void test(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("hi");
    }

}