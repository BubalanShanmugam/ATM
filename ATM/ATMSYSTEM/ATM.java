package ATM.ATMSYSTEM;

import ATM.ATMSYSTEM.Notes.Note;
import ATM.ATMSYSTEM.Notes.Notess;
import java.util.ArrayList;

public abstract class ATM {

    private static ArrayList<Account> listofuser = new ArrayList<>();//list for both user and admin
    private static double balance;//Atm balance(defaultly 0.0)
    static Notess<Note> notesArrayList = new Notess<>();//the user defined type collection of var.


    //getters and settors of the ATM's private var.

    public static void setNotesArrayList(Notess<Note> notesArrayList) {
        ATM.notesArrayList = notesArrayList;
    }

    public static void setBalance(double balance) {
        ATM.balance = balance;
    }

    public static double getBalance() {
        return balance;
    }

    public static ArrayList<Account> getListofuser() {
        return listofuser;
    }

}
