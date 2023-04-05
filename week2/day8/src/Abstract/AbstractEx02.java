package Abstract;

import java.util.Random;

abstract class Human{
    int weight;
    String name;
    int num;

    abstract void run();
    public abstract String toString();
    Human(String name, int height){
        this.name = name;
        this.weight = height;
    }
}

class Jumper extends Human{

    int height;
    static int count=1;

    void run(){
        System.out.println("Jumper가 뜁니다.");

    }
    void jump(){
        Random r = new Random();
        run();
        height = r.nextInt(100,150);
    }

    public String toString(){
        return String.format("%d번 Jumper의 체중은 %d, 높이 뛰기 기록은 %d cm입니다 ",num,weight,height);
    }
    Jumper(String name, int weight){
        super(name,weight);
        num = count++;
    }
}
class Runner extends Human{
    static int count = 1;
    int distance ;
    void run(){
        System.out.println("Runner가 달립니다.");
        distance += 1000;
    }
    public String toString(){
        return String.format("%d번 Runner의 체중은 %d, 달린 거리는 %d m입니다 ",num,weight,distance);
    }

    Runner(String name, int weight) {
        super(name, weight);
        num = count++;
    }
}



public class AbstractEx02 {

    public static void main(String[] args) {
        Runner r1 = new Runner("김영찬1",70);
        Jumper j1 = new Jumper("영찬1",80);
        Runner r2 = new Runner("김영찬2",100);
        Runner r3 = new Runner("김영찬3",90);
        r1.run();
        System.out.println(r1);
        j1.jump();
        System.out.println(j1);
        r3.run();
        r3.run();
        System.out.println(r3);
    }
}
