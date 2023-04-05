package Interface;

public interface Hero {
    int MAX_HP = 100;

    // 공격력
    void attack();
    // 치료
    void heal(int portion);
}
