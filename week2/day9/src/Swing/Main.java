package Swing;

import javax.swing.*;


class MyFrame extends JFrame{ // 이렇게 상속받아서 하는게 참조변수로 접근하는 것보다 융통성이나 확장성, 유지보수 측면에서도 효율적이다.
    MyFrame(){ // 인스턴스를 생성하면서 창을 열기
        setTitle("자바 GUI");
        setSize(500,300);
        // 그래픽을 구성할때는 순서가 중요하다

        JButton btn1 = new JButton("눌렀니?");

        // 창에 버튼을 부착
        add(btn1); // JFrame의 add



        setVisible(true); // 정확히 말하자면 JFrame을 상속하고 생성자가 실행되는 것 자체만으로도 Main메서드에서 실행창이 생성되긴 한다.
        // 다만 그 창이 보이냐 안보이냐는 setVisable로 컨트롤 할 수 있는 거고 그 창에 대한 판넬에 대한 설정을 JFrame클래스의 set이 들어간
        // 메서드로 하는 것이다.
    }
}

public class Main {
    public static void main(String[] args) {
        MyFrame m = new MyFrame();
    }
}
//}
//        // 자바 GUI ( Graphical User Inerface )
//        // -그래픽 이용, 사용자가 이해하기 쉬운 모양으로 정보 제공
//        // 마우스나 키보드를 이용하여 입력
//        // 스윙은 윈도우 기반 GU를 구현하는데 사용하는 자바 기반 클래스의 일종.
//
//        // 그래픽을 하기 위해서 필요한 프레임.
//        // 창 만드는 프레임
//
//        // 객체 생성
//        JFrame mac = new JFrame();
//
//        // 창을 보이게 하기 (true : 보임, false : 안보임)
//
//        //너비와 높이를 설정하기, 창 크기 설정하기
//        mac.setSize(400,200);
//
//        // 프로그램 타이틀
//        mac.setTitle("자바 GUI");
//
//        mac.setVisible(true);
