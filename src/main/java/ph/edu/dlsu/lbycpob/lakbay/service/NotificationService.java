package ph.edu.dlsu.lbycpob.lakbay.service;

import org.springframework.stereotype.Service;
import ph.edu.dlsu.lbycpob.lakbay.model.Notification;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// UNDERSTAND: Manages the creation, storage, and filtering of user notifications like flight reminders and random promos.
@Service
public class NotificationService {

    private final List<Notification> notifications = new ArrayList<>();
    private final Random random = new Random();

    // UNDERSTAND: List of random notifications to sample from
    private final List<Notification> promoPool = List.of(
            new Notification("p1", "50% Off Flash Sale", "Get up to 50% off on Tokyo flights this weekend!", "PROMO", LocalDateTime.now().minusHours(2)),
            new Notification("p2", "Weekend Getaway Deal", "Exclusive 20% discount on Boracay resorts!", "PROMO", LocalDateTime.now().minusHours(4)),
            new Notification("p3", "Price Drop Alert", "Flight prices to Osaka dropped by ₱2,500.", "PRICE_DROP", LocalDateTime.now().minusDays(1)),
            new Notification("p4", "Price Drop Alert", "Roundtrip fares to Palawan are now starting at ₱3,200.", "PRICE_DROP", LocalDateTime.now().minusHours(6)),
            new Notification("p5", "Schedule Update", "Flight LK-204 departure time shifted by 15 mins.", "CANCELLATION", LocalDateTime.now().minusDays(2))
    );

}