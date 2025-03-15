import java.util.Scanner;

public class MovieBookingSystem {
    static Theater theater;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        theater = new Theater("City Cinema");

        while (true) {
            System.out.println("\n===== Movie Ticket Booking System =====");
            System.out.println("1. View Screens & Movies");
            System.out.println("2. Select Movie & Book Seat");
            System.out.println("3. View My Bookings");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    theater.displayScreens();
                    break;
                case 2:
                    theater.bookSeat();
                    break;
                case 3:
                    theater.viewBookings();
                    break;
                case 4:
                    theater.cancelBooking();
                    break;
                case 5:
                    System.out.println("Thank you for using Movie Booking System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
