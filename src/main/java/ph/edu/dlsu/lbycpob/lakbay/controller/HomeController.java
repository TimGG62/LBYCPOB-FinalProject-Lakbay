package ph.edu.dlsu.lbycpob.lakbay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.lbycpob.lakbay.model.TouristSpot;
import ph.edu.dlsu.lbycpob.lakbay.service.FilterService;
import ph.edu.dlsu.lbycpob.lakbay.service.TouristSpotService;

import java.util.List;

@Controller
public class HomeController {
    private final FilterService filterService;
    private final TouristSpotService touristSpotService;


    public HomeController(FilterService filterService, TouristSpotService touristSpotService) {
        this.filterService = filterService;
        this.touristSpotService = touristSpotService;
    }


    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }


    @GetMapping("/home")
    public String home(@RequestParam(required = false, defaultValue = "international") String tab, Model model) {
        model.addAttribute("activeTab", tab);


        List<TouristSpot> spots = touristSpotService.getAllSpots().stream()
                .filter(s -> tab.equalsIgnoreCase(s.getScope()))
                .toList();


        model.addAttribute("spots", spots);
        return "home";
    }

