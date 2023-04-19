package collection_test;

public class Fruit extends Farm{
    private String name;

    Fruit(){}


    public Fruit(String kind, String name) {
        super(kind);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
        if(!(obj instanceof Fruit)){
            return false;
        }
        Fruit f = (Fruit)obj;

        return this.name.equals(f.getName()) ? true : false;
    }

}
