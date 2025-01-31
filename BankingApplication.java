import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;

        System.out.println("Welcome to Simple Banking Application!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Check Balance
                    System.out.printf("Your current balance is: Rs%.2f\n", balance);
                    break;

                case 2: // Deposit Money
                    System.out.print("Enter the amount to deposit: Rs");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.printf("Rs%.2f deposited successfully.\n", deposit);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    break;

                case 3: // Withdraw Money
                    System.out.print("Enter the amount to withdraw: Rs");
                    double withdrawal = scanner.nextDouble();
                    if (withdrawal > 0 && withdrawal <= balance) {
                        balance -= withdrawal;
                        System.out.printf("Rs%.2f withdrawn successfully.\n", withdrawal);
                    } else if (withdrawal > balance) {
                        System.out.println("Insufficient balance. Please try a smaller amount.");
                    } else {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    break;

                case 4: // Exit
                    System.out.println("Thank you for using Simple Banking Application. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
