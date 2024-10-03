package model;

public class Motorcycle extends Vehicle {
    private int engineCapacity; 
    private boolean hasSidecar;

    public Motorcycle(String vehicleID, String brand, String model, String licensePlate, int engineCapacity, boolean hasSidecar) {
        super(vehicleID, "Motorcycle", brand, model, licensePlate);
        this.engineCapacity = engineCapacity;
        this.hasSidecar = hasSidecar;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    @Override
    public String toString() {
        return "Motorcycle [Model: " + getModel() + ", Engine Capacity: " + engineCapacity + " CC, Has Sidecar: " + hasSidecar + "]";
    }
}