/**
 * Demonstrates basic room modeling using abstraction and inheritance.
 * This use case introduces room types and static availability before
 * introducing data structures.
 *
 * Version: 2.1
 *
 * @author Abhisheak Baskaran
 */

abstract class Room {

    private String roomType;
    private int beds;
    private int size;
    private double price;

    public Room(String roomType, int beds, int size, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq.ft");
        System.out.println("Price per night: $" + price);
    }
}


/**
 * Single Room implementation
 */
class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 1, 200, 100);
    }
}


/**
 * Double Room implementation
 */
class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 2, 350, 180);
    }
}


/**
 * Suite Room implementation
 */
class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite Room", 3, 500, 350);
    }
}


/**
 * Application entry point for Use Case 2
 */
class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Hotel Booking Management System v2.1");
        System.out.println("-------------------------------------");

        // Creating room objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        System.out.println("\nRoom Details:\n");

        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailability);
        System.out.println("--------------------------------");

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailability);
        System.out.println("--------------------------------");

        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailability);
        System.out.println("--------------------------------");

        System.out.println("Application execution completed.");
    }
}/**
 * Entry point for the Book My Stay application.
 * Demonstrates how a Java program begins execution.
 *
 * @author Abhisheak Baskaran
 * @version 1.0
 */
