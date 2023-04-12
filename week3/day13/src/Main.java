import java.io.*;

class Member implements  Serializable{

    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + "" + this.age;
    }
}


public class Main {
    public static void main(String[] args) {

        Member m = new Member("김영찬",20);

        // 자바가 객체 파일을 저장하려면 하나씩 해야해서 번거롭다.  -> ??
        // 객체 직렬화 : 바이트 형태로 데이터 변환
        // 역직렬화 : 바이트로 변환된 데이터를 다시 객체로 변환

        // 내가 이해한대로 정리해보자면 사용자와 컴퓨터간의 입출력을 제어해주는 애들이 스트림이고 다양한 클래스들이다. 얘네가 출력을(즉 사용자 기준 출력)
        // 처리하는 방법과 입력을 처리하는 다양한 방법에 대해서 간략하게 배웠다고 생각하면 될 듯 하다.

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            // new FileOutputStream(경로명\파일명, 추가모드 true,false);
            FileOutputStream fos = new FileOutputStream("object.bin");

            //직렬화 -> 그니까 저장할떄는 출력된 데이터를 바이트 형태로 변환해주는 과정이 아래의 과정. 파일을 열어보면 알 수 없는 문자로 뭔가 기록돼있음.
            oos = new ObjectOutputStream(fos); // dataoutput 클래스에서는 여기서 new DataOutputStream(fos)로 선언. 뭔가 비슷한 구조긴 하다.
            oos.writeObject(m); // member m의 정보를 저장한다.

            fos.close();

            FileInputStream fis = new FileInputStream("object.bin");

            // 역직렬화 -> 아까 바이트 형태로 저장한 데이터를 다시 역직렬화로 입력받고 그것을 문자의 형태로 확인하는 과정 .
            ois = new ObjectInputStream(fis);
            m = (Member)ois.readObject();
            System.out.println(m);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

// 프로그램이 종료되면 안에 저장돼있던 내용들이 모두 사라진다
// 프로그램이 종료돼도 데이터를 외부에 저장할 수 있게 해준다.
// 문자를 한꺼번에 가지고 올 것이다
// 버퍼이용하는 클래스랑 파일객체를 사용하면된다.

// 데이터베이스 , 혹은 동영상, 혹은 이미지 , url을 이용해서 자바 프로그램을 실행시킬떄 종류가 다르다.
// 이진 파일들을 한꺼번에 가지고 오거나 저장할 때
// 버퍼 (기본자료형) DataStream 기본자료형 저장 가져오는 통로만들기
// 우리가 만든 클래스, 자바가  제공하는 클래스를 저장하는 방식
// ObjectStream 객체를 저장하고 가져오는 통료만들기