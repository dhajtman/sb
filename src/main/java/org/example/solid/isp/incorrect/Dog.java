package org.example.solid.isp.incorrect;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    @Override
    public void hunt() {
        // Dogs don't hunt (Exception!)
        throw new UnsupportedOperationException();
    }

    @Override
    public void giveAPaw() {
        System.out.println("Dog is giving a paw");
    }
}
