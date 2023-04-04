import java.util.Arrays;
import java.util.Random;

public class JavaAPI {
    public static void main(String[] args) {
        /*
            자바 API
            - 프로그램을 만들기 위한 도구!
            - 이를 사용하면 더 편리한 프로그래밍이 가능하다.
            - 자바 API 패키지로 제공된다.

            패키지란?
            - 디렉토리 (폴더)  >> 패키지를 이 패키지에 담아서 관리한다.

            역할
            - 관련 코드들을 하나로 묶어서 관리를 수월하게 한다. ?? 그러니까 특정한 기능을 제공하는 어떠한 소스 코드의 프레임을 뜻하는건지?
            - 사용자가 각기 다른 플랫폼에서 어떤 특정한 지도 기능을 제공하는 API를 다운받았다고 했을 때 네이버, 카카오, 구글에서 제공하는 API는
            - 모두 기능이 다를 것이다. 이 때 클래스 이름이나 여러가지가 중복돼 충돌될 위험이 있으므로 패키지나 디렉토리로 구분을 시켜준다.

            Random클래스의 nextInt를 사용하는 것과 Scanner클래스의 nextInt를 사용하는 것이 완전히 다른 기능의 메서드를 제공하기 위해서
            이렇게 패키지나 디렉토리를 이용해 계층화를 시켜주는 것이다.

            import
            - 객체의 위치를 컴파일러한테 알려준다.


         */

        //Math 클래스

        Random r= new Random();

        int a1 = r.nextInt();
        double a2 = r.nextDouble();
        boolean a3 = r.nextBoolean();

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}


class Dice{
    /*
    주사위를 100번 던질 것!
    1~6사이에 숫자가 몇번씩 나왔는지 출력.

    배열 이용
    100번을 던지고 나면
    1개수:2
    2개수:0
    3개수:50
    4개수:10
    등의 형태로 출력하기
 */

    public static void main(String[] args) {
        Random r = new Random();

        int [] list = new int[6];
        for( int i = 1; i<=100; i++){
            int num = r.nextInt(1,7); // 1~6사이의 숫자가 나옴.
            if( num == 1){
                list[0] +=1;
            }else if( num == 2){
                list[1] +=1;
            }
            else if( num == 3){
                list[2] +=1;
            }
            else if( num == 4){
                list[3] +=1;
            }
            else if( num == 5){
                list[4] +=1;
            }
            else if( num == 6){
                list[5] +=1;
            }
        }
        int j = 0;
        for ( int tmp : list){

            System.out.printf("%d의 개수 : %d \n",j+1,list[j]);
            j++;
        }
        // ================for문 한개만으로 6의 배수를 이용해서 더 간단하게 만들 수 있을 것 같은데================================
        int [] num_list = {1,2,3,4,5,6}; // 숫자비교용 배열
        int [] list2 = new int[6]; // 개수 저장하는 배열
        for( int i = 1; i<=100; i++) {
            int ran = r.nextInt(1, 7);
            for(int k = 0; k<num_list.length ; k++) {
                 // 1~6사이의 숫자가 나옴.
                if (ran == num_list[k]) { // i는 1~100까지 들어옴
                    list2[k]+=1;
                    break;
                }
            }
        }
        j=1;
        for ( int tmp : list2){

            System.out.printf("%d의 개수 : %d \n",j,list2[j-1]);
            j++;
        }



    }
}