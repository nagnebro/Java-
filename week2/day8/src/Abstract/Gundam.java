package Abstract;

public abstract  class Gundam {


    // 강제성이 있는 메서드 > 자손에서 필수적으로 오버라이딩 해야하는 조상의 추상 메서드
    abstract void hand();
    abstract void leg();

    // 비강제성 => 자손에서 굳이 오버라이딩 하지 않고 사용해도 무관한 메서드
    void arm(){}
    void chest(){}
}

class GundamUser extends Gundam{
    void hand(){}
    void leg(){}
}
