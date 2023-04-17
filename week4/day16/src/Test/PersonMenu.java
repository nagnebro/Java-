package Test;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class PersonMenu {

    private Scanner sc = new Scanner(System.in);
    private PersonController pc  = new PersonController();

    void mainMenu() {

        int input;


        while (true) {
            System.out.println("학생은 최대 3명까지 저장할 수 있습니다");
            System.out.println("현재 저장된 학생은" + pc.personCount()[0] + "명 입니다.");
            System.out.println("사원은 최대 10명까지 저장할 수 있습니다");
            System.out.println("현재 저장된 사원은" + pc.personCount()[1] + "명 입니다.");

            System.out.println("1. 학생 메뉴");
            System.out.println("2. 사원 메뉴");
            System.out.println("9. 끝내기");
            System.out.print("메뉴 번호 : ");
            input = sc.nextInt();
            if (input == 1) {
                studentMenu();
            }
            if (input == 2) {
                employeeMenu();
            }
            if( input == 9){
                System.out.println("종료합니다.");
                break;
            }

        }
    }
    void studentMenu() {
        int input;

         do{
            System.out.println("1. 학생 추가");
            System.out.println("2. 학생 보기");
            System.out.println("9. 메인으로");
            System.out.print("입력하세요");
            input = sc.nextInt();
            if (input == 1) {
                    insertStudent();
            }
            if (input == 2) {
                printStudent();
            }
        }while (input != 9);
        System.out.println("종료합니다");
    }






    void employeeMenu(){
        int input;
        do{
            System.out.println("1. 사원 추가");
            System.out.println("2. 사원 보기");
            System.out.println("9. 메인으로");
            System.out.print("입력하세요");
            input = sc.nextInt();
            if (input == 1) {
                insertEmployee();
            }

            if (input == 2) {
                printEmployee();
            }
        } while( input != 9);
        System.out.println("종료합니다");
    }


    void insertStudent(){
        while(true) {
            if(pc.personCount()[0] == 3){
                System.out.println( "학생을 담을 수 있는 공간이 꽉 찼기 때문에 메뉴로 다시 돌아갑니다.");
                break;
            }
            System.out.println("학생 이름 : ");
            String name = sc.next();
            System.out.println("학생 나이 : ");
            int age = sc.nextInt();
            System.out.println("학생 키 : ");
            double height = sc.nextDouble();
            System.out.println("학생 몸무게 : ");
            double weight = sc.nextDouble();
            System.out.println("학생 학년 : ");
            int grade = sc.nextInt();
            System.out.println("학생 전공 : ");
            String major = sc.next();
            pc.insertStudent(name, age, height, weight, grade, major);
            if( pc.personCount()[0] == 3){
                System.out.println( "학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상 활성화 되지 않습니다.");
                break;
            }
            System.out.println("그만 하시려면 n또는 N을 입력하세요");
            String input = sc.next();
            if(input.equalsIgnoreCase("n")){break;}
        }
    }

    void printStudent(){
        Student [] s = pc.printStudent();
        int length =  pc.personCount()[0];
        for(int i = 0; i<length ; i++){
            System.out.println(s[i]);
        }
    }


    void insertEmployee(){
        while (true){
            if(pc.personCount()[1] == 10){
                System.out.println( "사원을 담을 수 있는 공간이 꽉 찼기 때문에 메뉴로 다시 돌아갑니다.");
                break;
            }
            System.out.println("사원 이름 : ");
            String name = sc.next();
            System.out.println("사원 나이 : ");
            int age = sc.nextInt();
            System.out.println("사원 키 : ");
            double height = sc.nextDouble();
            System.out.println("사원 몸무게 : ");
            double weight = sc.nextDouble();
            System.out.println("사원 급여 : ");
            int grade = sc.nextInt();
            System.out.println("사원 부서 : ");
            String major = sc.next();

            pc.insertEmployee(name, age, height, weight, grade, major);
            if( pc.personCount()[1] == 10){
                System.out.println( "사원을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상 활성화 되지 않습니다.");
                break;
            }
            System.out.println("그만 하시려면 n또는 N을 입력하세요");
            String input = sc.next();
            if(input.equalsIgnoreCase("n")){break;}
        }
    }
    void printEmployee(){
        Employee [] e = pc.printEmployee();
        int length =  pc.personCount()[1];
        for(int i = 0; i<length ; i++){
            System.out.println(e[i]);
        }
    }
}

