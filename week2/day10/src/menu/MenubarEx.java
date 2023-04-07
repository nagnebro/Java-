package menu;

import javax.swing.*;

class MenubarEx extends JFrame {



    JMenu menu = new JMenu();
    JSeparator sep = new JSeparator();
    JPanel pan =new JPanel();
    MenubarEx(){
        // 메뉴를 만들고 메뉴아이템을 메뉴에 추가하고 메뉴를 메뉴바에 추가를 하는 식으로. 프레임 구조가 그럼
        setTitle("메뉴 만들기");
        setSize(400,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true); // 얘 정확한 기능을 잘 모르겠다 추가하고 안하고 별 차이가 없긴한데 이 코드에서는
        init(); //메뉴들에 관한 명령문을 저장하는 메서드




        setVisible(true); // 얘가 젤 밑에 있어야 , 그니까 init()보다 아래에 있어어ㅑ 처음 창 열릴때 바로 생성된다
        // 창은 건드릴떄 main 메서드가 다시 도는데 setvisable이 init()보다 위에 있으면 안보이다가 창 건들면
        // 그떄 setvisable이 활성화됨
    }
    void init(){

        // JmenuBar에 JMenu가 추가돼야하고 JMenu에 JMenuItem이 추가가 돼야한다.
        // 그러니까 바가 한개 있고 바 안에 목록을 두고 목록안에 다시 목록이 나오는 형태.

        // 1. 메뉴 만들기
        JMenuBar menubar = new JMenuBar(); // 생성자 확인하기. 확인한 결과 생성자 매개변수 없음.

        // 2. 메뉴
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenu menu3 = new JMenu("View");

        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);

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
        JMenuItem item7 = new JMenuItem("New Window",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu3.add(item7);
        JMenuItem item8 = new JMenuItem("Configuration",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu3.add(item8);
        JMenuItem item9 = new JMenuItem("Structure",icon); // 클릭하면 내려오는 드롭다운 목로을 말함
        menu3.add(item9);

        // 프레임에 메뉴 설정 setJmenubar(메뉴바 수정)
        setJMenuBar(menubar); // add(menubar) 가 아니네?


    }

    public static void main(String[] args) {
        new MenubarEx();
    }
}




