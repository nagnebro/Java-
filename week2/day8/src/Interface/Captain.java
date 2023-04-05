package Interface;
// ============================다시 개념정리 할 것.
public class Captain implements Hero{
    private int hp = Hero.MAX_HP;


    @Override
    public void attack() {

    }
    @Override
    public void heal(int portion) {
        hp+= portion;
        if( hp > Hero.MAX_HP ){
            hp = Hero.MAX_HP;
        }
        System.out.println("캡틴아메리카가 "+portion+"만큼 체력을 회복해 "+hp+"가 됐습니다.");
    }
    void shield(){
        System.out.println("방패막기");
    }
}
