import java.util.Scanner;

public class Tax {


    public static int cal(int price){
        return (int)(price * 0.9);
    }

    public static int tax(int price){
        return (int)(price * 0.1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("가격을 입력하세요.");
        int price = sc.nextInt();
        int productPrice = cal(price);
        int tax = tax(price);
        System.out.printf("제품의 가격은 %d, 세금은 %d 입니다",productPrice,tax);
    }

}