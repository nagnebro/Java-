package Problem;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayTest {
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();


    public static void practice1(int[] list){


        for (int i = 0; i < list.length; i++) {
            list[i] = i+1;
            System.out.println(list[i]);
        }
    }

    public static void practice2(){
        int[] list = new int[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = 10-i;
            System.out.println(list[i]);
        }

    }

    public static void practice3(){
        sc = new Scanner(System.in);
        System.out.println("숫자 입력");
        int size = sc.nextInt();
        int [] list = new int [size];
        practice1(list);
    }

    public static void practice4(){
        String [] list = new String[5];
        list[0]="사과";
        list[1]="귤";
        list[2]="포도";
        list[3]="복숭아";
        list[4]="참외";
        System.out.println(list[1]);

    }
    public static void practice5(){
        sc = new Scanner(System.in);
        int count = 0;
        String idx = "" ;
        System.out.println("문자열 입력");
        String str = sc.nextLine();

        System.out.println("문자 입력");
        String chr = sc.nextLine();

        for ( int i = 0 ; i < str.length(); i++){
            if( str.charAt(i) == chr.charAt(0)){
                count ++;
                idx+= " "+i;
            }
        } System.out.printf("%s에 %s가 존재하는 개수 : %s \n",str,chr,idx);
        System.out.println(chr+"의 개수  : "+count);

    }
    public static void practice6(){
        // 문제가 이상하다. 쉽기도하고 생략.

    }

    public static void practice7(){


        System.out.print("정수입력");
        int leng = sc.nextInt();
        int [] list = new int[leng];
        int sum = 0;

        for(int i = 0 ; i<list.length; i++){
            System.out.printf("배열 %d번째 인덱스에 넣을 값",i);
            list[i] = sc.nextInt();
            sum += list[i];
        }
        System.out.println(Arrays.toString(list));
        System.out.println("총합 : "+sum);



    }
    public static void practice8(){
        int input;
        sc = new Scanner(System.in);
        System.out.println("정수입력 : ");
        while((input = sc.nextInt())<3 || input%2==0 ){
            System.out.println("다시입력 : ");
        }
        int [] list = new int[input];
        int j = 1;
        for(int i = 0 ; i< input; i++){
            if(i>input/2){
                list[i] = i- j;
                j+=2;
                System.out.println(j);
                continue;
            }
            list[i] = i+1;
        }
        System.out.println(Arrays.toString(list));
    }



    public static void practice9(){

        String [] c_list = {"양념","후라이드","불닭","스노잉"};
        Scanner sc = new Scanner(System.in);


        System.out.print("치킨 이름을 입력하세요");
        String input = sc.nextLine();

        for(int i = 0; i<c_list.length ; i++){
            if(input.equals(c_list[i])){
                System.out.println(input+"치킨 배달 가능");
                break;
            }else if(c_list.length-1 == i){
                System.out.println(input+"치킨은 없는 치킨입니다.");
            }

        }


    }
    public static void practice10(){

        String [] id = {"1","2","3","4","5","6","-","2","1","3","4","5","6"};
        String [] id_copy = new String[id.length];
        String id2 = "123456-1234567";
        //System.arraycopy ,  Arrays.copyOf , clone();

        for(int i = 0; i<id.length;i++){

            if (i>7){

                id_copy[i]=new String("*");
                System.out.print(id_copy[i]);
              continue;


            }
            id_copy[i] = id[i];
            System.out.print(id_copy[i]);


        }
        System.out.println(Arrays.toString(id_copy));
    }

    public static void practice11(){


        int [] list = new int[10];



         for ( int i = 0 ; i<list.length; i++){
             int ran = r.nextInt(10)+1;
            list[i] =ran;

        }


//        for (int i = 0; i<10; i++){
//            System.out.println(i);
//            if(i<5){
//                i-=1;
//            }
//        }
        System.out.println(Arrays.toString(list));
    }
    public static void practice12(){
        int [] list = new int[10];

        int max = 0, min = 0;

        for ( int i = 0 ; i<list.length; i++){
            int ran = r.nextInt(10)+1;
            if(i == 0){min = ran;}
            list[i] =ran;
            max = ran>max ? ran : max;
            min = ran<min ? ran : min;

        }

        System.out.println(Arrays.toString(list));
        System.out.println(max+" \n"+min);
    }
    public static void practice13(){
        int [] list = new int[10];

        int max = 0, min = 0;
        int ran = 0;
        int tmp = 0;
        int count = 0;



        for (int i = 0 ; i<list.length; i++) {
            ran = r.nextInt(45) + 1;
            for (int j = 0; j <= i; j++) {
                if (ran == list[j]) {
                    count =1;
                    break;
                }
            }
            if(count ==1){
                i-=1;
                count = 0;
                continue;
            }
            list[i]=ran;
        }

        System.out.println(Arrays.toString(list));
        }



    public static void practice14(){
        int [] list = new int[10];

        int num = 0;
        int ran = 0;
        int count = 0;
        for (int i = 0 ; i<list.length; i++) {
            ran = r.nextInt(10) + 1;
            for (int j = 0; j <= i; j++) {
                if(count==1){
                    j=0;
                    count=0;
                }
                if (ran == list[j]) {
                    count=1 ;// 같으면 안쪽 for문의 반복에 사용되는 j값을 0으로 만들면서 무한반복.
                    // continue; else if 문이라 의미없고.
                    ran = r.nextInt(10) + 1;
                } else if (j == i) { // 마지막 요소를 검사하고 난 후, 즉 i = j일떄 모든 요소가 다르다는 조건이
                    // 성립하는 상황이므로 그 떄 i인덱스에 난수를 저장시켜준다.
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }



    public static void practice15(){

        System.out.println("문자열을 입력하세요");
        String input = sc.nextLine();

        String [] input_list = input.split("");
        String [] answer_list = new String[input.length()];
        int count = 0;
        int check = 0;

        for (int i = 0; i < input_list.length; i++){
            for(int j = 0; j<=i ; j++){
                if(input_list[i].equals(answer_list[j])){
                    check = 1;
                    count++;
                    break;
                }

            }
            if(check ==1){

                check= 0;
                continue;
            }
            answer_list[i-count] = input_list[i];


        }
        System.out.println(Arrays.toString(answer_list));
        System.out.println("문자개수 : "+((answer_list.length)-count));

    }

    public static void practice16(){

        System.out.println("배열 길이 입력하세요");
        int input = sc.nextInt();
        String [] list = new String[input];
        String [] list2 ;
        int count = 0;



        while(true){
            while(count<list.length){ // 처음에는 사용자가 입력한 값. 그다음부터는 밑에서 입력한값으로 다시 돌려줌.
                System.out.printf("%d번쨰 문자열 :",count +1);
                String book = sc.next();
                list[count] = book;
                count++;
            }
            System.out.println("값을 더 입력하시겠습니까?");
            String input2 = sc.next();
            if(input2.equals("n")){
                System.out.println(Arrays.toString(list));
                break;
            }
            else if(input2.equals("y")){
                System.out.print("더입력하고싶은 개수");
                input = sc.nextInt();
                list2 = list.clone();
                list = new String[list.length+input]; // <<에러발생가능성.
                for(int i = 0; i < list2.length ; i++){
                    list[i] = list2[i]; // 복제된값을 다시 기존 배열로 넘겨줌. 추가 입력한만큼 길이가 늘어나ㅇ있는 상태.
                }


                // list2 = new String[list.length+input];
            }


        }

    }
    public static void main(String[] args) {
        //practice1();
        //practice2();
        //practice3();
        //practice4();
        //practice5();
        //practice7();
        //practice8();
        //practice9();
//        practice10();
//        practice11();
//        practice12();
//        practice13();
        practice14();
//        practice15();
//        practice16();
    }
}
