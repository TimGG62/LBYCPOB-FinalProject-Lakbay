package ph.edu.dlsu.lbycpob.lakbay.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.dlsu.lbycpob.lakbay.model.TouristSpot;
import ph.edu.dlsu.lbycpob.lakbay.model.UserSettings;
import ph.edu.dlsu.lbycpob.lakbay.service.FilterService;
import ph.edu.dlsu.lbycpob.lakbay.service.TouristSpotService;

import java.util.List;

// Handles tourist spot filtering requests
@Controller
public class FilterController {

    // Fixed exchange rate for USD to PHP
    private static final double USD_TO_PHP = 58.0;

    private final TouristSpotService touristSpotService;
    private final FilterService filterService;

    // Inject required service dependencies
    public FilterController(TouristSpotService touristSpotService, FilterService filterService) {
        this.touristSpotService = touristSpotService;
        this.filterService = filterService;
    }

    // Displays the filter page
    @GetMapping("/filter")
    public String showFilterForm(HttpSession session, Model model) {
        // SESSION: Fetch user currency preference or default to PHP
        UserSettings settings = (UserSettings) session.getAttribute("userSettings");
        String currency = (settings != null && settings.getCurrency() != null) ? settings.getCurrency() : "PHP";

        //Pass currency to filter view
        model.addAttribute("currency", currency);
        return "filter";
    }

    // Processes filter form inputs and returns matching destinations
    @PostMapping("/filter/results")
    public String processFilter(
            @RequestParam(defaultValue = "Any") String scope,
            @RequestParam(defaultValue = "50000") double maxBudget,
            @RequestParam(defaultValue = "7") int maxDays,
            @RequestParam(defaultValue = "0") double maxDistance,
            @RequestParam(defaultValue = "1") int pax,
            @RequestParam(required = false) List<String> vibes,
            HttpSession session,
            Model model
    ) {
        // Retrieve user currency preference
        UserSettings settings = (UserSettings) session.getAttribute("userSettings");
        String currency = (settings != null && settings.getCurrency() != null) ? settings.getCurrency() : "PHP";

        //Standardize budget to PHP if input is USD
        double budgetInPhp = "USD".equalsIgnoreCase(currency) ? maxBudget * USD_TO_PHP : maxBudget;

        // Load all tourist spot destinations
        List<TouristSpot> allSpots = touristSpotService.getAllSpots();

        // Find top 5 destinations based on user criteria
        List<TouristSpot> topSpots = filterService.findTop5Destinations(allSpots, scope, budgetInPhp, maxDays, maxDistance, vibes, pax);

        // Attach results and currency setting to results page
        model.addAttribute("topSpots", topSpots);
        model.addAttribute("currency", currency);
        return "filter-results";
    }
}