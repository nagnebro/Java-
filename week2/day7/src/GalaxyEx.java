class Galaxy {
    String serialNum; // 일련번호

    /* 1. 해당 필드를 클래스 변수화 하세요. */
    static int count = 0;

    // 생성자
    Galaxy() {
        count++;
        char c = randomAlphabet(); // A ~ Z 중 택1
        serialNum = String.format("%c-%d", c, count);
    }

    // 메소드
    char randomAlphabet() {
        return (char) ('A' + Math.random() * 26); // A to Z
    }

    void print() {
        System.out.printf("Galaxy { serialNum: %s }\n", serialNum);

    }
}

class GalaxyTest{
    public static void main(String[] args) {
        Galaxy g1 = new Galaxy();
        Galaxy g2 = new Galaxy();
        Galaxy g3 = new Galaxy();
        g1.print();
        g2.print();
        g3.print();
    }
}