package ph.edu.dlsu.lbycpob.lakbay.model;

import java.time.LocalDateTime;

// UNDERSTAND: Represents an alert or message for the user, like flight reminders or promos.
public class Notification {
    private String id;
    private String title;
    private String message;
    private String type; // "FLIGHT_REMINDER", "CANCELLATION", "PROMO", "PRICE_DROP"
    private LocalDateTime timestamp;

    public Notification() {}

    // UNDERSTAND: Initializes a complete notification with its title, message, and time.
    public Notification(String title, String message, String type) {
        this.id = java.util.UUID.randomUUID().toString();
        this.title = title;
        this.message = message;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}