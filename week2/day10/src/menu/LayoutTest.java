package menu;

import javax.swing.*;
import java.awt.*;

public class LayoutTest extends JFrame {

    LayoutTest(){
        setBounds(500,200,500,500);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setLayout(null);

        JPanel panel = new JPanel(new GridLayout(3,0)); //10행 10열일줄 알았는데 행만 늘어나고 열은 구분되지 않는다.
        //JPanel panel = new JPanel(new BorderLayout(10,10)); // 얘는 뭐자? 아.. 각 배치간격 사이의 갭이구나.

        // 간략하게 정리하자면 JPanel의 생성자에 그리드레이아웃으로 초기값을 설정할 경우에는 행과열을 설정할 수 있고 보더 레이아웃은 동서남북 중간의 형태로
        // 레이아웃이 나눠지는 형태다. 그리드 레이아웃의 행과 열을 설정해도 내가 원하는대로 컴포넌트가 붙지는 않는데 아마 넣으면 계속 추가되는 식인 듯하다.
        // 예를 들어 0,3 으로 생성시 행이 없어야한다.그러나 열이 3이 유지가 되고 행은 3열이 넘어서면 밑으로 행이 추가되는 식이고
        // 3,0으로 생성시에는 갯수에 맞게 3열로 생성되다가 갯수가 넘어서면 열이 늘어나며 옆으로 늘어나는 식이다.

        JButton btn1 = new JButton("fff");
        JButton btn2= new JButton("fff");
        JButton btn3 = new JButton("fff");
        //panel.add(new JTextArea());
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(new JButton());
        panel.add(new JButton());
        panel.add(new JButton());
        panel.add(new JButton());
        panel.add(new JButton());
        panel.add(new JButton());
        panel.add(new JButton());
        panel.add(new JButton());
        panel.add(new JButton());
        panel.add(new JButton());
        panel.add(new JButton());
        panel.add(new JButton());



        add(panel);


        setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutTest();
    }
}
