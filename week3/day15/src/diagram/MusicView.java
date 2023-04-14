package diagram;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicView {
    Scanner sc =  new Scanner(System.in);
    MusicController mc = new MusicController();
    boolean check = true;
    void mainMenu() {
        do {
            System.out.println("*******메인 메뉴*********");
            System.out.println("1. 마지막 위치에 곡 추가");
            System.out.println("2. 첫 위치에 곡 추가");
            System.out.println("3. 전체 곡 목록 출력");
            System.out.println("4. 특정 곡 검색");
            System.out.println("5. 특정 곡 삭제");
            System.out.println("6. 특정 곡 정보 수정");
            System.out.println("7. 곡명 오름차순 정렬");
            System.out.println("8. 가수명 내림차순 정렬");
            System.out.println("9. 종료");
            System.out.print("메뉴 번호 입력");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    addList();
                    break;
                case 2:
                    addAtZero();
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    searchMusic();
                    break;
                case 5:
                    removeMusic();
                    break;
                case 6:
                    setMusic();
                    break;
                case 7:
                    ascTitle();
                    break;
                case 8:
                    descSinger();
                    break;
                case 9:
                    System.out.println("종료");
                    check = false;
                    break;
            }

        }while (check) ;

    }
    void addList(){
        System.out.println("1. 마지막 위치에 곡 추가");
        System.out.print("곡 명 :");
        String singer = sc.next();
        System.out.print("가수명 :");
        String name = sc.next();
        mc.addList(new Music(singer,name));
        System.out.println("추가 성공");
    }
    void addAtZero(){
        System.out.println("2. 첫 위치에 곡 추가");
        System.out.print("곡 명 :");
        String singer = sc.next();
        System.out.print("가수명 :");
        String name = sc.next();
        mc.addAtZero(new Music(singer,name));
        System.out.println("추가 성공");
    }
    void printAll(){
        System.out.println("3. 전체 곡 목록 출력");
        ArrayList<Music> list = mc.printAll();
        for(int i = 0 ; i<list.size(); i++){
            System.out.printf(" %s - %s\n",list.get(i).singer,list.get(i).title);
            // 우선은 출력은 대충하자 이쁘게 꾸미는 건 나중에하고
        }
    }
    void searchMusic(){
        System.out.println("4. 특정 곡 검색");
        System.out.print("검색할 곡 명 : ");
        String input = sc.next();
        Music music = mc.searchMusic(input);
        if(music == null){return;}
        System.out.println(music);
    }
    void removeMusic(){
        System.out.println("5. 특정 곡 삭제");
        System.out.print("삭제할 곡 명 : ");
        String input = sc.next();
        Music music = mc.removeMusic(input);
        if(music == null){return;}

        System.out.printf(music +"을(를) 삭제했습니다 \n",music.singer,music.title);

    }
    void setMusic(){
        System.out.println("6. 특정 곡 정보 수정");
        System.out.print("검색할 곡 명 : ");
        String input = sc.next();
        System.out.print("수정할 곡 명 : ");
        String input2 = sc.next();
        Music music = mc.setMusic(input2,mc.searchMusic(input));
        if(music == null){return;}
        System.out.printf("%s - %s 가 값이 변경됐습니다\n",music.singer,music.title);
    }
    void ascTitle(){
        System.out.println("7. 곡명 오름차순 정렬");

        mc.ascTitle();
    }
    void descSinger(){
        System.out.println("8. 가수명 내림차순 정렬");
        mc.descSinger();
    }

}
