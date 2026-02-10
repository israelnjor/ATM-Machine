//import java.sql.SQLOutput;

public class ATM {
    private final String username;
    private final int accountNumber;
    private final int pin;
    private double balance;
    private final double dailyLimit;
    private double withdrawnToday;

    public ATM(String username, int accountNumber, int pin, double balance, double dailyLimit) {
        this.username = username;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.dailyLimit = dailyLimit;
        this.withdrawnToday = 0;
    }

    //GETTERS

    public String getUsername() {
        return "Username: " + username;
    }

    public String getAccountNumber() {
        return "Account Number: " + accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getDailyLimit() {
        return dailyLimit;
    }

    public double getWithdrawnToday() {
        return withdrawnToday;
    }

    //VALIDATE PIN
    private boolean validatePin(int inputPin) {
        return inputPin == pin;
    }

    //DEPOSIT
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Deposit Amount");
            return;
        }
        balance += amount;
        System.out.println("An amount of " + amount + " has been Successfully Deposited THANK YOU!");
    }

    public boolean withdraw(double amount, int inputPin) {
        if (!validatePin(inputPin) || amount <= 0 || amount > balance || (withdrawnToday + amount) > dailyLimit) {
            System.out.println("Transaction failed. Check PIN, balance, or daily limit.");
            return false;
        }
        balance -= amount;
        withdrawnToday += amount;
        System.out.println("Withdrawal Successful!");
        System.out.println("Withdrawal Amount: " + amount);
        System.out.println("Current balance: " + balance);
        System.out.print("Available Balance: " + (balance + amount));
        return true;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber +
                "\nCurrent Balance: " + balance +
                "\nDaily Limit: " + dailyLimit +
                "\nAmount Withdrawn Today: " + withdrawnToday;
    }

    public static void main(String[] args) {
        ATM user1 = new ATM("Israelnjor", 22302635, 85407, 1_000_000, 10_000_000);
        System.out.println(user1.getUsername());
        System.out.println(user1.getAccountNumber());
        System.out.println("Initial Balance: " + user1.getBalance());

        user1.deposit(5000);
        System.out.println("Current Balance: "+ user1.getBalance());
        user1.withdraw(250000, 85407);
//        user1.getWithdrawnToday();
        System.out.println(user1.getWithdrawnToday());

        System.out.println("\n" +user1.getAccountSummary());


    }

}
