import java.util.*;

class AddOnService {

    private String serviceName;
    private double cost;

    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }

    public void displayService() {
        System.out.println(serviceName + " : $" + cost);
    }
}

class Reservation {

    private String reservationId;
    private String guestName;
    private String roomType;

    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
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
}

class AddOnServiceManager {

    private Map<String, List<AddOnService>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    public void addService(String reservationId, AddOnService service) {

        reservationServices.putIfAbsent(reservationId, new ArrayList<>());

        reservationServices.get(reservationId).add(service);

        System.out.println("Service added: " + service.getServiceName());
    }

    public void displayServices(String reservationId) {

        System.out.println("\nServices for Reservation: " + reservationId);
        System.out.println("----------------------------------");

        List<AddOnService> services = reservationServices.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        for (AddOnService service : services) {
            service.displayService();
        }
    }


    public double calculateTotalCost(String reservationId) {

        double total = 0;

        List<AddOnService> services = reservationServices.get(reservationId);

        if (services != null) {
            for (AddOnService service : services) {
                total += service.getCost();
            }
        }

        return total;
    }
}


 class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Hotel Booking Management System v7.0");
        System.out.println("-------------------------------------");


        Reservation reservation = new Reservation("RES-101", "Alice", "Single Room");

        AddOnServiceManager manager = new AddOnServiceManager();


        AddOnService breakfast = new AddOnService("Breakfast", 20);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 50);
        AddOnService spa = new AddOnService("Spa Access", 40);


        manager.addService(reservation.getReservationId(), breakfast);
        manager.addService(reservation.getReservationId(), airportPickup);
        manager.addService(reservation.getReservationId(), spa);


        manager.displayServices(reservation.getReservationId());


        double totalCost = manager.calculateTotalCost(reservation.getReservationId());

        System.out.println("\nTotal Add-On Cost: $" + totalCost);

        System.out.println("\nBooking and inventory remain unchanged.");
    }
}