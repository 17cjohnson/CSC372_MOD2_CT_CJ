package bank;

public class BankAccount {

    private String firstName;
    private String lastName;
    private int accountID;
    protected double balance;

    public BankAccount() {
        balance = 0.0;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdrawal(double amount) {
        balance = balance - amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        lastName = name;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int id) {
        accountID = id;
    }

    public double getBalance() {
        return balance;
    }

    public void accountSummary() {
        System.out.println("Account Info");
        System.out.println("Owner: " + firstName + " " + lastName);
        System.out.println("ID #: " + accountID);
        System.out.println("Money: $" + String.format("%.2f", balance));
    }
}
