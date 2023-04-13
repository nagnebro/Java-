package Problem;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int i = 1;
        int num = 5;
        while(i<=num){
            if(i%2 == 0){
                System.out.println("짝");
            }else{
                System.out.println("홀");
            }
            i++;

        }
    }
}


class Ex2{
    public static void main(String[] args) {

        int i = 1;
        int num = 5;
        while(i<=num){
            if(i%2 == 0){
                System.out.println("짝");
            }else{
                System.out.println("홀");
            }
            i++;

        }
    }
}

class Ex3{

    public static void main(String[] args) {


        String [] str2 = {"a","b"};
        System.out.println(str2[0]=="a");
        Scanner sc = new Scanner(System.in);

        System.out.println("문자열 입력하세요");
        String str = sc.nextLine();
        System.out.println("검색할 문자를 입력하세요");
        String chr = sc.nextLine(); //
        String [] str_list = str.split("");
        System.out.println(Arrays.toString(str_list));
        System.out.println("chr의 주소 :" + System.identityHashCode(chr));
        System.out.println("a의주소 : "+System.identityHashCode("a"));
        System.out.println("str_list[0]의 주소 : " + System.identityHashCode(str_list[0]));
        System.out.println("chr hashcode : "+ chr.hashCode());


        System.out.println("str_list[0] hashcode : "+ str_list[0].hashCode());
        // 해쉬코드는 같으나 identituhashcode는 다르게 출력됨을 알 수 있다.즉. 주소는 다르다는 것.
        // 따라서 내가 new 연산자 없이 직접 생성한 문자열이 아닌 이상 계속 새로운 참조변수에 문자열을 저장시키는 듯.
        // 스캐너의 동작원리를 정확히는 모르겠으나 아래와 같이 스캐너로 새로운 문자열을 입력받으면 그때그떄 다른 주소가 나옴. 다른 객체라는 것.
        // 스캐너에서 입력받은 문자열의 저장원리는 "A"를 저장한다치면 'A\0'과 같은 형태로 저장된다
        // 자세히는 모르겠으나 일반적으로
        System.out.println( System.identityHashCode((sc.nextLine())));
        System.out.println( System.identityHashCode((sc.nextLine())));
        int count = 0;

        // =-======= 왜 스캐너로 입력받은 문자열과 여기서 선언한 문자열은 문자열의 값이 같아도 다르다고 나올까 심지어 주소값(정확히는 해시코드)도 같은데.
        for ( String tmp : str_list){

            if(tmp.equals(chr)){ // 왜 ==이걸로는 false지? 어차피 new String으로 생성안했으면 같은 주소를 갖고와야하는데.
                count++;
            }
        }
        System.out.printf("%s의 개수 : %d",chr,count);

        //이 방법말고 charAt으로 비교하면 됨 비교할떄 입력값 둘다 charAt으로 따야됨.
        /* - > 참고해서 적용해볼현
            System.out.println(System.identityHashCode(str1));
            System.out.println(System.identityHashCode(str2));

        System.out.println(str_list[0].hashCode()==chr.hashCode());
        String str3 = str_list[0];
        System.out.println(str3==chr);
        String str4= str_list[1];
        String chr2 = "abcdk";
        String ccc = new String("abcdk");
        System.out.println(ccc.hashCode());// 이 두개의 해쉬코드가 같다는 것부터 해쉬코드가 주소값을 뜻하지 않는다는 것을 증명한다
        System.out.println(chr2.hashCode()); // 그 이유는 실제로 비교연산자 ==로 eqauls 메서드를 이용해 비교하면 ccc와 chr2는 다른 값이라고
        // 나오기 때문이다. 그 뜻은 주소값이 다르다는건데 해쉬코드는 같게 나온다?
        String chr3  = "a";
        System.out.println(chr2==chr);
        System.out.println(chr2==chr3);
         */

    }
}

class Ex6{
    static int compare(String str){
        if(str.equals("가위")){
            return 0;
        }else if(str.equals("바위")){
            return 1;
        }else if(str.equals("보")){
            return 2;
        }
        return -1;
    }

    public static void main(String[] args) {

        String [] list = {"가위","바위","보"};
        int [] list2 = {0,1,2};
        Random r = new Random();
        int win = 0;
        int lose = 0;
        int draw = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            String result ="";
            int ran = r.nextInt(3);
            String com = list[ran]; // 0~2의 랜덤한 인덱스, 즉 가위바위보 리스트에서 랜덤을 뽑아옴.
            int comnum = compare(com);
            System.out.println("뭘 내실래요>");
            String mine = sc.nextLine();
            int minenum = compare(mine);
            if(mine.equals("exit")){
                System.out.printf("%d전 %d승 %d무 %d패 \n",count,win,draw,lose);
                break;
            }
            if(minenum == -1){
                System.out.println("다시입력하세요");
                continue;
            }
            switch(minenum - comnum){
                case -2: case 1:
                    result = "이겼다";
                    win+=1;
                    break;
                case 2: case -1:
                    result = "졌다";
                    lose-=1;
                    break;
                case 0:
                    result = "비겼다";
                    draw+=1;
                    break;
            }
            count++;
            System.out.printf("컴퓨터 : %s\n나 : %s\n%s\n",com,mine,result);
        }
    }
}