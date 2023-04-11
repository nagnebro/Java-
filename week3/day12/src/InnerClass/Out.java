package InnerClass;

// 클래스 안에 클래스를 작성하는 공간
// 멤버변수

import javax.swing.*;

public class Out {
    static int a =1;

    static class In{
        String Infun(){
            return a + "번째 static 내부 클래스!";
        }
        static String Infun2(){
            return "내부 클래스의 static 메서드!";
        }
    }
    // 커파일 하는 동안 static 영역에 메모리 할당.

}

class Out2{
    static int a= 1; // 같은 변수명이라도 속해있는 클래스가 다르기 때문에 중복 선언이 가능하다.

}
class Static_Inner{
    public static void main(String[] args) {
        String str = "";

        Out.In obj = new Out.In(); // out클래스 안에 있는 in클래스의 객체인 obj를 생성한것.
        str = obj.Infun(); // Infun 메서드는 static이 아니기 때문에 static 클래스에는 클래스명. 으로 접근 가능하지만 메서드에는 없음.
        System.out.println(str);
        JOptionPane.showMessageDialog(null,obj);
        str= Out.In.Infun2(); // Infun2 메서드는 static 메서드이기 때문에 참조변수로 접근하지 않아도 되는 모습.
        System.out.println(str);
    }
}