package ATM.ATMSYSTEM;

public class User extends Account {//USer pojo class
    private double balance;//balance of the users.

    public User(int accnum, int password,double balance) {//User constructor to call the Account's contructor. and initiate balance hete itself.
        super(accnum, password);//calling super Cinstructor
        this.balance = balance;//reassinging balance value.
    }

    //gettors and setters of  user balance .
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
