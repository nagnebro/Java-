package Generics;

public class Member {

    private String name;
    private String pass;
    private String p_name;


    Member(){}


    public Member(String name, String pass, String p_name) {
        this.name = name;
        this.pass = pass;
        this.p_name = p_name;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    @Override
    public String toString() {
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
