package GUI;

import javax.swing.JFrame;
import java.awt.*;

public class MyFrame extends JFrame implements Runnable{

    Dimension dimen ; // 너비와 높이를 저장하고 있는 클래스  (?? )
    int x;
    int y;


    public MyFrame(){
        setBounds(x,0,500,500);
        setTitle("안녕하세요");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        dimen = Toolkit.getDefaultToolkit().getScreenSize(); // 얘 원리 잘 모르겠다.
        // 화면의 해상도를 얻어온다. 그리고 자동으로 dimen에 저장된다.

        setVisible(true);
    }

    @Override
    public void run() {
        int count = 0;
        while(true) {
            // 윈도우 창을 오른쪽으로 움직일 것!>

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            // 자바 프로그램창을 넘어간다
            // 넘어가지 말고 멈출 것!
            if (x <= dimen.width - 500 && count == 0) {// 화면의 해상도에서 창의 크기만큼 뺴야한다. 창의 왼쪽위를 기준으로 x좌표가 정해지기 때문이다.
                x++;
                if (x - 1 == dimen.width - 500) {
                    count++;
                }
            } else if (count == 1) {
                y++;
                if (y - 1 == dimen.height - 500) {
                    count++;
                }
            } else if (count == 2) {
                x--;
                if (x + 1 == 0) {
                    count++;
                }
            }
            else if (count == 3) {
                y--;
                if (y + 1 == 0) {
                    count++;
                }
            }setLocation(x,y);
//            else if (y <= dimen.width-500){
//                y++;
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                setLocation(dimen.width-500,y);
//            }

            // 지연을 시킨다
            // 스레드가 너무 빠르면 실행했는지 안보이기 떄문에

            //창의 위치만 변경하고 싶을 경우에는 setLocation
            // 좌표는 좌우 기준 오른쪽 + 왼쪽 - 상하 기준 위- 아래+

        }
    }
}
class Main{
    public static void main(String[] args) {
        System.out.println("메인메서드 실행");
        MyFrame m = new MyFrame();
        Thread t = new Thread(m);// new Thread(new MyFrame()); 와 동일
        System.out.println("메인메서드 종료");
        t.start(); // 메인메서드 종료돼도 당연히 스레드이기 떄문에 실행된다.
    }
}