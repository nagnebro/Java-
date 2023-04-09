package mouse;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MouseMotionMain extends JFrame implements MouseMotionListener { // MouseListeer랑 다른 인터페이스이다.

    JPanel pan;
    JLabel label;

    public MouseMotionMain() {
        setTitle("마우스 이벤트");
        setSize(400,200);

        pan = new JPanel();
        label = new JLabel("움직이는 레이블");
        label.setForeground(Color.red); // 라벨의 글자 색을 빨간색으로 정해줌.

        pan.addMouseMotionListener(this);

        pan.add(label);
        add(pan);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MouseMotionMain();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // 마우스 눌러진 상태로 드래그 될 때
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // e 변수가 가지고 있는 정보를 사용
        // 동작원리 : 마우스가 움직이게되면 리스너가 반응해서 이 함수가 실행되고
        // 그때 우리가 설정한 lable을 마우스의 설정한 x,y의 좌표에 위치시켔다는 것.
        label.setLocation(e.getX() - 20,e.getY() -20);
    }

}