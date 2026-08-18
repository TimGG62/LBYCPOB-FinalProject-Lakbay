package ph.edu.dlsu.lbycpob.lakbay.service;

import org.springframework.stereotype.Service;
import ph.edu.dlsu.lbycpob.lakbay.model.TouristSpot;
import java.util.ArrayList;
import java.util.List;

// UNDERSTAND: Acts as a local database containing a predefined list of domestic and international tourist destinations.
@Service
public class TouristSpotService {

    private final List<TouristSpot> spots = new ArrayList<>();

}