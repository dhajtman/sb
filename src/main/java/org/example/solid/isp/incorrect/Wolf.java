package org.example.solid.isp.incorrect;

public class Wolf implements Animal {
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

    @Override
    public void giveAPaw() {
        // Wolves don't give a paw (Exception!)
        throw new UnsupportedOperationException();
    }
}
