public class BankAccount {

    private double balance;

    private String[] transactions = new String[100];

    private int transactionCount = 0;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        System.out.println("Your Balance: " + balance);
    }

    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;

            if (transactionCount < transactions.length) {
                transactions[transactionCount] =
                    "Deposited: " + amount;
                transactionCount++;
            }

            System.out.println("Deposit Successful!");

        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        }

        else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        }

        else {
            balance -= amount;

            if (transactionCount < transactions.length) {
                transactions[transactionCount] =
                    "Withdrawn: " + amount;
                transactionCount++;
            }

            System.out.println("Withdrawal Successful!");
        }
    }

    public void showHistory() {

        System.out.println("\nTransaction History:");

        if (transactionCount == 0) {
            System.out.println("No transactions yet.");
        }

        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactions[i]);
        }
    }
}