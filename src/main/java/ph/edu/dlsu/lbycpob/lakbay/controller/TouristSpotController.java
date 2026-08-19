package ph.edu.dlsu.lbycpob.lakbay.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.lbycpob.lakbay.model.TouristSpot;
import ph.edu.dlsu.lbycpob.lakbay.model.UserSettings;
import ph.edu.dlsu.lbycpob.lakbay.service.TouristSpotService;
import ph.edu.dlsu.lbycpob.lakbay.util.CurrencyFormatter;

import java.util.List;

@Controller
public class TouristSpotController {

    private final TouristSpotService touristSpotService;
    private final CurrencyFormatter currencyFormatter;

    public TouristSpotController(TouristSpotService touristSpotService, CurrencyFormatter currencyFormatter) {
        this.touristSpotService = touristSpotService;
        this.currencyFormatter = currencyFormatter;
    }

    //UNDERSTAND: Displays tourist spots filtered by country or region name
    @GetMapping({"/country/{locationName}", "/destination/{locationName}"})
    public String showSpotsByLocation(@PathVariable String locationName, Model model) {
        List<TouristSpot> matchingSpots = touristSpotService.getAllSpots().stream()
                .filter(s -> s.getCountryOrLocation().equalsIgnoreCase(locationName))
                .toList();

        model.addAttribute("locationName", locationName);
        model.addAttribute("spots", matchingSpots.isEmpty() ? touristSpotService.getAllSpots() : matchingSpots);
        return "country-spots";
    }
    //UNDERSTAND: Spot Detail & Flight Booking View
    @GetMapping("/spot/{spotId}")
    public String showSpotDetails(@PathVariable String spotId, HttpSession session, Model model) {
        UserSettings settings = (UserSettings) session.getAttribute("userSettings");
        String currency = (settings != null && settings.getCurrency() != null) ? settings.getCurrency() : "PHP";

        TouristSpot spot = touristSpotService.getSpotById(spotId);
        if (spot == null) {
            List<TouristSpot> spots = touristSpotService.getAllSpots();
            if (spots != null && !spots.isEmpty()) {
                spot = spots.get(0);
            }
        }
        if (spot != null) {
            model.addAttribute("spot", spot);
            model.addAttribute("formattedPrice", currencyFormatter.formatPrice(spot.getEstimatedPrice(), currency));
        }
        return "spot-detail";
    }

    //UNDERSTAND: Proceeds from Spot detail view to Payment page
    @PostMapping("/spot/proceed-to-payment")
    public String proceedToPayment(
            @RequestParam String destination,
            @RequestParam String flightDate,
            @RequestParam String flightTime,
            @RequestParam int seats,
            @RequestParam double pricePerSeat,
            HttpSession session,
            Model model
    ) {
        UserSettings settings = (UserSettings) session.getAttribute("userSettings");
        String currency = (settings != null && settings.getCurrency() != null) ? settings.getCurrency() : "PHP";

        double totalPrice = pricePerSeat * seats;
        model.addAttribute("destination", destination);
        model.addAttribute("flightDate", flightDate);
        model.addAttribute("flightTime", flightTime);
        model.addAttribute("seats", seats);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("formattedTotalPrice", currencyFormatter.formatPrice(totalPrice, currency));
        return "payment";
    }
}
