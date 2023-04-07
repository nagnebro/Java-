package memo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JMenuItem item1 = new JMenuItem();
    JMenuItem item2 = new JMenuItem();
    JMenuItem item3 = new JMenuItem();
    JMenuItem item4 = new JMenuItem();
    JMenuItem item5 = new JMenuItem();
    JTextArea textArea = new JTextArea();
    JPanel pan = new JPanel();
    Main(){

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

        JMenuItem item1 = new JMenuItem("ss");
        JMenuItem item2 = new JMenuItem("ss");
        JMenuItem item3 = new JMenuItem("ss");

        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        setJMenuBar(menubar);
    // 얘넣는거 아니다        add(menubar);

        Font ft = new Font("고딕체",Font.BOLD,20);

        textArea.setFont(ft);
        add(textArea);





    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Main();
    }
}
