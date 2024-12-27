import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

    public class AdminActions {


        public static boolean adminLogin(Scanner sc, ArrayList<Admin> adminList) {
            int attempts = 0;
            while (attempts < 3) {
                System.out.print("Enter Admin Username: ");
                String adminUsername = sc.nextLine();
                System.out.print("Enter Admin Password: ");
                int adminPassword = Integer.parseInt(sc.nextLine());

                for (Admin admin : adminList) {
                    if (admin.getAdminName().equals(adminUsername) && admin.getAdminPin() == adminPassword) {
                        admin.setAdminName(adminUsername);
                        admin.setAdminPin(adminPassword);
                        return true;
                    }
                }
                attempts++;
                System.out.println("Invalid credentials. Try again.");
            }
            return false;
        }

        public void addUserAccount(String username, int password)
        {
            User newUser = new User(username, password);
            for (User user : ATM.getUserAcc()) {
            if (user.equals(newUser)) {
                System.out.println("User is already Exist");
            }
            }
            ATM.getUserAcc().add(newUser);
            System.out.println("User account added.");
        }


        public void deleteUserAccount(String usernameToDelete) {
        User userToDelete = null;
        for (User user : ATM.getUserAcc()) {
            if (user.getUsername().equals(usernameToDelete)) {
                userToDelete = user;
                break;
            }
        }
        if (userToDelete != null) {
            ATM.getUserAcc().remove(userToDelete);
            System.out.println("User account deleted.");
        } else {
            System.out.println("User not found.");
        }
        }

        public void viewUserList() {
        if (ATM.getUserAcc().isEmpty()) {
            System.out.println("No users available.");
        } else {
            for (User user : ATM.getUserAcc()) {
                System.out.println("User Name :"+user.getUsername()+ " | Balance :"+user.getBalance());
            }
        }
        }

        public void viewTransactionHistory(String name) {
        System.out.println("Enter the username to view :");
        for( User u : ATM.getUserAcc()){
            if (u.getUsername().equals(name)) {
                System.out.println("User balance: " + u.getTransactionHistory());
                return;
            }
        }
     }

     public void adminDeposit(int deposit, Scanner sc) {

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
        if(deposit==total) {
            ArrayList<Notes> notesArrayList = ATM.getNotesArrayList();
            for (Notes note : ATM.getNotesArrayList()) {
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
            ATM.setBalance(ATM.getbalance() + deposit);
//          System.out.println("admin balance"+ ATM.getBalance());
            System.out.println("Deposit successful. New balance: " + ATM.getBalance());
//            user.getTransactionHistory().add(new Transfer("Admin", "Withdrawal", deposit));k
        }
     }
        public void viewUserBalance(String username) {
            for (User user : ATM.getUserAcc()) {
                if (user.getUsername().equals(username)) {
                    System.out.println("User balance: " + user.getBalance());
                    return;
                }
            }
            System.out.println("User not found.");
        }
    }
