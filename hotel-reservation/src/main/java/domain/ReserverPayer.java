package domain;

public class ReserverPayer extends Guest {

    private final String creditCardDetails;
    private final String id;

    public ReserverPayer(String name, String addressDetails, String creditCardDetails, String id) {
        super(name, addressDetails);

        if (creditCardDetails == null || creditCardDetails.isBlank()) {
            throw new IllegalArgumentException("Credit card details cannot be null or empty");
        }
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ReserverPayer ID cannot be null or empty");
        }

        this.creditCardDetails = creditCardDetails;
        this.id = id;
    }

    public String getCreditCardDetails() {
        return creditCardDetails;
    }

    public String getId() {
        return id;
    }
}
