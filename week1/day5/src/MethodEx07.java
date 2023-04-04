import java.util.Scanner;

public class MethodEx07 {


    public static int coffee(String input){
        String [] coffeelist = {"Americano", "Cafe mocha","Cafe Latte","Green Tea Latte"};
        int [] pricelist = {3900,4500,5000,5500};
        int idx = calculate(coffeelist,input);
        return pricelist[idx];
    }
    public static int size(String input){
        String [] sizelist = {"G", "R","S"};
        int [] pricelist = {1000,500,0};
        int idx = calculate(sizelist,input);
        return pricelist[idx];
    }
    public static int price(int cofprice, int sizeprice){
        return cofprice+sizeprice;
    }
    public static int calculate(String [] list,String str){
        int idx = -1;
        for(int i = 0 ; i < list.length; i++){
            if(list[i].equals(str)){
                idx = i;
                return idx;
            }
        }return idx;
    }
    public static void main(String[] args) {


        // 지금까지 한것을 모두 응용해서 해볼 것.
        // 매개변수로 커피의 가격과 사이즈의 가격을 받는다
        int price1, price2, result;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Harry Caffe");
        System.out.print("Choose 1 : Americano / Cafe mocha / Cafe Latte / Green Tea Latte :  ");
        String input1 = sc.nextLine();
        System.out.print("Choose size : G(grande) / R(regular) / S(short) :  ");
        String input2 = sc.nextLine();
        //메서드 실행해서 price구하기
        price1 = coffee(input1);
        price2 = size(input2);
        result = price(price1,price2);
        System.out.println("주문하신 커피의 가격은 "+result+"입니다");


        //user-Coffee 클래스
        //커피 정보
        //주문 번호
        //지불금액
        //메뉴
        //사이즈

        //User-Coffee 클래스의 정보를 출력하는 함수를 만들어 출력해봐라. return은 없다.
    }
}


class Coffee{

}



/*  클래스를 이용해서 입력한 가격을 출력하는 프로그램.
    user클래스 하나 만들고 입력값을 받으면 거기 생성자로 저장해놓고  맞네
    입력을 한개만 먼저받고 출력을 하든 두개 한번에 받고 하든 방법은 있네. 한번 해보자.
    근데 배열을 어디에 두느냐의 문제는 역시나 클래스에 둘 필요는 없다 라는게 내 결론이긴 하다. 클래스에서는 입력값을 매개변수로 하는
    생성자를 이용해 인스턴스 변수를 정해줄 뿐인 것 같다.
    굳이 그 배열을 인스턴스를 통해 접근할 필요는 없지만 ... 어차피 참조변수를 매개변수로 받고 인스턴스변수를 비교하는 포문을 만들어야하기 떄문에
    public static 메서드 내로 접근하게 되면 참조변수를 통해 계속 인스턴스 변수에 접근해야 하므로 그냥 user클래스로 다 뺴놓고 접근하는ㄱ ㅔ 나을려나.
 */

class Coffee2{
    //입력값을 입력받고 coffee 클래스에서 coffee 리스트와 가격에 해당하는 배열을 돌리고 해당하는 가격과 문자열을 돌려받고
    // 다시 입력값을 입력받고 size클래스에서 size리스트와 그 가격에 해당하는 배열돌려서 가격과 문자열 돌려주고
    //user클래스의 참조변수를 생성하면서 생성자에 그 이름과 가격을
    String [] c_list = {"Americano", "Cafe mocha","Cafe Latte","Green Tea Latte"};
    int [] p1_list = {3900,4500,5000,5500};
    String [] s_list = {"G", "R","S"};
    int [] p2_list = {1000,500,0};
    String size;
    String coffee;
    int c_price;
    int s_price;
    Coffee2(){}

    Coffee2(String coffee, String size){
        this.coffee= coffee;
        this.size = size;
    }
    void calculate(String coffee, String size){
        int c_idx = findfee(c_list,coffee);
        int s_idx = findfee(s_list,size);
        if(s_idx == -1 || c_idx == -1){
            System.out.println("입력을 잘못하셨습니다.");
            return;
        }
        c_price = p1_list[c_idx];
        s_price = p2_list[s_idx];


    }
    int findfee(String [] strlist, String menu){
        int idx = -1;
        for(int i = 0; i<strlist.length;i++){
            if ( strlist[i].equals(menu)){
                 idx = i;
                 return idx;
            }
        }
        return idx;
    }

}
class ReCoffee {
    public static void main(String[] args) {
        int price1, price2, result;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Harry Caffe");
        System.out.print("Choose 1 : Americano / Cafe mocha / Cafe Latte / Green Tea Latte :  ");
        String input1 = sc.nextLine(); // 여기서 입력을 내가 원하는 값 받을떄까지 무한 루프를 시킬 것인지
        // 혹은 위의 인스턴스 메서드에 가격 찾을 떄 예외처리를 할 것인지.
        System.out.print("Choose size : G(grande) / R(regular) / S(short) :  ");
        String input2 = sc.nextLine();
        //int i =1;  생성자 생성할떄마다 i++하면 주문번호가 되는거고. 만약에 주문을 계속 받을거면 그냥 이 문장 전체를 무한루프로 만들어버리면 되는거고
        // 참조변수배열 ArrayList만들어 놓으면 될거고.
        Coffee2 c = new Coffee2(input1,input2);
        c.calculate(c.coffee,c.size);
        System.out.printf("주문하신 커피는 %s, 사이즈는 %s, 가격은 %d입니다 \n",input1,input2,c.c_price+c.s_price);

    }
}


