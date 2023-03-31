import java.util.Scanner;

class ReionTrainList{
    String [] regionlist = {"부산","서울","대구","인천","강원도"};
    int [] regionfee = {3000,10000,4000,2000, 7000};
    String [] trainlist = {"ktx","무궁화","새마을","srt"};
    int [] trainfee = {10000,1000,2000,9000};
    //========================== 얘네 자체를 2차원 배열로 저장
    // 한 클래스내에 이와 같이 지역과 기차에 해당하는 요금을 가지고 있는 배열들을 저장하게 된다면 사용자의 입력이 어떤 걸 원하는지에 따라
    // 배열을 다른 걸 써야하는데 그떄 사용자에게 입력값으로 조건을 추가적으로 받던지 아니면 그냥 region 과 train을 또 다른 클래스로 아예 분리시킨 후에
    // 출력하는 부분만 공통 Static메서드로 묶던지.
    // 극단적으로 생각해봐라. 그럼 train list랑 region list이외에 다른 리스트가 계속 추가된다고 하면 그 때마다 클래스가 생기는 것도 말이안된다
    // 반복을 줄여라 반복되는 코드나 행동을 줄여라.
}

//public class MethodEx05 {
//
//
//    public static int checkfee(String userinput){
//
//        int idx = -1;
//        if{
//            for (int i = 0; i<regionlist.length ; i++) {
//                if (regionlist[i].equals(arrival)) {
//                    idx = i; // 지역리스트 region과 입력값이 일치하면 해당 인덱스를 idx에 저장
//                    return fee[idx]; // 찾는 즉시 for문 탈출.
//                }
//
//        }return 0;
//    }
//
//
//    // 메서드를 작성한다는 것은 여러곳에서 공통으로 사용될 가능성이 있는 명령문을 모아놓은 것이다. 또한 변수나 상수에 들어갈 수식 따위를
//    // 소스 코드에 직접 이용하는 것을 하드코딩이라고 한다. 이것은 변수 선언을 줄여주기에 메모리 사용 측면에서는 좋을 수 있고
//    // 코드를 간결하게 할 수는 있으나 나중에 수식이 달라져야 하는 상황에서 그 수식을 여러곳에서 사용했다면 모두 바꿔줘야 하는데 번거로움이 생긴다.
//    // 즉 내 생각에는 다른 곳에 많이 사용될 가능성이 별로 없는 값 같은 경우 하드코딩을 해도 괜찮으나 적어도 2번 이상 같은 수식이 쓰이고 수식의 길이가
//    // 너무 길어 가독성이 떨어질 경우 그냥 변수를 선언해놓는 것이 훨씬 안전한 방법이다.
//
//    public static void main(String[] args) {
//        //지금까지 풀었던 내용을 기반으로 어떤 방식으로든 풀면 된다.
//
//        /*
//            열차예매
//            1. 목적지를 매개변수로 받으면 운임비를 main에 있는 pay라는 변수에 저장. (매개변수는 지역별로 가격이 다르다)
//         */
//        Scanner sc = new Scanner(System.in);
//        System.out.println("가고싶은 지역을 입력하세요.");
//        String arrival = sc.nextLine();
//        int pay = checkfee(arrival);
//
//        System.out.println("탑승하실 열차를 입력하세요.");
//        String train = sc.nextLine();
//        pay += trainfee(train);   //trainfee는 그러면 반환타입이 int인 메서드.
//        System.out.printf("찾으시는 지역은 %s, 요금은 %d입니다",arrival,pay);
//
//        // 함수명 trainfee
//        // 매개변수 열차의 종류
//        // 종류
//        // ktx  10000
//        // srt  5000
//        // 무궁화 1000
//        // 새마을 2000
//    }
//
//
//
//}
