package Exception;

class MyException extends Exception{

    String str1;

    public MyException(String str2){
        str1 = str2;
    }

    @Override
    public String toString() {
        return "My Exception 발생" + str1;
    }
}



public class DefineException {
    //		사용자가 새로운 예외 클래스를 만들어서 이용할 수 있는 방법
//		 java.lang 패키지의 Exception 예외 클래스를 상속받아 작성
//		사용자 정의 예외 클래스에 대한 생성자를 정의하고(필수는 아님)
//		 toString() 메서드를 재정의하여 catch 블록에서 사용자 정의 메시지를 표시할 수 있음
//		사용자 정의 예외 클래스를 만들고 throw 키워드로 예외를 발생시켜 호출함
    public static void main(String[] args) {
        try {
            System.out.println("try 블럭입니다");
            throw new MyException("MyException 클래스가 호출됩니다"); // 생성자가 호출되며 에러메시지를 전달한다.
            // 이것은 우리가 그냥 메시지를 보기 위해 인자로 전달했을 뿐이고 애초에 생성자 매개변수도 없어도 된다. 단지 throw
            // 다음에는 예외 클래스의 인스턴스가 생성돼야 예외가 발생한다는 것이다.
            // throw는 일부러 예외를 발생시켜주는 예약어이다. 그 떄 예외를 발생시킬 클래스의 타입을 지정해주어야 하고
            // 모든 예외의 최고 조상인 Exception 클래스를 상속받은 MyException의 타입으로 선언. 이렇게 되면 catch문에서는
            // MyException 타입의 참조변수로 예외를 받아줘야 한다.
        } catch (MyException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}

