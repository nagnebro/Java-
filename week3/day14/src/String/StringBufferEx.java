package String;

public class StringBufferEx {
    // String, StringBuffer, StringBuilder
    // 공통점 : 문자열 다룬다.
    // 차이점 : 사용 목적에 따라 쓰임새가 많이 다르다.

    // StringBuffer, StringBuilder
    // 문자열을 연산(추가하거나 변경) 할 때 자주 쓴다.

    void showstrbu(){ // StringBuffer

        // 버퍼 (Buffer)
        // - 임시 저장 공간(독립적인 공간)
        // 문자열을 바로 추가할 수가 있고 공간 낭비도 없고 연산(추가 및 삭제)속도가 매우 빠르다. -> 그럼 수정후에도 같은 주소를 가지나? 그냥 연산만 빠른건가

        StringBuffer sb = new StringBuffer();
        System.out.println(sb);
        sb.append("hello"); // StringBuffer와 StringBuilder는 append를 사용함으로서 길이가 16인 빈 공간에 추가하고자는 문자열을
        // 생성한 후 sb라는 문자열공간에 저장시켜준다. 이때 String클래스로 문자열끼리 연산하는 것보다 효율이 좋다는 것인데 그 이유는
        // String 클래스로 연산을 하게 되면 값의 추가 복사가 지속적으로 이루어지고 새로 복사된 값은 가비지 컬렉터가 제거하는 등의 불필요한 과정들이
        // 포함돼있기 때문이다.
        sb.append("world");
        sb.append("java");
        sb.append("isit");
        sb.append("fun");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("hi");
        System.out.println("sb2의 해쉬코드 : "+sb.hashCode()); // 서로 다른 주소값을 가지게 된다.
        System.out.println("hi의 해쉬코드"+"hi".hashCode());
        System.out.println(sb2.hashCode());
        //sb1과 sb2과 있을 떄 각각ㄱ의 해쉬코드는 hashcode를 생성하는 순서에 따라 달라진다. 즉 append를 하고 나서도 값을 가지고 있는
        // 주소를 가지고 있지 않다가 출력될 떄 주소값을 할당해주는 건가?


        //================================좀더 정리하자 sb의 타입이 무엇인지. char 배열인가?================================================


        System.out.println(sb);
        System.out.println(sb.hashCode());
        String ex = "helloworldjavaisitfun";// append를 통해 추가된 문자열을 저장하는 공간 sb의 주소와 그냥 문자열 값을 비교해보면
        System.out.println(ex.hashCode());// 결국 상수 문자열 값의 주소를 같이 공유하고 있다는 것을 알 수 있다.

        String result = sb.toString(); // sb라는 스트링버퍼 타입의 참조변수에 내가 추가한 문자열들이 버퍼에 저장된 상태이다
        // 그 버퍼에 저장된 값을 문자열로 갖고 오기 위해서는 toString()으로 갖고와야함.
        System.out.println(result.hashCode());
        System.out.println(result);



    }

    void showstrbu2(){
        String str = "abcdefg";
        StringBuffer sb= new StringBuffer(str);
        System.out.println(sb);

        //문자열 자르기 (추출) substring(시작,끝)

        // 문자열 중간에 추가하기
        sb.insert(2,"추가합니다"); // 문자열 사이에 값을 넣을 수 있는 메서드.
        System.out.println(sb);

        //삭제
        sb.delete(2,4);
        System.out.println(sb);

        //버퍼 용량
        System.out.println(sb.capacity());// 버퍼의 길이를 출력함

        //뒤집기 reverse()



    }
    void showstr(){

        String str = "abcdefg";
        System.out.println(str.hashCode());
        System.out.println("aa".hashCode());
        str+= "김영찬";
        str+=",";
        str += "jump to java"; // 각기 다른 주소를 갖고 있는 문자열들이기 떄문에 연산속도가 느리다.

        System.out.println(str);
        // 단점 : 심플하다 근데 연산속도가 느리다
    }



}

class StringEx{

    public static void main(String[] args) {
        StringBufferEx sb = new StringBufferEx();
        sb.showstr();
        sb.showstrbu();

        sb.showstrbu2();
    }
}