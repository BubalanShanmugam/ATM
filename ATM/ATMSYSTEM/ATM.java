package ATM.ATMSYSTEM;

import ATM.ATMSYSTEM.Notes.Note;
import ATM.ATMSYSTEM.ListofNotes.*;

import java.util.ArrayList;
import java.util.Arrays;




public class ATM {

    private static ArrayList<Account> listofuser = new ArrayList<>();//list for both user and admin
    private static double balance;//Atm balance(defaultly o.o)
    //arraylist that calls the constructors of twoo,five,two,one and sets the count and denominations as 0....using new .
    private static ArrayList<Note> notesArrayList =new ArrayList<>(Arrays.asList( new Twoo(2000,0),  new Five(500,0), new Two(200,0),new One(100,0)));


    //getters and settors of the ATM's private var.
    public static ArrayList<Note> getNotesArrayList() {
        return notesArrayList;
    }//

    public static void setNotesArrayList(ArrayList<Note> notesArrayList) {
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
