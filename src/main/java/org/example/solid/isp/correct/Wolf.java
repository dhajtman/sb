package org.example.solid.isp.correct;

public class Wolf implements WildAnimal {

    @Override
    public void eat() {
        System.out.println("Wolf is eating");
    }

    @Override
    public void run() {
        System.out.println("Wolf is running");
    }

    @Override
    public void hunt() {
        System.out.println("Wolf is hunting");
    }
}
