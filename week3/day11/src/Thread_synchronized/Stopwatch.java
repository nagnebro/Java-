package Thread_synchronized;


// 내가 짠 코드 아님. =========================해석할 것========================================
class StopWatch extends Thread{
    public String timeText;
    long time = 0l; long preTime = 0l;
    boolean play = true;
    //Thread 클래스안에 있는 메서드
    public void run() {
        // 현재시간 초로변환된 값
        preTime = System.currentTimeMillis();
        while(play ) {
            try {
                sleep(10);
                time = System.currentTimeMillis() - preTime;
                int m = (int)(time / 1000.0 / 60.0);
                int s = (int)(time % (1000.0 * 60) / 1000.0);
                int ms = (int)(time % 1000 / 10.0);
                System.out.println(m + " : " + s  + " "+ ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Day0804_스탑와치 {
    public static void main(String[] args) {
        StopWatch st = new StopWatch();
        st.start();
    }


}