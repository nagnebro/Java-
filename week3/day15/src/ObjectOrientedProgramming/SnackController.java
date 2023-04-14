package ObjectOrientedProgramming;

public class SnackController {
    private Snack s = new Snack();

    SnackController(){

    }
    public String savedata(String kind, String name, String flavor, int numOf, int price){


        s.setKind(kind); // 제어자 private에 접근 가능한 원리.
        s.setName(name);
        s.setFlavor(flavor);
        s.setNumOf(numOf);
        s.setPrice(price);



        return "저장완료";
    }
    public String confirmData(){


        return s.information();
    }
}
