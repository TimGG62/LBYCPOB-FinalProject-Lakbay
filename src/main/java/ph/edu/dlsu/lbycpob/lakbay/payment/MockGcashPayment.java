package ph.edu.dlsu.lbycpob.lakbay.payment;

public class MockGcashPayment implements PaymentMethod {

    public MockGcashPayment() {}

    public static boolean validate(String phoneNumber) {
        if (phoneNumber == null) return false;
        String cleaned = phoneNumber.replaceAll("[\\s-]", "");
        return cleaned.matches("^(09\\d{9}|\\+639\\d{9})$");
    }

    @Override
    public boolean processPayment(double amount) {
        return amount > 0;
    }
}
