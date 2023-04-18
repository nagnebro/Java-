package lotto;

public class Lottery {

    private String name;
    private String phone;

    Lottery(){}

    public Lottery(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)",this.name,this.phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Lottery l = (Lottery) obj;
        if(!(obj instanceof Lottery)){
            return false;
        }
        return l.getName().equals(this.name)&&l.getPhone().equals(this.phone);

    }
}
