package Swing;

import javax.swing.*;
import javax.swing.JTextField;
import java.awt.*;

class MyText extends JFrame{

//    JPasswordField obj1 = new JPasswordField(10); // 10칸의 공간을 가진 텍스트필드가 나오고 입력시 비밀번호 입력창처럼 보호됨.
//    JPasswordField obj2 = new JPasswordField("댕댕이");
//    JPasswordField obj3 = new JPasswordField("댕댕이",10);


    String [] name = {"강아지","돼지","고양이"};
    JLabel obj3 = new JLabel(new ImageIcon("cat.png")); // 현재 런 화면에서 내 클래스를 실행시키는 경로가 어떻게 되는지 확인하고
    // 상대경로를 작성할 것. 아래에서는 절대경로로 작성.
    JLabel obj2 = new JLabel("고냉이");

    JLabel obj4 = new JLabel("고냉이",new ImageIcon("cat.png"),JLabel.RIGHT);


    JPanel pan = new JPanel();
    MyText(){

        setSize(500,300);


        //pan.add(obj1);
        pan.add(obj2);
        pan.add(obj3);
        pan.add(obj4);



        add(pan);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 창을 닫으면 메인 메서드가 종료된다.
    }
}


public class TextFieldMain {
    public static void main(String[] args) {

        // Label
        // - 고정된 텍스트값을 표현
        // - 읽기 전용 한 줄 표시

        // TextField
        // -텍스트 입력 한줄 입력하거나 수정하거나 등
        // - 편집을 할 수 있는 텍스트 구성 요소! 검색창, 아이디, 댓글창

        new MyText();

        // passwordField
        //  - 비밀번호 입력에 특화된 텍스트
        //  - 암호 기능을 처리하고  한 줄의 텍스트로 편집을 할 수 있다.

         // CheckBox
        // 선택하거나 선택을 해제했을 때 할 수 있고 사용자한테 그 인터페이스를 보여주는 컴포넌트

        // 라디오버튼
        // - 여러 옵션 중에 하나를 선택할 수 있는 라디오버튼
        // - 한번에 하나만 결과를 얻는다.


    }
}
//    //글자10만큼의 크기로 초기화
//    JTextField obj1 = new JTextField(10);
//
//    //글자로 초기화
//    JTextField obj2 = new JTextField("고양이");
//
//    // 강아지로 초기화하고 글자 10개만큼의 크기로 생성
//    JTextField obj3 = new JTextField("강아지",10);
//    JPanel pan = new JPanel();
//


//    JCheckBox obj1 = new JCheckBox(); // javax.swing.
//    JCheckBox obj2 = new JCheckBox("고양이");
//    JCheckBox obj3 = new JCheckBox("강아지",true);



//    JRadioButton obj1 = new JRadioButton();
//    JRadioButton obj2 = new JRadioButton("강아지");
//    JRadioButton obj3 = new JRadioButton("고양이");

//    JComboBox obj1 = new JComboBox(name);
//

//    String [] name = {"강아지","돼지","고양이"};
//    JLabel obj2 = new JLabel("고냉이");
//    JLabel obj3 = new JLabel(new ImageIcon("cat.png"));
//    JLabel obj4 = new JLabel("고냉이",new ImageIcon("cat.png"),JLabel.RIGHT);

///Users/kim/IdeaProjects/khjava/week2/day9