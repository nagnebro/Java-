package menu;

import javax.swing.*;

public class Circle extends JFrame {
    JTextField textField = null;
    JLabel label = null;
    JButton btn = null;
    JMenu menu = null;
    JMenuBar menubar = null;
    JPanel panel = null;


    Circle(){


        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);

        init();
        setVisible(true);


    }
    void init () {
        setLayout(null);
        setTitle("원 넓이 구하기");

        JPanel r_panel = new JPanel();
        JLabel r_label = new JLabel("원의 반지름"); // 얘 먼저 넣어야지 그다음에 텍스트필드가 들어옴.
        JTextField r_textfield = new JTextField(10);
        r_panel.setBounds(100,0,300,50);
        r_panel.add(r_label);
        r_panel.add(r_textfield);
        add(r_panel);

        // 판넬 제외하고 나머지는 계속 다른 메서드에서 쓰이니까 인스턴스 변수로 선언하는 것이 좋다
        JPanel a_panel = new JPanel(); // 넓이 : area
        JLabel a_label = new JLabel("원의 넓이");
        JTextField a_textfield = new JTextField(10);
        a_panel.setBounds(100,50,300,50);

        a_textfield.setEnabled(false);
        a_panel.add(a_label);
        a_panel.add(a_textfield);

        add(a_panel);


        JTextField input = new JTextField();
        JButton btn1 = new JButton("계산");
        JButton btn2 = new JButton("리셋");
        input.setBounds(100,100,350,100);
        input.setEnabled(false);
        add(input);
        JMenu menu = new JMenu();
        menu.setBounds(100,150,30,30);
        btn1.setBounds(100,250,30,30);
        btn2.setBounds(150,250,30,30);
        menu.setBounds(200,250,30,30);
        add(btn1);
        add(btn2);
        add(menu);
        if(r_textfield.getText().equals(null)){
            System.out.println("hi");
            System.out.println(r_textfield.getText());
        }
//        double result = calculate(r_textfield.getText());
//        //a_textfield = result+"";
//        r_textfield.setText(result+"");

    }

    double calculate(String r){
        if (r == null){
            return 1;
        }
        double r2 =Double.parseDouble(r);

        return r2*r2*3.14;
    }

    public static void main(String[] args) {
        new Circle();
    }
}
