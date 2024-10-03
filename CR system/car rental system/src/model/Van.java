package model;

public class Van extends Vehicle {
    private double cargoCapacity; 
    private int numberOfSeats;

    public Van(String vehicleID, String brand, String model, String licensePlate, double cargoCapacity, int numberOfSeats) {
        super(vehicleID, "Van", brand, model, licensePlate);
        this.cargoCapacity = cargoCapacity;
        this.numberOfSeats = numberOfSeats;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        return "Van [Model: " + getModel() + ", Cargo Capacity: " + cargoCapacity + " m³, Seats: " + numberOfSeats + "]";
    }
}