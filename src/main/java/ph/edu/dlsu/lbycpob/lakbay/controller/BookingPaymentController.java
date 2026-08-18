package ph.edu.dlsu.lbycpob.lakbay.controller;

import ph.edu.dlsu.lbycpob.lakbay.payment.MockCreditCardPayment;
import ph.edu.dlsu.lbycpob.lakbay.payment.MockGcashPayment;
import ph.edu.dlsu.lbycpob.lakbay.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingPaymentController {
    private final BookingService bookingService;

    public BookingPaymentController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/pay")
    public String processPayment(
            @RequestParam String mop,
            @RequestParam String accountOrCardNumber,
            @RequestParam String destination,
            @RequestParam String flightDate,
            @RequestParam String flightTime,
            @RequestParam int seats,
            @RequestParam double totalPrice,
            Model model
    ) {
        boolean isValid = false;

        if ("GCASH".equalsIgnoreCase(mop)) {
            isValid = MockGcashPayment.validate(accountOrCardNumber);
        } else if ("CREDIT_CARD".equalsIgnoreCase(mop)) {
            isValid = MockCreditCardPayment.validate(accountOrCardNumber);
        }

        if (!isValid) {
            model.addAttribute("error", "Invalid account or card details. GCash requires 11 digits (09XXXXXXXXX) and Credit Card requires 16 digits.");
            model.addAttribute("mop", mop);
            model.addAttribute("destination", destination);
            model.addAttribute("flightDate", flightDate);
            model.addAttribute("flightTime", flightTime);
            model.addAttribute("seats", seats);
            model.addAttribute("totalPrice", totalPrice);
            return "payment";
        }

        bookingService.createBooking(destination, flightDate, flightTime, seats, totalPrice);
        return "redirect:/home?bookingSuccess=true";
    }
}
