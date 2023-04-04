import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackEx02 {


    int top; // 마지막 데이터가 어딘지 알려주는 방번호(인덱스)
    int size; // 스택 배열의 크기
    User[] stack; // stack을 저장하는 공간은 초기화할때 미리 공간의 크기를 지정해놓으면 한계가 있어서 다음과 같이 선언해준다.

    StackEx02(){} // 기본 생성자는 컴파일 시에 자동 생성. 다만 매개변수를 갖는 다른 생성자를 생성해놓았다면 생성되지 않으니 주의.

    // 추가
    void push(User item){
        stack[++top] = item; // top이 -1이기 떄문에 전위형으로 먼저 값을 증가시켜준다.
        System.out.println(stack[top]);
    }


    // 삭제
    void pop(){
        System.out.println("stack pop");
        User pop = stack[top];
        stack[top] = null;  // size는 동일한 상태에서 스택안의 값만 0으로 바꿔주는 것.
        top -=1;// 그리고 그 때 마지막 값을 가지고 있는 stack의 인덱스 번호를 가지고 있는 top의 인덱스 번호를 1개 빼준다.
    }

    // 조회
    void peek(){
        System.out.println(Arrays.toString(stack));
    }
    StackEx02(int size){
        this.size = size;
        stack = new User[size]; // 생성자를 통해 매개변수를 그때그때 받은 후에 그 크기만큼 배열을 생성해준다.
        top = -1;
    }
    // void remove()는 값 삭제, 객체리턴 pop()은 인덱스 삭제
    // remove는 삭제한 값을 확인시키지 않고 그냥 삭제
    // pop은 삭제한 값을 프로그래머한테 보여준다.

}

//고객의 정보
class User{
    // 고객정보
    String id;
    String pw;
    String phone;
    String email;

    User(){}

    public User(String id, String pw, String phone, String email) {
        this.id = id;
        this.pw = pw;
        this.phone = phone;
        this.email = email;
    }

    // 예매정보를 저장하는 변수
    Reservation res = new Reservation();
}

//예매정보
class Reservation{

    String movie_name;    //영화이름
    String movie_time;    //영화시간
    int number_people;    //인원수
    String movie_room;    // 몇 관인지 저장

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    void setInfo(String movie_name, String movie_time, int number_people, String movie_room){

        this.movie_name = movie_name;
        this.movie_time = movie_time;
        this.number_people = number_people;
        this.movie_room = movie_room;
    }
}

class CGV_movie {

    public static void main(String[] args) {
        StackEx02 stack1 = new StackEx02(3);
        User user1 = new User("qwer","qq111","01066922","ssss");
        User user2 = new User("qwer","qq111","01066922","ssss");
        User user3 = new User("qwer","qq111","01066922","ssss");
        stack1.push(user1);
        stack1.push(user2);
        stack1.push(user3);
        System.out.println(stack1.top);
        stack1.stack[stack1.top].res.setInfo("웅남이","98분",2,"5관이지");
        //참조변수의 User클래스의 stack1이라는 User 참조배열에 접근은 ㅎ헀음.표


    }
}