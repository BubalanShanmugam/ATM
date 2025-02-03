package ATM.ATMSYSTEM;

import java.util.ArrayList;

public class Account {//Account pojo class

    private  int acnum;//Name for the both user and admin
    private  int pin;//pin for the both user and admin
    private ArrayList<Transfer> transactions = new ArrayList<>();//transactions arraylist for the both user and admin

//gettor for the transactions
    public ArrayList<Transfer> getTransactions() {
        return transactions;
    }

//Account class's constructor.
    protected Account(int accnum, int password) {
        this.acnum = accnum;
        this.pin = password;
    }

//gettor for pin
    public int getPin() {
        return pin;
    }
//settor for pin
    public void setPin(int pin) {
        this.pin = pin;
    }
    //gettor for the name
    public int getAcnum() {
        return acnum;
    }

}
