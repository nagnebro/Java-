

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Account a = new Account(10000, "1215");
        Account b = new Account(10000, "56788");
        a.transfer(b,3000);
        a.transfer(b,3000);
        a.transfer(b,3000);
        a.transfer(b,3000);
        System.out.println(a);
        System.out.println(b);

    }
}
class Account{

    int money;
    String name;

    void transfer(Account b, int s_money){
        if(money>=3000) {
            b.money += 3000;
            money -= 3000; // 여기서 money는 메서드를 호출한 참조변수의 money
        }

    }
    public String toString(){
        return "{ num : "+name+", balance : "+money+" }";
    }

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

