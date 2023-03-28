import java.util.*;
public class ArrayEx05 {
    public static void main(String [] args){
        String name = "김영찬";
        String name2 = "김영영찬";
        //비교 문자열은 같은데 과연 같다고 나올지?

        String name3 = "김영찬";
        //비교 name == name3 같니?
        System.out.println("name == name2??"+name==name2);
        System.out.println("name == name3??"+name==name3);
        System.out.println("name2 == name3??"+name2==name3);

        Scanner scanner = new Scanner(System.in);
        int [] arr = {13,35,0,0,0};
        int count = 2;
        int size = arr.length;

        while(true){
            System.out.println("현재 남은 공간 : "+(size-count));
            System.out.println("1:추가 2: 삭제 : 0: 종료");
            int input = scanner.nextInt();

            if(input == 1 && count != size ){
                // 추가
                //공간이 남아있으면 추가를 한다.
                //정수를 하나 입력받는다.
                //공간이 없다 break;
                System.out.println("추가할 값을 입력하세요");
                arr[count++] = scanner.nextInt();

            }else if(input == 2 && count != 0){
                //삭제
                System.out.println("값을 삭제합니다.");
                arr[count--] = 0;
            }else if(input == 0){
                System.out.println("종료합니다 현재 배열 내부의 값은"+Arrays.toString(arr)+"입니다.");
                break;
            }else{

            }
        }
        System.out.println("aa"+'h');

    }//메인의 끝

}
