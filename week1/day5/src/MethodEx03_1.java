import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class Common2{
    ArrayList<Elv2> elv_list = new ArrayList<>();
    ArrayList<User_Elv2> usr_list = new ArrayList<>();

}
class Elv2 extends  Common2{
    int e_floor;
    int e_num;

    void set_elv(int num){
        Random r = new Random();

        for (int i = 0; i< num; i++){
            elv_list.add(new Elv2(i+1,r.nextInt(0,5)+1));
        }
    }

    void toUser(int sel_floor, User_Elv2 u){ // 선택 층수랑 엘리베이터 이용을 선택한 유저 참조변수 전달 받음.
        int idx = findElv(u.u_floor); // 나랑 가장 가까운 위치에 있는 엘리베이터를 찾는다.
        if(elv_list.get(idx).e_floor == u.u_floor){
            System.out.printf("%d호기가 현재층에 대기중입니다. \n",elv_list.get(idx).e_num,elv_list.get(idx).e_floor);
            return;
        }else if(elv_list.get(idx).e_floor > u.u_floor){ // 희망 층수 > 현재층수

            System.out.println("엘리베이터가 내려오고 있습니다.");
            //쓰레드이용 시간 텀.
            elv_list.get(idx).e_floor = u.u_floor;
            System.out.printf("%d호기가 %d층으로 내려왔습니다.",elv_list.get(idx).e_num,elv_list.get(idx).e_floor);

        }else{ //희망 층수 < 현재 층수

            System.out.println("엘리베이터가 올라오고 있습니다.");
            //쓰레드이용 시간 텀.
            elv_list.get(idx).e_floor = u.u_floor;
            System.out.println(elv_list.get(idx).e_floor);
            System.out.printf("%d호기가 %d층으로 올라왔습니다.",elv_list.get(idx).e_num,elv_list.get(idx).e_floor);
        }
    }
    int findElv(int u_floor){
        int idx=0;
        int min = 100;
        for (int i = 0 ; i<elv_list.size(); i++){
              // 어차피 백층이상의 엘리베이터를 이용하지 않는 이상은 초기값을 나올 수 있는 어떤 수보다 크게만 해놓으면 관계없다.
            // 최소값 구할떈 나올 수 있는 어떤수보다도 크게 해놓고 최대값 구할떄는 어떤수보다도 작게 해놓고,.
            if( (Math.abs(u_floor - elv_list.get(i).e_floor ))<min){
                min = (Math.abs(u_floor - elv_list.get(i).e_floor ));
                idx=i;
            }else if( u_floor == elv_list.get(i).e_floor){
                return idx;
            }
        }return idx;
    }
    Elv2(){}

    public Elv2(int e_num, int e_floor) {
        this.e_floor = e_floor;
        this.e_num = e_num;
    }

}

class User_Elv2 extends Common2{
    int u_floor;
    String u_name;

    public User_Elv2(int u_floor, String u_name) {
        this.u_floor = u_floor;
        this.u_name = u_name;
    }

    User_Elv2(){}

}
public class MethodEx03_1  {
    public static void main(String[] args) {

        Elv2 e = new Elv2();  // 어레이리스트를 참조하기 위한 참조변수 일뿐 직접적인 엘리베이터는 아님.
        User_Elv2 u = new User_Elv2();
        u.usr_list.add(new User_Elv2(3,"김영찬"));
        u.usr_list.add(new User_Elv2(1,"김영찬2"));
        u.usr_list.add(new User_Elv2(2,"김영찬3"));
        u.usr_list.add(new User_Elv2(4,"김영찬4"));
        e.set_elv(5);
        Scanner sc = new Scanner(System.in);

        while(true) {
            info(u); // 이용할 사람 명단 및 현재 층수가 나오는 메서드
            System.out.println("엘리베이터를 이용하실 분을 선택하세요");
            int input1 = sc.nextInt(); // 이용할 사람의 번호 입력.
            User_Elv2 sel_u = u.usr_list.get(input1 - 1); // 이용할 사람의 참조변수

            System.out.printf("%s님의 현재 위치는 %d층입니다.\n", sel_u.u_name, sel_u.u_floor);
            info(e); // 현재 엘리베이터 호기들의 충수 목록이 나오는 메서드.
            System.out.printf("몇층을 가시겠습니까");
            int sel_floor = sc.nextInt(); // 몇층 갈지 입력
            e.toUser(sel_floor,sel_u); // 선택한 층수, 선택한 유저의 참조변수를 인자로 전달.
            // 메서드가 실행되면 엘리베이터가 유저가 있는 층수로 온다.

//        System.out.printf("%d호기가 %d층에 도착했습니다.");

        }
    }
    public static void info(Common2 c){ // user아니면 elv타입의 인스턴스가 들어올건데 그 인스턴스의 타입에
        // 따라 서로 다른 정보를 출력하는 메서드.
        if(c instanceof User_Elv2) { // 엘베인스턴스면 해당 인스턴스를 참조하는
            User_Elv2 u1 = (User_Elv2) c;
            ArrayList<User_Elv2> list = u1.usr_list;
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d. %s님  \n", i+1, list.get(i).u_name);
            }
        }
        if(c instanceof Elv2) {
            Elv2 e1 = (Elv2) c;
            ArrayList<Elv2> list = e1.elv_list;
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d호기의 현재 층수는 %d층입니다 \n", list.get(i).e_num, list.get(i).e_floor);
            }
        }
    }
}
