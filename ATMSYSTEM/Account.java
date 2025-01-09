package ATM.bubalanatms.ATMSYSTEM;

import java.util.ArrayList;

public class Account {//Account pojo class

    private  String name;//Name for the both user and admin
    private  int pin;//pin for the both user and admin
    private ArrayList<Transfer> transactions = new ArrayList<>();//transactions arraylist for the both user and admin

//gettor for the transactions
    public ArrayList<Transfer> getTransactions() {
        return transactions;
    }

//Account class's constructor.
    protected Account(String username, int password) {
        this.name = username;
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
    public String getName() {
        return name;
    }

}
