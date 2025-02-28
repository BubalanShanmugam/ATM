package ATM.ATMSYSTEM;

import ATM.ATMSYSTEM.Notes.Notess;

import java.util.Scanner;

public interface AdminActionsInterface extends Actions {
      Account Login(Scanner sc) ;
      void deposit ( double deposit, Scanner sc, Admin admin,Notess newnote);
      void addUserAccount(Scanner sc);
      void deleteUserAccount(int usernameToDelete) ;
      void viewUserList() ;
      void viewTransactionHistory(Admin admin) ;
      void viewTransactions(Scanner sc);

//      void deposit(double deposit, Scanner sc, Admin admin, Notess newnote);

      void viewtrahis (Scanner sc, Admin admin);
}
