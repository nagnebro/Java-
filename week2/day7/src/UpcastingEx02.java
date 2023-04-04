
class UpCastingEx02 {
    public static void main(String[] args) {
        // 기사 객체 생성 및 초기화
        Knight knight = new Knight();
        knight.name = "아서스";
        knight.hp = 180;
        knight.strength = 50;

        // 도적 객체 생성 및 초기화
        Thief thief = new Thief();
        thief.name = "발리라";
        thief.hp = 120;
        thief.agility = 40;

        // 업 캐스팅 - 부모 타입으로 객체를 해석
        Adventurer adv0 = knight;
        Adventurer adv1 = thief;

        // 모험가들의 배열 생성
        Adventurer[] advs = { adv0, adv1 };

        // 모든 모험가의 정보 출력
        for (int i = 0; i < advs.length; i++) {
            System.out.println(advs[i].toString());
        }
    }
}

/* 1. 부모 클래스 Adventurer를 만드세요. */
class Adventurer {
    String name;
    int hp;
    void punch(){
    }
    public String toString(){
        return "Name : "+name+", Hp : "+hp;
    }
}

/* 2. Knight를 Adventurer의 자식 클래스로 정의하세요. */
class Knight extends Adventurer {
    int strength; // 힘

    public void berserker() {
        System.out.println("체력과 공격력이 증가합니다.");
    }
}

/* 3. Thief를 Adventurer의 자식 클래스로 정의하세요. */
class Thief extends Adventurer {

    int agility; // 민첩



    public void sharpen() {
        System.out.println("크리티컬 확률이 증가합니다.");
    }
}