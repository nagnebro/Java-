import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class User{
    int userfloor;

}
class Elv{
    int num;
    int elvfloor;


    void up(int floor){}
    void down(int floor){}
    void print(int floor){}


    Elv(){}


    Elv(int num, int elvfloor){
        this.num = num;
        this.elvfloor = elvfloor;
    }

}

public class MethodEx03 {
    public static void a(){

    }
    public static void main(String [] args){


        Scanner sc = new Scanner(System.in);
        ArrayList<Elv> elvlist = set(5); // 설정한 호수만큼 엘리베이터의 참조변수가 생성되고 그 참조변수를 배열은 set 메서드를 통해 구하고
        // ArrayList를 통해 참조변수 배열을 저장한다.
        System.out.println(elvlist);
        System.out.println("탑승할 엘리베이터 호수를 선택해주세요.");
        int input1 = sc.nextInt();
        System.out.println(elvlist.get(0).num);



    }
    public static ArrayList<Elv> set(int total){
        ArrayList<Elv> elvlist = new ArrayList<>(); //ArrayList의 초기용량은 10이지만 괄호안의 값으로 용량을 지정할 수는 있다.\
        int i=1;
            for (i = 0; i<total ; i++){
                elvlist.add(new Elv(i,(new Random().nextInt(5)+1))); // elv참조변수를(elv 대수) total개수만큼 생성하면서
                // 생성자의 인자로 호수를 지정해준다.
                // 후위형이기 때문에 현재 i값이 호수로 지정되고 난 후에 연산이 된다.

            }

            return elvlist;
    }

}

