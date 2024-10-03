package main;

import model.Car;
import model.Motorcycle;
import model.Van;
import model.VIPClient;
import services.Rental;
import services.SuggestionEngine;
import services.VehicleHealthMonitor;
import services.CreditCardPayment;
import services.BankTransferPayment;
import java.util.Date;
import java.util.Calendar;

public class Main {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        VIPClient vipClient = new VIPClient("C001", "Malakas Ben", "mlakas.ben@example.com");
        VIPClient anotherClient = new VIPClient("C002", "Malakas cain", "malaka.scain@example.com");

        Car car = new Car("V001", "Toyota", "Corolla", "ABC123", "Petrol", 4);
        Motorcycle motorcycle = new Motorcycle("M001", "Harley Davidson", "Street 750", "HD750", 750, false);
        Van van = new Van("VAN001", "Mercedes", "Sprinter", "SPR456", 10.0, 2);

        SuggestionEngine suggestionEngine = new SuggestionEngine();
        System.out.println(ANSI_CYAN + "\n--- Vehicle Suggestion for VIP Client ---" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Suggested Vehicle: " + suggestionEngine.recommendVehicle(vipClient).getModel() + ANSI_RESET);

        Date rentalStartDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rentalStartDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date rentalEndDate = calendar.getTime();

        System.out.println(ANSI_CYAN + "\n--- Rental Process for a Car ---" + ANSI_RESET);
        Rental carRental = new Rental("R001", car, vipClient, rentalStartDate, rentalEndDate, false);
        carRental.generateInvoice();
        carRental.processPayment(new CreditCardPayment("P001", carRental.applyDynamicPricing()));
        vipClient.accumulateLoyaltyPoints(carRental.applyDynamicPricing());
        System.out.println(ANSI_GREEN + "Client's Loyalty Tier: " + vipClient.getLoyaltyTier() + ANSI_RESET);

        System.out.println(ANSI_CYAN + "\n--- Rental Process for a Motorcycle ---" + ANSI_RESET);
        Rental bikeRental = new Rental("R002", motorcycle, anotherClient, rentalStartDate, rentalEndDate, true); // Use another client
        bikeRental.generateInvoice();
        bikeRental.processPayment(new BankTransferPayment("P002", bikeRental.applyDynamicPricing()));
        anotherClient.accumulateLoyaltyPoints(bikeRental.applyDynamicPricing());
        System.out.println(ANSI_GREEN + "Client's Loyalty Tier after motorcycle rental: " + anotherClient.getLoyaltyTier() + ANSI_RESET);

        System.out.println(ANSI_CYAN + "\n--- Rental Process for a Van ---" + ANSI_RESET);
        Rental vanRental = new Rental("R003", van, vipClient, rentalStartDate, rentalEndDate, false);
        vanRental.generateInvoice();
        vanRental.processPayment(new CreditCardPayment("P003", vanRental.applyDynamicPricing()));
        vipClient.accumulateLoyaltyPoints(vanRental.applyDynamicPricing());
        System.out.println(ANSI_GREEN + "Client's Loyalty Tier after van rental: " + vipClient.getLoyaltyTier() + ANSI_RESET);

        System.out.println(ANSI_CYAN + "\n--- IoT-Based Vehicle Health Monitoring ---" + ANSI_RESET);
        VehicleHealthMonitor carMonitor = new VehicleHealthMonitor(car);
        carMonitor.checkVehicleHealth();
        carMonitor.sendRealTimeAlert("Car engine needs an oil change!");

        VehicleHealthMonitor bikeMonitor = new VehicleHealthMonitor(motorcycle);
        bikeMonitor.checkVehicleHealth();
        bikeMonitor.sendRealTimeAlert("Motorcycle tire pressure is low!");

        VehicleHealthMonitor vanMonitor = new VehicleHealthMonitor(van);
        vanMonitor.checkVehicleHealth();
        vanMonitor.sendRealTimeAlert("Van cargo door is not properly locked.");
    }
}
