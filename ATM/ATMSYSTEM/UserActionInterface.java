package ATM.ATMSYSTEM;

import ATM.ATMSYSTEM.Notes.Note;
import ATM.ATMSYSTEM.Notes.Notess;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Scanner;

public interface UserActionInterface extends Actions{
    Account Login(Scanner sc);
    void deposit(double amount, Scanner sc, User user, Notess newnote);
    double performwithdraw(double amount, Note notes, ArrayList<String> statement);
    void withdraw(double amount, User user,Notess newnote) throws CloneNotSupportedException;
    double viewBalance(User user);
    void viewTransactionHistory(User user);
    void changePassword(int currentPassword, User user, Scanner sc);

}
