

public class Student {

    // 컴파일 시에 미리 메모리에 선언이 되고
    // 명령문은 삭제 된다. 즉 static int count = 1이라는 명령문이 삭제된다.
    // 인스턴스 변수가 생길때마다 굳이 count라는 변수를 계속 생성할 이유가 없기 때문. 어차피 공통의 변수이기 때문에
    // 한개 생성한 후에 삭제된다는 뜻.
    static int count=1; // 클래스 변수
    int id ; // 인스턴스 변수
    String name; // 인스턴스 변수

    public String toString(){  // public을 쓰지 않으면 오버라이딩 하는 조상의 메서드보다 접근제어자의 범위가 좁기 때문에 항상 선언해줘야한다.
        return "id : "+id+" name : "+name;
    }
    Student(int id,  String name){
        this.id = id;
        this.name = name;
    }


}

class StudentTest{
    public static void main(String[] args) {
        Student [] s = new Student[5];
        s[0] = new Student(Student.count++,"김영찬1");
        s[1] = new Student(Student.count++,"김영찬2");
        s[2] = new Student(Student.count++,"김영찬3");
        s[3] = new Student(Student.count++,"김영찬4");
        s[4] = new Student(Student.count++,"김영찬5");
        for (Student stu : s){
            System.out.println(stu);
        }
    }
}