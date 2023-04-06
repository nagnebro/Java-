package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateEvent extends JFrame implements ActionListener {

    JPanel panel1 = new JPanel();
    JButton btn1 = new JButton("+");
    JButton btn2 = new JButton("-");
    JTextField text1 = new JTextField(5);
    JTextField text2 = new JTextField(5);


    CalculateEvent(String name, int x, int y, int width, int height) {

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        calculate(name, x, y, width, height);
        // setLocationRelativeTo(null); 센터에 프레임 창 배치
    }

    void calculate(String name, int x, int y, int width, int height) {
        setTitle(name);
        JPanel textpanel = new JPanel();
        setBounds(x, y, width, height);


        JLabel textLabel1 = new JLabel("숫자1");
        JLabel textLabel2 = new JLabel("숫자2");


        textpanel.setBounds(150, 150, 300, 50);
        textpanel.add(textLabel1);
        textpanel.add(text1);
        textpanel.add(textLabel2);
        textpanel.add(text2);
        add(textpanel);


        JPanel btnpanel = new JPanel();
        btnpanel.setBounds(150, 200, 300, 50);

        btnpanel.add(btn1);
        btnpanel.add(btn2);

        btn1.addActionListener(this);
        btn2.addActionListener(this);




        add(btnpanel);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) { // 버튼 클릭하면 알아서 참조변수값이 넘어올 듯.

        Object obj = e.getSource(); // 반환타입이 object이다.
        ImageIcon icon = new ImageIcon("./images1/1.png");
        int num1 = Integer.parseInt(text1.getText());
        int num2 = Integer.parseInt(text2.getText());
        if (obj == btn1) {


            JOptionPane.showMessageDialog(this, "결과값 : "+(num1 +num2), "완료", JOptionPane.ERROR_MESSAGE,icon);
        } else if (obj == btn2) {
            JOptionPane.showMessageDialog(this, "뺄셈완료 : "+(num1 - num2), "완료", JOptionPane.ERROR_MESSAGE,icon);
        }

        // 계산기 사이즈는 다이얼로그 메인이랑 똑같이 하고. 입력값 두개 받을 수 있는 textfield2개 만들고 + -버튼을 만들고
        // 두개를 계산해서 콘솔창에 계산값이 출력되게끔 하는 프로그램. 뭐 계산ㄴ할떄 버튼 누를떄 팝업창으로 계산이 됐습니다 라고 뜬다던지 그런식으로 할수도 있을 듯.
    }
}

class CalculateTest{
    public static void main(String[] args) {
        new CalculateEvent("계산기",0,0,500,400);
    }
}