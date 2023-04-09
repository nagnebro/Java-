package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Circle extends JFrame implements ActionListener , KeyListener {


    JTextField r_textfield = new JTextField(10);
    JTextField a_textfield = new JTextField(5);
    JButton btn1 = new JButton("계산");
    JButton btn2 = new JButton("리셋"); // null로 선언하고 아래 메서드에서 생성하는게 더 효율적.
    JTextArea input = new JTextArea(3, 20);
    JMenuItem menu1 = new JMenuItem("Green");
    JMenuItem menu2 = new JMenuItem("Blue");

    Font ft = null;

    Circle() {


        setResizable(true); // 이 메서드는 창의 크기를 조절할 수 있게 하냐 없냐를 결정 지어준다.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        init();
        setVisible(true);


    }

    void init() {
        setTitle("원 넓이 구하기");
        setLayout(new GridLayout(6, 0));
        // r_panel 및 r_label 등은 반지름을 입력받는 부분의 텍스트필드 및 프레임을 뜻한다.
        JPanel r_panel = new JPanel();
        JLabel r_label = new JLabel("원의 반지름"); // 얘 먼저 넣어야지 그다음에 텍스트필드가 들어옴.

        // setLayout(null) 로 설정했을 시에는 아래의 setBounds를 이용해 판넬들의 위치를 조정해줘야 고정이 된다.
        // r_panel.setBounds(100,0,300,50); //setLayout을 null로 설정했기 때문에 창의 크기를 조절해도
        // 텍스트나 텍스트필드가 따라오지 않는다.
        r_panel.add(r_label); // 판넬에 텍스트가 입혀진 라벨을 더하고
        r_panel.add(r_textfield); // 다시 판넬에 라벨옆에 텍스트창이 들어가게 텍스트필드를 넣어준다.
        add(r_panel); // 라벨과 텍스트가 더해진 r_panel을 메인 프레임에 붙여준다.

        // a_panel 및 a_label 등은 사용자에게 입력받은 값을 계산한 텍스트를 출력해주는 공간이다.
        // 판넬 제외하고 나머지는 계속 다른 메서드에서 쓰이니까 인스턴스 변수로 선언하는 것이 좋다
        JPanel a_panel = new JPanel(); // 넓이 : area
        JLabel a_label = new JLabel("원의 넓이");

        // a_panel.setBounds(100,50,300,50);

        a_textfield.setEnabled(false); // 이 텍스트 필드는 사용자가 입력할 수 없게끔 만들어 놓는다. 그저 결과값을 출력만 해줄 텍스트 필드일 뿐.
        a_panel.add(a_label);
        a_panel.add(a_textfield);

        add(a_panel);

        JPanel btnpanel = new JPanel();
        JPanel areapanel = new JPanel();


        //input.setBounds(100,100,350,100);
        // input.setEnabled(false); 참고로 다음과 같이 작성시 색상 변경도 안된다.
        input.setForeground(Color.red);
        input.setText("계산 과정이 출력됩니다");
        areapanel.add(input);
        add(areapanel);
        add(btnpanel);



        JMenu menu = new JMenu("색상");
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        menu.add(menu1);
        menu.add(menu2); // 메뉴바에 메뉴가 추가돼야하고 그 메뉴에 메뉴아이템이 추가돼야 아래로 내려오는 것 같다.

        btnpanel.add(btn1);
        btnpanel.add(menuBar);
        btnpanel.add(btn2);


        menu1.addActionListener(this);
        menu2.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        r_textfield.addKeyListener(this);

    }


    public static void main(String[] args) {
        new Circle();
    }

    @Override
    public void actionPerformed(ActionEvent e) { // 계산이나 리셋을 하기 위해 인터페이스 메서드를 오버라이딩.
        Object obj = e.getSource();
        double result = 0;
        if (obj == btn1) {
            double r = Double.parseDouble(r_textfield.getText());
            result = r * r * 3.14;
            a_textfield.setText(result + "");
            input.setText(String.format("%f * %f * 3.14 = %f", r, r, result));

        } else if (obj == btn2) {
            r_textfield.setText(null);
            a_textfield.setText(null);
            input.setText(null);
        }

        Object obj2 = e.getSource();
        if (obj2 == menu1) {
            ft= new Font("고딕체",20,10);
            input.setForeground(Color.green);
        } else if(obj2 == menu2){
            System.out.println("hi2iiiiii2");
            input.setForeground(Color.cyan);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



}
