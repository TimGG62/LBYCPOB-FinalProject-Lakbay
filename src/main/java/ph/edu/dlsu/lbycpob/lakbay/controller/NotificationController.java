package ph.edu.dlsu.lbycpob.lakbay.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ph.edu.dlsu.lbycpob.lakbay.model.UserSettings;
import ph.edu.dlsu.lbycpob.lakbay.service.NotificationService;

@Controller
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    //UNDERSTAND: Displays user notifications
    @GetMapping("/notifications")
    public String showNotifications(HttpSession session, Model model) {
        UserSettings settings = (UserSettings) session.getAttribute("userSettings");
        if (settings == null) {
            settings = new UserSettings();
        }
        model.addAttribute("notifications", notificationService.getFilteredNotifications(settings));
        return "notifications";
    }
}
