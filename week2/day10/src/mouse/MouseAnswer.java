package mouse;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Main2 extends JFrame implements MouseListener{

    JPanel pan;

    public Main2() {
        setTitle("마우스 이벤트");
        setSize(400,200);

        pan = new JPanel();

        add(pan);
        // 실제 메인프레임에 이벤트가 설정
        pan.addMouseListener(this); // pan을 붙이든 안 붙이든 똑같다.
        // 어차피 기본 프레임 위에 pan이 덮어쓰기 돼있는건데 마우스가 올라가면 그 두개의 프레임 구분없이 마우스가 올라가있는 것으로
        // 인식하기 때문. 하지만 레이아웃에 프레임이 나눠져있다면 pan.addMoustListener로 접근하는 것이 맞다.


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new Main2();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // 마우스 클릭할 때
        pan.setBackground(Color.cyan);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        // 마우스 누를 때
        pan.setBackground(Color.green);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // 마우스 뗄 때
        pan.setBackground(Color.pink);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // 마우스가 프레임 안 쪽으로 들어왔다
        pan.setBackground(Color.magenta);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // 마우스가 프레임을 나갔다.
        pan.setBackground(Color.orange);
    }
}