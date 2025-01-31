import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String category;
    private boolean isAvailable;
    private double pricePerNight;

    public Room(int roomNumber, String category, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true; // By default, the room is available
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void reserveRoom() {
        isAvailable = false;
    }

    public void freeRoom() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + category + ", Rs" + pricePerNight + " per night, " +
                (isAvailable ? "Available" : "Booked") + ")";
    }
}

class Reservation {
    private Room room;
    private String customerName;
    private int nights;
    private double totalCost;

    public Reservation(Room room, String customerName, int nights) {
        this.room = room;
        this.customerName = customerName;
        this.nights = nights;
        this.totalCost = room.getPricePerNight() * nights;
    }

    public Room getRoom() {
        return room;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Reservation: Room " + room.getRoomNumber() + ", Customer: " + customerName +
                ", Nights: " + nights + ", Total: Rs" + totalCost;
    }
}

public class HotelReservationSystem {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        initializeRooms(); // Create some sample rooms
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHotel Reservation System Menu:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View All Reservations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", 100.00));
        rooms.add(new Room(102, "Single", 100.00));
        rooms.add(new Room(201, "Double", 150.00));
        rooms.add(new Room(202, "Double", 150.00));
        rooms.add(new Room(301, "Suite", 300.00));
        rooms.add(new Room(302, "Suite", 300.00));
    }

    private static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.println("\nEnter the type of room you want to reserve (Single, Double, Suite): ");
        String category = scanner.nextLine();
        Room availableRoom = null;

        for (Room room : rooms) {
            if (room.isAvailable() && room.getCategory().equalsIgnoreCase(category)) {
                availableRoom = room;
                break;
            }
        }

        if (availableRoom == null) {
            System.out.println("No available rooms in the " + category + " category.");
            return;
        }

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        availableRoom.reserveRoom();
        Reservation reservation = new Reservation(availableRoom, customerName, nights);
        reservations.add(reservation);
        System.out.println("Reservation successful! " + reservation);
    }

    private static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("\nNo reservations found.");
        } else {
            System.out.println("\nAll Reservations:");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
