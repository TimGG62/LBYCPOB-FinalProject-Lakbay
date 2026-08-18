package ph.edu.dlsu.lbycpob.lakbay.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.lbycpob.lakbay.model.UserSettings;
import ph.edu.dlsu.lbycpob.lakbay.user.Passenger;
import ph.edu.dlsu.lbycpob.lakbay.user.User;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }


    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        // Mock authentication check
        if ("user@lakbay.com".equals(email) && "password123".equals(password)) {
            User loggedUser = new Passenger("Juan Dela Cruz", email, password, "P12345678");
            session.setAttribute("currentUser", loggedUser);


            // Initialize default settings if not set
            if (session.getAttribute("userSettings") == null) {
                session.setAttribute("userSettings", new UserSettings("PHP", true, true));
            }
            return "redirect:/home";
        }
