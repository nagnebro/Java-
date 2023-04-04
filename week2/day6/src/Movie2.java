import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


// MovieInfrom 클래스의 메인메서드에 정의된 것들을 인스턴스 메서드로 정리한 버전.
class MovieInform{

    ArrayList<Integer> s_list = new ArrayList(Arrays.asList(0,0,0,0,0,0,0,0)); // seat list
    int price ;
    // Scanner scan = null;
    // 만약에 현재 클래스의 인스턴스 메서드에서 사용자에게 입력을 받아야하기 위해 계속 스캐너를 사용해야 한다고 하면 scanner 변수를 지정해주는 데에는 여러가지
    // 방법이 있다. 1. 해당 클래스에 Scanner를 선언할 수도 있고 2. 메서드마다 그때그떄 Sacnner를 매개변수로 받아와서 사용할 수도 있다.
    // 다만 항상 프로그래밍은 극단적으로 생각해야한다. 1번의 경우 여러명의 유저의 입력을 받아야하기 때문에 참조변수가 여러개가 생성된다면
    // Scanner sc = new Scanner(System.in); 과 같은 참조변수가 여러개가 생성됨과 동시에 메모리 공간을 차지하는 것과 마찬가지다.
    // 현재 사용하지는 않는데 메모리를 차지하는 것은 낭비이기 때문에 사용자에게 입력을 받으려고 할때만 사용하는 것이 바람직하다.
    // 2번의 경우 중복되는 부분을 main메서드에 작성하는 것이기 때문에 메모리를 낭비하지는 않으나 지속적으로 매개변수를 사용해야 하는 점이 번거롭다.
    // 따라서 해당 클래스의 인스턴스 변수로는 Scanner scan = null;의 형태로 참조변수만 만들어놓는다. 이후에 메인 메서드에서 생성자를 이용하여 객체 생성시 인자로 스캐너 인스턴스를
    //  넘겨주고 해당 클래스에서는 기존에 참조변수만 선언됐던 scan에 인스턴스를 저장하는 방법으로 이용하면 불필요하게 모든 참조변수가 scanner 인스턴스를 사용하는 것을
    //  막을 수 있다.


    public void s_print(){ // 만약에 어레이리스트를 메인 메서드에 선언하지 않고 새로운 클래스에 생성한 후에
        // 그 클래스의 참조변수로 접근한다면 매개변수로 일일히 이렇게 넘겨주지 않아도 돼서 편하긴하다. 다만 메서드에 접근할때 마다 참조변수로 접근해야 하니
        // 그게 좀 귀찮을 순 있지만 매개변수로 어레이리스트 계속 넘기는 것 보다는 나은 것 같다.
        String str = "";
        for (int i = 0 ; i<s_list.size(); i++){
            str += " "+s_list.get(i); // 문자열과 정수 더하면 문자열이된다.
        }
        System.out.println("현재자리 : "+str);
    }

    public void showSales(){
        int price = 0;
        for (int i = 0 ; i<s_list.size(); i++){
            if( s_list.get(i)==1) {
                price += 5000; // 문자열과 정수 더하면 문자열이된다.
            }
        }
        System.out.println("현재 매출은 "+price+"원 입니다");
    }
    int choiceSeat(Scanner sc){
        System.out.println("예약할 좌석을 입력하세요");
        int input = sc.nextInt();
        if(input == 99) {
            System.out.println("종료합니다.");
            return 1;
        }
        else if (s_list.get(input-1) == 0){ // 0번 자리를 없애기 위해 1을 빼준다. 즉 1번 자리를 입력받으면 인덱스 0번이 수정되게끔.
            s_list.set(input-1,1); // ArrayList의 요소값을 변경하기, 얘 역시 입력받은거에 1을 뺀만큼의 인덱스 요소를 수정해줘야 한다.
            System.out.printf("%d번 자리가 예매완료됐습니다.",input);
        }else{
            System.out.println("이미 예매가 완료된 자리입니다.");
        }return 0;
    }


}

public class Movie2 {
    /*
     * # 영화관 좌석예매 : 클래스 + 변수
     * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
     * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
     * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
     * 4. 한 좌석당 예매 가격은 12000원이다.
     * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
     * 예)
     * seat = 0 0 0 0 0 0 0
     *
     * 좌석선택 : 1
     * seat = 0 1 0 0 0 0 0
     *
     * 좌석선택 : 3
     * seat = 0 1 0 1 0 0 0
     *
     * 좌석선택 : 3
     * seat = 0 1 0 1 0 0 0
     * 이미 예매가 완료된 자리입니다.
     * ----------------------
     * 매출액 : 24000원
     */

    public static void main(String[] args) {
        MovieInform m = new MovieInform();
        Scanner sc = new Scanner(System.in);
        while(true){
            m.s_print();
            m.showSales();
            int out = m.choiceSeat(sc);
            if(out==1){
                break;}
        }
    }
}
