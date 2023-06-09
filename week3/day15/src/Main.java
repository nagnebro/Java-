import java.util.*; // Arrays.toString 사용가능

class Solution {
    static public int[] solution(int []arr) {
        int[] answer = new int [arr.length];
        int count = 0;
        int tmp = -1; // arr원소의 크기가 제한적이기 떄문에 가능한 방법.
        // 처음검사떄가 조건이 애매한데 -1로 설정해도 아무문제 없기떄문에가능.

        for(int i = 0 ; i< arr.length-1 ; i++){
            if(arr[i]==tmp){// tmp는 앞전 인덱스의 값이고 혹시 같으면 넘겨라
                count++; // 건너뛴횟수를 저장, 나중에 새로운 배열의 길이를 정할떄 쓰임.
                continue;
            }
            tmp = arr[i]; // 현재값을 임시 비교할 숫자에 저장시켜준다 이렇게 되면 다음 반복떄는 ㅇtmp가 이전의 숫자를 들고있게된다.
            answer[i-count] = arr[i];// 건너뛴 만큼 빼서 저장

        }

        int a_length = answer.length-count;
        int [] answer2 =Arrays.copyOf(answer,a_length-1);

        return answer2;
    }

    public static void main(String[] args) {
        int [] arr = {2,4,5,6,6,6,6,7,8,9,2,1,1,3,3,2,1,5,7,2};
        System.out.println(Arrays.toString(solution(arr)));
    }
}

// 입력 받은 10진수를 2진수로 변환하고 다시 10진수로 변환하기
class DecToBinEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("십진수 입력 : ");
        int val = sc.nextInt();
        val = decToBin(val);
        System.out.println("이진수 : " + val);
//        val = binToDec(val);
//        System.out.println("십진수 : ");
    }
// 리스트 거꾸로 받고 저장시키기?
    static int decToBin(int dec) { // 10진수를 2진수로 바꾸는 메서드
        //dec /2  즉 몫+1은 받아야하는 배열의 길이와같다 예를 들어 5는 이진수 101 이고 10은 1010 이다 이떄 5의 몫은 2 32는
        int [] list  = new int[dec]; // 아무리 큰 수가 들어와도 저 길이안에는 무조건 다 담을 수 있음.
        //거의 무조건 배열로 처리해야한다고 생각해라.
        int i = 0;
        int length = 0;
        int result = 0;
        while(dec>=1){ // 2로 나눠서 0이 될떄까지 나눠준다.
            System.out.println(dec);
            list[length] = dec%2;
            length ++;
            dec/= 2;
            }
        int [] answer = new int[length];
        for(int j = 0 ; j <length; j++){
            answer[j] = list[j]; // 여기서 i는 아까 값의 개수를 셀떄 추가했었다.
        }
        for(int k = 0; k<answer.length; k++){
            //3항 연산자? 조건연산자
            if(answer[k]==1){ //리스트의 저장된 값이 1이면 그 자리수만큼 10의제곱해서 더해줘야한다.
                int ten = 1;
                for(int a = 0 ;a <k ; a++){
                    ten *= 10;
                }
                result += ten;
            }
        }
        System.out.println(Arrays.toString(answer));
        return result;

    }

    static int bintoDec(int bin){

        //이진수가 들어오면 그 자릿수에 해당하는 만큼 2의 제곱을 곱해야한다.거꾸로 되니 length-i 만큼 포문 반복시켜서 더하기.
        // 반복문을 이용해 처리하는 방법. 일단 숫자길이를 알아야 지수를 체크한다.
        // 숫자길이를 확인하는 방법  -> 10으로 나누기?
        // 쉬운 방법 보다 되는방법 먼저 찾기
        int length = 0; //bin의 길이를 확인하기 위한 변수
        int count = 0; //
        int tmp = bin; // bin의 값은 계속 유지돼야 하기 때문에 임시값을 사용.
        int result = 0;
        int comp = 1;
        int two = 2;
        int j = 0;
        int [] list = null;
        while(tmp!=0) { // 자리수 체크 , 현재 1의자리는 체크안되는 경ㅇ우.
            length++;
            tmp /= 10;
        }
        list = new int[length]; // 길이 구한 후 길이만큼 배열 생성

        for( int i = 0; i<length; i++){ // i는 들어온 숫자의 길이만큼 반복됨. 처음부터 가장 앞자리 수를 구함.

            while(j<length){ // 2진수의 첫쨰자리수부터 10진수로 저장하기 위함
                two *= 2; // 10의 제곱수를 구했을떄 더해줘야할 10진수의 수
                comp *= 10; // 입력값 2잔슈룰 나누기 위한 10의 제곱수
                j++;
            }
            if(bin/comp == 1){
                result += two;
                two = 2;
                comp = 0;
                j=0;
            }
        }






        return 1;

    }

    static int binToDec(int bin) { // 2진수를 10진수로 바꾸는 메서드.
        return 1;
    }
}