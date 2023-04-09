package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuColorMain extends JFrame implements ItemListener, MouseListener, ActionListener {

    JMenuItem item7 ;
    JMenuItem item8 ;
    JMenuItem item9 ;
    JMenu menu = new JMenu();
    JSeparator sep = new JSeparator();
    JPanel pan = new JPanel();
    MenuColorMain(){
        // 메뉴를 만들고 메뉴아이템을 메뉴에 추가하고 메뉴를 메뉴바에 추가를 하는 식으로. 프레임 구조가 그럼
        setTitle("메뉴 만들기");
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // 얘 정확한 기능을 잘 모르겠다 추가하고 안하고 별 차이가 없긴한데 이 코드에서는
        init(); //메뉴들에 관한 명령문을 저장하는 메서드




        setVisible(true); // 얘가 젤 밑에 있어야 , 그니까 init()보다 아래에 있어어 처음 창 열릴때 바로 생성된다
        // 창은 건드릴떄 main 메서드가 다시 도는데 setvisable이 init()보다 위에 있으면 안보이다가 창 건들면
        // 그떄 setvisable이 활성화됨
    }
    void init(){
        // 니모닉키    자주 쓰는 키보드 단축키에 해당하는 키코드를 나타낸 것.
        // 마우스를 사용하지 않고 단축키 메뉴에 엑세스
        // setMnemonic ("니모닉 키에 설정하는 문자")



        // JmenuBar에 JMenu가 추가돼야하고 JMenu에 JMenuItem이 추가가 돼야한다.
        // 그러니까 바가 한개 있고 바 안에 목록을 두고 목록안에 다시 목록이 나오는 형태.

        // 1. 메뉴 만들기
        JMenuBar menubar = new JMenuBar(); // 생성자 확인하기. 확인한 결과 생성자 매개변수 없음.

        // 2. 메뉴
        JMenu menu1 = new JMenu("File");
        menu1.setMnemonic(KeyEvent.VK_UP);

        JMenu menu2 = new JMenu("Edit");
        JMenu menu3 = new JMenu("Color");

        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        menu2.setMnemonic(KeyEvent.VK_F);
        //3. 항목만들기
        //3-1 File에 해당하는 아이콘
        ImageIcon icon = new ImageIcon("./images1/1.png");
        JMenuItem item1 = new JMenuItem("New",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu1.add(item1);
        JMenuItem item2 = new JMenuItem("Open",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu1.add(item2);
        JMenuItem item3 = new JMenuItem("Close",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu1.add(item3);

        //ImageIcon icon = new ImageIcon();
        JMenuItem item4 = new JMenuItem("Cut",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu2.add(item4);
        JMenuItem item5 = new JMenuItem("Copy",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu2.add(item5);
        JMenuItem item6 = new JMenuItem("Paste",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu2.add(item6);

        //ImageIcon icon = new ImageIcon();
        item7 = new JMenuItem("Red",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu3.add(item7);
        item8 = new JMenuItem("Green",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu3.add(item8);
        item9 = new JMenuItem("Blue",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu3.add(item9);

        // 프레임에 메뉴 설정 setJmenubar(메뉴바 수정)

        setJMenuBar(menubar); // add(menubar) 가 아니네?
        item7.addActionListener(this);
        item8.addActionListener(this);
        item9.addActionListener(this);
        item7.setMnemonic(KeyEvent.VK_G);

        add(pan);
    }








    public static void main(String[] args) {
        new MenuColorMain();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object obj = e.getSource();
        System.out.println("hi");
        if(obj == item7){
            System.out.println("hi");
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if(obj == item7){
            System.out.println("hi");
    }

}

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == item7){
            System.out.println("hi");
            pan.setBackground(Color.red);

        }else if(obj == item8){
            pan.setBackground(Color.green);
        }else if(obj == item9){
            pan.setBackground(Color.blue);
        }

    }
}
