package InnerClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface A{
    void show();
}
public class AnonymousMain extends JFrame {

    public AnonymousMain(){
        setBounds(0,0,400,300);
        JButton btn = new JButton("눌렀니");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setText("놀랐네~"); // 얘를 정확히 왜쓰는지 모르겠다. 강사님 말씀으로는 굳이 계속 액션리스너의 입력을 받을 필요가 없다?? 라고
                // 말하셨는데.. 아마 한번 이벤트를 감지하고 나서는 굳이 btn이 계속 액션리스너에서 어떤 값이 오기를 기다릴 필요가 없을떄는 그 리스너를
                // 사용하지 않는 것이 효율적이라서?
            }
        });
        add(btn);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        setVisible(true);
    }
    public static void main(String[] args) {


        new AnonymousMain();



        // 내부클래스 익명클래스
        // - 클래스를 정의와 동시에 객체를 생성할 때 만들어지는 클래스
        // - 1회용 클래스.
        // 이벤트할떄, GUI 그래픽할 떄 많이 사용이 된다.

    }

}
//        A a1 = new A(){
//
//            @Override
//            public void show() {
//                System.out.println("딱 한번만 실행.");
//            }
//        };
//
//        a1.show();
