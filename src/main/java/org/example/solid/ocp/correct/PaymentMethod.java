package org.example.solid.ocp.correct;
// This interface adheres to the Open/Closed Principle (OCP) because it allows for new payment methods to be added without modifying existing code
public interface PaymentMethod {
    public void pay(double amount);
    public boolean validate();
}
