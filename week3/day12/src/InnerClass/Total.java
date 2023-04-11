package InnerClass;

class PocketBall{

    int size = 100;
    static int price = 5000;

    class User{
        String name;

        public User(String name){
            this.name = name;
        }
    }



    static class PocketMoster {
        static String name = "이상해씨";
        int level = 10;

        public static void getPoketMember(){
            // 외부 클래스 인스턴스 멤버 접근 불가능하다.
            // System.out.println(size); 불가능하다.

            System.out.println(price);
            // System.out.println(level);
        }
    }

}



public class Total {

    public static void main(String[] args) {

        PocketBall.PocketMoster pm = new PocketBall.PocketMoster(); // 스태틱 내부클래스의 객체 생성
        PocketBall.User user = new PocketBall().new User("김영찬"); // 멤버 내부클래스의 객체 생성
        // 내부 클래스의 객체를 생성하는 방법이 조금 낯서니 익숙해져야 한다.
    }
}
