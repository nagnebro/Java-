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


    //            @Override
    //            public Object equals(Object obj){
    //
//                if(this == obj) { return true;}
//
//                if (!(obj instanceof Music)){return false;}
//
//                Music user = (Music)obj;
//
//                // 만약 타이틀로 비교한다면
//                // 타이틀 자체가 String클래스 이기때문에
//                // equals()  로 비교하는 것이고 만약 가지고 온 멤버변수의 값이 int 나 double일 경우에는
//                //  == 으로 비교하는 것이지요~
//
//                if(this.title.equals(user.title)){
//                    return true;
//                }else{
//                    return false;
//                }

            // equals 메서드를 오버라이딩 함으로서 내가 원하는 객체들의 타입이나 값을 비교하는 메서드로써 사용할 수 있다
            // 이게 무슨 말이냐면 우리가 일반적으로 알고 있는 string타입의 equals메서드는 String타입의 객체들이 갖고 있는 값이 같은지 비교하는 메서드이다
            // String 클래스의 equals역시 본인의 클래스에서 재정의돼 equals 메서드가 사용되고 있기 떄문에 같은 문자열 값을 가지면 true를 반환하게끔 메서드가 작성됐을 뿐이다
            // 그러나 원래 Object 클래스의 equals메서드는 반드시 본인 자신의 값이 들어와야만 true를 반환하게끔 작성돼있다. 따라서 우리가 같은 값을 가지면
            // 같은 인스턴스라고 반환하는 equals가 필요하다면 현재 클래스에서 재정의 해줘야하는 것이다.
            // 그래서 우리가 비교하고자 하는 객체가 서로 같은지 비교하기 위해서는 우리가 사용하는 클래스에서 오버라이딩 해 재정의 해준 후 사용하는 것이 바람직하며
            // 효율적일 것이다. 이 예제에서 우리는 같은 값을 비교하는지가 아니고 혹은 같은 값을 가지고 있다면 true를 반환하게끔 재정의해서 사용하여야 한다.
            // 우리에게 필요한 것은 객체가 서로 같은건지 비교하는 것이 아닌 객체가 가진 title이라는 값이 같은지 아닌지를 비교해주는 메서드이다.
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {

        if(this == obj){ // 매개변수로 들어온 obj의 주소값과 equals메서드를 실행시킨 참조변수의 주소가 같은 곳을 가르킨다면 그 두 참조변수는 같은 인스턴스이다.
            // 따라서 true를 반환한다. 주소값이 같으면 아예 같은 인스턴스니까 더 비교하고 자시시고 할 것 없이 메서드 종료,.
            return true;
        }else if(this == null){ // this가 어어떻게 널이지?
            return false;
        }
        Music user = (Music)obj; // 이게 된다고? string클래스가 들어올텐데?
        if(this.title.equals(user.title)){
            return true;
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
