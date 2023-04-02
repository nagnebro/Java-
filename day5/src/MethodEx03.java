//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;
//
//
//
//class Elv{
//    int num;
//    int elvfloor;
//
//
//    void up(int floor){}
//    void down(int floor){}
//    void print(int floor){}
//
//
//
//    Elv(){}
//
//    Elv(int num, int elvfloor){
//        this.num = num;
//        this.elvfloor = elvfloor;
//    }
//
//}
//
//class ElvUser{
//    int user_floor;
//    static int user_num=0;
//    String user_name;
//
//    ElvUser(int user_floor,String user_name){
//        this.user_floor = user_floor;
//        this.user_name = user_name;
//        user_num+=1;
//    }
//
//}
//
//public class MethodEx03 extends Elv {
//
//    public static void main(String [] args){
//
//
//        Scanner sc = new Scanner(System.in);
//        ArrayList<ElvUser> usrlist = new ArrayList<>();
//        usrlist.add(new ElvUser(1, "김영찬")); //굳이 입력으로 유저 정보를 받아들이는 걸로 구현하지 않음.
//        ArrayList<Elv> elvlist = set(5); // 설정한 호수만큼 엘리베이터의 참조변수가 생성되고 그 참조변수를 배열은 set 메서드를 통해 구하고
//        // ArrayList를 통해 참조변수 배열을 저장한다.
//        //User정보와 엘리베이터의 초기세팅이 끝났다. 이 부분을 유저의 입력을 여러개 받던가 엘리베이터 호수를 지정하려면 역시 scanner로 여러개의
//        // 입력을 받고 변수로 주고 for문 넣으면 됨.
//
//        // 반복을 줄여야한다. 그냥 메인메서드에서 실습하듯이 직접 유저값을 집어넣는 하드코딩식이 아니라 어떤 입력, 어떤 변수, 어떤 경우의 수가
//        // 오더라도 정상 작동할 수 있는 프로그램을 작성해야 한다.
//
//
//        // 엘베 클래스에서는 엘베어레이리스트, 유저 클래스에는 유저어레이리스트를 넣어준다.
//        // 그 후 참조변수를 유저와 엘리베이터 클래스 각각 1개씩 만들고 나서 그 다음에 걔네만을 통해서 유저리스트와 엘리베이터 리스트에 접근하기만 하면 문제는 되지 않는다.
//        // 그러면 그 뒤로는 그 참조변수를 통ㅇ한 어레이리스트에 접근하니까 그 클래스에 메서드 이용할떄 매개변수로 일일히 어레이 리스트 안줘도 되고.
//        // 그게 아니면 그 어레이리스트 두개를 각각 퍼블릭스태틱 메서드로 놔두고 배열값을 메인메서드에서 다시 받아주면 되는데 그러려면 메서드 이용할 떄
//        // 보통 다 어레이리스트에 접근해야하는 메서드인데 일일히 매개변수를 지정해줘야하는 번거로움이 있다.
//        userinfo();
//        System.out.println("=========현재 엘리베이터 정보=========");
//        elvinfo(elvlist);
//        System.out.print("이용하실 엘리베이터 호수를 입력하세요");
//        int input1 = sc.nextInt(); //입력이 제대로 들어왔다는 가정하에 작성.
//        user1.touser(user1.user_floor);
//
//
//
//    }
//
//    static void elvinfo(ArrayList<Elv> elvlist){
//        for(int i = 0; i<elvlist.size(); i++){
//            System.out.printf("%d호기 : %d층 \n",elvlist.get(i).num,elvlist.get(i).elvfloor);
//        }
//
//    }
//    public static ArrayList<Elv> set(int total){  // 참조변수를 통해 접근하는 것이 아니고 메서드 내에서도 인스턴스에 접근하는 것이 아니기 때문에
//        // 굳이 인스턴스 메서드로 설정할 필요가 없을 거 같기는한데.. 밖에다 뺴놓으면 괜히 Elv클래스랑 구분 안되고 직관적이지 못하니 클래스 안에 넣는게 나을려나?
//        // ArrayList<Elv>를 Elv 클래스로 묶어놓으면 좋은 것이 참조변수가 여러개의 배열을 만들고 그 말은 곧 여러대의 엘리베이터를 가진 배열을 여러 곳에서
//        // 탈 수 있게끔 만든다는 것이다. 그 말은 Elv타입의 참조변수를 생성한 후에 그 참조변수로 여러개의 elvlist를 만든다는 것.
//        // 여기선 오히려 유저가 Elv 이용에 확장성을 두는 것이 아니라 여러 유저가 사용하는 것의 확장성을 두는 것이 맞다.
//        // 따라서 ArrayList를 Elv클래스에 포함시키는 것은 별 의미가 없고 새 클래스를 만들거면 User클래스를 만들고 유저가 이용한 엘리베이터의 층수를
//        // 유저의 정보에 저장하는 정도로 이용할 수 있겠다.
//
//        // 유저별로 서로 다른 엘리베이터를 타는 것이 아니라 한 번 생성해놓은 공통의 엘리베이터를 사용하는 것이기 떄문에 참조변수 배열은 static으로 두는
//        // 것이 맞는 것 같다.
//
//        // 정확히 말하면 지금처럼 elvlist 를 static메서드로 뺴놓고 정의한 것이 앞선 커피 클래스의 배열을 static으로 모아놓은 거랑 같냐고 하면 그거랑은 좀 다르다.
//        // 왜냐하면 얘네는 ArrayList이기 떄문에 결국 그 안에서의 참조변수는 각각 다른값을 가질 수 있기 떄문이다.
//
//        ArrayList<Elv> elvlist = new ArrayList<>(); //ArrayList의 초기용량은 10이지만 괄호안의 값으로 용량을 지정할 수는 있다.
//        // 초기용량이 10이라고 길이가 10은 아님. 그냥 빈 배열인 상태이기는 하다.
//        int i=1;
//            for (i = 0; i<total ; i++){
//                elvlist.add(new Elv(i,(new Random().nextInt(5)+1))); // elv참조변수를(elv 대수) total개수만큼 생성하면서
//                // 생성자의 인자로 호수를 지정해준다.
//                // 후위형이기 때문에 현재 i값이 호수로 지정되고 난 후에 연산이 된다.
//
//            }
//
//            return elvlist;
//    }
//
//}
//
