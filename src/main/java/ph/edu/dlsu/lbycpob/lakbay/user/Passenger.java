package ph.edu.dlsu.lbycpob.lakbay.user;

public class Passenger extends User {
    private String passportNumber;

    public Passenger(String name, String email, String password, String passportNumber) {
        super(name, email, password);
        this.passportNumber = passportNumber;
    }
}