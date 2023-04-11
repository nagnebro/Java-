package InnerClass;

// 클래스 안에 클래스를 작성하는 공간
// 멤버변수

import javax.swing.*;

class Out3 {
     int a =1;

     class In{
        String Infun(){
            return a + "번째 멤버 내부 클래스!";
        }
         String Infun2(){
            return "내부 클래스의 멤버 메서드!";
        }
    }
    // 커파일 하는 동안 static 영역에 메모리 할당.

}

class Static_Inner3{
    public static void main(String[] args) {
        String str = "";

        Out3 obj = new Out3();
        Out3.In obj2 = obj.new In();
        str = obj2.Infun();
        JOptionPane.showMessageDialog(null,obj2);
        System.out.println(str);
        str= Out.In.Infun2();
        System.out.println(str);
    }
}