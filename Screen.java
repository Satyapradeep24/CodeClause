import java.util.*;


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
        System.out.println("\nAvailable time slots for " + movieName + ":");
        for (int i = 0; i < timeSlots.length; i++) {
            System.out.println((i + 1) + ". " + timeSlots[i]);
        }

        System.out.println("Enter the serial number of your preferred time slot (1-3): ");
        int slotIndex = MovieBookingSystem.scanner.nextInt();
        MovieBookingSystem.scanner.nextLine(); // Consume newline

        if (slotIndex < 1 || slotIndex > 3) {
            System.out.println("Invalid selection!");
            return;
        }

        String selectedSlot = timeSlots[slotIndex - 1];

        if (!bookings.containsKey(selectedSlot)) {
            bookings.put(selectedSlot, new Booking(selectedSlot));
        }

        bookings.get(selectedSlot).bookSeat();
    }

    public void viewBookings() {
        System.out.println("\nBookings for " + movieName + ":");
        for (Booking booking : bookings.values()) {
            booking.viewBookings();
        }
    }

    public void cancelBooking() {
        System.out.println("\nAvailable time slots for " + movieName + ":");
        for (int i = 0; i < timeSlots.length; i++) {
            System.out.println((i + 1) + ". " + timeSlots[i]);
        }

        System.out.println("Enter the serial number of the time slot to cancel booking (1-3): ");
        int slotIndex = MovieBookingSystem.scanner.nextInt();
        MovieBookingSystem.scanner.nextLine(); // Consume newline

        if (slotIndex < 1 || slotIndex > 3) {
            System.out.println("Invalid selection!");
            return;
        }

        String selectedSlot = timeSlots[slotIndex - 1];

        if (!bookings.containsKey(selectedSlot)) {
            System.out.println("No bookings found for this time slot!");
            return;
        }

        bookings.get(selectedSlot).cancelSeat();
    }
}
