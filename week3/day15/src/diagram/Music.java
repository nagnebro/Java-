package diagram;

import java.util.ArrayList;

public class Music {
    String title;
    String singer;


    Music(){}
    Music(String title, String singer){
        this.title = title;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {

        return String.format(" 곡명 : %s , 가수 : %s ",this.title,this.singer);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }else if(this == null){ // 아직도 이 코드가 어떤 식으로 동작하는지 잘 모르겠다.

        }

        return super.equals(obj);
    }

    int compareTo(Object o){ // 뭐 비교하는 쉬운 메서드 있을 것 같은데 원시적으로 한 번 해보기.
        ArrayList<Music> list = (ArrayList<Music>)o;// 버블정렬 해야하는데.. 길이도 길고 set도 해야하고..
        for (int i = 0; i< list.size()-1;i++){
            System.out.println(list.size());

            for( int j = 0; j < list.size()-1;j++){
                System.out.printf("i : %d, j : %d\n",i,j);
                if(list.get(j).title.charAt(0) > list.get(j+1).title.charAt(0)){
                    System.out.printf("i : %d, j : %d\n",i,j);
                    Music tmp = new Music(list.get(j).title,list.get(j).singer); // 대입연산자쓰면
                    //주소를 같이 참조해서 꼬인다. 그래서 같은 값 갖고있는애 새로 생성해야함. 배열 복사하듯이.
                    // tmp는  i번쨰 데이터가 들어있는 인스턴스를 참조하고있다
                    list.set(j,list.get(j+1));
                    list.set(j+1,tmp);
                    System.out.println(list);
                }
            }
        }

        return 1;
    }
}
