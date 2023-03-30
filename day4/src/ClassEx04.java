import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
    회원가입 member클래스

    꼭 받아야 되는 데이터
    id, name, email, pw, pw_check

    선택사항 (입력하면 입력한 값으로 저장, 입력x)
    성별 m/f
    취미
    직업
    결혼여부 true 기혼 false 미혼

    클래스 생성자 이용해서 객체를 생성하세요
 */
class Member{

    String id, name, email, pw, pw_check;
    int [] arr ;
    void inform(Member m){
        System.out.println(m.id);
        System.out.println(m.name);
        System.out.println(m.email);
        System.out.println(m.pw);
        System.out.println(m.pw_check);
    }

    Member(String _id, String _name, String _email, String _pw, String _pw_check){
        id = _id;
        name = _name;
        email = _email;
        pw = _pw;
        pw_check = _pw_check;
    }
    Member(String[] s){

    }
}


public class ClassEx04 {


    public static void main(String [] args){

        Member m = new Member("yasuo","kim","goldfish@naver.com","55221","55221");
        System.out.println(Arrays.toString(m.arr)); //null 값 출력
        // 입력이 전부 문자열이니까 컬렉션 리스트로 한 번 응용해볼려 했으나 잘 모르겠다.
        ArrayList<String> memberlist = new ArrayList<>();
        m.inform(m);
    }
}



class User{

    String id, pw, phone, email;

    //예매정보를 저장하는 변수

    User(String id, String pw, String phone, String email) {
        this.id = id;
        this.pw = pw;
        this.phone = phone;
        this.email = email;
    }

    //Reservation r = new Reservation();
    User(){
    }
} //고객의 정보
class CGV{
    // 고객들의 정보를 저장하는 ArrayList를 만들어 저장하고 있으면 됨.
    //user정보는 본인걸로
    //영화 웅남이 98분 5관 2명 데이터를 저장
    ArrayList<Reservation> reservelist = new ArrayList<>();
    ArrayList<User> userlist = new ArrayList<>();
    //인스턴스에 값을 줄때 생성자를 이용하면 좋을 것 같다.
}

//예매정보
class Reservation{
    String movie_name; //영화명

    String movie_time; //영화 러닝타임
    String movie_people; //인원수
    String movie_room; //몇 관인지

    Reservation(String movie_name, String movie_time, String movie_people, String movie_room) {
        this.movie_name = movie_name;
        this.movie_time = movie_time;
        this.movie_people = movie_people;
        this.movie_room = movie_room;
    }
}

class CGVTest{
    public static void main(String [] args){


        //입력받는 Scanner랑 변수 만들고
        //switch를 이용해라
        CGV cgv = new CGV();
        Scanner sc = new Scanner(System.in);
        String id ;
        int idx;
        while(true){
            System.out.println("---cgv---");
            System.out.println("1. 영화예매");
            System.out.println("2. 영화예매 조회");
            System.out.println("3. 영화예매 삭제");
            System.out.println("0. 영화예매 종료");
            System.out.print("원하시는 메뉴를 입력하세요");

            int menu = sc.nextInt();


            Dan : switch(menu) { // menu랑 id굳이 두개로 나눠서 입력받을 필요 없이 1개만 계속 써도 관계없을 듯. 어차피 switch문
                // 시작될 때 menu의 값은 이미 비교가 다 끝난 후니까 다시 입력을 받아도 됨
                case 1: //예매정보, 고객정보 입력을 받아서 객체 생성 후 cgv 리스트에 저장.
                    sc.nextLine(); // nextInt와 nextLine이 같이 붙어있으면 개행문자 관계없이 바로 다음 입력으로 넘어가버린다
                    // 자세한 것은 velog에 정리.
                    System.out.print("예매할 영화 이름, 시간, 관객 수 , 영화관 번호를 공백을 기준으로 차례로 입력하세요");
                    String sel1 = sc.nextLine();

                    System.out.println("예매하신 분의 아이디, 비밀번호, 휴대폰번호, 이메일을 공백을 기준으로 입력해주세요.");

                    String sel2 = sc.nextLine();

                    String[] sellist = sel1.split(" ");
                    String[] sellist2 = sel2.split(" ");

                    if (sellist.length == 4 && sellist2.length == 4) { // 배열의 길이는 배열.length, 문자열의 길이는 문자열.length()
                        Reservation r = new Reservation(sellist[0], sellist[1], sellist[2], sellist[3]);//공백을 기준으로 입력받은
                        //문자열을 총 4개로 구분지어줌. 그리고 그 문자열들의 배열을 저장하고 배열의 인덱스로 생성자를 초기화 해줌.
                        User u = new User(sellist2[0], sellist2[1], sellist2[2], sellist2[3]);
                        cgv.reservelist.add(r); // 그렇게 초기화된 인스턴스를 cgv에 정보를 넘겨주는 형식으로 진행.
                        cgv.userlist.add(u);
                        System.out.println("영화 예매가 완료됐습니다");
                    } else {
                        System.out.println("형식에 맞춰 제대로 작성하세요");
                    }

                    break;


                case 2:
                    System.out.print("예매하신 분의 id를 입력하세요");
                    sc.nextLine();
                    id = sc.nextLine();
                    System.out.println(id);
                    idx = -1;
                    System.out.println(cgv.userlist.size());
                    for ( int i = 0; i<cgv.userlist.size();i++) { // cgv userlist의 길이, 즉 예매한 유저들의 참조변수 길이를 뜻함.
                        if (cgv.userlist.get(i).id.equals(id)) { // ==비교연산자로는 문자열의 값은 항상 false가 나오게 된다.
                            // String은 참조변수로서 주소값이 다르기 떄문에 같다고 판별하지 않는 것이다.
                            System.out.println("find idx");
                            idx = i;
                            break;
                        }
                    }  if(idx==-1){
                        System.out.println("찾으시는 id가 없습니다");
                        break;
                        }
                    User usrinf = cgv.userlist.get(idx);
                    Reservation movinf = cgv.reservelist.get(idx);
                    System.out.printf("id : %s\npw :%s\n휴대폰번호 : %s\n이메일 : %s\n",
                            usrinf.id,usrinf.pw,usrinf.phone,usrinf.email);
                    System.out.printf("영화 제목 : %s\n영화 시간 :%s\n관객 수 : %s\n영화관 번호 : %s\n",
                            movinf.movie_name,movinf.movie_time,movinf.movie_people,movinf.movie_room);
                    break;
                case 3:
                    //삭제 list.remove(i) 를 이용할 것.
                    System.out.print("예매 내역을 삭제할 id를 입력하세요");
                    sc.nextLine();
                    id = sc.nextLine();
                    idx = -1;
                    for ( int i = 0; i<cgv.userlist.size();i++) { // 조회와 마찬가지로 인덱스를 찾는 과정
                        if (cgv.userlist.get(i).id.equals(id)) {
                            System.out.println("find idx");
                            idx = i;
                            break;
                        }                       // case2와 중복되는 코드, method로 뺴야함.
                    }if(idx==-1) {
                    System.out.println("찾으시는 id가 없습니다");
                    break;
                    }

                    cgv.userlist.remove(idx);
                    cgv.reservelist.remove(idx);
                    System.out.println("예매내역 및 회원정보가 삭제됐습니다");
                    break;

                case 0:
                    System.out.println("종료합니다");
                    return;

                default :
                    break;



        }
    }
}
}

