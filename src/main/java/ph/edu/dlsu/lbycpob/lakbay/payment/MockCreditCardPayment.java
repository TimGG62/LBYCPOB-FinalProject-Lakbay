package ph.edu.dlsu.lbycpob.lakbay.payment;

public class MockCreditCardPayment implements PaymentMethod {

    public MockCreditCardPayment() {}

    public static boolean validate(String cardNumber) {
        if (cardNumber == null) return false;
        String cleaned = cardNumber.replaceAll("[\\s-]", "");
        return cleaned.matches("^\\d{16}$");
    }

    @Override
    public boolean processPayment(double amount) {
        return amount > 0;
    }
}
