package collection_test;

public class Nut extends Farm{
    private String name;
    Nut(){}

    public Nut(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nut(String kind, String name) {
        super(kind);
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s : %s",this.getKind(),this.name);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Nut)){// 이 조건을 추가한 다음에 아래에서 obj를 캐스팅 해줘야한다.
            // 일단 서로 캐스팅 될 수 없는, 즉 조상 자손관계가 아닌 인스턴스가 들어왔을떈 바로 내보내야하낟. 이후의
            // 프로그램에서 꼬이기 때문이다.
            return false;
        }
        Nut f = (Nut)obj;
        return this.name.equals(f.getName()) ? true : false;

    }

}
