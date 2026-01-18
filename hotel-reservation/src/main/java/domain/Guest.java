package domain;

public class Guest {

    private final String name;
    private final String addressDetails;

    public Guest(String name, String addressDetails) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Guest name cannot be null or empty");
        }
        if (addressDetails == null || addressDetails.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        this.name = name;
        this.addressDetails = addressDetails;
    }

    public String getName() {
        return name;
    }

    public String getAddressDetails() {
        return addressDetails;
    }
}
