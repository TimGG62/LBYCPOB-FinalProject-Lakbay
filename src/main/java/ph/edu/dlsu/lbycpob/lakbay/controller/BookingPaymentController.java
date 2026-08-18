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

}
