import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- Banking System -----");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Deposit: ");
                    double deposit = sc.nextDouble();

                    // ✅ get the returned auto-generated accNo
                    String accNo = bank.createAccount(name, deposit);

                    System.out.println("Please note your Account Number: " + accNo);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();
                    bank.showAccount(accNo);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();
                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();
                    bank.deposit(accNo, amt);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();
                    System.out.print("Enter Amount: ");
                    amt = sc.nextDouble();
                    bank.withdraw(accNo, amt);
                    break;

                case 5:
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);
    }
}

