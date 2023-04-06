// 고객 정보를 관리하는 UserInit 클래스


// 실제 user 정보는 이름, 연락처
class User {

    private String name;
    private String phone;


    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

class UserTset{
    public static void main(String[] args) {
        User u = new User("김영찬","ㄴㄴ");
    }
}




