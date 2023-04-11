package Thread_synchronized;

public class FamilyThread extends Thread{

    private Washroom wr;
    private String who;

    public FamilyThread(String name, Washroom wr){
        this.wr = wr;
        this.who = name;
    }

    @Override
    public void run() {


            wr.openDoor(who);
            // 그떄 예를 들어 아빠가 openDoor를 호출했다면 누나 엄마 나는 그 메서드를 실행할 수 없는 것이다. 싱크로나이즈드는 그 메서드가 실행되는
            // 시간이 굉장히 찰나기 때문에 서로 다른 객체가 그 메서드에 접근해서 꼬이는 것을 방지하는 역할을 하는 것이고. 다만 여기에
            // sleep로 지연시키면 확실히 호출하려는 메서드에 락이 걸려 한개의 객체에서만 프로그램이 돈다는 것을 알 수 있다.
            // 그러나 결과를 보면 알다시피  스레드에 접근하는 객체의 순서는 코드가 짜여진 순서가 아니다(예) 첫번쨰 실행 아빠>누나>나>엄마
            // 두번쨰 실행  나>누나>엄마>아빠 . 다만 같은 메서드에서 서로 다른 객체가 같은 메서드에 들어와 프로그램이 꼬이는 일은 방지할 수 있다.

    }
}
