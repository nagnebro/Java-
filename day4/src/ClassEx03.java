class Poketmon{
    //포켓몬정보

    //생성자의 특징
    //1. 리턴 타입이 없는 메서드
    //2. 이름이 클래스명과 같다.
    Poketmon(){
        //기본생성자, 모든 생성자에는 super();가 생략돼있다.
    }
    String name;
    float weight; // float타입은 리터럴에 일일히 접미사 f를 붙여줘야하기 떄문에 귀찮으나 메모리 낭비는 덜하다.
    String charact;

    Poketmon(String name, float weight, String charact){ // 기본 생성자는 항상 생략돼있다. 그러나 생성자 하나라도 생성하게 되면 기본 생성자는 생성되지 않는다. 즉 매개변수를 받는
        //생성자만 생성하게 되면 인자값없이 인스턴스를 생성할 때 기본 생성자가 없기 때문에 에러가 발생한다.
        System.out.println(this.name);
        this.name = name;
        this.weight = weight;
        this.charact = charact;
    }
    Poketmon(String _name, float _weight){
        this(_name,_weight,"노랗다");
        System.out.println(this.name);
        System.out.println(name);
        System.out.println(name); // 매개변수명 앞에 언더바를 사용시 매개변수와 지역변수를 구분할 수 있다. 위 코드를 보면 매개변수와
        //인스턴스 변수의 이름이 같으면 매개변수의 값이 우선적으로 사용되는 것을 알 수 있다. 이를 구분하기 위해서는 참조변수를 가르키는 this를
        //사용하던지 이와같이 언더바를 사용해 구분해주면 된다.
        name = _name;
        weight = _weight;
    }

    void attack(){
        System.out.println("펀치~");
    }
    void inform(Poketmon p){
        System.out.println(p.name);
        System.out.println(p.weight);
        System.out.println(p.charact);
    }
}

public class ClassEx03 {
    public static void main(String [] args){

        //생성자
        // -객체를 만드는 특별한 메서드

        //역할
        //-객체 생성(객체를 만드는 것)
        //-객체의 필드(변수) 값을 설정하는 것!
        //즉 생성자에 인자를 집어넣어 클래스 내부의 생성자의 매개변수로 들어옴으로서 인스턴스 변수의 초기화가 가능하다는 것.
        Poketmon p = new Poketmon("푸린이",4.4f,"귀엽다");
        // Poketmon p1 = new Poketmon(); 기본 생성자가 생성되지 않았기 때문에 따로 생성해주지 않으면 컴파일 에러 발생.
        p.inform(p);
        Poketmon p2 = new Poketmon("피카츄",5.5f);
        p2.inform(p2);

        //1. new 연산자를 통해 참조변수를 생성하게 되면 메모리 공간의 힙 영역이 생기게 된다.
        //2. 이 때 생성자를 호출하며 생성자의 매개변수에 맞게 초기화를 진행한다.
        //3. ()괄호안에 값이 있으면 원하는 값으로 초기화를 진행한다. ()괄호 안에 값이 없으면 기본값으로 초기화를 진행한다.
        //4. 만들어진 객체가 어딨는지 주소값을 부여하고
        //5.


    }
}
