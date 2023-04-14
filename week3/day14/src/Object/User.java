package Object;

import java.util.Scanner;

public class User implements Cloneable{

    Scanner sc = new Scanner(System.in);
    private int id;
    private int pw;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }
    User(){}

    User(String a, String b){

    }
    @Override // cloneMain 클래스에서 사용하기 위해 오버라이딩.
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    int inputpw;
    int inputid;
    User temp;
    //equals() 오버라이딩

    //private id, pw 멤버변수

    // 생성자는 기본생성자 안쓸거다
    //게터세터로 id pw에 접근해 수정할 것.

    // 회원가입 시 아이디 패스워드를 입력받아서 객체 생성을 하고
    // 로그인 시에 아이디와 패스워드를 입력받는데
    // equals(Object o)
    // temp = User() scanner로 입력받아서 넘겨주고
    // 그렇게 입력받은 아이디 비번을 equals를 통해 비교하고 로그인성공시키기
    // user id님 환영합니다 이런식.


    @Override
    public boolean equals(Object obj) {

        if(this == obj){return true;}
        if (!(obj instanceof User)){return false;}
        // 위 두문장의 의미가 뭐지? 위의 문장은 자신이 equals를 실행시켰느냐인데.. 뭔가 문제 조건이랑 좀 안맞는 구조인 것 같고
        // User보다 상위 클래스의 인스턴스가 들어왔다면 그냥 False를 반환하고..

        User tmp = (User)obj;
        return (tmp.id == this.id && tmp.pw == this.pw);
    }

    // hashing기법? hashcode() 메서드를 이용한다
    // 객체 주소값을 이용해서 해싱코드를 만든 후 반환
    // 서로 다른 객체는 같은 해시 코드를 가질 수 없다  --> (String은 같다....)
    // 해시코드는 주소값은 아니고 주소값으로 만든 고유의 숫자값이다.
    // int 형태로 표현


    void enter(){
        temp = new User();
        System.out.println("아이디 입력하세요"); // 게터 세터 써도 된다.
        inputid = sc.nextInt();
        temp.id = inputid;
        System.out.println("비밀번호 입력하세요");
        inputpw = sc.nextInt();
        temp.pw = inputpw;
        if(equals(temp)){
            System.out.println(this.id+"님 환영합니다");
        }
    }

    void signup(){
        System.out.println("아이디를 입력하세요");
        inputid = sc.nextInt();

        while(true) {
            System.out.println("비밀번호 입력하세요");
            inputpw = sc.nextInt();
            System.out.println("입력한 비밀번호를 다시 입력하세요");
            int checkpw = sc.nextInt();
            if(inputpw == checkpw)break;
        }
        this.id = inputid;
        this.pw = inputpw;
        System.out.println("회원가입이 완료됐습니다.");
    }
}

class UserTest{
    public static void main(String[] args) {
        User u = new User();
        u.signup();
        u.enter();
        System.out.println(u.getClass());
    }
}