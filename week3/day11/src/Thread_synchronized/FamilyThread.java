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


            wr.openDoor(who);// 이 구문을 작성해도 어쨌든 결국에는 1초후에 아빠엄마누나 나의 스레드가 다같이 실행된다
            // 물론 제어자 synchronized를 붙였기 때문에 빠른속도로 독립적으로 시행되기는 하지만 .. 이걸 통해 알 수 있는 사실은
            // run이 동시에 실행된 후에 위의 openDoor메서드를 호출하기 전까지는 지연을 시키든 뭐든 일단 opendoor 실행직전까지 스레드가 접근한다는것
            // 즉 위의 1000ms는 아무의미없는 코드이다. 다만 여기서 이제 synchonized의 원리가 나오는데 정확히 opendoor를 호출하기 시작했을떄
            // 그떄 예를 들어 아빠가 openDoor를 호출했다면 누나 엄마 나는 그 메서드를 실행할 수 없는 것이다. 싱크로나이즈드는 그 메서드가 실행되는
            // 시간이 굉장히 찰나기 때문에 서로 다른 객체가 그 메서드에 접근해서 꼬이는 것을 방지하는 역할을 하는 것이고.
            // 결과를 보면 알다시피  스레드에 접근하는 객체의 순서는 코드가 짜여진 순서가 아니다(예) 첫번쨰 실행 아빠>누나>나>엄마
            // 두번쨰 실행  나>누나>엄마>아빠 . 다만 같은 메서드에서 서로 다른 객체가 같은 메서드에 들어와 프로그램이 꼬이는 일은 방지할 수 있다.

    }
}
