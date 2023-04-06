package Swing_layout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

import java.util.ArrayList;


class MyGrid extends JFrame { // JFrame import
    ArrayList<JButton> list  = new ArrayList<>();

    JButton btn1 = new JButton("버튼1"); // JButton import
    JButton btn2 = new JButton("버튼2");
    JButton btn3 = new JButton("버튼3");
    JButton btn4 = new JButton("버튼4");
    JButton btn5 = new JButton("버튼5");

    JPanel panel = new JPanel(); // JPanel import
    MyGrid(){


        setSize(400,200);
        panel.setLayout(new GridLayout(4,4)); // rows : 열 ,  columns : 행
        // GridLayoutds
        for (int i = 1 ; i <= 16; i++){
            list.add(new JButton(i+""));
            panel.add(list.get(i-1));
        }
        //화면 배치 설정

        // 보조 프레임에 여러개의 버튼을 추가한다.

        // 이렇게 버튼을 추가하고 구성한 보조프레임인 panel을 메인프레임에 추가!
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 창을 닫으면 메인 메서드가 종료된다.
    }
}
public class GridLayoutMain {
    public static void main(String[] args) {


        new MyGrid();
        // GridLayout
        // - 행과 열을 만들어 격자 형태로 정렬하는 레이아웃
        // - 모든 컴포넌트들이 동일한 크기를 가지고 프레임에 배치된다.
        // - 엑셀, 바둑판처럼 칸의 크기가 일정한 행열을 나타내는 레이아웃.

        // ArrayList나 배열을 이용해서 버튼이 많이 달린 퍼즐 완성


    }

}
