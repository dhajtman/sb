package org.example.solid.ocp.correct;
// This class adheres to the Open/Closed Principle (OCP) because it allows for new payment methods to be added without modifying existing code
public class PaymentManager {
    public void pay(PaymentMethod paymentMethod, double amount) {
        if(paymentMethod.validate()) {
            paymentMethod.pay(amount);
            // Send a confirmation email (Example)
        } else {
            // Handle the validation error
        }
    }
}
