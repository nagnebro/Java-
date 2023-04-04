import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class User1{
    int id;
    int pw;
}
public class MethodEx06 {

    public static void info(User1 u){ // 참조 매개변수.
        System.out.println("-----kh uer-----");
        System.out.println(u.id);
        System.out.println(u.pw);
    }
    public static void funt1(Random r){

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        User1 u = new User1();

        u.id = 1111;
        u.pw = 2222;
        info(u);
        funt1(r);

    }
}

class Movie{
    String movie_name;
    String movie_time;
}

class Member {

    public static void moviePrint(Movie m){
        System.out.println(m.movie_name);
        System.out.println(m.movie_time);
    }//이와 같이 인스턴스를 사용할 건데 스테틱 메서드를 쓰는 것은 별로 좋지 않다. 다른 클래스에서도 이 스태틱 메서드에 접근하기 위해서는 클래스명.메서드명으로
    // 접근할 수 있고 코드가 직관적이지 못하다. 그냥 Movie 클래스의 인스턴스 메서드로 선언하는 편이 더 나을 것 같다.

    public static void main(String[] args) {
        Movie m =new Movie();
        m.movie_name = "신세계";
        m.movie_time = "90분";
        moviePrint(m);
        //존윅4  130분
        Movie m2 = new Movie();
        m2.movie_name = "존윅4";
        m2.movie_time = "120분";
        moviePrint(m2);

    }
}

class Objection{
    String dest;
    int fee;
    Objection(){}
    Objection(String dest, int fee){
        this.dest = dest;
        this.fee = fee;
    }

}
class Member1{


    public static Objection objectInput(){
        System.out.println("목적지와 운임비를 입력");
        Scanner sc = new Scanner(System.in);
        Objection o = new Objection();
        String dest = sc.nextLine();
        int fee = sc.nextInt();

        o.dest = dest;
        o.fee = fee;
        return o;
    }
    public static void trainprint(Objection o){
        System.out.printf("목적지는 %s,  가격은 %d입니다",o.dest,o.fee);
    }
    public static void main(String[] args) {

        Objection o1 = new Objection("서울", 30000);
        Objection o2 = new Objection("부산", 20000);
        System.out.println("=====예매 정보=====");
        System.out.printf("목적지 : %s    %s\n",o1.dest,o2.dest);
        System.out.printf("운임비 : %d    %d\n",o1.fee,o2.fee);

        Objection o3 = objectInput();
        trainprint(o3);


    }
}

class Member2{
    public static void main(String[] args) {
        Objection o1 = new Objection("서울", 30000);
        Objection o2 = new Objection("대구", 10000);
        Objection o3 = new Objection("부산", 20000);

        // 내가 만든 클래스로 여러개를 저장
        // 배열은 클래스명 [개수] 기본타입[개수]만큼 변수를 묶었다.

        Objection [] list = new Objection[3];
        list[0]=o1;
        list[1]=o2;
        list[2]=o3;

        System.out.println(list[0].dest);
        System.out.println(list[1].dest);
        System.out.println(list[2].dest);

    }
}
