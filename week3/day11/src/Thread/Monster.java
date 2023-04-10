package Thread;
// 몬스터의 이름, 몇초마다 한번씩 출모하는지 인스턴스 변수를 선언하고 생성자로 초기화
// 오크 2초마다
// 골렘 5초마다
public class Monster extends Thread{

    String name;
    int time;

    public Monster(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        while (true){
            System.out.printf("%s 가 출현! \n",name);
            try {
                sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
