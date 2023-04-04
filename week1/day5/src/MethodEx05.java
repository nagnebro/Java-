

//문제 : 사용자애게 여행지를 입력받고 그 여행지에 해당하는 운임요금과 어떤 기차를 이용할 것인지에 대한 운임요금을 각각 입력받고 마지막에는 최종금액을 출력하여라


import java.util.Scanner;

class TrainUser{
    String [] r_list = {"부산","서울","인천","대구","제주도"};  //region list
    int [] rp_list = {10000, 25000,15000,8000,30000};
    String [] t_list = {"ktx","무궁화","새마을"};  //train list
    int [] tp_list = {50000, 25000,15000};

    // 공통되는 부분은 사실 static 메서드로 작성해도 될 듯 하다. 위에 배열들은 어차피 참조변수별로 다르게 생성할 필요가 없는 고정적인 값이기 떄문이다.
    String region ;
    String train;
    void inform(String [] list){
        for (int i = 0 ; i< list.length ; i++){
            System.out.printf("%d. %s \n",i+1,list[i]);
        }
    }

    int find(String input, String [] list){
        int idx = -1;
        for( int i = 0 ; i<list.length; i++){
            if(input.equals(list[i])){
                idx=i;
                return idx;
            }
        }

        return idx;
        }



    TrainUser(){}
    TrainUser(String region, String train) {
        this.region = region;
        this.train = train;
    }
}



class TrainTest{
    public static void main(String[] args) {
        TrainUser t = new TrainUser();
        Scanner sc = new Scanner(System.in);
        System.out.println("여행하고자 하는 지역을 입력하세요.");
        t.inform(t.r_list); // 지역 정보 출력
        String region = sc.nextLine();
        System.out.println("이용하고자 하는 기차를 입력하세요.");
        t.inform(t.t_list); // 기차 정보 출력
        String train = sc.nextLine();
        t.region = region;
        t.train = train;
        int t_idx = t.find(train,t.t_list);
        int r_idx = t.find(region,t.r_list);
        System.out.println(t_idx+""+r_idx);
        System.out.printf("%s로 가는 요금은 %d, %s 열차를 선택할시 %d입니다..",region,t.rp_list[r_idx],train,t.tp_list[t_idx]);


    }
}