package Sort;

public class BinarySearchMain {

    public static boolean bsearch(int [] arr, int key){

        int left = 0;
        int right = arr.length -1; // 오른쪼 끝 인덱스 번호
        int mid; // 반복하다보면 중간값입 바뀌니까 초기화하지 않는다.

        while(left <= right){ // 왼쪽과 오른쪽의 인덱스가 같아졌다는 건 서치가 끝낫다는건
            mid = (left+right)/2;
            if(arr[mid] < key){ // 중간 인덱스가 갖고 있는 값보다 찾는 키의 값이 클경우 오른쪽을 찾아봐야한다.
                left= mid+1;// arr[mid]s는 이미 작은게 판별됐으니 +1로 넘어가준다.
            }else if(arr[mid] >key){
                right = mid -1;
            }else{
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {


        // 이진탐색
        // - 조건! 무조건 정렬이 돼있어야한다. -> 이게 뭔소리야?
        // - 인덱스의 길이를 반으로 나눈다
        // - 중간 기준점을 찾는다
        // - 중간을 기점으로 비교하는 값이 작으면 기준점보다 앞의 ㅓ범위에서 찾는다
        // 기준점보다 클 경우는 오른쪽 범위를 검사.

        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        boolean res = bsearch(arr,7);
        if(res){
            System.out.println("값을 찾았다.");
        }else{
            System.out.println("값이 없다.");
        }
    }
}
