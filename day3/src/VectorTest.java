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
            System.out.println("4. 학번과 점수 추가"); //구현은 하지말고 냅둬놔라
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

                        int[] tmp1 = haks;//기존의 값을 우선 복사해놓고 기존의 배열을 길이 1을 늘려준다.
                        int[] tmp2 = scores;//그러기 위해 기존의 배열을 임시공간에 잠깐 저장.
                        haks = new int[count]; //초기에 빈배열을 생성하면서 count의 값이 1증가됐기 때문에 count만으로 이미 1개의 빈공간이
                        scores = new int[count];//있는 상태.
                        for (int i = 0; i < count - 1; i++) { //for문을 통해 임시배열에 있는 값에 기존배열의 값을 넘겨줘야 한다.
                            haks[i] = tmp1[i]; //1개씩 넘겨준다
                            scores[i] = tmp2[i]; //1개씩 넘겨준다.

                        }
                        tmp1 = null;
                        tmp2 = null;
                    }
                    // 배열의 복사가 끝났으면 사용자에게 추가할 값을 입력받고 새로운 배열에 넘겨준다.
                    System.out.print("추가할 학번을 입력하세요 :  ");
                    int datahaks = sc.nextInt();
                    System.out.print("추가할 점수를 입력하세요 :  ");
                    int datascores = sc.nextInt();
                    haks[haks.length - 1] = datahaks;
                    scores[scores.length - 1] = datascores;

                    count++;

                    break;
                case 2:
                    System.out.print("삭제할 점수의 학번을 입력하세요 : ");
                    menu = sc.nextInt();
                    // 삭제를 하려면 삭제해야할 인덱스 넘버가 나왔을 때 포문에서 넘겨주면 된다.
                    int delIdx = -1;
                    for (int i = 0; i < count; i++) {
                        if (menu == haks[i] && count >= 1) {
                            delIdx = i;
                            break;
                        }
                        System.out.println("찾는 학번이 없거나 빈 배열입니다..");
                    }

                    if (delIdx != -1) { //위의 식을 통해 idx에 어떠한 삭제할 값의 인덱스가 저장됐을때 배열복사 및 이동이 이루어지는 구문.
                        int[] tmp1 = haks;
                        int[] tmp2 = scores; //tmp1,tmp2에 기존의 배열값을 임시저장.
                        haks = new int[count - 1]; // 기존길이에서 1을 뺀 빈 배열로 재생성
                        scores = new int[count - 1];
                        for (int i = 0, j = 0; i < count; i++) {//기존 배열값을 갖고 있는 tmp배열들의 값을 haks와 scores배열에 이동시켜준다
                            //단 이때 조건은 삭제된 값은 넘겨주면 안됨. 따라서 조건문을 통해 저장된 삭제인덱스 번호는 패스하게함.
                            if (delIdx != -i) {
                                haks[i] = tmp1[j];
                                scores[i] = tmp2[j];
                                j += 1; //ㅇ
                            }
                        }
                    }
                        break;

                        case 3:
                            System.out.print("선택하세요 1.학번과 점수를 전체출력 2.학번의 점수 \n");
                            menu = sc.nextInt();
                            if (menu == 1) {
                                for (int hak : haks) {
                                    System.out.print(hak + ",");
                                }
                                System.out.println();
                                for (int score : scores) {
                                    System.out.print(score + ",");
                                }
                            }
                            System.out.println();
                            //for문 써서 동일 인덱스로 학번과 점수를 엮어서 출력도 가능.
                            break;
                        case 4:
                            break;
                        case 0:
                            break;
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
        int a=3;
    }
}