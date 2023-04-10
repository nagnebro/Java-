package Thread_wait_notify;

public class Cook implements  Runnable{ // 스레드 인터페이스

    private final Dish dish; // 상수는 생성자에서 초기화하게 할 수 있다.

    // 매개 변수가 있는 생성자만 생성시 기본생성자가 생기지 않기때문에 항상 신경써야 한다.


//    public Cook(){ // 다음과 같이 기본생성자를 작성하면 에러가 난다. final인 상수를 초기화시켜주지 않기 때문.
//        this.DISH = null;
//    }
    Cook(Dish dish){
        this.dish = dish;
    }
    // 주방장의 고유 권한 cook. private.
    private void cook(int i) throws InterruptedException { // try catch말고 다른 예외처리. 뭔지 모르겠다.
        synchronized (dish){
            while(!dish.isEmpty()){
                dish.wait(); // 음식을 먹을떄까지 기다린다.
            }
            dish.setEmpty(false);
            System.out.println(i+"번째 음식이 준비되었습니다.");
            dish.notify(); // 빈그릇이 올떄까지 기다린다.
        }
    }
    @Override
    public void run() {

        for( int i = 0; i < 5 ; i ++){

            try {
                cook(i);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

// 이 스레드의 동작 원리?? 내 이해 아님.

/*
    - 마트에 물건이 가득 찬 경우
    - 마트에 물건이 가득 찼을 경우에는 생성자 더 이상 생산하지 말라고 기다리라고 한다 -> wait()
    - 소비자가 물건을 소비한 후 생산자에게 알려준다 ( 제품 만들어 달라고 ) -> notify()



 */