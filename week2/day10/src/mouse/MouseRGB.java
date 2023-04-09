package mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

public class MouseRGB extends JFrame implements MouseWheelListener {

    JPanel pan = new JPanel(new GridLayout(2,0)); // 메인 프레임을 2행 0열의 그리드레이아웃으로 설정

    int size1 = 130; // 다른 메서드에서도 실행돼야 하기 떄문에 전역변수로 선언.
    int size2 = 130;
    int size3 = 130;
    JLabel red = new JLabel(size1+"");
    JLabel green = new JLabel(size2+"");
    JLabel blue = new JLabel(size3+"");
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    MouseRGB(){
        setSize(400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        pan.setBackground(Color.BLUE);
        panel3.setBackground(Color.red);

        panel4.setBackground(Color.green);

        panel4.add(red);

        panel5.setBackground(Color.blue);

        JPanel pan2 = new JPanel(new GridLayout(0,3));
        // GridLayout으로 설정한 화면의 윗부분은 RGB를 나타낼 화면 세개로 구성돼야 한다. 즉 pan에 들어갈 0행 3열짜리 pan2를 만든 것.

        panel3.add(red);
        panel4.add(green);
        panel5.add(blue);

        pan2.add(panel3);
        pan2.add(panel4);
        pan2.add(panel5);// pan2에 가로로 pan3,4,5를 추가하며 3열짜리 판넬을 만들어준다.
        pan.add(pan2); // 3개짜리 판넬은 pan의 첫번째 행의 위치에 추가해준다.

        pan.addMouseWheelListener(this);
        panel3.addMouseWheelListener(this);
        panel4.addMouseWheelListener(this);
        panel5.addMouseWheelListener(this);
        //panel3.addMouseWheelListener(this);

        add(pan);


        //addMouseWheelListener(this);
        setVisible(true);

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        Object obj = e.getSource();

        int res = e.getWheelRotation();

        System.out.println(res);



            if (obj == panel3) {
                if (0 < size1 && size1 < 250) {
                    size1 += res;
                    red.setText(size1 + "");
                }
            } else if (obj == panel4) {
                if (0 < size2 && size2 < 250) {
                    size2 += res;
                    green.setText(size2 + "");
                }

            } else if (obj == panel5) {
                if (0 < size3 && size3 < 250) {
                    size3 += res;
                    blue.setText(size3 + "");
                }
            }

        pan.setBackground(new Color(size1,size2,size3));







    }


    public static void main(String[] args) {
        new MouseRGB();
    }

}
