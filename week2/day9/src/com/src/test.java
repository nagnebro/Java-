import java.awt.*;

import javax.swing.*;

class GuestWindow extends JFrame{
    // 그래픽 프레임창의 기본설정은 생성자 안에다가 설정
    public GuestWindow(String title, int x, int y, int width, int height) {

        initContainer(title, x, y, width, height);
        initContainer(title,0,0,500,500);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void initContainer(String title,int x,int y ,int width,int height) { // 컴포넌트 (버튼,텍스트필드,라벨,이미지)
        setTitle(title);
        setBounds(x,y,width,height); //프레임의 위치,크기 설정
        setLayout(null);              // 프레임 미설정(배치) 얘를 null값을 주지 않으면
        // 본인이 계쏙 센터 맞출려고 함.

        Font ft;
        ft = new Font("함초롬돋음",Font.BOLD,20); // 글꼴설정

        // 너비와 높이를 필드로 가지고 있는 클래스
        // 툴킷 클래스

//        Dimension sreenSize =  Toolkit.getDefaultToolkit().getScreenSize();
//        // 창 위치 setLocation(화면의너비, 화면의 높이)
//        setLocation((sreenSize.width-1000) / 2, (sreenSize.height-1000) / 2);

        // 여러 컴포넌트 올리는 보조 프레임 생성
        JPanel userPanel = new JPanel();
        userPanel.setBounds(0, 100,1000,260);


        // 아이콘 (고양이 가져와서 아이콘 객체 생성)
        // 상대경로 . 점으로 현재 폴더 (src)
        ImageIcon imageIcon = new ImageIcon("./images1/user.png"); // .은 현재폴더를 뜻하며 다음 경로로
        // 들어가기 위해서는 먼저 현재경로 설정후 경로로 들어가야한다.
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel("고양이",imageIcon,JLabel.RIGHT);
        imageLabel.setFont(ft);
        userPanel.add(imageLabel);
        // 이미지 아이콘 크기,스타일 setImage()

        // 라벨

        // userPanel.add()추가

        // 보조프레임 -> 메인프레임
        add(userPanel); // 그냥 add() 메서드는 JFrame의 메서드이다. JFrame의 화면에 프레임을 더해주느 메서드이다.
        // 쉽게 설명하면 최종적으로 add();하는 것이 메인프레임에 올리는 것이고 나머지 JPanel들은 모두 보조프레임이라고 보면 된다.
        // 보조프레임에는 라벨이나 버튼등 여러가지 컴포넌트를 추가할 수 있다.



        // 고객 정보를 입력하세요 -
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(0, 350, 1000, 50);
        add(titlePanel);

        JLabel titleLabel = new JLabel("--고객 정보를 입력하세요--");
        // 라벨을 생성 글꼴 설정
        titleLabel.setFont(ft);
        titleLabel.setForeground(Color.pink);  // 글꼴 색상
        titlePanel.add(titleLabel); // titlePanel에 titleLabel값을 대입
        titleLabel.setFont(ft);



        // 이름 : 입력받는 text 필드
        JPanel namePanel = new JPanel();// 이름을 입력받는 텍스트 박스 및 문자열을 담을 파넬을 생성
        namePanel.setBounds(0, 400, 1000, 50);
        add(namePanel); // 사실 메인메서드는 계속 실행되기 때문에 namePanel을 메인 프레임에 먼저 더하고 이후에 namePanel에
        // 라벨이나 텍스를 대입해도 관계없다.


        JLabel nameLabel = new JLabel("이 름");
        JTextField nametext = new JTextField(10);
        namePanel.add(nameLabel);
        namePanel.add(nametext);
        nameLabel.setFont(ft);


        // 이름이랑 text 객체 각각 성생해서 namePanel 추가


        // 연락처
        JPanel phonePanel = new JPanel();
        phonePanel.setBounds(0, 450, 1000, 50);
        add(phonePanel);


        JLabel phoneLabel = new JLabel("휴대폰");
        JTextField phoneText = new JTextField(10);
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneText);
        phoneLabel.setFont(ft);


        // 연락처 라벨 연락처 텍스트필드 생성해서 phonePanel 추가

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 500, 1000, 50);

        JLabel buttonLabel = new JLabel("쇼핑하기", new ImageIcon("./images1/user1.png"),JLabel.RIGHT);
        buttonPanel.add(buttonLabel);
        buttonLabel.setFont(ft);

        JButton enterButton = new JButton(); // 버튼 생성
        enterButton.add(buttonLabel); // 버튼 참조변수에 버튼의 라벨 글자를 입력
        buttonPanel.add(enterButton); // 다시 버튼 판넬에 버튼을 추가
        add(buttonPanel); // 이 메서드의 순서는 딱히 상관 없는 것 같다.

    }




}

class Test{
    public static void main(String[] args) {
        new GuestWindow("제목",1000,1000,100,200);
    }
}