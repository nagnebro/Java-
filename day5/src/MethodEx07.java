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
