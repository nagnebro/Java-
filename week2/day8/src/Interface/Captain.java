package Interface;
// ============================다시 개념정리 할 것.
public class Captain implements Hero{
    private int hp = Hero.MAX_HP;


    @Override
    public void attack() {

    }
    @Override
    public void heal(int portion) {
        hp+= portion; // 체력을 일단 포션만큼 더하고
        if( hp > Hero.MAX_HP ){ // 포션먹고 체력이 맥스보다 많으면
            hp = Hero.MAX_HP; // 맥스로 현재체력을 바꿔라. 다만 포션을 애초에 더 못먹게 하던지 하는 기능을 추가할 필요가 있는 것 같기는 한데
            // 오히려 유저가 그걸 원할수도 있어서 모호하네.
        }
        System.out.println("캡틴아메리카가 "+portion+"만큼 체력을 회복해 "+hp+"가 됐습니다.");
    }
    void shield(){
        System.out.println("방패막기");
    }
}
