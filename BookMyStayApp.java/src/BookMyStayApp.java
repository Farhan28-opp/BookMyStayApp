import java.util.LinkedList;
import java.util.Queue;


class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Requested Room : " + roomType);
        System.out.println("---------------------------");
    }
}


class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }


    public void addRequest(Reservation reservation) {

        requestQueue.add(reservation);

        System.out.println("Booking request received from " + reservation.getGuestName());
    }


    public void displayRequests() {

        System.out.println("\nPending Booking Requests (FIFO Order)");
        System.out.println("-------------------------------------");

        for (Reservation reservation : requestQueue) {
            reservation.displayReservation();
        }
    }
}


class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Hotel Booking Management System v5.0");
        System.out.println("------------------------------------");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guest booking requests
        Reservation r1 = new Reservation("Alice", "Single Room");
        Reservation r2 = new Reservation("Bob", "Double Room");
        Reservation r3 = new Reservation("Charlie", "Suite Room");


        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);


        bookingQueue.displayRequests();

        System.out.println("\nAll requests stored in FIFO order.");
        System.out.println("Inventory is not modified at this stage.");
    }
}