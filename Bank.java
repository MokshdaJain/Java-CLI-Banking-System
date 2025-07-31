import java.util.*;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();
    private Random rand = new Random();           // ← NEW

    /** Generates a unique 6-digit account number */
    private String generateAccountNumber() {      // ← NEW
        String accNo;
        do {
            accNo = String.format("%06d", rand.nextInt(1_000_000));
        } while (accounts.containsKey(accNo));
        return accNo;
    }

    public String createAccount(String name, double initialDeposit) {
        String accNo = generateAccountNumber();
        Account acc = new Account(accNo, name, initialDeposit);
        accounts.put(accNo, acc);
        System.out.println("Account created successfully. Your Account Number is: " + accNo);
        return accNo;
    }


    public void showAccount(String accNo) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Name: " + acc.getName().toUpperCase());
            System.out.println("Balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deposit(String accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.deposit(amount);
            System.out.println("Deposited successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            if (acc.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Cannot withdraw. Minimum balance of ₹500 must be maintained.");

            }
        } else {
            System.out.println("Account not found.");
        }
    }
}