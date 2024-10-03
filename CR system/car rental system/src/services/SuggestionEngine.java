package services;

import model.Car;
import model.Client;
import model.LoyaltyTier;
import model.Vehicle;

public class SuggestionEngine {

    public Vehicle recommendVehicle(Client client) {
        System.out.println("Analyzing client's rental history...");

        if (client.getLoyaltyTier() == LoyaltyTier.GOLD) {
            return new Car("V002", "Tesla", "Model S", "ECO123", "Electric", 5);
        } else if (client.getLoyaltyTier() == LoyaltyTier.SILVER) {
            return new Car("V003", "BMW", "3 Series", "BMW789", "Petrol", 4);
        } else {
            return new Car("V004", "Honda", "Civic", "HON456", "Petrol", 4);
        }
    }
}
