import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    JPanel mMenuPanel = null;
    ArrayList<JButton> buttonList = new ArrayList<>();
    String [] menuList = {"1. 고객 정보 확인하기","2. 장바구니 상품 목록 보기","3. 장바구니 비우기", "4. 장바구니에 항목 추가하기",
            "장바구니의 항목수량 줄이기","장바구니의 항목 삭제하기", "주문하기", "종료", "관리자"};
    public MainWindow(String title, int x , int y, int width, int height){

        initContainer(title,x,y,width,height);

        setVisible(true);
        setResizable(true); // 창 사이즈 조절 가능
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
    void initContainer(String title, int x , int y, int width, int height){
        setTitle(title);
        setBounds(x,y,width,height); //프레임의 위치,크기 설정
        setLayout(null);              // 프레임 미설정(배치)

        Font ft;
        ft = new Font("함초롬돋음",Font.BOLD,20); // 글꼴설정

        // 너비와 높이를 필드로 가지고 있는 클래스
        // 툴킷 클래스

        Dimension sreenSize =  Toolkit.getDefaultToolkit().getScreenSize();
        // 창 위치 setLocation(화면의너비, 화면의 높이)
        setLocation((sreenSize.width-1000) / 2, (sreenSize.height-1000) / 2); // 생성자로 0,0 을 받고
        // setLocation 메서드로 다시 창의 위치를 조절해준다.

        // 메뉴 버튼 표시를 위한 보조프레임 설정


        // 한번에 x,ywidth,height
        // setSize(x,y) -> 컴포넌트들의 위치를 변경해주는 메서드
        // setLocation() ->  너비높이만 변경하고 싶다.
        // setBounds() -> 위 두가지 기능을 한번에 합친 메서드 기능
        mMenuPanel = new JPanel(); // 메인 판넬
        mMenuPanel.setBounds(x,y,width,height);


        // 첫 번째 아이콘 1. 고객정보 확인하기 버튼을 만들기
        for(int i = 1 ; i<=9 ; i++) {
            ImageIcon num1 = new ImageIcon("./images1/" + i + ".png");
            JLabel label1 = new JLabel(menuList[i-1], num1, JLabel.LEFT);
            JButton btn1 = new JButton();
            btn1.add(label1);
            mMenuPanel.add(btn1); // 다른 인스턴스 타입이면 다시 추가해도 중복해서 추가되지 않는다.
        }
        add(mMenuPanel);
    }
}

class MainWindowTest{
    public static void main(String[] args) {
        MainWindow m = new MainWindow("쇼핑",0,0,800,500);
    }
}
