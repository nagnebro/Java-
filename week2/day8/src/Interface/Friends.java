package Interface;

interface Friends{
    void friend();
}
class Job{  /// 인터페이스 생성 안하고 그냥 이 클래스에 인터페이스의 friend()메서드
    //정의하면 편하긴 하지만 어차피 이름까지 같이 출력하려면 결국 오버라이딩 하긴 해야하고.
    String name;

    Job(){}
    public Job(String name) {
        this.name = name;
    }
}


class Musician extends  Job implements Friends{


    public void friend(){
        if(this instanceof Friends){
            System.out.println("뮤지션"+name+"친구아이가~");
        }
    }

    public Musician(String name) {
        super(name);
    }
}
class Structurer extends Job implements Friends{
    public void friend(){
        if(this instanceof Friends){
        System.out.println("건축가"+name+"친구아이가~");
     }
    }

    public Structurer(String name) {
        super(name);
    }
}
class Developer extends Job implements Friends{
    public void friend(){
        if(this instanceof Friends){
            System.out.println("개발자"+name+"친구아이가~");
        }
    }

    public Developer(String name) {
        super(name);
    }
}
class Lawer extends  Job implements Friends{
    public void friend(){
        if(this instanceof Friends){
            System.out.println("변호사"+name+"친구아이가~");
        }
    }

    public Lawer(String name) {
        super(name);
    }
}

class FriendsTest {
    public static void main(String[] args) {
        Musician m = new Musician("이씨");
        Structurer s = new Structurer("최씨");
        Developer d = new Developer("김씨");
        Lawer l = new Lawer("박씨");
        m.friend();
        s.friend();
        d.friend();
        l.friend();


    }
}
