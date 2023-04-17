package Test;

public class PersonController {

    private Student []  s = new Student[3];
    private Employee [] e = new Employee[10];

    int[] personCount() {
        int[] count_list = new int[2];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] instanceof Student) { // null값이 아닐떄
                count_list[0] = ++count2;
            }
        }
        for ( int j = 0 ; j< e.length; j++){
            if (e[j] instanceof Employee) {
                count_list[1] = ++count2;
            }
        }
        return count_list;
    }
    void insertStudent(String name, int age, double height, double weight, int grade, String major){
        int length = personCount()[0];

        // student 리스트의 인덱스를 정하는 방법은 카운트의 0번쨰인 학생배열의 길이가 담긴
        // 정보를 넘기면서 그 참조변수의 세팅을 하는 것이다.
        s[length] = new Student( name,age,height,weight, grade,major);



    }

    Student [] printStudent(){
        return s;
    }

    void insertEmployee(String name, int age, double height, double weight, int salary, String dept){
        int length = personCount()[1];
         e[length] = new Employee( name,age,height,weight, salary, dept);

    }


    Employee [] printEmployee(){
        return e;
    }



}
