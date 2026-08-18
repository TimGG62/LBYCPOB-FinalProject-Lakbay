package ph.edu.dlsu.lbycpob.lakbay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.lbycpob.lakbay.model.TouristSpot;
import ph.edu.dlsu.lbycpob.lakbay.service.TouristSpotService;

import java.util.List;

@Controller
public class TouristSpotController {

    private final TouristSpotService touristSpotService;

    public TouristSpotController(TouristSpotService touristSpotService) {
        this.touristSpotService = touristSpotService;
    }

    //UNDERSTAND: Displays tourist spots filtered by country or region name
    @GetMapping("/destination/{locationName}")
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
    public String showSpotDetails(@PathVariable String spotId, Model model) {
        TouristSpot spot = touristSpotService.getSpotById(spotId);
        if (spot == null) {
            // Fallback to first spot if ID not found
            spot = touristSpotService.getAllSpots().get(0);
        }
        model.addAttribute("spot", spot);
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
            Model model
    ) {
        double totalPrice = pricePerSeat * seats;
        model.addAttribute("destination", destination);
        model.addAttribute("flightDate", flightDate);
        model.addAttribute("flightTime", flightTime);
        model.addAttribute("seats", seats);
        model.addAttribute("totalPrice", totalPrice);
        return "payment";
    }
}
