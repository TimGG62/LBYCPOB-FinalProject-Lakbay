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
