package ph.edu.dlsu.lbycpob.lakbay.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.lbycpob.lakbay.model.UserSettings;
import ph.edu.dlsu.lbycpob.lakbay.service.BookingService;


@Controller
public class UserController {


    private final BookingService bookingService;


    public UserController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping("/settings")
    public String showSettings(HttpSession session, Model model) {
        UserSettings settings = (UserSettings) session.getAttribute("userSettings");
        if (settings == null) {
            settings = new UserSettings();
            session.setAttribute("userSettings", settings);
        }
        model.addAttribute("settings", settings);
        return "settings";
    }


    @PostMapping("/settings/update")
    public String updateSettings(
            @RequestParam String currency,
            @RequestParam(defaultValue = "false") boolean promoAlertsEnabled,
            @RequestParam(defaultValue = "false") boolean priceDropAlertsEnabled,
            HttpSession session
    ) {
        UserSettings settings = new UserSettings(currency, promoAlertsEnabled, priceDropAlertsEnabled);
        session.setAttribute("userSettings", settings);
        return "redirect:/settings?updated=true";
    }
