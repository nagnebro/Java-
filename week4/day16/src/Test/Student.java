package Test;

public class Student extends Person{

    private int grade;
    private String major;

    Student(){}

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }



    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(name, age, height, weight);
        this.grade = grade;
        this.major = major;
    }

    @Override
    public String toString() {

        return super.toString() + String.format("grade : %d major : %s",grade,major);
    }
}
