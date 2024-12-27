import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

    public class UserActions {
        private User user;

        public UserActions(User user) {
            this.user = user;
        }
        public UserActions() {

        }


        public static boolean userLogin(Scanner sc, AdminActions adminActions) throws CloneNotSupportedException {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();
            System.out.print("Enter Password: ");
            int password = Integer.parseInt(sc.nextLine());

            for (User user : ATM.getUserAcc()) {
                if (user.getUsername().equals(username) && user.getPassword() == password) {
                    UserActions userActions = new UserActions(user);
                    ATMActions.userMenu(sc, userActions);
                    return true;
                }
            }
            System.out.println("Invalid credentials! User not found.");
            return false;
        }

        public void deposit(double amount, Scanner sc) {
            System.out.print("2000=");
            int tk=Integer.parseInt(sc.nextLine());
            System.out.print("500=");
            int f=Integer.parseInt(sc.nextLine());
            System.out.print("200=");
            int t=Integer.parseInt(sc.nextLine());
            System.out.print("100=");
            int o=Integer.parseInt(sc.nextLine());

            int t2000= 2000*tk;
            int f500= 500*f;
            int t200=200*t;
            int o100=100*o;

            int total = t2000+f500+t200+o100;
            if(amount==total){
                ArrayList<Notes> notesArrayList= ATM.getNotesArrayList();
                for( Notes note:ATM.getNotesArrayList()){
                    int notetype = note.getDenomination();
                    switch (notetype) {
                        case 2000:
                            note.setNote(note.getNote() + tk);
                        case 500:
                            note.setNote(note.getNote() + f);
                        case 200:
                            note.setNote(note.getNote() + t);
                        case 100:
                            note.setNote(note.getNote() + o);
                    }
                }
                user.setBalance(user.getbalance()+ amount);
//              System.out.println("admin balance"+ ATM.getBalance());
                System.out.println("Deposit successful. New balance: " + user.getBalance());
//                Transfer tr=new Transfer(user.getUsername(),"Deposit", amount);
//                user.setTransactionHistory();
                user.getTransactionHistory().add(new Transfer(user.getUsername(), "Deposit", amount));
            }
        }

        public static double performwithdraw(double amount,Notes notes,ArrayList<String> statement) {
            int count = (int)amount / notes.getDenomination();
            if (notes.getDenomination() <= amount && count <= notes.getNote())
            {
                amount -= (count * notes.getDenomination());

                statement.add("Note :"+notes.getDenomination() +" | Count: " + String.valueOf(count));
                notes.setNote((notes.getNote() - count));
                return amount;
            }
            return amount;
        }
        public void withdraw(double amount) throws CloneNotSupportedException {
            double amount1 = amount;
            ArrayList<String> statement = new ArrayList<String>();
            ArrayList<Notes> duplicatenotes = new ArrayList<Notes>();
            for(Notes notes: ATM.getNotesArrayList())
            {
                duplicatenotes.add(notes.clone());
            }
             x : while(amount!=0)
             {
                for(Notes notesinduplicate:duplicatenotes) {
                    int type = notesinduplicate.getDenomination();
                    switch (type)
                    {
                        case 2000, 500, 200, 100:
                            amount = (int) UserActions.performwithdraw(amount, notesinduplicate, statement);
                            break;
                    }
                }
                    if (amount ==0)
                    {
                        ATM.setNotesArrayList(duplicatenotes);
                        user.setBalance(user.getBalance() - amount1);
                        Transfer withdrawTransfer = new Transfer(user.getUsername(),"Withdraw",amount1);
                        user.addTransaction(withdrawTransfer);
                        System.out.println("Withdrawal successful. Current Balance: " + user.getBalance());
                        for(String s : statement)
                        {
                             System.out.println("Withdrawl Denominations :"+s);
//                           System.out.println("You got "+notes.getNote()+" "+notes.getDenomination());
                        }
                        break ;
                    }
                    else
                    {
                        System.out.println("Denominations are not available,Enter another amount...");
                        break ;
                    }

            }

            if (user.getBalance() >= amount)
            {
                user.setBalance(user.getBalance() - amount);
//                user.getTransactionHistory().add(new Transfer(user.getUsername(), "Withdrawal", amount));
//                System.out.println("Withdrawn " + amount + " using denomination: " + denomination);
            }
            else
            {
                System.out.println("Insufficient balance.");
            }
        }

        public double viewBalance() {
            return user.getBalance();
        }

        public void viewTransactionHistory() {
            ArrayList<Transfer> transactionHistory = user.getTransactionHistory();
            if (transactionHistory.isEmpty()) {
                System.out.println("No transaction history available.");
            } else {
                System.out.println("\nTransaction History:");
                for (Transfer transfer : transactionHistory) {
                    System.out.println(transfer);
                }
            }
        }

        public void changePassword(int currentPassword, int newPassword) {
            if (user.getPassword() == currentPassword) {
                user.setPassword(newPassword);
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("Incorrect current password.");
            }
        }
    }




