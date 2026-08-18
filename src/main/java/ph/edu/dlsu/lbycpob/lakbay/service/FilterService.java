package ph.edu.dlsu.lbycpob.lakbay.service;

import org.springframework.stereotype.Service;
import ph.edu.dlsu.lbycpob.lakbay.model.TouristSpot;
import java.util.List;
import java.util.stream.Collectors;

// UNDERSTAND: Filters tourist spots to recommend the top destinations based on user preferences.
@Service
public class FilterService {

    // UNDERSTAND: Filtering spots by location and budget, returning the top 5 highly recommended ones.
    public List<TouristSpot> findTop5Destinations(List<TouristSpot> allSpots, String scope, double maxBudget, int maxDays, List<String> vibes, int pax) {
        if (allSpots == null) return List.of();

        return allSpots.stream()
                .filter(spot -> "Any".equalsIgnoreCase(scope) || spot.getScope().equalsIgnoreCase(scope))
                .filter(spot -> spot.getEstimatedPrice() * pax <= maxBudget)
                .sorted((s1, s2) -> Double.compare(s2.getRating(), s1.getRating()))
                .limit(5)
                .collect(Collectors.toList());
    }
}