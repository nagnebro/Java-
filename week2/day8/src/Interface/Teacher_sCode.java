//
//
//
//abstract class Printer{
//    abstract void print();
//}
//
//class Samsung extends Abstract.Printer { // 추상클래스인 Printer 클래스를 상속받기 위해서는 1. 추상메서드를 오버라이딩하던지 2. 추상 클래스화 하던지
//    void print(){
//        System.out.println("삼성 프린터");
//    };
//}
//
//abstract class Lg extends Abstract.Printer {
//    //  추상메서드를 오버라이딩 할 것이 아니라면 클래스를 추상클래스로 선언해야한다.
//}
//
//
//
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        // 흑백 프린터 잘 사용
//        SamsungPrinter	seohee = new SamsungPrinter();
//        LgPrinter  jihee = new LgPrinter();
//
//        Sam3D_Printer hee = new Sam3D_Printer();
//        // hee 참조할 수있는 타입 모두?
//        // Sam3D_Printer , Print3D ,PrintColor,Three_dimensional
//        // Object
//
//        Print3D p1 = hee;
//
//        boolean res = p1 instanceof Sam3D_Printer;
//
//        System.out.println(res);
//
//    }
//
//}
//
//public abstract class Printer {
//	// 기능  print
//	abstract void print();
//}
//class Lg_Printer extends Printer{
//
//	@Override
//	void print() {
//		System.out.println("Lg 프린터");
//	}
//}
//
//class Samsung_Printer extends Printer{
//
//	@Override
//	void print() {
//		System.out.println("삼성프린터");
//	}
//	// 1. 오버라이딩
//	// 2. 본인도 비정상적인 메서드를 가지고 있기때문에
//	//    추상클래스 되라!
//
//}
