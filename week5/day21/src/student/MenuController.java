package student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MenuController {

    Scanner sc = new Scanner(System.in);

//    private ArrayList<Student> ss_list = new ArrayList<>();
    private static HashMap<Student, ArrayList<Lecture>> s_list = new HashMap<>();// 굳이 hashset을 쓸 필요가 없었을 것 같긴하다. 어차피
    // 인스턴스를 저장하는 거라 중복을 제거하지도 못해서.
    ArrayList<String> subject_list = new ArrayList<>(Arrays.asList("파이썬", "자바", "C", "HTML"));



    void booting(){


        FileReader fr = null;
        BufferedReader br = null;
        String str;
        String [] idpw = new String[2];

        try{
            fr = new FileReader("user");
            br = new BufferedReader(fr);

            while((str = br.readLine()) != null){
                idpw = str.split("/");// 인덱스 0번은 id, 1번은 pw이다,
                Student stu = new Student(idpw[0],idpw[1],idpw[2],idpw[3]);
                s_list.put(stu,null);
            }
        }catch(IOException e){

        }
        System.out.println("DB연동이 완료됐습니다.");
    }


    Student login(Student loginStu) {

        for (Student s : s_list.keySet()) {
            if (s.equals(loginStu)) { // id와 비번이 같으면 true 반환하게끔 메서드 오버라이딩.
                return s;
            }
        }
        return null;
    }


    boolean checkDB(String id){

        String str;
        FileReader fr = null;
        BufferedReader br = null;
        String [] idpw = new String[4];

        for(Student s : s_list.keySet()){

            if(s.getId().equals(id)){
                return true;

            }
        }
        return false;
    }


    boolean signUp() {
        System.out.print("이름을 입력하세요");
        String name = sc.next();
        boolean res = true;
        String id = null;
        while (res) {
            System.out.print("아이디를 입력하세요"); // 아이디를 입력하자말자 바로 기존에 존재하는 아이디라고 하는편이 낫긴하다.
            id = sc.next();
            res = checkDB(id);
            if(res) System.out.println("기존에 존재하는 아이디입니다. 다시입력하세요.");
        }
        System.out.print("패스워드를 입력하세요");
        String pw = sc.next();
        System.out.print("폰번호를 입력하세요");
        String phone = sc.next();


        Student s = new Student(name, id, pw, phone);
        s_list.put(s,null); // 학생정보 리스트에 가입정보를 추가
        // 학생정보를 담고있는 txt파일에 가입정보를 작성

        FileWriter fw = null;

        try{
            fw = new FileWriter("user",true);
            fw.write(name+"/"+id+"/"+pw+"/"+phone+"\n");
            System.out.println("db에 가입정보가 저장됩니다.");
            fw.close();

        }catch(IOException e){

        }
        return true;

    }

    Student findId(String name, String phone) {

        for (Student s : s_list.keySet()) {

            if (s.equals(name, phone)) { // 학생 db에 입력한 이름과 휴대폰번호를 가진 학생이 있으면 해당 학생의 객체를
                // 돌려주고 호출메서드에서 이름과 비밀번호를 출력하게끔한다.
                return s;
            }
        }
        return null;
    }


    Student findpw(String id, String phone) {

        for (Student s : s_list.keySet()) {

            if (s.getId().equals(id) && s.getPhone().equals(phone)) { // 학생 db에 입력한 이름과 휴대폰번호를 가진 학생이 있으면 해당 학생의 객체를
                // 돌려주고 호출메서드에서 이름과 비밀번호를 출력하게끔한다.
                return s;
            }
        }
        return null;
    }

    void sortedSubject(Student s){

        for( int i = 0 ; i < s_list.get(s).size(); i++){
            for( int j = 0; j < s_list.get(s).size()-1 ; j++){

                if(s_list.get(s).get(j).hashCode()>s_list.get(s).get(j+1).hashCode()){ // 왼졲값이 오른쪽 값보다 크다면, Lecture클래스에서 hashcode 오버라이딩.
                    Lecture l = s_list.get(s).get(j);
                    s_list.get(s).set(j,s_list.get(s).get(j+1));
                    s_list.get(s).set(j+1,l);

                }

            }
        }
    }

    void addLecture(Student s){
        ArrayList<Lecture> l_list = s.getL_list();

         dan : while(true) {

            System.out.print("1. 수강 과목조회  2. 수강 신청 3. 수강 철회 4. 로그아웃 ");
            int input = sc.nextInt();
            int count = 1;

            if (input == 1) {
                if(s_list.get(s)==null) {
                    System.out.println("수강 신청 현황이 없습니다.");
                    continue;
                }
                System.out.printf("수강 신청 현황은 다음과 같습니다 \n");
                sortedSubject(s);
                for ( Lecture l : s_list.get(s)){

                    System.out.println(l);
                }

            } else if (input == 2) {

                System.out.println("신청하고 싶은 과목을 선택하세요.");
                for( String str : subject_list){
                    System.out.println(count++ +". " + str); // 과목 현황을 보여주는 메서드
                }
                int subject_num  = sc.nextInt();

                if(s_list.get(s)!=null) {
                    for (Lecture l : s_list.get(s)) {

                        if (l.getSubject().equals(subject_list.get(subject_num - 1))) {
                            s_list.remove(l);
                            System.out.println("기존에 수강신청된 과목입니다");
                            continue dan;
                        }
                    }
                }
                try {

                    l_list.add(new Lecture(subject_list.get(subject_num - 1)));

                    s_list.put(s,l_list);
                    System.out.println("수강신청이 완료됐습니다."); // TreeSet이라서 어차피 중복해서 신청 안된다. 출력을 다르게 하고 싶으면
                    //add메서드의 결과값 boolean타입을 이용해 출력하면된다.
                    continue;

                    // 인덱스번호를 벗어난 숫자가 입력시 에러발생할 수 있기 떄문에 예외처리.


                }catch(Exception e){
                    System.out.println("수강번호를 제대로 입력하세요");
                }

            } else if (input == 3) {

                System.out.printf("제거 가능한 강의 목록은 다음과 같습니다 \n");

                for ( Lecture l : s_list.get(s)){
                    System.out.println(l);
                }
                System.out.println("제거할 강의명을 입력하세요.");
                String sub_name = sc.next();

                for ( Lecture l : s_list.get(s)){
                    if(l.subject.equals(sub_name)){
                        System.out.println(l + "강의가 제거 완료됐습니다");
                        s_list.get(s).remove(l);
                        continue dan;
                    }

                }
                System.out.println("제거하려는 강의가 없습니다.");
            }else if( input == 4){

                System.out.println("초기화면으로 돌아갑니다");
                return;
            }
        }
    }

    void addSubject(){

        System.out.println("현재 수강과목은 다음과 같습니다.");
        for(String str : subject_list){
            System.out.println(str);
        }
        System.out.print("추가, 삭제하실 강의명을 입력하세요 (기존에 있는 강의라면 삭제되고 없는 강의라면 추가됩니다.");
        String input = sc.next();

        for( String str : subject_list){
            if(str.equals(input)){
                System.out.println(str+ " 과목이 삭제됐습니다.");
                subject_list.remove(str);
                return;
            }

        }
        System.out.println(input + " 과목이 추가됐습니다");
        subject_list.add(input);

    }

    void checkStudent(){

        for(Student s : s_list.keySet()){
            System.out.print(s);
            if(s_list.get(s)==null) {
                System.out.println("미신청");
                continue;
            }
                for (Lecture l : s_list.get(s)) {
                    System.out.print(l);
                }

            System.out.println();
        }

    }
}




// 텍스트에서 유저정보를 갖고오게 되면 다음id pw찾기를 할떄도 마찬가지로 거기서 찾아야한다.
