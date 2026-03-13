import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Room class representing common properties of all rooms.
 * Version: 4.0
 */
abstract class Room {

    protected String roomType;
    protected double price;
    protected String amenities;

    public Room(String roomType, double price, String amenities) {
        this.roomType = roomType;
        this.price = price;
        this.amenities = amenities;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public String getAmenities() {
        return amenities;
    }

    public void displayDetails() {
        System.out.println("Room Type : " + roomType);
        System.out.println("Price     : $" + price);
        System.out.println("Amenities : " + amenities);
    }
}

/**
 * Single Room implementation
 */
class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 100, "1 Bed, WiFi, TV");
    }
}

/**
 * Double Room implementation
 */
class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 180, "2 Beds, WiFi, TV, Mini Fridge");
    }
}

/**
 * Suite Room implementation
 */
class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite Room", 350, "King Bed, WiFi, TV, Living Area");
    }
}

/**
 * Centralized Room Inventory (Read-only access for search)
 */
class RoomInventory {

    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 0); // Example unavailable room
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}

/**
 * Search Service – Handles read-only room search operations.
 */
class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms() {

        System.out.println("\nAvailable Rooms");
        System.out.println("---------------------");

        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            if (available > 0) {

                room.displayDetails();
                System.out.println("Available : " + available);
                System.out.println("---------------------");
            }
        }
    }
}

/**
 * Application Entry Point for Use Case 4
 */
 class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Hotel Booking Management System v4.0");
        System.out.println("------------------------------------");

        RoomInventory inventory = new RoomInventory();

        RoomSearchService searchService = new RoomSearchService(inventory);

        searchService.searchAvailableRooms();

        System.out.println("\nSearch completed. Inventory state unchanged.");
    }
}