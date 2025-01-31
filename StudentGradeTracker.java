import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        // Create an ArrayList to store grades
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Student Grade Tracker!");
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a grade");
            System.out.println("2. View all grades");
            System.out.println("3. Calculate average grade");
            System.out.println("4. Find highest grade");
            System.out.println("5. Find lowest grade");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1: // Add a grade
                    System.out.print("Enter the grade (0-100): ");
                    int grade = scanner.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                        System.out.println("Grade added successfully.");
                    } else {
                        System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                    }
                    break;
                
                case 2: // View all grades
                    if (grades.isEmpty()) {
                        System.out.println("No grades available.");
                    } else {
                        System.out.println("Grades: " + grades);
                    }
                    break;
                
                case 3: // Calculate average grade
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to calculate the average.");
                    } else {
                        double average = calculateAverage(grades);
                        System.out.printf("Average grade: %.2f\n", average);
                    }
                    break;
                
                case 4: // Find highest grade
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to find the highest grade.");
                    } else {
                        int highest = findHighest(grades);
                        System.out.println("Highest grade: " + highest);
                    }
                    break;
                
                case 5: // Find lowest grade
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to find the lowest grade.");
                    } else {
                        int lowest = findLowest(grades);
                        System.out.println("Lowest grade: " + lowest);
                    }
                    break;
                
                case 6: // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to calculate the average grade
    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Method to find the highest grade
    public static int findHighest(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest grade
    public static int findLowest(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
