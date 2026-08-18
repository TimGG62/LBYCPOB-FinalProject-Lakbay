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

}
