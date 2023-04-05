package Print;

import java.awt.*;

public class Samung implements Print{
    @Override
    public void print(String p) {
        System.out.println("상성 프린터");
    }


}

// 인터페이스에서 추가 기능이 계속 생겨날때는 클래스에 계속 인터페이스를 구현하는 식으로 진행할 수는 없으니까 인터페이스끼리 상속하는 방법을 채택해야 한다.

// 상속의 문제점은 기능이 추가되거나 삭제될때 기존의 값들을 처리하는 것이 까다로운 것이다.

// 예를 들자면 흑백 프린트 기능만 제공하는 삼성의 프린터가 있다고 하자. 그 프린터는 흑백 Print기능만 제공하는 Print를 구현한다. 이때 Print에 칼라출력이
// 가능한 기능이 생겼다고 했을 때 Print 인터페이스에 칼라 기능을 추가한다면 기존의 Samsung 클래스를 이용하고 있던 사람은 칼라 기능을 사용할 수도 없는
// 프린트기에서 칼라기능을 가져야한다는 뜻인데 애초에 말이 안되는 조건이다. 따라서 다른 방법으로 칼라기능을 추가해줘야 한다. 이후에는 칼라기능 뿐만 아니라
// 수많은 기능이 계속 추가될것이기 때문이다. 기존의 사용자와 겹치지 않게끔 칼라기능을 추가한 ColorPrint 인터페이스를 생성하는데 이떄 이 인터페이스는 기존의
// 흑백기능을 제공하는 Print를 상속했다. 즉 칼라와 흑백의 기능을 둘다 가진 이 인터페이스를 새롭게 만든 SamsungColor에 구현해주면 되는 것이다.
class SamsunColor implements ColorPrint {
    @Override
    public void color(String p) {

    }

    @Override
    public void print(String p) {

    }
}

class Sam3D implements Print3D  {
    @Override
    public void color(String p) {

    }

    @Override
    public void print(String p) {

    }

    @Override
    public void three_d(String p) {

    }
}