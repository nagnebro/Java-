package Generice;

import java.util.ArrayList;

public class Person<T,E> {

    T id;
    E pw;
}


class PersonMain{

    public static void main(String[] args) {

      //  Person<Integer,Double> p1 = new Person<Integer,Double>();
        Person <String,Integer> p2 = new Person<String,Integer>();

        ArrayList<Person> list = new ArrayList<>();

        for(int i = 1; i < 7 ; i++){
            System.out.println(i);
            if ( i%4 == 0){
                i =7;
            }
        }
    }
}
//    String name;
//    int age;
//    T weight; //
//    T height;
