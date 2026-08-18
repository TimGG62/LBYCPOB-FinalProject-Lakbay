package ph.edu.dlsu.lbycpob.lakbay.service;

import org.springframework.stereotype.Service;
import ph.edu.dlsu.lbycpob.lakbay.model.Booking;
import ph.edu.dlsu.lbycpob.lakbay.model.Ticket;
import java.util.ArrayList;
import java.util.List;

// UNDERSTAND: Handles the core logic for creating, cancelling, and paying for flight bookings.
@Service
public class BookingService implements GenericService<Ticket>, BookingSystem {

    private final List<Ticket> globalBookedTickets = new ArrayList<>();
    private final List<Booking> userBookings = new ArrayList<>();


}