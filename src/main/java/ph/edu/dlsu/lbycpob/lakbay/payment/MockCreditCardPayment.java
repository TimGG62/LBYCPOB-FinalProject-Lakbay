package ph.edu.dlsu.lbycpob.lakbay.payment;

public class MockCreditCardPayment implements PaymentMethod {

    public MockCreditCardPayment() {}

    //UNDERSTAND: Validates credit card number
    public static boolean validate(String cardNumber) {
        if (cardNumber == null) return false;
        String cleaned = cardNumber.replaceAll("[\\s-]", "");
        return cleaned.matches("^\\d{16}$");
    }

    //UNDERSTAND: Overridden method for payment processing
    @Override
    public boolean processPayment(double amount) {
        return amount > 0;
    }
}
