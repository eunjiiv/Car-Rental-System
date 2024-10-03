package services;

public class BankTransferPayment extends Payment {

    public BankTransferPayment(String paymentID, double amount) {
        super(paymentID, amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing bank transfer payment of P" + amount + " for Payment ID: " + paymentID);
        System.out.println("Bank transfer completed successfully.");
    }
}
