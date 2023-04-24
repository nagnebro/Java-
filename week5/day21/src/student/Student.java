package student;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;



public class Student {
    public ArrayList<Lecture> getL_list() {
        return l_list;
    }

    public void setL_list(ArrayList<Lecture> l_list) {
        this.l_list = l_list;
    }

    // 내가 구조화시킬줄 알아야한다.
    private String name;
    private String id;
    private String pw;
    private String phone;
    private int lecture_num;
    private ArrayList<Lecture> l_list = new ArrayList<>(); // 로그인한 학생의 강의 목록을 담아주는 리스트

    public Student(){

    }
    public Student(String name, String id, String pw, String phone) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.phone = phone;
    }

    public Student(String id, String pw) { // 로그인 시 db와 비교하기 위한 생성자.
        this.id = id;
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLecture_num() {
        return lecture_num;
    }

    public void setLecture_num(int lecture_num) {
        this.lecture_num = lecture_num;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Student)){
            return false;
        }
        Student s = (Student) obj;
        return s.id.equals(this.id) && s.pw.equals(this.pw);
    }

    public boolean equals(String name, String phone){ // 오버라이딩x 오버로딩, id pw를 찾기 위함.

        if(name.equals(this.name) && phone.equals(this.phone)){

            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("이름 : %-12s  ID : %-12s  PW : %-12s  Mobile : %-12s ",this.name, this.id, this.pw, this.pw);
    }
}
