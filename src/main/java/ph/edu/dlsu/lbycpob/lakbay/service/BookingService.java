package ph.edu.dlsu.lbycpob.lakbay.service;

import org.springframework.stereotype.Service;
import ph.edu.dlsu.lbycpob.lakbay.model.Booking;
import ph.edu.dlsu.lbycpob.lakbay.model.Ticket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// UNDERSTAND: Handles the core logic for creating, cancelling, and paying for flight bookings.
@Service
public class BookingService implements GenericService<Ticket>, BookingSystem {

    private final List<Ticket> globalBookedTickets = new ArrayList<>();
    private final List<Booking> userBookings = new ArrayList<>();

    // UNDERSTAND: Generates a new booking with a random ID and saves it to the user's list.
    public Booking createBooking(String destination, String flightDateStr, String flightTime, int seats, double totalPrice) {
        Booking booking = new Booking(UUID.randomUUID().toString().substring(0, 8).toUpperCase(),
                "Juan Dela Cruz",
                destination,
                LocalDate.parse(flightDateStr),
                flightTime,
                seats,totalPrice,
                "BOOKED");

        userBookings.add(booking);

        return booking;
    }

    // UNDERSTAND: Attempting the cancellation of booking seeing if it meets the 7-day rule.
    public boolean cancelBooking(String bookingId) {
        for (Booking booking : userBookings) {
            if (booking.getId().equalsIgnoreCase(bookingId)) {
                if (booking.canCancel()) {
                    booking.setStatus("CANCELLED");
                    return true;
                } else {
                    return false; // Less than 7 days prior
                }
            }
        }
        return false;
    }

    // UNDERSTAND: Retrieves all bookings made by the user.
    public List<Booking> getUserBookings() {
        return userBookings;
    }

    // UNDERSTAND: Retrieves all tickets booked across the entire system.
    @Override
    public List<Ticket> getAll() {
        return globalBookedTickets;
    }

}