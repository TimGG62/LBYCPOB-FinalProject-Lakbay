package ph.edu.dlsu.lbycpob.lakbay.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.dlsu.lbycpob.lakbay.payment.MockCreditCardPayment;
import ph.edu.dlsu.lbycpob.lakbay.payment.MockGcashPayment;
import ph.edu.dlsu.lbycpob.lakbay.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingPaymentController {
    private final BookingService bookingService;

    public BookingPaymentController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/history")
    public String showHistory(HttpSession session, Model model) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }

        model.addAttribute("bookings", bookingService.getActiveUserBookings());
        return "history";
    }

    //UNDERSTAND: Deals with payment processing and details
    @PostMapping("/pay")
    public String processPayment(
            @RequestParam(defaultValue = "") String mop,
            @RequestParam(defaultValue = "") String accountOrCardNumber,
            @RequestParam(defaultValue = "") String destination,
            @RequestParam(defaultValue = "") String flightDate,
            @RequestParam(defaultValue = "") String flightTime,
            @RequestParam(defaultValue = "1") int seats,
            @RequestParam(defaultValue = "0.0") double totalPrice,
            HttpSession session,
            Model model
    ) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }

        boolean isValid = false;
        if ("GCASH".equalsIgnoreCase(mop)) {
            isValid = MockGcashPayment.validate(accountOrCardNumber);
        } else if ("CREDIT_CARD".equalsIgnoreCase(mop)) {
            isValid = MockCreditCardPayment.validate(accountOrCardNumber);
        }

        if (!isValid) {
            model.addAttribute("error", "Invalid payment details provided.");
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

    @PostMapping("/history/cancel")
    public String cancelBooking(@RequestParam("bookingId") String bookingId, HttpSession session, RedirectAttributes redirectAttributes) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }

        boolean success = bookingService.cancelBooking(bookingId);
        if (!success) {
            redirectAttributes.addFlashAttribute("error", "Bookings within 7 days of the flight date cannot be cancelled.");
        }

        return "redirect:/history";
    }
}
