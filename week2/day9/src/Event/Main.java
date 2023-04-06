package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// 이벤트를 듣고 있는 리스너 클래스를 생성

public class Main {
    public static void main(String[] args) {
        new MyFrame();
        //이벤트
        // -특정한 상황이 발생했다.
        // -상태 변화


    }
}


class MyFrame extends JFrame implements ActionListener{
    @Override // ActionListner 인터페이스에서 오버라이딩 된 메서드
    public void actionPerformed(ActionEvent e) {
        // 이벤트 객체에서 getSource()
        // 이벤트 정보를 가지고 있다. 버튼을 눌렀다던지 이러한 이벤트
        // 반환타입이 Object이다. 즉 모든 객체들을 받아서 돌려줄 수 있는데
        // 그렇게되면 그 타입의 멤버를 사용하지 못하니 형변환해서 사용해야 한다.
        JButton btn = (JButton)e.getSource();//

        String text = btn.getText();
        boolean res = text.equals("왜 눌렀니??");
        System.out.println(res);
        if(res){
            btn.setText("왜 눌렀냐니까???");
        }else{
            btn.setText("왜 눌렀니??");
        }


        //System.out.println(btn.getText()); // 클릭시 현재 텍스트 값을 콘솔창에 출력함
        //btn.setText(("왜 눌렀니"));

    }
    MyFrame(){

        setBounds(0,0,300,300); // 이렇게만해도 이 크기를 가진 창이 열리기는 함.

        JPanel panel1 = new JPanel();
        add(panel1); // 그럼에도 이렇게 판넬을 생성하는 이유는 보이지 않는 어떠한 판넬이 생기고 우리는 그 판넬에 접근해
        // 컴포넌트 같은 것들을 추가하는 식이다.

        JButton btn1 = new JButton("버튼을 누르세요");

        Font font = new Font("궁서체",Font.ITALIC,30);
        // JFrame의 기본적인 메서드들 set으로 시작함 setBounds, setSize, setFont, 둥둥
        btn1.setFont(font); // setFont(new Font("궁서체",Font.ITALIC,30)); 와 같이 해도 됨. 한 번 사용할 경우 굳이 변수 사용할 필요X

        //버튼에 이벤트를 설정한다.
        btn1.addActionListener(this);



        panel1.add(btn1);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
//package Event;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//
//// 이벤트를 듣고 있는 리스너 클래스를 생성
//
//class MyListener implements ActionListener{
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // 이벤트 객체에서 getSource()
//        // 이벤트 정보를 가지고 있다. 버튼을 눌렀다던지 이러한 이벤트
//        // 반환타입이 Object이다. 즉 모든 객체들을 받아서 돌려줄 수 있는데
//        // 그렇게되면 그 타입의 멤버를 사용하지 못하니 형변환해서 사용해야 한다.
//        JButton btn = (JButton)e.getSource();//
//
//        String text = btn.getText();
//        boolean res = text.equals("왜 눌렀니??");
//        System.out.println(res);
//        if(res){
//            btn.setText("왜 눌렀냐니까???");
//        }else{
//            btn.setText("왜 눌렀니??");
//        }
//
//
//        //System.out.println(btn.getText()); // 클릭시 현재 텍스트 값을 콘솔창에 출력함
//        //btn.setText(("왜 눌렀니"));
//
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        new MyFrame();
//        //이벤트
//        // -특정한 상황이 발생했다.
//        // -상태 변화
//
//
//    }
//}
//
//
//class MyFrame extends JFrame{
//
//    MyFrame(){
//
//        setBounds(0,0,300,300); // 이렇게만해도 이 크기를 가진 창이 열리기는 함.
//
//        JPanel panel1 = new JPanel();
//        add(panel1); // 보이지 않는 어떠한 판넬이 생기고 우리는 그 판넬에 접근해 컴포넌트 같은 것들을 추가하는 식이다.
//
//        JButton btn1 = new JButton("버튼을 누르세요");
//
//        Font font = new Font("궁서체",Font.ITALIC,30);
//        // JFrame의 기본적인 메서드들 set으로 시작함 setBounds, setSize, setFont, 둥둥
//        btn1.setFont(font); // setFont(new Font("궁서체",Font.ITALIC,30)); 와 같이 해도 됨. 한 번 사용할 경우 굳이 변수 사용할 필요X
//
//        //버튼에 이벤트를 설정한다.
//        btn1.addActionListener(new MyListener());
//
//
//
//        panel1.add(btn1);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//}