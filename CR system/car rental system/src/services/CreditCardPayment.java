package services;

public class CreditCardPayment extends Payment {

    public CreditCardPayment(String paymentID, double amount) {
        super(paymentID, amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment of P" + amount + " for Payment ID: " + paymentID);
    }
}