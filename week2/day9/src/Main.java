public class Main {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;
        boolean b= num1<=num2;
        System.out.println(b);
        String value1 = "신민철";
        String value2 = "신민철";
        String value3 ;
        value3 = value1;
        System.out.println(value1 == value2);
        System.out.println(value1 == value3);
    }
}