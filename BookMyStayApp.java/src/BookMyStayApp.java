import java.util.*;


class Reservation {

    private String reservationId;
    private String guestName;
    private String roomType;
    private double roomPrice;

    public Reservation(String reservationId, String guestName, String roomType, double roomPrice) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void displayReservation() {
        System.out.println("Reservation ID : " + reservationId);
        System.out.println("Guest Name     : " + guestName);
        System.out.println("Room Type      : " + roomType);
        System.out.println("Room Price     : $" + roomPrice);
        System.out.println("-------------------------------");
    }
}


class BookingHistory {

    private List<Reservation> confirmedBookings;

    public BookingHistory() {
        confirmedBookings = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        confirmedBookings.add(reservation);
    }

    public List<Reservation> getAllReservations() {
        return confirmedBookings;
    }
}


class BookingReportService {

    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }


    public void displayAllReservations() {
        System.out.println("\nConfirmed Booking History");
        System.out.println("-------------------------------");

        List<Reservation> bookings = history.getAllReservations();

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : bookings) {
            r.displayReservation();
        }
    }

    public void displaySummaryReport() {

        List<Reservation> bookings = history.getAllReservations();

        int totalBookings = bookings.size();
        double totalRevenue = 0;

        for (Reservation r : bookings) {
            totalRevenue += r.getRoomPrice();
        }

        System.out.println("\nBooking Summary Report");
        System.out.println("-------------------------------");
        System.out.println("Total Bookings : " + totalBookings);
        System.out.println("Total Revenue  : $" + totalRevenue);
    }
}


 class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Hotel Booking Management System v8.0");
        System.out.println("-------------------------------------");

        BookingHistory history = new BookingHistory();


        Reservation r1 = new Reservation("RES-101", "Alice", "Single Room", 100);
        Reservation r2 = new Reservation("RES-102", "Bob", "Double Room", 180);
        Reservation r3 = new Reservation("RES-103", "Charlie", "Suite Room", 350);


        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);


        BookingReportService reportService = new BookingReportService(history);

        reportService.displayAllReservations();
        reportService.displaySummaryReport();
    }
}