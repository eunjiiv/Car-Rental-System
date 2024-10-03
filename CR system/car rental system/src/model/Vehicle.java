package model;

public class Vehicle {
    private String vehicleID;
    private String type; 
    private String brand;
    private String model;
    private String licensePlate;
    private boolean availabilityStatus; 
    private String location; 
    private boolean maintenanceStatus; 


    public Vehicle(String vehicleID, String type, String brand, String model, String licensePlate) {
        this.vehicleID = vehicleID;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.availabilityStatus = true; 
        this.maintenanceStatus = false;
        this.location = "Unknown"; 
    }

    public String trackLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }

    public void updateMaintenanceStatus(boolean status) {
        this.maintenanceStatus = status;
    }

    public boolean isAvailable() {
        return availabilityStatus && !maintenanceStatus; 
    }

    public void setAvailabilityStatus(boolean status) {
        this.availabilityStatus = status;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isInMaintenance() {
        return maintenanceStatus;
    }
}
