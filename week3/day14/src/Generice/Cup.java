package Generice;

public class Cup<T> {  // <>안의 저부분을 타입 매개변수라고 한다.

    // 컵은 여러개의 음료를 담을 수 잇다.
    // 안에 들어가는 내용물
    //

    T obj;
}
class Water{}
class Milk{}


class Coffee{
    public static void main(String[] args) {
        Cup c1 = new Cup();

        c1.obj = new Coffee();

        c1.obj = new Water();


//        ===== 정확한 원리?


        // 컵인데 너는 무조건 커피만 담아라 라고 지정해주는 것.
        Cup c2 = new Cup<Coffee>(); // new Cup<Coffee>(); 의 <Coffee>부분은 생략가능

        c2.obj = new Coffee();
        c2.obj = new Water();
        c2.obj = new Milk();

        //제너릭은 타입을 검사하는 과정을 생략할 수 있다. 다형성을 이용해 타입을 바꾸려면 에러를 내는 경우가 많다.
        // 클래스의 개수를 줄일 수 있다.


        // 매개변수 타입
        // E 원소( Element)
        // K key
        // N nuber
        // T type
        // V Value

        //타입 매개변수 (Generic

        for(int i =0 ; i<10 ; i++){
            for(int j = 0 ; j <=i ; j++){
                System.out.println(j);
            }
        }
    }
}
