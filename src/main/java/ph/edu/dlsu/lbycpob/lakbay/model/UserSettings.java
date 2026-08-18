package ph.edu.dlsu.lbycpob.lakbay.model;

// UNDERSTAND: Stores user preferences like preferred currency and notification toggles.
public class UserSettings {
    private String currency = "PHP"; // "PHP" or "USD"
    private boolean promoAlertsEnabled = true;
    private boolean priceDropAlertsEnabled = true;

    public UserSettings() {}

    // UNDERSTAND: Initializes custom settings for the user.
    public UserSettings(String currency, boolean promoAlertsEnabled, boolean priceDropAlertsEnabled) {
        this.currency = currency;
        this.promoAlertsEnabled = promoAlertsEnabled;
        this.priceDropAlertsEnabled = priceDropAlertsEnabled;
    }

    // UNDERSTAND: Getters and Setters.
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public boolean isPromoAlertsEnabled() { return promoAlertsEnabled; }
    public void setPromoAlertsEnabled(boolean promoAlertsEnabled) { this.promoAlertsEnabled = promoAlertsEnabled; }

    public boolean isPriceDropAlertsEnabled() { return priceDropAlertsEnabled; }
    public void setPriceDropAlertsEnabled(boolean priceDropAlertsEnabled) { this.priceDropAlertsEnabled = priceDropAlertsEnabled; }
}