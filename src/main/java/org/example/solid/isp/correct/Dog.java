package org.example.solid.isp.correct;

public class Dog implements DomesticAnimal {

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    @Override
    public void giveAPaw() {
        System.out.println("Dog is giving a paw");
    }
}
