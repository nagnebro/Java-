class Wizard{
    void fireball(){
        System.out.println("데미지10");
    }
}

class KingWizard extends Wizard{
    void fireball(){
        System.out.println("데미지20");
    }
}

public class OverrideEx01 {

    public static void main(String[] args) {

        Wizard w = new Wizard();
        KingWizard k = new KingWizard();
        k.fireball(); // 오버라이딩 된 메서드
        w.fireball();

        //메서드 오버라이딩
        // - 부모클래스의 메서드를 자식클래스가 재정의
        // - 부모클래스 메서드 이름을 자식클래스가 똑같이 만들어서 사용하는 것. 일전의 toString같은 메서드.

        //메서드 오버로딩
        // - 메서드의 이름이나 반환타입은 같으나 매개변수나 매개변수의 타입이 다른 경우를 말함. 오버로딩은 같은 클래스 내에서 한정됨.
    }
}

class Point{
    int x,y;

    String info1(){
        return "x : "+x+" y : "+y;
    }


    @Override
    public String toString(){
        return "x : "+x+" y : "+y;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Point3d extends Point{

    int z;

    String info2(){  // 오버라이딩 아님. 수정사항에 좀 더효율적인 프로그래밍을 하기 위함. 중복되는 부분을 제거. 오버라이딩으로 작성하게되면
        // 조상의 메서드는 호출이 안돼서 그냥 별개의 메서드로 작성함.
       return info1()+" z : " +z;
    }

    @Override
    public String toString(){
        return "x : "+x+" y : "+y+" z : "+z;
    }
    public Point3d(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class PointTest{
    public static void main(String[] args) {
        Point3d p = new Point3d(3,5,1);
        System.out.println(p);
        System.out.println(p.info2());
    }
}