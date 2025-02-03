package ATM.ATMSYSTEM;

import java.util.ArrayList;
import java.util.Scanner;
import ATM.ATMSYSTEM.Notes.Note;

    public class AdminActions { //admin actions class

        public static Account adminLogin(Scanner sc,int adminUsername) {// admin login method
            int attempts = 0;//for condition purpose
            while (attempts < 3) {//repeats untill 3 attempts
                boolean usernameExists = false;//condition purpose
                for (Account admin : ATM.getListofuser()) {//takes the user and admin object element from the userlist.
                    if (admin instanceof Admin) {//checks....admin is the Admin / User object type.
                        if (admin.getAcnum()==(adminUsername)) {//enters into the body ,if the adminname is equal to the given adminname.
                            usernameExists = true;
                            break;
                        }
                    }
                }
                if (!usernameExists) {//if user is not avilable.
                    return null;//returns admin as null . (if admin is not valid.
                }
                //password
                System.out.print("Enter Admin Password: ");
                int password = Integer.parseInt(sc.nextLine());

                for (Account admin : ATM.getListofuser()) {//takes the user and admin object element from the userlist.
                    if (admin instanceof Admin) {//checks....admin is the Admin object type.
                        if (admin.getAcnum()==(adminUsername) && admin.getPin() == password) {//enters into the body ,if the adminname is equal to the given adminname and pass.
                            System.out.println("Login successful!");
                            return admin;//returns the admin object iuf the admin is valid.
                        }
                    }
                }
                attempts++;//increments the attempts
                System.out.println("Invalid credentials. Try again.");
            }
            System.out.println("attempt finished");
            return null;//if not admin found.
        }


        public void addUserAccount(Scanner sc) {//method to add user.
            //gets the username for the user
            System.out.print("Enter new account num: ");
            int newaccount = Integer.parseInt(sc.nextLine());
            for (Account account : ATM.getListofuser()) {//takes the user and admin object element from the userlist.
                if (account instanceof User) {//checks....admin is the User object type.
                    if (account.getAcnum()==(newaccount)) {//enters into the body ,if the usernme is equal to the given username.
                        System.out.println("User is already Exist.....Enter the newusername");
                        return;
                    }
                }
            }
            System.out.print("Enter new password: ");
            int password = Integer.parseInt(sc.nextLine());
            User newUser = new User(newaccount, password, 0);

            ATM.getListofuser().add(newUser);
            System.out.println("User account added.");
        }

        public void deleteUserAccount(int usernameToDelete) {
            User userToDelete = null;
            for (Account user : ATM.getListofuser()) {//takes the user and admin object element from the userlist.
                if (user instanceof User) {//checks....admin is the User object type.
                    if (user.getAcnum()==(usernameToDelete)) {//enters into the body ,if the usernme is equal to the given username.
                        userToDelete = (User) user;//for the condition purpose boolean var.
                        break;//if any user has the given name ...then breaks.
                    }
                }
            }
            if (userToDelete != null) {//if user is available
                ATM.getListofuser().remove(userToDelete);//romoves the user object from the listofusers
                System.out.println("User account deleted.");
            } else {//if user not found.
                System.out.println("User not found.");
            }
        }

        public void viewUserList() {//user list view method

            ArrayList<User> list = new ArrayList<>();//local list to store the user objects only.
            for (Account account : ATM.getListofuser()) {//takes the user and admin object element from the userlist.
                if (account instanceof User) {//checks....admin is the User object type.
                    list.add((User) account);//adds all the user object to the list .
                }
            }
            if (list.isEmpty()) {//if the user list is empty
                System.out.println("No users available.");
            } else {//if any user found
                for (User account : list) {//takes the user objects from the userlist and prints
                    System.out.println("User Name :" + account.getAcnum() + " | Balance :" + account.getBalance());
                }
            }
        }

        public void viewTransactionHistory(Admin admin) {//Admin transaction method.
            if (admin.getTransactions().isEmpty()) {//checks if the transactions of admin object is empty or not.
                System.out.println("No Admin transactions found.");
            } else {//if not empty
                System.out.println("Admin Transaction History:");
                for (Transfer transfer : admin.getTransactions()) {//iterates all the admin transactions and prints it.
                    System.out.println(transfer);//printing the transaction.
                }
            }
        }

        public void viewTransactions(Scanner sc) {//to view the user transactions
            //getting the name of the user need to print.
            System.out.print("Enter the account number of the user: ");
            int username = Integer.parseInt(sc.nextLine());
            for (Account account : ATM.getListofuser()) {//takes the user and admin object element from the userlist.
                User user = null;
                if (account instanceof User) {//checks....admin is the User object type.
                    if (account.getAcnum()==(username)) {//enters into the body ,if the usernme is equal to the given username.
                        user = (User) account;//if username is equal...stores it

                        if (user == null) {//if user is not available
                            System.out.println("User not found!");
                        } else {//user is available
                            ArrayList<Transfer> userTransactions = user.getTransactions();//storing the particular user's transactions to another arraylist
                            if (userTransactions.isEmpty()) {//if no transactions available.
                                System.out.println("No transactions found for user: " + username);
                            } else {//if transactions are found.
                                System.out.println("Transaction History for user: " + username);
                                for (Transfer transfer : userTransactions) {//iterates the user 's gransactions and prints them.
                                    System.out.println(transfer);//printing the transaction.
                                }
                            }
                        }
                    }
                }
            }
        }


            public double adminDeposit ( int deposit, Scanner sc, Admin admin) {//admin deposit method
                //getting the denomination's count
                System.out.print("2000=");
                int tk = Integer.parseInt(sc.nextLine());
                System.out.print("500=");
                int f = Integer.parseInt(sc.nextLine());
                System.out.print("200=");
                int t = Integer.parseInt(sc.nextLine());
                System.out.print("100=");
                int o = Integer.parseInt(sc.nextLine());

                int t2000 = 2000 * tk;
                int f500 = 500 * f;
                int t200 = 200 * t;
                int o100 = 100 * o;
                //by multipling the count and respective denominations ....get the total value.
                int total = t2000 + f500 + t200 + o100;
                if (deposit == total) {//if total is equal to the deposit value....getting in..
                    for (Note note : ATM.getNotesArrayList()) {//from the notesarraylist......gets all the  Notes objects
                        int notetype = note.getDenomination();//using the Note object stores the denomination...2000/500/200/100
                        switch (notetype) {//swith case for the setting notes count.
                            case 2000://if the note type is 2000
                                note.setNote(note.getNote() + tk);
                            case 500://if the note type is 500
                                note.setNote(note.getNote() + f);
                            case 200://if the note type is 200
                                note.setNote(note.getNote() + t);
                            case 100://if the note type is 100
                                note.setNote(note.getNote() + o);
                        }
                    }

                    ATM.setBalance(ATM.getBalance() + deposit);//setting balance after depositing

                    admin.getTransactions().add(new Transfer(admin.getAcnum(), "Deposit", deposit));//adding the transaction of the deosited process,to the admin transactions
                    System.out.println("Deposit successful. New balance: " + ATM.getBalance());
                }else{//if denomination is mismatching...
                    System.out.println("Denominations doesn't matching...!\n Please enter the real value");
                    return adminDeposit(deposit,sc,admin);
                }
                return 0;
            }

            public void viewtrahis (Scanner sc, Admin admin)//method for view transaction
            {
                //Transaction options
                System.out.println("\nSelect an option:");
                System.out.println("1.  Admin transaction history");
                System.out.println("2.  User transaction history");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {//switch case for Transactions
                    case 1://if choice is 1(admin trasactions)
                        viewTransactionHistory(admin);
                        break;

                    case 2://if choice is 1(user trasactions)
                        viewTransactions(sc);
                        break;

                    default://if...invalid choice
                        System.out.println("Invalid choice, please enter the valid choice.");
                }
            }
    }