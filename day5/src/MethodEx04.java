public class MethodEx04 {

    public static int 입금(int money, int addmoney){
        money =money+addmoney;
        return money; // 메서드내에서 어떠한 결과값을 출력하는 것이 아니고 리턴값으로 다른 메서드에서 이용하려고 한다면
        // 호출한 메서드에서는 메서드 호출의 리턴값을 변수나 수식에 이용해야 한다. 아니면 그 리턴값은 그냥 증발해버리기 때문이다.
    }
    public static void main(String [] args){

        //ATM기

        //main(나)
        int money = 10000;
        //입금
        money = 입금(money, 20000);
        System.out.println(money);
    }
}
