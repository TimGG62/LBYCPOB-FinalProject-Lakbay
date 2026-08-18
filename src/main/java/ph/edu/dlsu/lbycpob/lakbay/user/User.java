package ph.edu.dlsu.lbycpob.lakbay.user;

import ph.edu.dlsu.lbycpob.lakbay.model.Ticket;
import java.util.ArrayList;
import java.util.List;

public abstract class User {

    public static class UnauthorizedAccessException extends RuntimeException {
        public UnauthorizedAccessException(String message) {
            super(message);
        }
    }

    protected String name;
    protected String email;

    // Encapsulated sensitive data
    private String password;
    private List<Ticket> bookingHistory;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.bookingHistory = new ArrayList<>();
    }

    public String getName() { return name; }

    // Secure getter for booking history (returns a copy to protect original data)
    public List<Ticket> getBookingHistory() {
        return new ArrayList<>(bookingHistory);
    }

    // Controlled setter for adding to history
    public void addBooking(Ticket ticket) {
        if (ticket != null) {
            this.bookingHistory.add(ticket);
        }
    }
}