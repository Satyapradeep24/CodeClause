import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String timeSlot;
    private List<Integer> bookedSeats;

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

        System.out.println("Enter seat number (1-100): ");
        int seat = MovieBookingSystem.scanner.nextInt();
        MovieBookingSystem.scanner.nextLine(); // Consume newline

        if (seat < 1 || seat > 100 || bookedSeats.contains(seat)) {
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
            System.out.println(timeSlot + " - Booked Seats: " + bookedSeats);
        }
    }

    public void cancelSeat() {
        System.out.println("Enter seat number to cancel: ");
        int seat = MovieBookingSystem.scanner.nextInt();
        MovieBookingSystem.scanner.nextLine(); // Consume newline

        if (!bookedSeats.contains(seat)) {
            System.out.println("No booking found for seat " + seat);
            return;
        }

        bookedSeats.remove((Integer) seat);
        System.out.println("Seat " + seat + " cancelled for " + timeSlot);
    }
}
