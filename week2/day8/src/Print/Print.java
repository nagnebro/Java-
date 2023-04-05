package Print;

public interface Print {

    void print(String p);  // 흑백
}


interface ColorPrint extends Print{
    void color(String p);
}



interface Print3D extends Print,ColorPrint{ // 인터페이스는 다중상속이 가능하다.
    // 새로운 기능이 추가될때 마다 인터페이스를 다중상속하면서 문제가 없게끔 만들어준다.
    void three_d(String p);

}