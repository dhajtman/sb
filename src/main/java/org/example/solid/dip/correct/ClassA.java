package org.example.solid.dip.correct;

public class ClassA {
    InterfaceB objectB;

    public ClassA(InterfaceB objectB) {
        this.objectB = objectB;
    }

    public void foo() {
        // Some code
        // And then call the method of ClassB
        objectB.doSomething();
    }
}
