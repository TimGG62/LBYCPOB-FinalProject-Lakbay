package ph.edu.dlsu.lbycpob.lakbay.model;

// UNDERSTAND: Stores user preferences like preferred currency and notification toggles.
public class UserSettings {
    private String currency = "PHP"; // "PHP" or "USD"
    private boolean promoAlertsEnabled = true;
    private boolean priceDropAlertsEnabled = true;

    public UserSettings() {}

}