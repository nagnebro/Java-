package mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

public class MouseRGB extends JFrame implements MouseWheelListener {

    JPanel pan = new JPanel(new GridLayout(2,0));
    int totalsize = 130;
    int size1 = 130; // 다른 메서드에서도 실행돼야 하기 떄문에 전역변수로 선언.
    int size2 = 130;
    int size3 = 130;
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    MouseRGB(){
        setSize(400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        pan.setBackground(Color.BLUE);
        panel3.setBackground(Color.red);
        panel4.setBackground(Color.green);
        panel5.setBackground(Color.blue);
        JPanel pan2 = new JPanel(new GridLayout(0,3)); // pan2에 3 4 5추가
        pan2.add(panel3);
        pan2.add(panel4);
        pan2.add(panel5);
        pan.add(pan2);

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


        if(obj == panel3){ totalsize = size1;}
        else if(obj == panel4){ totalsize = size2;}
        else if(obj == panel5){ totalsize = size3;}

        if(obj == panel3   ){
            if(0 < size1 && size1< 250) {
                size1+=res;
            }
        }else if(obj == panel4  ){
            if( 0 < size2 && size2< 250){
                size2+=res;
            }

        }else if(obj == panel5  ){
            if(0 < size3 && size3< 250) {
                size3+=res;
            }

        }
        pan.setBackground(new Color(size1,size2,size3));







    }


    public static void main(String[] args) {
        new MouseRGB();
    }

}
