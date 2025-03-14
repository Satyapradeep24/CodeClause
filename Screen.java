import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Screen {
    private String movieName;
    private String[] timeSlots;
    private Map<String, Booking> bookings;

    public Screen(String movieName, String[] timeSlots) {
        this.movieName = movieName;
        this.timeSlots = timeSlots;
        this.bookings = new HashMap<>();
    }

    public String getMovieName() {
        return movieName;
    }

    public void bookSeat() {
        System.out.println("\nAvailable time slots for " + movieName + ": " + Arrays.toString(timeSlots));
        System.out.println("Enter time slot (e.g., '10:00 AM'): ");
        String slot = MovieBookingSystem.scanner.nextLine();

        if (!Arrays.asList(timeSlots).contains(slot)) {
            System.out.println("Invalid time slot!");
            return;
        }

        if (!bookings.containsKey(slot)) {
            bookings.put(slot, new Booking(slot));
        }

        bookings.get(slot).bookSeat();
    }

    public void viewBookings() {
        System.out.println("\nBookings for " + movieName + ":");
        for (Booking booking : bookings.values()) {
            booking.viewBookings();
        }
    }

    public void cancelBooking() {
        System.out.println("\nEnter time slot (e.g., '10:00 AM') to cancel booking: ");
        String slot = MovieBookingSystem.scanner.nextLine();

        if (!bookings.containsKey(slot)) {
            System.out.println("No bookings found for this time slot!");
            return;
        }

        bookings.get(slot).cancelSeat();
    }
}
