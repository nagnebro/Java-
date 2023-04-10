package Thread_wait_notify;

public class Dish {
    private boolean empty = true;

    public boolean isEmpty(){
        return empty;
    }
    public void setEmpty(boolean empty){
        this.empty = empty;
    }
}

class main{
    public static void main(String[] args) {

        final Dish d = new Dish();
        Customer s = new Customer(d);
        Cook c = new Cook(d);
        Thread st2 = new Thread(c);
        Thread st = new Thread(s);// 스레드를 구현했기 때문에 스레드 생성자로 참조변수를 주며 다시 생성해야 함.
        st.start();
        st2.start();
        //new Thread(new Customer(d)).start();
    }
}