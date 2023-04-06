//import javax.swing.*;
//import java.awt.*;
//
//public class GuestWindow extends JFrame {
//    // 그래픽 프레임창의 기본설정은 생성자 안에다가 설정.
//    public GuestWindow(String title){ // 제목을 받아오겠다.
//
//        // 창을 보겠냐
//        setResizable(true); // 창의 크기를 조절 가능
//        setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 닫으면 메인 종료
//    }
//    // 컴포넌트들을 생성하고 관리하는 메서드는 따로 관리하는 것이 낫다
//
//    public void initContainer(String title, int x, int y, int width, int height){ // 컴포넌트 (버튼, 텍스트필드, 라벨, 이미지) 이러한 컴포넌트를 모아놓은 것을 container라고 한다.
//        setTitle(title); // 창의 제목을 설정
//        setBounds(x,y,width,height); // 창의 너비 높이  , setSize()는 크기만 설정가능, 그러나 Bounds는 그 창의 크기는 물론 좌표값까지 설정가능
//        setLayout(null);
//
//        Font ft ; // 글자 크기, 글꼴 설정 ,  java.awt import
//        ft = new Font("고딕",Font.BOLD,15);
//
//        // 너비와 높이를 필드로 가지고 있는 클래스
//        // 툴킷 클래쓰
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 창을 중간에 세팅하기 위한 메서드
//        setLocation((screenSize.width)/2,(screenSize.height)/2); // 중간에 배치하기 위해 2를 나누어준다.
//
//
//        // 여러 컴포넌트를 올리는 보조 프레임 생성
//        JPanel userPanel = new JPanel();
//        userPanel.setBounds(100,100,100,100);
//
//        // 아이콘 (고양이 가져와서 아이콘 객체 생성)
//        // 상대경로 . 점으로 현재 폴더를 뜻함( src )
//        ImageIcon imageIcon = new ImageIcon("/Users/kim/IdeaProjects/khjava/week2/com.market.main/user.png"); // 현재폴더에서 상대경로를 입력해줌
//        JLabel cat = new JLabel("고양이",imageIcon,JLabel.RIGHT);
//        // 이미지 아이콘 크기, 스타일, setImage() 세팅이 끝나면 라벨로 값을 보내주겠다
//
//        // userPanel1.add() 추가
//        userPanel.add(cat);
//        // 보조프레임 -> 메인프레임
//        add(userPanel); // add 는 JFrame의 메서드. 메인 프레임에 보조판넬인 userPanel에 더해주겠다. 고양이 사진판넬
//
//        // 고객 정보를 입력하세요 =
//        JPanel titlePanel = new JPanel();
//        titlePanel.setBounds(0,350,1000,50);
//        add(titlePanel); // 타이틀 패널을 추가
//
//        JLabel titleLabel = new JLabel("===고객 정보를 입력하세요===");
//        titleLabel.setFont(ft);
//        titleLabel.setForeground(Color.BLACK); // 글꼴의 색상
//        titlePanel.add(titleLabel);
//
//        // 이름 : 입력받는 txext 필드
//        JPanel namePanel = new JPanel();
//        namePanel.setBounds(0,400,1000,50); // 창의 위치와 크기 조절.
//        add(namePanel);
//        // 이름이랑 text 객체 각각 생성해서 namePanel 추가
//
//
//        // 연락처
//        JPanel phonePanel = new JPanel();
//        phonePanel.setBounds(0,400,1000,50); // 창의 위치와 크기 조절.
//        add(phonePanel);
//
//        // 연락처 라벨 연락처 텍스트필드 생성해서 phonePanel 추가
//
//        // 맨 밑에 로그인 버튼 만들기
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setBounds(0,400,1000,50); // 창의 위치와 크기 조절.
//        add(buttonPanel);
//
//        setVisible(true);
//    }
//}
//
//class Main{
//    public static void main(String[] args) {
//
//        new GuestWindow("sss").initContainer("쇼핑몰",700,1500,500,500);
//    }
//}