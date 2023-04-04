import java.util.Scanner;

class PointTest {
    public static void main(String[] args) {
        // 객체 생성
        Point p1 = new Point(-2, -5);
        Point p2 = new Point(3, 4);

        // 거리 계산
        double dist = Point.distance(p1, p2);

        // 결과 출력
        System.out.printf("두 점 A%s, B%s 사이의 거리: %.2f\n", p1.toStr(), p2.toStr(), dist);
        System.out.println(p1.inform(p2));
    }
}

class Point {
    /* 1. 필드를 만드시오. */
    int p1;
    int p2;
    /* 2. 생성자를 정의하시오. */
    String toStr(){
        return String.format("(%d,%d)",p1,p2);
    }
    public Point(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    /* 3. 객체 정보를 문자열로 반환하는 인스턴스 메소드를 만드시오. */
    String inform(Point p){
        return String.format("두 점 A(%d,%d),B(%d,%d) 사이의 거리 : %.2f",p1,p2,p.p1,p.p2,distance(this,p));
    }

    /* 4. 두 점 사이의 거리를 반환하는 클래스 메소드를 만드시오. */
    static double distance(Point p1, Point p2){
        double x = p1.p1-p2.p1;
        double y = p1.p2-p2.p2;
        return Math.sqrt((x*x)+(y*y));
    }
}

/*
 * # 틱택토
 * === 틱택토 ===
 * [X][X][O]
 * [ ][O][ ]
 * [ ][ ][ ]
 * [p1]인덱스 입력 : 6
 * === 틱택토 ===
 * [X][X][O]
 * [ ][O][ ]
 * [O][ ][ ]
 * [p1]승리
 *
 */

class Ex10{

    static String[][] game = new String[3][3]; //

    int turn = 0;
    int win = 0;
    String flag ;



    void check(int input){
        //[input/game.length] 이게 행 번호가 됨. 즉 3행 5열이라치면 3을 입력하면 1행인데 3에 행인 3을 나누면 1이 나오기떄문ㅁ에 1행으로 넘어감
            game[input/game.length][input%game.length] = flag;
    }
    Ex10(String flag){
        this.flag = flag;
    }


}

class Ex10Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ex10 player1 = new Ex10("O");
        Ex10 player2 = new Ex10("X");

        while(true){
            System.out.printf("번호를 입력하세요");
            int input1 =sc.nextInt();
            player1.check(input1);
            System.out.printf("번호를 입력하세요");
            int input2 =sc.nextInt();
        }
    }
}