package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DialogMain extends JFrame implements ActionListener {
    ArrayList<JButton> btnList = new ArrayList<>();
    String [] strList = {"에러","정보","경고","질문"};


    DialogMain(String name, int x, int y, int width, int height) {

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(x, y, width, height);
        test(name, x, y, width, height);

        //각각의 버튼에 리스너 추가
    }
    void test(String name, int x, int y, int width, int height) {
            JPanel panel1 = new JPanel();
            GridLayout grid = new GridLayout(1, 4);
            for (int i = 0; i < strList.length; i++) {
                JButton btn1 = new JButton(strList[i]);  // 문자열이 있는 텍스트 박스
                btnList.add(btn1);
                btn1.addActionListener(this); //이 메서드의 동작원리가 뭐지? 여기 집어 넣어놔도 에러 찾기는하는데 메인메서드가 계속 돌고 있어서 그런가?
                panel1.add(btn1); // 버튼추가
            }

        JButton j = new JButton();

//        btnList.get(0).addActionListener(this);
//        btnList.get(1).addActionListener(this);
//        btnList.get(2).addActionListener(this);
//        btnList.get(3).addActionListener(this);
//        panel1.add(btnList.get(0));
//        panel1.add(btnList.get(1));
//        panel1.add(btnList.get(2));
//        panel1.add(btnList.get(3));

            add(panel1);
        }


    @Override
    public void actionPerformed(ActionEvent e) { // 여기서 ActonEvnet 가 버튼을 클릭했을 때 비로소 인스턴스가 넘어오는 형식이지 않은가 생각됨.
        // 동작원리를 자세히 모르겠다 일단은 코드 작성하자.

        // 나는

        Object obj = e.getSource(); // >> 얘가 가지고 있는 값은 Object타입
        if( obj == btnList.get(0)){ // 객체의 주소값끼리 비교! 발생한 이벤트 객체와 btn1의 주소가 같은지 비교
            // 팝업창은 static으로 선언돼있어서 class로 접근가능하다.
            JOptionPane.showMessageDialog(this, "팝업창 대화상자","에러",JOptionPane.ERROR_MESSAGE); // 이건 또 무슨 원리인지 모르겠다.
            btnList.get(0).setBackground(Color.GREEN);
            btnList.get(0).setOpaque(true);
            System.out.println(btnList.get(0));
        }else if( obj == btnList.get(1)){ // 객체의 주소값끼리 비교! 발생한 이벤트 객체와 btn1의 주소가 같은지 비교

            // 팝업창은 static으로 선언돼있어서 class로 접근가능하다.
            JOptionPane.showMessageDialog(this, "팝업창 대화상자","경고",JOptionPane.ERROR_MESSAGE);
            btnList.get(1).setOpaque(true);
            btnList.get(1).setBackground(Color.BLUE);
        }else if( obj == btnList.get(2)){ // 객체의 주소값끼리 비교! 발생한 이벤트 객체와 btn1의 주소가 같은지 비교

            // 팝업창은 static으로 선언돼있어서 class로 접근가능하다.
            JOptionPane.showMessageDialog(this, "팝업창 대화상자","아님",JOptionPane.ERROR_MESSAGE);
            btnList.get(2).setBackground(Color.BLUE);
        }else if( obj == btnList.get(3)){ // 객체의 주소값끼리 비교! 발생한 이벤트 객체와 btn1의 주소가 같은지 비교
            btnList.get(3).setBackground(Color.BLUE);
            // 팝업창은 static으로 선언돼있어서 class로 접근가능하다.
            JOptionPane.showMessageDialog(this,
                    "팝업창 대화상자"
                    ,"에러"
                    ,JOptionPane.ERROR_MESSAGE); // 이건 또 무슨 원리인지 모르겠다.
        }
        // else if써서 다른 조건 생성가능  정보 JOptionPane.Information_MESSAGE
    }                                //경고 JOptionPane.Information_MESSAGE
}

class DialogTest{
    public static void main(String[] args) {
        new DialogMain("버튼",0,0,500,400);

    }
}