package ATM.ATMSYSTEM;

public class Transfer {
    private int username;
    private String type;
    private double amount;

    public Transfer(int username, String type, double amount) {
        //super();[implicitly calling the constructor of object class]
        this.username = username;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Name: " + username + " | Transaction: " + type + " | Amount: " + amount+"\n\t\t";
    }
}
