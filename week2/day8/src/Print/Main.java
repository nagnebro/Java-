package Print;

public class Main {
    public static void main(String[] args) {
        Sam3D s = new Sam3D();
        Lg l = new Lg();
        SamsunColor sc = new SamsunColor();

        System.out.println(s instanceof Print);
        System.out.println(l instanceof Print);
        System.out.println(sc instanceof Print);
//        s.color(5);
    }
}
