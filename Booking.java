import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String timeSlot;
    private List<String> bookedSeats;

    public Booking(String timeSlot) {
        this.timeSlot = timeSlot;
        this.bookedSeats = new ArrayList<>();
    }

    public void bookSeat() {
        System.out.println("\nTotal seats: 100 | Booked: " + bookedSeats.size());
        if (bookedSeats.size() >= 100) {
            System.out.println("Error: No available seats for this show!");
            return;
        }

        System.out.println("Enter seat row (A-E) and number (1-20) (e.g., A5, C10): ");
        String seat = MovieBookingSystem.scanner.nextLine().toUpperCase();

        if (!seat.matches("[A-E](1[0-9]|20|[1-9])") || bookedSeats.contains(seat)) {
            System.out.println("Invalid or already booked seat!");
            return;
        }

        bookedSeats.add(seat);
        System.out.println("Seat " + seat + " booked successfully for " + timeSlot);
    }

    public void viewBookings() {
        if (bookedSeats.isEmpty()) {
            System.out.println("No bookings for " + timeSlot);
        } else {
            System.out.println(timeSlot + " - Booked Seats:");
            for (int i = 0; i < bookedSeats.size(); i++) {
                System.out.println((i + 1) + ". " + bookedSeats.get(i));
            }
        }
    }

    public void cancelSeat() {
        if (bookedSeats.isEmpty()) {
            System.out.println("No bookings available to cancel.");
            return;
        }

        System.out.println("\nYour booked seats for " + timeSlot + ":");
        for (int i = 0; i < bookedSeats.size(); i++) {
            System.out.println((i + 1) + ". " + bookedSeats.get(i));
        }

        System.out.println("Enter the serial number of the ticket to cancel: ");
        int seatIndex = MovieBookingSystem.scanner.nextInt();
        MovieBookingSystem.scanner.nextLine(); // Consume newline

        if (seatIndex < 1 || seatIndex > bookedSeats.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        String removedSeat = bookedSeats.remove(seatIndex - 1);
        System.out.println("Seat " + removedSeat + " has been canceled successfully.");
    }
}
