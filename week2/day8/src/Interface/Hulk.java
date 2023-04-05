package Interface;

public class Hulk implements Hero {
    private int hp = Hero.MAX_HP; // public static final 생략돼있어서 클래스명으로 클래스변수에 접근함.

    @Override
    public void attack() {
        System.out.println("눈에 보이는 건 다 던짐");
    }
    @Override
    public void heal(int portion) {
        hp+= portion;
        if( hp > Hero.MAX_HP ){
            hp = Hero.MAX_HP;
        }
        System.out.println("헐크가 "+portion+"만큼 체력을 회복해 "+hp+"가 됐습니다.");
    }
    void jump(){
        System.out.println("강한 점프");
    }
}

