package Set;

import java.util.LinkedList;

class HashTable{ // 해시의 구조를 보여주는 알고리즘.
    class Node{
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        //value 값을 수정하는 메서드
        void value(String value){
            this.value = value;
        }

        //value 값을 수정하는 메서드
        String value(){
            return this. value;
        }
    }
    // 충돌이 발생해서 데이터를 저장할 때 사용하는 리스트 > 해시테이블에 동일한 값이 있어 넘어올 경우
    LinkedList<Node>[] data;

    // 해시테이블에 데이터를 저장하는 개수(배열의 길이)
    public HashTable(int size){
        this.data = new LinkedList[size];
    }
    int getHashCode(String key){
        // 문자열의 키를 받아오면 해시코드로 변환을 해서 배열의 길이만큼 나눠서 나눈 나머지값을
        // 인덱스 방번호로 지정.
        int sum = 0;
        for ( char c : key.toCharArray()){ //입력받은 문자열 하나하나를 아스키코드값의 비교를 위해 다음과 같이 char배열로 선언
            sum += c;
        }
        return sum;
    }

    // 문자열 각각의 아스키코드값을 더한 해쉬코드 값을 인덱스 방 번호로 변환해주는 메서드
    int convertToIndex(int hashcode){
        return hashcode % data.length;
    }

    Node searchKey(LinkedList<Node> list, String key){ // 리스트에 아무런 값도 없을 경우
        if(list == null){
            return null;
        }
        for(Node node : list){
            if(node.key.equals((key))){
                return node;
            }
        }
        return null;
    }

    void put(String key, String value){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];

        if(list == null){ // 리스트가 없을 경우 새롭게 리스트를 생성
            list = new LinkedList<>();
            data[index] = list;
        }
        Node node = searchKey(list,key);
        if( node == null){ // 키가 없을 경우에는 새로운 키와 값으로 node를 생성해준다.
            list.addLast(new Node(key,value));
        }else{ // 키가 있을 경우에는 값만 바꿔주면 되니 값만 바꿔주는 메서드를 실행.
            node.value(value);

        }
    }
    String get(String key) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null? "Not found" : node.value();
    }
}
//========== 자료구조에 대한 공부 필요 hash ,set ,map , 등등. ================
public class Hash {
    // isEmpty() : 데이터가 있는지 없는지 확인다
    // contains() : 지정된 key가 있는지 검색한다.
    // getOrDefault() : key가 있으면 value를 반환

    // 해시는 해시테이블과 해시함수로 이루어져있다.
    // -> 해시테이블 , 해시 함수

    // 해시가 실행된 배경?
    // 해시가 실행되는 과정
    // key( 문자, 숫자, 파일 ) -> 키가 들어오면 해시함수가 실행된다 -> 그때 해쉬코드가 동작한다
    // -> 그 해시코드를 인덱스로 확인하고 -> value 값을 찾아갈 수 있는 것.

    // 해시는 내가 받은 키값을 방번호로 사용한다.

    // 인덱스 방번호가 중복이 된다
    // 따라서 충돌을 방지하기 위해 동일한 인덱스로 데이터가 들어올 시
    // 선형구조(배열, 리스트) 저료형을 생성해 저장하게 만든다

    // 충돌 < 인덱스 방번호가 같거나, hashcode값이 같을 경우 >
}

class HashTest{
    public static void main(String[] args) {

        // 문자열의 길이를 가지고 인덱스로 사용하게 되면
        // 문자열의 길이가 똑같을 떄 두개의 데이터가 하나의 인덱스번호를 가지게 되므로 충돌이 발생한다
        // 따라서 위의 구조처럼 문자열의 아스키코드값을 더해서 설정한 해쉬테이블의 길이로 나눈 값을
        // 하나의 인덱스로 사용하면서 이때도 중복될 수 있기 때문에 내부적으로 또 리스트를 만드는 것.
        HashTable h = new HashTable(3);
        h.put("sung","She is pretty");
        h.put("jin","She is a model");
        h.put("hee","She is an angel");
        h.put("min","She is cute");
        h.put("min","She is Pure");


        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("min"));
        System.out.println(h.get("min"));
    }
}