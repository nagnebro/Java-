package Interface;

 interface Fly{
     void fly();
 }

interface Walk{
     void walk();
}

interface Cry{
     void cry();
}

public class Bird implements Fly,Walk,Cry{

    @Override
    public void cry() {
    }
    @Override
    public void walk() {
    }
    @Override
    public void fly() {
    }
}

class Dog implements Cry,Walk{
    @Override
    public void cry() {

    }
    @Override
    public void walk() {

    }
}

class Chicken implements Walk, Fly{
     @Override
     public void walk() {
     }
    @Override
    public void fly() {
    }
}