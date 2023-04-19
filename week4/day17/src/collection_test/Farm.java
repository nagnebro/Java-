package collection_test;

public class Farm {
    private String kind;

    Farm(){}

    public Farm(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Farm)){
            return false;
        }

        return super.equals(obj);
    }
}
