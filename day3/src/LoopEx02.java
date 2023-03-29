import java.util.Scanner;
public class LoopEx02 {
    public static void main(String [] args){
        int j = 0;
        for( ; j<10; j++){
            System.out.println(j);
        }
        System.out.println("j는" + j); // 여기서 j는 for문 내부에서만 유효한 변수가 아닌 메인 메서드 내의 지역변수로서 유효한 값임을
        //확인할 수 있음.

        // if 문 먼저 혹시 switch문 바꿔서 작성 가능하면 해라
        // 뭘 입력 받는다.
        // 3~5월까지는 봄
        // 6~8월 까지는 여름
        // 9~11월 까지는 가을
        // 12월~2월 겨울
        // 무한 루프로 입력받다가 99숫자를 입력하면 프로그램 종료!
        // 단 1~12 외에 숫자를 입력하면 "월을 잘못 입력했습니다"라고 출력


        // 아래 프로그램의 문제점은 정수가 아닌 실수가 입력값으로 들어올 시 런타임 에러가 발생할 수 있다는 것.
        // 그러나 그건 if문의 범위설정과는 관계없이 애초에 잘못된 값이 들어온 것이 근본적인 이유이기 때문에 내가 짠 if문의 조건과 에러발생과는 관련없음

        Scanner sc = new Scanner(System.in);
        int input = 0;
        String weather = "" ;
        for (;;){ // for문 무한루프
            System.out.printf("월을 입력하세요 : ");
            input = sc.nextInt();
            if(3<=input && input<=5){
                weather = "봄";
            }else if(6<=input && input<=8){
                weather = "여름";
            }else if(9<= input && input<= 11){
                weather = "가을";
            }else if(12== input || (1<=input&&input<=2)){
                weather = "겨울";
            }else if(input == 99){
                System.out.println("종료합니다");
            }else{
                System.out.println("제대로 입력하세요");
                continue;
            }
            System.out.printf("선택하신 계절은 %s입니다 \n",weather);

        }//main의 끝

    }
}

class LoopEx03{
    public static void main(String [] args){

        int input = 0;
        String weather = "";
        Scanner sc = new Scanner(System.in);
        boolean exit = true; // Dan: 루프문 탈출을 사용할 것이 아니라면 exit에 false값 주고
        //switch문 바깥에 조건문에서 exit값 판별하고 루프문 break하면 제일 깔끔하고
        // 조건문 1개를 추가하기가 껄끄러우면 while문에 직접 true를 선언하는 것이 아닌 exit값을 넣고 다음 루프때
        // 조건식에서 종료되게 해도 괜찮으나 프린트문이 case문 바깥에 있기 떄문에 종료되기 전에 한번은 출력이 되게 돼있음.
        // 즉 처음 종료하게 되면 빈 문자열이 출력되고 그 이후에는 이전에 담겨있던 계절의 값이 문자열에 담겨있음.
        Dan : while(true){
            System.out.printf("월을 입력하세요 : ");
            input = sc.nextInt();
            // jdk 버전 11이전의 경우 switch문의 매개변수로 실수값을 사용하지 못하고 정수값만 가능했었다. 또한 표현식 역시 case1: case2:의
            // 형태로 사용이 가능했었으나 12버전부터는 case 1,2,3과 같이 사용 가능해졌음.
            // 14버전 이상부터는 yield라고해서 switch문에서 반환값을 가질 수 있게 됐음. 궁금하면 찾아볼 것.
            switch(input){
                    case 3,4,5: weather = "봄";
                    break;
                    case 6,7,8: weather = "여름";
                    break;
                    case 9,10,11 : weather = "가을";
                    break;
                    case 12,1,2 : weather = "겨울";
                    break;
                    case 99 : System.out.println("종료합니다");
                    break Dan;
                    default : System.out.println("제대로 입력하세요"); //if문의 else같은 존재
                    continue;




            }   System.out.printf("선택하신 계절은 %s입니다 \n",weather);
        }
    }
}
