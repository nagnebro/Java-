package mouse;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseWheelMain extends JFrame implements MouseWheelListener{

    public MouseWheelMain() {
        setTitle("마우스 이벤트");
        setSize(400,200);


        addMouseWheelListener(this);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        new MouseWheelMain();
    }


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        // 휠이 움직였을 때 이벤트가 발생!
        //  마우스가 앞으로 움직임 -1
        //  마우가가  뒤로 움직임  1
        System.out.println(e.getWheelRotation());



    }
}