package student;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Lecture {

    String subject;
    String time;
    LocalDateTime now = LocalDateTime.now();


    public Lecture(String subject) {
        this.subject = subject;
        this.time = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
    }

    public Lecture(){}

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return subject +" | "+ time + " | ";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {

        String [] s_list = this.subject.split("");
        return s_list[0].hashCode();

    }
}
