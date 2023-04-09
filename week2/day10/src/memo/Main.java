package memo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Main extends JFrame implements ActionListener, KeyListener {

    JMenuItem item1 = null;
    JTextArea textArea =null;
    JPanel pan = new JPanel();
    Main(){
         // setLayout(null); 얘 넣으면 textarea 가 나오지않는다 이유는 .. 모르곘다.
        setTitle("메모장");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);


        init();
        setVisible(true);

    }

    void init(){
        pan.setBounds(0,0,500,500);
        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("파일");
        JMenu menu2 = new JMenu("추가");
        JMenu menu3 = new JMenu("편집");

        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);

        item1 = new JMenuItem("액션 발생시켜주는 ");
        JMenuItem item2 = new JMenuItem("ss");
        JMenuItem item3 = new JMenuItem("ss");

        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        setJMenuBar(menubar);    // 메뉴바 추가는 다음과 같이한다. 우측과 같이 작성할 시 추가 안됨.       add(menubar);


        Font ft = new Font("고딕체",Font.BOLD,20);
        textArea = new JTextArea();
        item1.addActionListener(this);
        textArea.setFont(ft);
        textArea.addKeyListener(this);

        add(textArea);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == item1){
            System.out.println("액션리스너 발생");
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Object obj = e.getSource();
        if( obj == textArea){
            System.out.println("hi");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
