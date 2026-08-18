package ph.edu.dlsu.lbycpob.lakbay.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// UNDERSTAND: Represents a flight booking with customer details, schedule, pricing, and cancellation rules.
public class Booking {
    private String id;
    private String username;
    private String destination;
    private LocalDate flightDate;
    private String flightTime;
    private int seats;
    private double totalPrice;
    private String status; // "BOOKED", "CANCELLED"

    public Booking() {}

    // UNDERSTAND: Initializes a complete booking object with all required details.
    public Booking(String id, String username, String destination, LocalDate flightDate, String flightTime, int seats, double totalPrice, String status) {
        this.id = id;
        this.username = username;
        this.destination = destination;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.seats = seats;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // UNDERSTAND: Checks if cancellation is allowed, only if current date is at least 7 days before the flight date.
    public boolean canCancel() {
        if (flightDate == null || "CANCELLED".equalsIgnoreCase(status)) {
            return false;
        }
        long daysUntilFlight = ChronoUnit.DAYS.between(LocalDate.now(), flightDate);
        return daysUntilFlight >= 7;
    }

    // UNDERSTAND: Getters and Setters.
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDate getFlightDate() { return flightDate; }
    public void setFlightDate(LocalDate flightDate) { this.flightDate = flightDate; }

    public String getFlightTime() { return flightTime; }
    public void setFlightTime(String flightTime) { this.flightTime = flightTime; }

    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
