package ph.edu.dlsu.lbycpob.lakbay.payment;

public interface PaymentMethod {
    boolean processPayment(double amount);
}