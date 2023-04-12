package BookMarket;

// 고객들의 정보를 저장하는 user class
// 이름 핸드폰 주소 모두 비공개.
// 장바구니 클래스를 생성해라 (아래의 정보는 모두 비공개)
// 책의 제목저장하는 배열 사이즈 7개 itemBook  -> 내가 산걸 저장하라는 거?
// 총 구매액 저장하는 totalPrice
// 책의 번호 bookID
// 책의 개수 quantity 저장
public class User {
    private String name;
    private String address;
    private int phone;

    void menuGuestInfo(){
        System.out.printf("이름 : %s , 주소 : %s, 아이디 : %d\n",name,address,phone);
    }

    public User(String name, String address, int phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
