package ph.edu.dlsu.lbycpob.lakbay.model;

public abstract class Ticket {

    public static class InvalidBookingException extends RuntimeException {
        public InvalidBookingException(String message) {
            super(message);
        }
    }
    public abstract double calculateTotalCost();
}