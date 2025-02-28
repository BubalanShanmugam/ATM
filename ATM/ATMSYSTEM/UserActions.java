package ATM.ATMSYSTEM;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import ATM.ATMSYSTEM.Notes.Note;
import ATM.ATMSYSTEM.Notes.Notess;

class UserActions implements UserActionInterface {
        @Override
        public Account Login(Scanner sc) {//method to the user login
            int attempts = 0;//for iteration
            while (attempts < 3) {//to iterate till 3 rd attempt.(name)
                attempts++;//incrementing attempts
                //getting username
                System.out.print("Enter user account number: ");
                int accnumber = Integer.parseInt(sc.nextLine());
                for (Account user : ATM.getListofuser()) {//takes the user and admin object element from the userlist.
                    if (user instanceof User) {//checks....user is the User object type.
                        int attempt = 0;//for iteration(pass)
                        while (attempt <= 2) {//to iterate till 3 rd attempt.(pass)
                            attempt++;//incrementing attempt
                            if (user.getAcnum() == accnumber) {//enters into the body ,if the usernme is equal to the given username.
                                //getting pass
                                System.out.print("Enter Password: ");
                                int password = Integer.parseInt(sc.nextLine());

                                if (user.getAcnum() == (accnumber) && user.getPin() == password) {//enters into the body ,if the usernme and pass is equal to the given username and pass.
                                    System.out.println("Login successful!");
                                    return user;//if successfull login returns the current user object
                                } else if (user.getAcnum() == accnumber && user.getPin() != password) {//if name correct and pass is wrong
                                    System.out.println("Please enter the valid pass");
                                } else {//both are wrong
                                    return new User(0, 0,0);
                                }
                            }
                        }
                    }
                }
            }
            //if username was mismatched for all the attempts
            System.out.println("ATTEMPT FINISHED!.. User not found.");
            return null;
        }

        public void deposit(double amount, Scanner sc, User user, Notess newnote) {//user deposit method
            //denomintion count getting
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
            // claculating the total using the denomination and count of respective denominations
            int total = t2000 + f500 + t200 + o100;
            if (amount == total) {//if total amount and deposited amount is equal
                for (Note note : newnote.getNotearray()) {//from the notesarraylist......gets all the  Notes objects
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
                user.setBalance(user.getBalance() + amount);//setting userbalance after user depositing
                System.out.println("Deposit successful. New balance: " + user.getBalance());

                user.getTransactions().add(new Transfer(user.getAcnum(), "Deposit", amount));//adding the transaction of the deposited process,to the transactions using the user object
            } else {//if denominations are mismatching.
                System.out.println("Denominations are mismatching...!PLease enter the valid Denominations");
            }
        }

        public double performwithdraw(double amount, Note notes, ArrayList<String> statement) {// method for denominateed withdraw
            int count = (int) amount / notes.getDenomination();//devides the amount useing the denomiinations,1 st -> 2000,2 nd ->500......
            if (notes.getDenomination() <= amount && count <= notes.getNote())//if the denomination iis less than amount and count is less than the no. of count of the available note.
            {
                amount -= (count * notes.getDenomination());//minusing the amount
                statement.add("Note :" + notes.getDenomination() + " | Count: " + count);//adding the denomination statement in the string type statement arraylist
                notes.setNote((notes.getNote() - count));//minus the count
                return amount;//returns the minused amount.
            }
            return amount;//this value is the not reduced.because it doesn't entered into the minusing process
        }

        public void withdraw(double amount, User user,Notess newnote) throws CloneNotSupportedException {//method for the user withdraw
           UserActions userActions = new UserActions();
            if (user.getBalance() >= amount) {//enters only if the withdraw amount is greater than the balance
                double amount1 = amount;//we are going to change the withdraw amount...so for final purpose we had stored into the another var. (amount1)
                ArrayList<String> statement = new ArrayList<>();//string arrarlist name statement (for denomination statements)
                Notess<Note> duplicatenotes = new Notess<>();//to copy the orginal notesarrylist

                for (Note notes : newnote.getNotearray()) {//from the notesarraylist......gets all the  Notes objects
                    duplicatenotes.set(notes.clone());//adds the orginal notes objects into duplicate list using clone(shallow copy)
                }

                while (amount != 0) {//untill amount not 0
                    for (Note notesinduplicate : duplicatenotes.getNotearray()) {//from the duplicatenotes......gets all the  Notes objects
                        int type = notesinduplicate.getDenomination();//2000,500,200,100(it takes one by one for each iterations)
                        switch (type) {//switch case for calling peerformwithdraw with respective dennominations
                            case 2000, 500, 200, 100://modern switch case
                                amount = (int) userActions.performwithdraw(amount, notesinduplicate, statement);//calling performwithdraw for all the deniminations
                                break;
                        }
                    }

                    if (amount == 0) {//if amount gets 0
                        ATM.setNotesArrayList(duplicatenotes);//setting the notesarraylist's denominations and count as perthe result of the perform withdraw method.
                        user.setBalance(user.getBalance() - amount1);//setting the balance for the user after withdraw
                        user.getTransactions().add(new Transfer(user.getAcnum(), "Withdraw", amount1));//Adding the transaction to the transaction arraylist
                        System.out.println("Withdrawal successful. Current Balance: " + user.getBalance());
                        for (String s : statement) {//to print the withdraw statement one by one
                            System.out.println("Withdrawl Denominations :" + s);
                        }
                        break;
                    } else {//if denominations are mismatching.
                        System.out.println("Denominations are not available,Enter another amount...");
                        break;
                    }
                }
            } else// if balance < withdraw amount
            {
                System.out.println("Insufficient balance.");
            }
        }

        public double viewBalance(User user) {//method to view the balance
            for (Account account : ATM.getListofuser()) {//takes the user and admin object element from the userlist.
                if (account instanceof User) {//checks....user is the User object type.
                    return user.getBalance();//returns the balance of the current user object.
                }
            }
            return 0;
        }

        public void viewTransactionHistory(User user) {//method to view transaction of user
            for (Account account : ATM.getListofuser()) {//takes the user and admin object element from the userlist.
                if (account instanceof User) {//checks....user is the User object type.
                    if (account.equals(user)) {//enters body,if account is current user object type
                        ArrayList<Transfer> transactions = user.getTransactions();//stores transaction history of the user object in the transactions arraylist
                        if (transactions.isEmpty()) {//if transactions is empty
                            System.out.println("No transaction history available.");
                        } else {//if not empty
                            System.out.println("\nTransaction History:");
                            for (Transfer transfer : transactions) {//iterates one by one
                                System.out.println(transfer);//prints it
                            }
                        }
                    }
                }
            }
        }

        public void changePassword(int currentPassword, User user, Scanner sc) {//method to change the password
            for (Account account : ATM.getListofuser())//takes the user and admin object element from the userlist.
            {
                if (account instanceof User) {//checks....user is the User object type.
                    if (currentPassword != user.getPin()) {//if current password is not equal..then gets out
                        System.out.println(" password was mismatching...!Please try later with valid current PIN");

                    } else {//if password is matching

                        //getting new pass
                        System.out.print("Enter new password: ");
                        int newPassword = Integer.parseInt(sc.nextLine());

                        user.setPin(newPassword);//settig the new pin
                        System.out.println("Password changed successfully.");
                        break;
                    }
                }
            }
        }
    }




