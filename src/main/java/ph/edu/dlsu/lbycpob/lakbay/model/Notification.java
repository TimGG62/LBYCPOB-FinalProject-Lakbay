package ph.edu.dlsu.lbycpob.lakbay.model;

import java.time.LocalDateTime;

// UNDERSTAND: Represents an alert or message for the user, like flight reminders or promos.
public class Notification {
    private String id;
    private String title;
    private String message;
    private String type; // "FLIGHT_REMINDER", "CANCELLATION", "PROMO", "PRICE_DROP"
    private LocalDateTime timestamp;

}