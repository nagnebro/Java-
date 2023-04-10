package menu;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CircleAnswer extends JFrame implements ActionListener, ItemListener, KeyListener {

    //필드 두개

    JTextField t1, t2;
    JTextArea area;   // 여러줄을 입력할 수 있는 클래스
    JButton cal, reset;
    JComboBox cb; //얘는 또 뭐임??  드롭다운 클래스

    //JFrame 클래스는 기본적으로 borderlayout을 사용하고 있음.

    CircleAnswer() { // 메인프레임 정도만 설정해줄 생성자
        setTitle("원넓이 구하기");
        setLayout(new BorderLayout(10, 10)); //보더레이아웃간의 간격을 10씩 준다는 것.
        setSize(400, 300);

        showNorth(); // borderlayout을 위로 배치할 메서드를 만듦.
        showCenter();
        showSouth();

        t1.addKeyListener(this);
        cal.addActionListener(this); // this는 메인메서드를 실행시킨 현재 클래스의 객체
        // 즉 circleanswer의 객체이다.
        reset.addActionListener(this);
        cb.addItemListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); // 얘는 웬만하면 맨 밑으로 뺴놓는 것이 좋다. 이벤트, 창크기, 컴포넌트 생성 후에 하는 것이 이상적.
    }

    void showNorth() {
        JPanel pan1 = new JPanel(); // 반지름 필드
        JPanel pan2 = new JPanel(); // 원의 넓이
        JPanel panel = new JPanel(new GridLayout(2, 0)); // 위의 pan1,2 를 합쳐서 한번에 panel에 저장
        // 그리드는 현재 2행 1열 상태의 판넬이 있음.
        JLabel l1 = new JLabel("원의 반지름");
        JLabel l2 = new JLabel("원의 넓이");

        t1 = new JTextField(10); // 원의 반지름 입력할 텍스트 필드
        t2 = new JTextField(10); // 원의 넓이를 입력받지는 않고 결과값을 보여줄 텍스트 필드

        // 버튼이나 텍스트필드같은 컴포넌트에는 보여지긴 하지만 비활성화 시키는 메서드가 있다 그니까 사용자가 입력값은 못받는 거임
        t2.setEnabled(false);
        pan1.add(l1);
        pan1.add(t1);
        pan2.add(l2);
        pan2.add(t2);

        // 두개를 묶어주는 panel
        panel.add(pan1); // 위에서 panel의 grid를 설정했는데 괄호안의 pan1이 그리드의 첫번째에 들어감.
        panel.add(pan2); // 얘가 두번째, 즉 아래로 들어감.
        add(panel, BorderLayout.NORTH);
    }

    void showCenter() {
        // 여러 줄을 입력받는 공간

        JPanel panel = new JPanel();
        // panel.setBackground(Color.BLACK); 뒷 배경을 검은색으로 함으로서 텍스트 박스의 크기를 가늠할 수 있음.

        area = new JTextArea(5, 20); // 가로 세로 글자 수
        area.setText("이 영역에 원의 넓이를 계산하는 과정");

        area.setForeground(Color.red); // area안의 글자색을 설정해주는 메서드
        panel.add(area);
        add(panel, BorderLayout.CENTER);
    }

    void showSouth() {

        String[] color = {"red", "blue"};
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        cal = new JButton("계산");
        cb = new JComboBox(color); // 얘는 뭐지?  Jmenu랑 비슷한데 Jmenubar에 Jmenu를 추가한 느낌
        reset = new JButton("리셋");
        panel.add(cal);
        panel.add(cb);
        panel.add(reset);
        add(panel, BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        repeat(obj,e);// 이 getsource의 정확한 동작원리가 뭐지? 버튼이 몇개가 있던 그냥
        // 이벤트를 발생시키는 것인지
        //repeat(obj,(Object)e);
//        if (obj == cal) {
//            if (t1.getText().isEmpty()) {
//                area.setText("값을 입력하세요");
//                return;
//            }
//            //t1텍스트필드의 값이 있는지 없는지 확인하고 잇으면 실행없으면 x
//            //isEmpty() 비어있으면 true, 값있다 false
//            // 비어있다면 반지름을 입력하세요 를 area에 setText();를 집어넣기
//            // 1. 텍스트필드에서 값을 가지고 와야된다
//            String s = t1.getText();
//            // 2. getText()메서드는 String으로 값을 가지고 오기 때문에 산술을 위해서는 형변환을 시켜줘야한다.
//            double radius = Double.parseDouble(s); // 텍스트 필드에서 가져온 문자열을 double형으로 변환시켜 준다.
//            double result = radius * radius * 3.14;
//            // 3. 계산된 결과를 textField와 textarea에 수정 시켜준다.
//            t2.setText(result + "");
//            area.setText(String.format("%.2f * %.2f * 3.14 = %.2f", radius, radius, result));
//        } else if (obj == reset) {
//            t1.setText(null);
//            area.setText("");
//            t2.setText("");
//        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // 콤보박스는 아이템 배열로 들어간 형태임. 즉 콤보박스에 들어간 color배열은 값에 접근하기 위해서 인덱스로 접근해야 한다.

        int index = (cb).getSelectedIndex(); // cb도 콤보박스 타입인데 왜 굳이 캐스팅하지?

        if (index == 0) {
            area.setForeground(Color.red); // area내부의 글자색을 변경해준다. 기본이 빨간색임
        } else {
            area.setForeground(Color.blue); // 푸른색으로 색상을 변경해준다.
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Object obj = e.getSource();
        repeat(obj,e);
//        Object obj = e.getSource(); // 이 getsource의 정확한 동작원리가 뭐지? 버튼이 몇개가 있던 그냥
//        // 이벤트를 발생시키는 것인지
//        repeat(obj,e);
//        if ((obj == t1 && e.getKeyCode() == 10)|| obj ==cal) {
//
//            if (t1.getText().isEmpty()) {
//                area.setText("값을 입력하세요");
//                return;
//            }
//            //t1텍스트필드의 값이 있는지 없는지 확인하고 잇으면 실행없으면 x
//            //isEmpty() 비어있으면 true, 값있다 false
//            // 비어있다면 반지름을 입력하세요 를 area에 setText();를 집어넣기
//            // 1. 텍스트필드에서 값을 가지고 와야된다
//            String s = t1.getText();
//            // 2. getText()메서드는 String으로 값을 가지고 오기 때문에 산술을 위해서는 형변환을 시켜줘야한다.
//            double radius = Double.parseDouble(s); // 텍스트 필드에서 가져온 문자열을 double형으로 변환시켜 준다.
//            double result = radius * radius * 3.14;
//            // 3. 계산된 결과를 textField와 textarea에 수정 시켜준다.
//            t2.setText(result + "");
//            area.setText(String.format("%.2f * %.2f * 3.14 = %.2f", radius, radius, result));
//        } else if (obj == reset) {
//            t1.setText(null);
//            area.setText("");
//            t2.setText("");
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    //ActionListenr를 오버로딩해도 가독성이 좋을듯. 매개변수 개수만 다르니까?
    public void repeat(Object obj,Object e) { // keyevent 와 actionevent타입의 변수를 모두 받기 위해 참조변수 타입으로
        // Object타입으로 선언했다. 이렇게 되면 obj에는 실행된 이벤트의 getsource()값이 넘어와 실행시킨 참조변수값이 넘어오고
        // e에는 키이벤트나 액션이벤트의 참조변수가 넘어오게 된다.
        // 여기서 의문점은 e에 actionevent e가 넘어올 수도 있는데 얘를 아래와 같이 keyevent를 하면 에러가 발생하지않나?

        if ((obj == t1 &&  ((KeyEvent)e).getKeyCode() == 10 )|| obj == cal) { // 이 조거때문에 위 의문점에 해당하는 부분이 해결딘다
            // obj의 인스턴스가 t1의 것이라면 애초에 e도 keyevent가 들어왔을 것이므로 에러가 발생하지 않는다.
            // 예를 들어 actionListener인 계산버튼 cal의 인스턴스가 obj에 들어오고 actionevent가 e에 들어왔다고 가정하면
            // 첫번째 조건인 obj==t1에서 이미 &&조건은 비교를 끝내버리기 때문에 다음의 ((KeyEvent)e) 가 실행되지 않기 때문에
            // 캐스팅 에러가 발생하지 않는다.
            if (t1.getText().isEmpty()) {
                area.setText("값을 입력하세요");
                return;
            }
            //t1텍스트필드의 값이 있는지 없는지 확인하고 잇으면 실행없으면 x
            //isEmpty() 비어있으면 true, 값있다 false
            // 비어있다면 반지름을 입력하세요 를 area에 setText();를 집어넣기
            // 1. 텍스트필드에서 값을 가지고 와야된다
            String s = t1.getText();
            // 2. getText()메서드는 String으로 값을 가지고 오기 때문에 산술을 위해서는 형변환을 시켜줘야한다.
            double radius = Double.parseDouble(s); // 텍스트 필드에서 가져온 문자열을 double형으로 변환시켜 준다.
            double result = radius * radius * 3.14;
            // 3. 계산된 결과를 textField와 textarea에 수정 시켜준다.
            t2.setText(result + "");
            area.setText(String.format("%.2f * %.2f * 3.14 = %.2f", radius, radius, result));
        } else if (obj == reset) {
            t1.setText(null);
            area.setText("");
            t2.setText("");
        }
    }



    public static void main(String[] args) {
        new CircleAnswer();
    }
}
