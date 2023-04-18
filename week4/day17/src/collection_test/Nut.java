package collection_test;

public class Nut extends Farm{
    private String name;
    Nut(){}

    public Nut(String name) {
        this.name = name;
    }

    public Nut(String kind, String name) {
        super(kind);
        this.name = name;
    }

    @Override
    public String toString() {
        return "tost";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
