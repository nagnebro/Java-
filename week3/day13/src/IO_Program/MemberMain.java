package IO_Program;


import IO.FileOutput;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Account implements Serializable { // 이게 뭐자?
    String id;
    String pw;
    String name;

    public Account(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }
    Account(String[] temp){
        this.id = temp[0];
        this.pw = temp[1];
        this.name = temp[2];
    }

    @Override
    public String toString() {
        return String.format("id : %s  pw : %s  name : %s",id,pw,name);
    }
}

public class MemberMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("id, pw, 이름을 입력하세요 ");
        String [] temp = sc.nextLine().split(",");

        Account a1 = new Account("qwer","qwer","하하");
        Account a2 = new Account("wsxc","wsxc","홍철");
        Account a3 = new Account("erty","erty","재석");
        Account a4 = new Account(temp);

        ArrayList<Account> a_list = new ArrayList<>();
        a_list.add(a1);
        a_list.add(a2);
        a_list.add(a3);
        a_list.add(a4); // 파일 형태가 아닌 객체를 밖으로 빼기 위해서는 objectStream을 사용해야한다


        //output , input이 헷갈린다면 가운데에서 입출력을 담당하는 자바를 기준으로 봐라. ㅁ-----입력----->0----출력---> ㅁ
        // ㅁ은 사용자, 혹은 컴퓨터이고 0은 자바이다. 컴퓨터로부터 입력을 받을떄, 즉 내가 컴퓨터의 파일을 read할떄를 input이라고 하고
        // 내가 가지고 있는 데이터를 컴퓨터나 사용자에게 파일로서 작성하고 싶으면 output이라 한다.

// ===========객체를 저장하는 구문===========
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream("accountlist");
//            ObjectOutputStream oos = new ObjectOutputStream(fos); // fos에 객체를 저장할 수 있는 oos를 생성
//            oos.writeObject(a_list);
//            fos.close();
//            oos.close();
//
//        } catch (IOException e) {
//
//        }
        FileInputStream fis = null;
        try {
            FileOutputStream fos = null;

            fos = new FileOutputStream("accountlist");
            ObjectOutputStream oos = new ObjectOutputStream(fos); // fos에 객체를 저장할 수 있는 oos를 생성
            oos.writeObject(a_list);
            fos.close();
            oos.close();


            fis = new FileInputStream("accountlist");
            ObjectInputStream ois = new ObjectInputStream(fis); // fos에 객체를 저장할 수 있는 oos를 생성
            a_list = (ArrayList<Account>) ois.readObject();
            fis.close();
            ois.close();
            for (Account tmp : a_list){
                System.out.println(tmp);
            }
        } catch (Exception e) {

        }



//        System.out.println(temp.split(","));
//        for ( String tmp : temp.split(",")){ // 입력의 개수가 몇개 들어올지 모르니 요소 전체를 출력하기 위해 for each문 사용
//            System.out.println(tmp);
//        }

    }
}
