package collection_test;

public class Vegetable extends Farm{
    private String name;

    Vegetable(){}

    public Vegetable(String kind, String name) {
        super(kind);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
