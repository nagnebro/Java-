class Node{

    int data;  // 데이터
    Node next; // 다음 주소

    //LinkedList는 이 Node클래스를 이용해 데이터와 주소를 확인하고 데이터끼리 연결시켜주는 동작 원리를 가지고 있다.
}

public class LinkedListEx {
    public static void main(String[] args) {

        int count = 0;

        // ArrayList는 배열을 기반으로 프로그래밍 돼있다. 즉 데이터가 늘어나거나 줄어들떄 마다 배열을 복사하고 값을 옮겨주기 위한 메모리 사용이 계속 일어난다.
        // LinkedList는 데이터를 저장할 주소값이 여러개로 이어져있다고 생각하면된다. 추가, 삭제가 어레이리스트보다 빠르다.

        //리스트
        // -배열기반이 아니라 리스트 기반
        // -열차 칸
        // -변수를 만들어서 주소값을 이용해서 만들 수 있다.
        // -시작점에는 데이터를 저장하지 않는다.

        // ArrayList와 LinkedList의 차이. 검색에 있어서 속도 차이가 난다. 배열(ArrayList)은 전체적인 주소값을 가지고 있기 때문에 검색이 빠르고 쉽지만
        // 리스트(LinkedList)는 일렬로 배열의 형태로 데이터를 가지고 있는 것이 아닌 다음 데이터의 주소만 기억하고 있기 때문에 검색에 있어서 조금 느리다.
        // 따라서 어레이리스트는 인덱스가 있고 링크드리스트는 인덱스가 없다.즉 데이터 추가 삭제에서는 링크드리스트가 유리하고 데이터 검색에는 어레이리스트가 유리하다.

        // 링크드리스트의 시작점
        // 머리(head)부분, 즉 시작점에는 데이터를 저장 하지 않는다.

        Node head = new Node(); // 머리부분을 생성

        // 실제 첫번쨰 노드를 생성
        Node node1 = new Node(); // 또 다른 노드타입의 인스턴스를 생성
        node1.data = 10; // node1참조변수의 데이터를 입력
        head.next = node1; // 이때 머리 부분의 객체가 참조해야 할 다음 데이터의 주소를 node1의 주소로 저장해놓는다. 그러면 꼬리가 이어지듯이 연결되는 구조.
        count++; // 인덱스 번호가 없기 때문에 노드를 생성할 때마다 인데스를 체크하기 위한 카운트.
        //두번째 노드를 생성

        Node node2 = new Node();
        node2.data = 20;
        node1.next = node2;
        count++;
        //세번째 노드를 생성

        Node node3 = new Node();
        node3.data = 30;
        node2.next = node3;
        count++;

        //nodenext를 이용해서 데이터 결과를 출력
        System.out.println(head.next.data); // 헤드가 참조하고 있는 부분은 다음 노드인 node1이다.
        System.out.println(head.next.next.data);// node1이 참조하고 있는 부분은 다음 노드인 node2이다. node1.next.data와 같음
        System.out.println(head.next.next.next.data);// node2가 참조하고 있는 부분은 다음 노드인 node3이다. node2.next.data와 같음

        //시작점인 head의 값은 변경돼서는 안된다.

        Node temp = head.next; // 기존의 노드 주소값이 변경돼서는 안되니까 주소값을 복사할 참조변수를 선언.
        // head를 넣게 되면 head객체의 data를 출력
        // 0부터 출력
        // head.next 다음 주소값을 가져온다. 첫번째 node1부터 시작.
        for(int i = 0; i<count ; i++){
            System.out.println(temp.data);
            temp = temp.next; // head.next.next
        }
        // 중간값인 node1을 삭제했다고 가정해보자
        // 1. node1 먼저 찾는다.
        // 2. node1.next를 head.next로 연결. >> 그렇게 되면 head.next가 참조하고 있던 node1의 정보는 없어지고 바로 node1.next(즉 node2의 접오)
        // 의 정보를 가지게 된다

        Node del = node1;

        // 대충 스택은 이런 구조이다 라고만 생각하고 넘어가기 ?? 스택과 노드와 컬렉션과 링크드리스트의 관련성??
        head.next = del.next;

    }
}
