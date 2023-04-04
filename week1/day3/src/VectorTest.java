import java.util.Arrays;
import java.util.Scanner;

public class VectorTest {
    public static void main(String[] args) {

        //
        // 이름을 저장하는 배열 (벡터구조)
        // 학번을 저장하는 배열, 점수를 저장하는 배열 (벡터구조로 만들기)
        int[] haks = null;
        int[] scores = null;
        int count = 0; //  배열의 생성 여부를 판단할 수 있는 정수값. 배열의 길이를 나타내는 정수값이기도 하다.
        // 내 생각에 지금 벡터 배열에 대한 실습은 벡터클래스를 이용해서 우리가 편하게 배열을 사용할 수 있는 것을
        // 직접 코드로 구현해보는 것 같다.
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===kh정보학원===");
            System.out.println("1. 학번과 점수 추가");
            System.out.println("2. 학번과 점수 삭제");
            System.out.println("3. 학번과 점수 조회");
            System.out.println("4. 미정"); //구현은 하지말고 냅둬놔라
            System.out.println("0. 종료");

            // 2번 삭제와 3번 조회 기준은 학번을 기준으로 검색하고 삭제하기
            // 조회는 학번조회를 하면 1.전체출력 2.조회하는 학번의 내용(점수?)
            System.out.print("원하는 메뉴 번호를 입력하세요");
            int menu = sc.nextInt();
            switch (menu) {
                case 1: // 추가의 경우 기존의 데이터가 비어있는지 있는지 확인해야하는데 이때 판별할 수 있는 것이 count.
                    if (count == 0) { // 배열이 생성돼있지 않을 경우
                        System.out.println("배열이 없기 떄문에 길이가 1인 배열을 생성합니다");
                        haks = new int[1];
                        scores = new int[1]; // 길이가 1인 배열 생성
                        count++;
                    } else {// 배열이 생성돼있을 경우. 즉 count 가 0이 아닐경우
                        count++;
                        int[] tmp1 = haks;//기존의 값을 우선 복사해놓고 기존의 배열을 길이 1을 늘려준다.
                        int[] tmp2 = scores;//그러기 위해 기존의 배열을 임시공간에 잠깐 저장.
                        haks = new int[count]; //초기에 빈배열을 생성하면서 count의 값이 1증가됐기 때문에 count만으로 이미 1개의 빈공간이
                        scores = new int[count];//있는 상태.
                        for (int i = 0; i < count - 1; i++) { //for문을 통해 임시배열에 있는 값에 기존배열의 값을 넘겨줘야 한다.
                            haks[i] = tmp1[i]; //1개씩 넘겨준다
                            scores[i] = tmp2[i]; //1개씩 넘겨준다.

                        }

                        tmp1 = null; // 메모리에 남겨놓을 이유가 없기 때문에 null로 가비지 처리.
                        tmp2 = null;
                    }
                    // 배열의 복사가 끝났으면 사용자에게 추가할 값을 입력받고 새로운 배열에 넘겨준다.
                    System.out.print("추가할 학번을 입력하세요 :  ");
                    int datahaks = sc.nextInt();
                    System.out.print("추가할 점수를 입력하세요 :  ");
                    int datascores = sc.nextInt();
                    haks[haks.length - 1] = datahaks;
                    scores[scores.length - 1] = datascores;



                    break;
                case 2:
                    System.out.print("삭제할 점수의 학번을 입력하세요 : ");
                    menu = sc.nextInt(); // 맨 위에서 선언한 menu 선택 변수.
                    // 삭제를 하려면 삭제해야할 인덱스 넘버가 나왔을 때 포문에서 넘겨주면 된다.
                    int delIdx = -1; // 삭제할 학번과 배열안의 학번이 일치하지 않으면 idx값을 -1로 두고 조건문이나 반복문이 실행되지 않게 한다.
                    for (int i = 0; i < count; i++) { //현재 count는 현재 배열의 길이이다. 즉 현재 배열의 값을 모두 비교해야 하기 때문에
                        // 조건식의 조건은 저게 맞다. haks.length와 scores.length와 같은 값임.
                        if ((menu == haks[i]) && (count >= 1)) {
                            //삭제할 점수의 학번과 학번 배열의 특정 값이 같다면 배열안에 삭제하고자 하는 학번이 있는 것이므로 그 인덱스 번호를
                            //delIdx에 저장. 그리고 길이가 0일떄, 즉 프로그램이 처음 시작하고 나서라던지 모두 삭제된 상태일 때 실행되면 인덱스
                            //넘버 에러가 발생할 수 있기 때문에 길이가 무조건 1이상일때만 조건식에 들어올 수 있게 했다.
                            //삭제할 수 없다는 걸 알리고 싶다면 해당 조건을 빼고 따로 else문으로 작성하면 된다.
                            delIdx = i; // 학번이 같을때 해당 학번의 인덱스를 저장
                            System.out.println("idx저장");
                            break;
                        }

                    }
                    //위에서 delIdx에 인덱스 번호가 저장됐다면 아래 조건식을 수행할 것이고 아니면 다시 루프문의 처음으로 돌아갈 것이다.
                    if (delIdx != -1) { //delIdx를 구한 후 본격적으로 배열을 복사하고 값을 넘겨주는 부분.
                        count--; // 여기서 count를 미리 줄여주고 아래에서 중복되어 나올 수 있는 count-1 코드를 제거.
                        int[] tmp1 = haks;
                        int[] tmp2 = scores; //tmp1,tmp2에 기존의 배열값을 임시저장.
                        haks = new int[count]; // 기존길이에서 1을 뺀 빈 배열로 재생성
                        scores = new int[count];//count--의 위치가 중요한데 if문이 시작될 떄 바로 감소 시켜준다.
                        for (int i = 0, j = 0; i <= count; i++) {//기존 배열값을 갖고 있는 tmp배열들의 값을 haks와 scores배열에 이동시켜준다
                            //단 이때 조건은 삭제된 값은 넘겨주면 안됨. 따라서 조건문을 통해 저장된 삭제 인덱스 번호는 패스하게함.
                            if (delIdx != i) { // 아까 삭제할 학번의 인덱스를 delIdx에 저장했다. 그 인덱스 번호가 아니면
                                // 지속적으로 배열의 값을 옮기도록 한다. 이 때 만약 삭제할 학번의 인덱스 번호가 i값으로 들어온다면
                                // pass하게 되는데 이때 haks , scores 배열의 인덱스는 그대로 있어야하고 복사해놓은(기존의 값을 갖고
                                // 있는 임시배열 tmp)배열들의 인덱스만 넘어가야한다.
                                haks[j] = tmp1[i]; // 따라서 두 배열의 인덱스 번호는 i,j로 각각 다르고 새로운 배열 (haks,scores)에는 빈 공간이 생기면
                                scores[j] = tmp2[i];//안되니 증감식이 실행되지 않으면 넘어가지 않게 인덱스 번호를 j로 설정.
                                j += 1; //삭제할 인덱스 번호가 조건식에 오면 인덱스 번호가 유지되고 임시배열에서만 삭제할 값 다음 인덱스로 넘어간다.
                            }
                        }
                        tmp1 = null;// 마찬가지로 메모리 낭비로 제거.
                        tmp2 = null;
                    }
                        break;

                        case 3:
                            System.out.print("선택하세요 1.학번과 점수를 전체출력 2.학번의 점수 \n");
                            menu = sc.nextInt();
                            switch(menu) {
                                case 1:
                                    for (int hak : haks) {
                                        System.out.print(hak + ",");
                                    }//Arrays.toString()으로 작성하면 배열의 형태로 나와서 그냥 foreach문 사용.
                                    //for문 써서 동일 인덱스로 학번과 점수를 엮어서 출력도 가능.
                                    System.out.println();
                                    for (int score : scores) {
                                        System.out.print(score + ",");
                                    }System.out.println();
                                    break;
                                case 2:
                                    System.out.print("점수를 보고자 하는 학번을 입력하세요");
                                    menu = sc.nextInt(); //어차피 조건식 비교하는 건 끝났으니 위의 menu를 중복사용. 좋은 방법은 아닌듯.
                                    for(int i = 0 ; i<count; i++) {
                                        if (haks[i] == menu) {
                                            System.out.printf("%s의 점수는 %s입니다 \n", haks[i], scores[i]);
                                            break;
                                        }
                                    }
                                        System.out.println("해당 학번은 없습니다");

                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 4:

                            break;
                        case 0:
                            System.out.println("종료합니다");
                            return;
                        default:

            }

        }
    }
}
class tTt{
    public static void main(String [] args){

        int [] arr = new int [1];
        arr[0]=2;
        if(true){
            int c= 3;
        }else{
            int c=  3;
        }
        while(true){
            int a;
            break;
        } // while문안의 지역변수와 break가 없을 떄 이후의 변수 선언에 대한 에러에 관해..
        // if 와 else문에서 각각 변수의 타입을 선언했을 떄는 에러가 발생하지 않는다. 어차피 같이 실행될 수 없는 조건이기 떄문이다
        //무한 루프문에서도 선언이 반복되는데 에러가 발생하지 않는다. 이유는 중괄호 {가 시작될때 메모리에 변수가 선언됐다가 중괄호 } 가
        //끝나는 순간에 메모리에서 삭제되기 떄문이다. 다만 메인메서드내에서의 지역변수는 for문이나 if문에 영향을 받는 모습을 보이는데 그건
        //main메서드의 지역변수가 반복문안에 들어가는 것이고 반복문에서 선언한 변수는 그 블럭 안에서만 지역변수가 되기 떄문에 반복문 밖에서는
        //다시 사용할 수 있는 것.

        int a=3;
    }
}