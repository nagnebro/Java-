import java.util.Arrays;
import java.util.Stack;

public class StackEx01 {


    int top; // 마지막 데이터가 어딘지 알려주는 방번호(인덱스)
    int size; // 스택 배열의 크기
    int[] stack; // stack을 저장하는 공간은 초기화할때 미리 공간의 크기를 지정해놓으면 한계가 있어서 다음과 같이 선언해준다.

    StackEx01(){} // 기본 생성자는 컴파일 시에 자동 생성. 다만 매개변수를 갖는 다른 생성자를 생성해놓았다면 생성되지 않으니 주의.
    StackEx01(int size){
        this.size = size;
        stack = new int[size]; // 생성자를 통해 매개변수를 그때그때 받은 후에 그 크기만큼 배열을 생성해준다.
        top = -1;
    }

    // 추가
    void push(int item){
        stack[++top] = item; // top이 -1이기 떄문에 전위형으로 먼저 값을 증가시켜준다.
        System.out.println(stack[top]);
    }
    // 삭제
    void pop(){
        System.out.println("stack pop");
        int pop = stack[top];
        stack[top] = 0;  // size는 동일한 상태에서 스택안의 값만 0으로 바꿔주는 것.
        top -=1;// 그리고 그 때 마지막 값을 가지고 있는 stack의 인덱스 번호를 가지고 있는 top의 인덱스 번호를 1개 빼준다.
    }

    // 조회
    void peek(){
        System.out.println(Arrays.toString(stack));
    }

    // void remove()는 값 삭제, 객체리턴 pop()은 인덱스 삭제
    // remove는 삭제한 값을 확인시키지 않고 그냥 삭제
    // pop은 삭제한 값을 프로그래머한테 보여준다.
    public static void main(String[] args) {
        /*
            자료구조란?
            - 데이터를 효율적으로 다룰 수 있게 도와주는 데이터 보관 방법
            - 효율적 (검색, 삭제, 추가) 쉽게 해준다.

            스택(Stack)
            - 컴퓨터에서 아주 많이 사용되는 자료구조

            홈페이지 같은 곳에서 뒤로 다시 돌아가는 구조가 스택의 구조이다.

                후입선출(LIFO)
            - 가장 최근에 들어온 데이터가 가장 먼저 나간다.  ?? 선형구조와 비선형구조와의 관계?


            큐(queue)
            - 선입선출. 택시, 버스 승강장에서 승객이 기다리는 등의 구조에 사용된다.

            제일 먼저 들어간 녀석이 제일 나중에 나온다. (프링글스 구조ㅋㅋ)


         */
        StackEx01 s = new StackEx01(10);
        s.push(10);
        s.push(20);
        s.push(30);
        // 값을 넣은 순서대로 출력하기?

        Stack<Integer> stack2 = new Stack<>();

        // 추가
        stack2.push(20);

        //삭제
        stack2.pop();

        //조회
        //  stack2.peek();   왜 에러나지??
    }
}
