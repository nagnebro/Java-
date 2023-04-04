public class InheritanceEx04 {

    public static void main(String[] args) {
        Miner m1 = new Miner("글로리아");
        Miner m2 = new Miner("빅토리아");
        m1.findCoin();
        m1.findCoin();
        m1.findCoin();
        m2.findCoin();
        System.out.println(m1);
        System.out.println(m2);
    }
}
class Miner{
    String name ;
    int coins;
    void findCoin(){
        coins+=1;
    }

    public String toString(){
        return "name : "+name+"  coins : "+coins;
    }
    Miner(String name){
        this.name = name;
    }

}
