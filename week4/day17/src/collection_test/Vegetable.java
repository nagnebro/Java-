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
        return String.format("%s : %s",this.getKind(),this.name);
    }
    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Vegetable)){
            return false;
        }
        Vegetable f = (Vegetable) obj;
        return this.name.equals(f.getName()) ? true : false;
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
