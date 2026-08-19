package ph.edu.dlsu.lbycpob.lakbay.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.lbycpob.lakbay.model.UserSettings;
import ph.edu.dlsu.lbycpob.lakbay.user.Passenger;
import ph.edu.dlsu.lbycpob.lakbay.user.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class AuthController {

    // In-memory user storage (Username/Email -> Password)
    private final Map<String, String> userStore = new ConcurrentHashMap<>();

    public AuthController() {
        // Pre-loaded default test credentials
        userStore.put("user@lakbay.com", "password123");
        userStore.put("user", "password123");
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String email, //UNDERSTAND: Accepts username or email input from form
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        //UNDERSTAND: Mock authentication check
        if (userStore.containsKey(email) && userStore.get(email).equals(password)) {
            User loggedUser = new Passenger("Juan Dela Cruz", email, password, "P12345678");
            session.setAttribute("currentUser", loggedUser);
            if (session.getAttribute("userSettings") == null) {
                session.setAttribute("userSettings", new UserSettings("PHP", true, true));
            }
            return "redirect:/home";
        }

        model.addAttribute("error", "Invalid username/email or password.");
        return "login";
    }
    //UNDERSTAND: Displays registration page
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    //UNDERSTAND: Handles information input in registration
    @PostMapping("/register")
    public String handleRegister(
            @RequestParam(required = false, defaultValue = "Juan Dela Cruz") String name,
            @RequestParam String email, //UNDERSTAND: Receives the Username input field value
            @RequestParam String password,
            @RequestParam String confirmPassword,
            @RequestParam(required = false, defaultValue = "P12345678") String passportNumber,
            Model model
    ) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "register";
        }

        // Store new account
        userStore.put(email, password);

        return "redirect:/login?registered=true";
    }
}