package ph.edu.dlsu.lbycpob.lakbay.util;

import org.springframework.stereotype.Component;

@Component("currencyFormatter")
public class CurrencyFormatter {
    private static final double PHP_TO_USD_RATE = 0.018;

    public String formatPrice(double amountPhp, String currency) {
        if ("USD".equalsIgnoreCase(currency)) {
            double usdAmount = amountPhp * PHP_TO_USD_RATE;
            return String.format("$%.2f USD", usdAmount);
        }
        return String.format("₱%,.2f", amountPhp);
    }
}
