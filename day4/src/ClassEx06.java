import java.util.Random;

class Hero{
    String name;
    int hp;

    void herolist(){
        System.out.println("이름은 "+this.name+"hp는 "+this.hp);
    }

    void attack(Hero h){
        h.hp -= 30;
        System.out.printf("%s의 공격으로 %s의 hp가 %d가 됐습니다 \n",this.name,h.name,h.hp);

    }
    Hero(String name, int hp){

        this.name = name;
        this.hp = hp;
    }

}

public class ClassEx06 {
    //아래와 같은 4개의 HERO 객체를 생성하고, 이들에 대한 정보를 출력하려 한다.
    // 주어진 HERO 클래스에 생성자를 완성하여 출력 예와 같은 결과를 얻으시오
    // 아이언맨(hp:80)
    // 타노스(hp :160) 등과 같이.
    public static void main(String [] args) {
        Hero ironman = new Hero("아이언맨", 100);
        Hero tanos = new Hero("타노스",400);
        Hero spiderman = new Hero("스파이더맨",100);
        ironman.herolist();
        tanos.herolist();
        spiderman.herolist();

    }
}
class HeroTest{
    public static void main(String [] args){

        Hero [] herolist = new Hero[3];
        Hero tanos = new Hero("tanos",500);
        Hero ironman =  new Hero("ironman",100);
        Hero spiderman =  new Hero("spiderman",100);
        Hero hulk =  new Hero("hulk",100);
        herolist[0] = ironman;
        herolist[1] = spiderman;
        herolist[2] = hulk;

        ironman.herolist();
        tanos.herolist();

        for(int i = 0 ; i<3 ; i++){
            herolist[i].attack(tanos);
        }
        Random r = new Random();
        int i = 0;
        while( i<=10) {
            herolist[r.nextInt(3)].attack(tanos);
            i++;
        }
    }
}




// 슈퍼마리오 , 쿠파
class Character1{


    String name;    // 이름
    int hp;         // 목숨

    // 기본생성자
    Character1(){}

    // 생성자
    public Character1(String _name, int _hp) {
        name = _name;
        hp = _hp;
    }

    void attack(Character1 ch) { // 공격한 대상 말고 맞는 대상을 attack()
        System.out.println(this.name +" 불주먹공격!");
        ch.hp -= 50;
        System.out.println(ch.name +" 목숨:"+ ch.hp);

    }
}

class Main {

    public static void main(String[] args) {

        // 마리오 객체 생성
        // 150

        Character1 mario = new Character1("마리오",150);
        Character1 coopa = new Character1("쿠파",300);
        Character1 luigi = new Character1("루이지",150);
        Character1 peach = new Character1("피치공주",150);

        // 우리는 한팀 !
        Character1[] team = new Character1[3];

        // 마리오, 피치공주, 루이지 각각 저장
        team[0] = mario;
        team[1] = luigi;
        team[2] = peach;

        // 마리오 -> 루이지 -> 피치공주 공격
        team[0].attack(coopa);  //마리오
        team[1].attack(coopa);  //루이지
        team[2].attack(coopa);  //피치

        // 랜덤값을 이용해서

        // 쿠파가 주먹 공격을 한다.
        coopa.attack(peach);
        //셋이 돌아가면서 쿠파를 때리게 만들기.
        Random r = new Random();

    }
}
// 마리오가 주먹 공격을 한다!
//mario.attack(coopa);