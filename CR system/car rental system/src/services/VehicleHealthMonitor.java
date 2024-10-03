package services;

import model.Vehicle;

public class VehicleHealthMonitor {

    private Vehicle vehicle;
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m"; 

    public VehicleHealthMonitor(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void checkVehicleHealth() {
        System.out.println(ANSI_YELLOW + "\n--- Health Check for " + vehicle.getModel() + " ---" + ANSI_RESET);
        
  
        String tirePressure = "Normal";  
        String fuelLevel = "Full";        
        String engineStatus = "Operational"; 

        System.out.println(ANSI_GREEN + "✔️ Tire Pressure: " + tirePressure + ANSI_RESET);
        System.out.println(ANSI_GREEN + "✔️ Fuel Level: " + fuelLevel + ANSI_RESET);
        System.out.println(ANSI_GREEN + "✔️ Engine Status: " + engineStatus + ANSI_RESET);
    }

    public void sendRealTimeAlert(String message) {
        System.out.println(ANSI_RED + "\n🚨 ALERT for " + vehicle.getModel() + ": " + message + ANSI_RESET);
    }
}