package Swing_layout;
import javax.swing.*;




class MyFlow extends JFrame {

    JButton btn1 = new JButton("버튼1");
    JButton btn2 = new JButton("버튼2");
    JButton btn3 = new JButton("버튼3");
    JButton btn4 = new JButton("버튼4");
    JButton btn5 = new JButton("버튼5");
    // FlowLayout flow = new FlowLayout();
    JPanel panel = new JPanel();

    MyFlow(){ // 기본 생성자
        setSize(500,200);
        panel.setLayout(new java.awt.FlowLayout());
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);

        add(panel);

        setVisible(true);
    }

}


public class FlowLayout {
    // 왼쪽에서 오른쪽으로 한줄에 차례대로 정렬 레이아웃
    // 왼쪽에서 실행
    // 오른쪽에서 실행
    public static void main(String[] args) {
        new MyFlow();

        //JFrame으로는 하나의 버튼만 올라갈 수 있고 여러가지를 표현하기 위해서는 보조프레임이 필요하다.
    }
}
