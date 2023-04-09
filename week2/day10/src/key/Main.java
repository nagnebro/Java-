package key;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


// 내부클래스
//   클래스가 클래스 안으로 들어간다.
//   멤버 변수, 멤버메서드


class MyAdapter extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == 10){ // KeyEvent.VK_ENTER


        }

    }
}

// keyevent는 사용자가 키를 입력할 때 발생하는 이벤트이다.
public class Main extends JFrame implements KeyListener {
    public Main(){
        // Adapter 클래스
        // -여러개의 인터페이스를 오버라이딩 할 때 실제 사용되는 메서드의 개수를 정하고 싶을떄
        // 원하는 인터페이스만 오버라이딩해서 사용할 수 있게 만들어주는 어댑터 클래스.
        // 인터페이스의 메서드가 하나인 경우에는 어댑터 클래스가 없다.
        // 리스너 인터페이스들은 그에 대응하는 어댑터 클래스가 있다.

        setTitle("키 어댑터");
        setSize(300,400);

        JLabel l = new JLabel("키 어댑터",JLabel.CENTER); // 라벨을 실행창의 정가운데에 위치시킨다.
        JTextField t = new JTextField(10);

        // 보더레이아웃 add(위치, 컴포넌트)
        // "North" 문자열로 주고 앞 글자 무조건 대문자.
        add("North",t);// 텍스트 필드를 보더레이아웃의 제일 상단에 위치시킨다.
        add("Center",l); // 라벨을 보더레이아웃의 센터에 위치시킨다.

        t.addKeyListener(this); // JtextField에 키리스너를 추가함으로써 텍스트 창에 키보드 입력을 감지한다.

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }




    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void keyTyped(KeyEvent e) { // 타이핑할때
        System.out.println("타이핑");
    }

    @Override
    public void keyPressed(KeyEvent e) { //누를때
        System.out.println(e.getKeyCode());
        // 아스키코드 값을 기준으로 문자만 표시됨. 특수키가 안나옴.
    }

    @Override
    public void keyReleased(KeyEvent e) { // 뗄 때
        System.out.println("키를 뗐다");
    }
}
