import java.util.*;


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
}


class RoomInventory {

    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 2);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void decrementRoom(String roomType) {
        int count = inventory.get(roomType);
        inventory.put(roomType, count - 1);
    }

    public void displayInventory() {
        System.out.println("\nCurrent Inventory State");
        System.out.println("-----------------------");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}


class BookingRequestQueue {

    private Queue<Reservation> queue = new LinkedList<>();

    public void addRequest(Reservation reservation) {
        queue.add(reservation);
    }

    public Reservation getNextRequest() {
        return queue.poll();
    }

    public boolean hasRequests() {
        return !queue.isEmpty();
    }
}


class BookingService {

    private RoomInventory inventory;


    private Set<String> allocatedRoomIds = new HashSet<>();


    private Map<String, Set<String>> roomAllocationMap = new HashMap<>();

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void processReservation(Reservation reservation) {

        String roomType = reservation.getRoomType();

        if (inventory.getAvailability(roomType) <= 0) {
            System.out.println("No rooms available for " + reservation.getGuestName());
            return;
        }


        String roomId = roomType.substring(0, 2).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 4);


        while (allocatedRoomIds.contains(roomId)) {
            roomId = roomType.substring(0, 2).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 4);
        }

        allocatedRoomIds.add(roomId);


        roomAllocationMap.putIfAbsent(roomType, new HashSet<>());
        roomAllocationMap.get(roomType).add(roomId);


        inventory.decrementRoom(roomType);
        System.out.println("Reservation Confirmed");
        System.out.println("Guest : " + reservation.getGuestName());
        System.out.println("Room Type : " + roomType);
        System.out.println("Assigned Room ID : " + roomId);
        System.out.println("------------------------------");
    }
}


class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Hotel Booking Management System v6.0");
        System.out.println("-------------------------------------");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        BookingService bookingService = new BookingService(inventory);

        // Add booking requests
        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));
        queue.addRequest(new Reservation("Charlie", "Suite Room"));
        queue.addRequest(new Reservation("David", "Single Room"));


        while (queue.hasRequests()) {

            Reservation request = queue.getNextRequest();

            bookingService.processReservation(request);
        }


        inventory.displayInventory();

        System.out.println("\nRoom allocation process completed.");
    }
}