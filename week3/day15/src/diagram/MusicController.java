package diagram;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicController {


    ArrayList<Music> list = new ArrayList<>();

    int addList(Music music){
        list.add(music);

        return 1;
    }

    int addAtZero(Music music){
         // 인덳스확인할것, 처음에 이렇게 추가하면 삽입이 안된다. 처음 뿐만아니라 중간에 삭제할떄도
        // 계속 이럴 것이기 떄문에 처리해줘야한다.
        System.out.println(list.size());

        list.add(0,music);
        return 1;
    }

    ArrayList<Music> printAll(){
        return list;
    }

    Music searchMusic(String title){



        for(int i = 0 ; i<list.size(); i++){
            if(list.get(i).equals(title)){
                return list.get(i);
            }
        }
        return null;
    }

    Music removeMusic(String title){
        for(int i = 0 ; i<list.size(); i++){
            if(list.get(i).title.equals(title)){
                Music m = list.get(i);
                list.remove(i);
                return m;
            }
        }
        return null;

    }
    Music setMusic(String title, Music music){ // 여기서 뮤직을 왜받았지? 리턴이 뮤직이라서.?>어레이리스트로 줘도되는데?
        Scanner sc = new Scanner(System.in);

        System.out.print("수정할 가수 명 : ");
        String input2 = sc.next();
        music.title = title;
        music.singer = input2;
        return music;
//        for(int i = 0 ; i<list.size(); i++){
//            if(list.get(i).title.equals(title)){
//                Scanner sc = new Scanner(System.in);
//                System.out.print("수정할 곡 명 : ");
//                String input = sc.nextLine();
//                System.out.print("수정할 가수 명 : ");
//                String input2 = sc.nextLine();
//                list.get(i).title = input;
//                list.get(i).singer= input2;
//                return list.get(i);
//            }
//        }
    }
    int ascTitle(){ // 제목 기준으로  오름 차순

        new Music().compareTo(list);
        System.out.println("곡명으로 오름차순 정렬 완료!");
        return 1;
    }
    int descSinger(){
        new Music().compareTo(list);
        return 1;
    }


}
