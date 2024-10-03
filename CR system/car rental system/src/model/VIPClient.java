package model;

public class VIPClient extends Client {

    public VIPClient(String clientID, String name, String contactInfo) {
        super(clientID, name, contactInfo, "VIP");
    }

    @Override
    public double getLoyaltyDiscount() {
        double baseDiscount = super.getLoyaltyDiscount();
        return baseDiscount + 0.05;
    }
}