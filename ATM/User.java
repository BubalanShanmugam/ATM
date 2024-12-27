import java.util.ArrayList;

public class User {
    private String username;
    private int password;
    private double balance;
    private ArrayList<Transfer> transactionHistory;

    public User(String username, int password) {
        this.username = username;
        this.password = password;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public int setBalance(double balance) {
        this.balance = balance;
        return 0;
    }

    public ArrayList<Transfer> getTransactionHistory() {
        return transactionHistory;
    }

//    public void setTransactionHistory(ArrayList<Transfer> transactionHistory) {
//        this.transactionHistory = transactionHistory;
//    }

    public double getbalance() {
        return balance;
    }

    public void addTransaction(Transfer transfer ){
        transactionHistory.add(transfer);
    }

}
