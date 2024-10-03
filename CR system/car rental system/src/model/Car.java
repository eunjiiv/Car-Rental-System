package model;

public class Car extends Vehicle {
    private String fuelType; 
    private int numberOfSeats; 

    public Car(String vehicleID, String brand, String model, String licensePlate, String fuelType, int numberOfSeats) {
        super(vehicleID, "Car", brand, model, licensePlate);
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        return "Car [ID: " + getVehicleID() + ", Brand: " + getBrand() + ", Model: " + getModel() +
                ", License Plate: " + getLicensePlate() + ", Fuel Type: " + fuelType +
                ", Number of Seats: " + numberOfSeats + ", Available: " + isAvailable() + "]";
    }
}
