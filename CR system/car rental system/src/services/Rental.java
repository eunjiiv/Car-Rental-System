package services;

import model.Client;
import model.Vehicle;
import java.util.Date;

public class Rental {
    private String rentalID;
    private Vehicle vehicle;
    private Client client;
    private Date rentalStartDate;
    private Date rentalEndDate;
    private double price;
    private boolean ecoMode;

    
    public Rental(String rentalID, Vehicle vehicle, Client client, Date rentalStartDate, Date rentalEndDate, boolean ecoMode) {
        if (!isValidRentalPeriod(rentalStartDate, rentalEndDate)) {
            throw new IllegalArgumentException("Invalid rental period: End date must be after start date.");
        }
        
        this.rentalID = rentalID;
        this.vehicle = vehicle;
        this.client = client;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.ecoMode = ecoMode;
        this.price = applyDynamicPricing(); 
    }

    public double applyDynamicPricing() {
        double basePrice = 12000; 
        double discount = client.getLoyaltyDiscount();
        double ecoDiscount = ecoMode ? 0.05 : 0.0;
        return basePrice - (basePrice * (discount + ecoDiscount));
    }

    public void generateInvoice() {
        System.out.println("------ Invoice ------");
        System.out.println("Rental ID: " + rentalID);
        System.out.println("Client: " + client.getName());
        System.out.println("Vehicle: " + vehicle.getModel());
        System.out.println("Rental Period: " + rentalStartDate + " to " + rentalEndDate + " (" + getRentalDays() + " days)");
        System.out.println("Base Price: P12000");
        System.out.println("Loyalty Discount: " + (client.getLoyaltyDiscount() * 100) + "%");
        if (ecoMode) {
            System.out.println("Eco Discount: 5%");
        }
        System.out.println("Final Price: P" + price);
        System.out.println("---------------------");
    }

    public void processPayment(Payment payment) {
        payment.processPayment(); 
        System.out.println("Payment for Rental ID " + rentalID + " processed successfully!");
    }

    public void generateEcoReport() {
        if (ecoMode) {
            double co2Saved = calculateEcoSavings();
            System.out.println("Eco-friendly rental: You have saved approximately " + co2Saved + " kg of CO2 emissions!");
        } else {
            System.out.println("Eco-mode was not selected for this rental.");
        }
    }

    private int getRentalDays() {
        long diffInMillis = rentalEndDate.getTime() - rentalStartDate.getTime();
        return (int) (diffInMillis / (1000 * 60 * 60 * 24)); 
    }

    private boolean isValidRentalPeriod(Date startDate, Date endDate) {
        return endDate.after(startDate);
    }

    private double calculateEcoSavings() {
        return 10.0; 
    }
}

