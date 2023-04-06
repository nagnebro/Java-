package Swing_layout;

import javax.swing.*;
import java.awt.*;

class MyBorder extends JFrame{
    JButton btn1 = new JButton("버튼1");
    JButton btn2 = new JButton("버튼2");
    JButton btn3 = new JButton("버튼3");
    JButton btn4 = new JButton("버튼4");
    JButton btn5 = new JButton("버튼5");

    JPanel panel = new JPanel();
    MyBorder(){
        setSize(400,200);

        //화면 배치 설정
        panel.setLayout(new BorderLayout());


        // 보조 프레임에 여러개의 버튼을 추가한다.
        panel.add(btn1,BorderLayout.NORTH);
        panel.add(btn2,BorderLayout.WEST);
        panel.add(btn3,BorderLayout.EAST);
        panel.add(btn4,BorderLayout.SOUTH);
        panel.add(btn5,BorderLayout.CENTER);

        // 이렇게 버튼을 추가하고 구성한 보조프레임인 panel을 메인프레임에 추가!
        add(panel);
        setVisible(true);
    }
}
public class BorderLayoutMain {
    public static void main(String[] args) {

        // BorderLayout은 상,하,좌,우,중앙으로 인터페이스를 구성하는 기능을 가지고 있음.

        // JFrame은 기본적으로 화면배치가 가운데로 설정
        // 각 영역당 하나의 컴포넌트 (버튼, 스크롤, 체크박스, 라디오박스) ( 컴포넌트 : 재사용 가능한 각각의 독립적인 모듈? 인터페이스 박스 같은 개념 )
        new MyBorder();
    }

}
