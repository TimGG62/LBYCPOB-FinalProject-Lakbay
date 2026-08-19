package ph.edu.dlsu.lbycpob.lakbay.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ph.edu.dlsu.lbycpob.lakbay.model.TouristSpot;
import ph.edu.dlsu.lbycpob.lakbay.service.TouristSpotService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private TouristSpotService touristSpotService;

    //UNDERSTAND: Displays the home page
    @GetMapping({"/", "/home"})
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }

        List<TouristSpot> allSpots = touristSpotService.getAllSpots();
        List<TouristSpot> uniqueLocations = new ArrayList<>();
        Set<String> seenLocations = new HashSet<>();

        for (TouristSpot spot : allSpots) {
            String location = spot.getCountryOrLocation();
            if (location != null && !seenLocations.contains(location.toLowerCase())) {
                seenLocations.add(location.toLowerCase());
                uniqueLocations.add(spot);
            }
        }

        model.addAttribute("spots", uniqueLocations);
        return "home";
    }
}