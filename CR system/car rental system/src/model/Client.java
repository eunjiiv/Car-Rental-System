package model;

public class Client {
    private String clientID;
    private String name;
    private String contactInfo;
    private String clientType;
    private int loyaltyPoints;
    private LoyaltyTier loyaltyTier;

    public Client(String clientID, String name, String contactInfo, String clientType) {
        this.clientID = clientID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.clientType = clientType;
        this.loyaltyPoints = 0;
        this.loyaltyTier = LoyaltyTier.BRONZE;
    }

    public void accumulateLoyaltyPoints(double price) {
        loyaltyPoints += (int) price / 10; 
        updateLoyaltyTier(); 
    }


    private void updateLoyaltyTier() {
        if (loyaltyPoints > 1000) {
            loyaltyTier = LoyaltyTier.GOLD;
        } else if (loyaltyPoints > 500) {
            loyaltyTier = LoyaltyTier.SILVER;
        } else {
            loyaltyTier = LoyaltyTier.BRONZE;
        }
    }

    public double getLoyaltyDiscount() {
        switch (loyaltyTier) {
            case GOLD:
                return 0.15;
            case SILVER:
                return 0.10;
            default:
                return 0.05;
        }
    }

    public LoyaltyTier getLoyaltyTier() {
        return loyaltyTier;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public String getClientID() {
        return clientID;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
}
