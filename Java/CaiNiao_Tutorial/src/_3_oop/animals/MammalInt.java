package _3_oop.animals;

public class MammalInt implements Animals {
    @Override
    public void eat() {
        System.out.println("Mammal eats");
    }

    @Override
    public void travel() {
        System.out.println("Mammal travels");

    }
}
