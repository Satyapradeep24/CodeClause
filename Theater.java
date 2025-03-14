import java.util.ArrayList;
import java.util.List;

public class Theater {
    private String name;
    private List<Screen> screens;

    public Theater(String name) {
        this.name = name;
        this.screens = new ArrayList<>();

        // Adding sample movies and screens
        screens.add(new Screen("Inception", new String[]{"10:00 AM", "2:00 PM", "6:00 PM"}));
        screens.add(new Screen("Interstellar", new String[]{"11:00 AM", "3:00 PM", "7:00 PM"}));
        screens.add(new Screen("The Dark Knight", new String[]{"12:00 PM", "4:00 PM", "8:00 PM"}));
    }

    public void displayScreens() {
        System.out.println("\nScreens in " + name + ":");
        for (int i = 0; i < screens.size(); i++) {
            System.out.println((i + 1) + ". " + screens.get(i).getMovieName() + " (Screen " + (i + 1) + ")");
        }
    }

    public void bookSeat() {
        System.out.println("\nEnter screen number (1-" + screens.size() + "): ");
        int screenChoice = MovieBookingSystem.scanner.nextInt();
        MovieBookingSystem.scanner.nextLine(); // Consume newline

        if (screenChoice < 1 || screenChoice > screens.size()) {
            System.out.println("Invalid screen number!");
            return;
        }

        Screen selectedScreen = screens.get(screenChoice - 1);
        selectedScreen.bookSeat();
    }

    public void viewBookings() {
        for (Screen screen : screens) {
            screen.viewBookings();
        }
    }

    public void cancelBooking() {
        System.out.println("\nEnter screen number to cancel booking: ");
        int screenChoice = MovieBookingSystem.scanner.nextInt();
        MovieBookingSystem.scanner.nextLine(); // Consume newline

        if (screenChoice < 1 || screenChoice > screens.size()) {
            System.out.println("Invalid screen number!");
            return;
        }

        Screen selectedScreen = screens.get(screenChoice - 1);
        selectedScreen.cancelBooking();
    }
}
