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