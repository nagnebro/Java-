import java.util.LinkedList;
import java.util.Queue;


class ArrayQueue {

    /*

        큐는 스택과 다르게 먼저 들어간 데이터먼저 저장이 되는 형식이다. 선선출.
     */
    int MAX = 1000;
    int front;    //머리 쪽에 위치할 index값, pop할때 참조하는 index
    int rear;    //꼬리 쪽에 위치할 index값, push할때 참조하는 index
    // stack에서 top의 역할
    int[] queue;

    public ArrayQueue() {
        front = rear = 0;    //초기값 0
        queue = new int[MAX]; //배열 생성
    }

    public boolean queueisEmpty() { //queue에 아무것도 들어있지 않은지 판단하는 함수
        return front == rear;
    }

    public boolean queueisFull() {    //queue가 가득 차 공간이 없는지 판단하는 함수
        if (rear == MAX - 1) {
            return true;
        } else
            return false;
    }

    public int size() { //queue에 현재 들어가 있는 데이터의 개수를 return
        return front - rear;
    }

    public void push(int value) {
        if (queueisFull()) {
            System.out.println("Queue is Full");
            return;
        }
        queue[rear++] = value; //rear가 위치한 곳에 값을 넣어주고 rear를 증가시킨다.
    }

    public int pop() {
        if (queueisEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int popValue = queue[front++];
        return popValue;  // 삭제하는 메서드가 아니고 삭제할 큐의 인덱스번호를 넘겨주는 메서드인가?
    }

    public int peek() {
        if (queueisEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int popValue = queue[front];
        return popValue;
    }

    public static void main(String[] args) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(10);
        qu.offer(20);
        qu.offer(30);
        qu.offer(10); //데이터를 추가한다
        qu.isEmpty();
        // qu.offer와 qu.add의 차이는?
        while (!qu.isEmpty()) {
            System.out.println(qu.poll()); //조회
        }

        // 자료구조 큐를 이용해서
        // 뽀로로
        // 크롱
        // 루피
        // 포비
        Queue<String> qu1 = new LinkedList<>();
        qu1.add("뽀로로");
        qu1.add("크롱");
        qu1.add("루피");
        qu1.add("포비");

        while (!qu1.isEmpty()) { // 비어있으면 중단.
            System.out.println(qu1.poll()); //조회
        }




    }
}