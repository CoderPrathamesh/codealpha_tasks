import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    private String name;
    private String startDate;
    private String endDate;
    private double budget;

    public Destination(String name, String startDate, String endDate, double budget) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Start Date: " + startDate + ", End Date: " + endDate + ", Budget: $" + budget;
    }
}

public class TravelItineraryPlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();

        System.out.println("Welcome to the Travel Itinerary Planner!");

        System.out.print("Enter the number of destinations: ");
        int numberOfDestinations = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfDestinations; i++) {
            System.out.println("\nEnter details for destination " + (i + 1) + ":");

            System.out.print("Enter destination name: ");
            String name = scanner.nextLine();

            System.out.print("Enter start date (e.g., YYYY-MM-DD): ");
            String startDate = scanner.nextLine();

            System.out.print("Enter end date (e.g., YYYY-MM-DD): ");
            String endDate = scanner.nextLine();

            System.out.print("Enter budget for this destination: $");
            double budget = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            itinerary.add(new Destination(name, startDate, endDate, budget));
            System.out.println("Destination added successfully.");
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Itinerary");
            System.out.println("2. Calculate Total Budget");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (itinerary.isEmpty()) {
                        System.out.println("Your itinerary is empty.");
                    } else {
                        System.out.println("Your Travel Itinerary:");
                        for (Destination destination : itinerary) {
                            System.out.println(destination);
                        }
                    }
                    break;

                case 2:
                    double totalBudget = 0;
                    for (Destination destination : itinerary) {
                        totalBudget += destination.getBudget();
                    }
                    System.out.printf("Total estimated budget: $%.2f\n", totalBudget);
                    break;

                case 3:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Safe travels!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
