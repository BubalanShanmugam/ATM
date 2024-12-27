import java.util.ArrayList;
import java.util.Scanner;

public class ATMActions {
    Scanner sc = new Scanner(System.in);
    AdminActions adminActions = new AdminActions();

    private static ArrayList<Notes> notesArrayList =new ArrayList<Notes>();


    public void start() throws CloneNotSupportedException {
        ArrayList<Admin> adminList = new ArrayList<>();
        adminList.add(new Admin("admin", 1234));
        adminList.add(new Admin("admin2", 5678));

        while (true) {
            System.out.println("\nATM System Menu:");
            System.out.println("1. Admin Login \n2. User Login \n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                boolean isAdmin = AdminActions.adminLogin(sc, adminList);
                if (isAdmin) {
                    adminMenu(sc, adminActions);
                }
            } else if (choice == 2) {
                boolean isUser = UserActions.userLogin(sc, adminActions);
                if (isUser) {
                    User user = new User();
                    userMenu(sc, new UserActions());
                }
            } else if (choice == 3) {
                System.out.println("Exiting the ATM system...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void adminMenu(Scanner sc, AdminActions adminActions) {
        boolean exitAdmin = false;
        while (!exitAdmin) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add user \n2. Delete user \n3. View transaction history \n4. View user list \n5. Admin Deposit \n6. View your balance \n7. Exit");
            int adminChoice = Integer.parseInt(sc.nextLine());

            switch (adminChoice) {
                case 1:
                    System.out.print("Enter new username: ");
                    String newUsername = sc.nextLine();
                    System.out.print("Enter new password: ");
                    int newPassword = Integer.parseInt(sc.nextLine());
                    adminActions.addUserAccount(newUsername, newPassword);
                    break;
                case 2:
                    System.out.print("Enter username to delete: ");
                    String usernameToDelete = sc.nextLine();
                    adminActions.deleteUserAccount(usernameToDelete);
                    break;
                case 3:
                    System.out.print("Enter username to view transaction history: ");
                    String username = sc.nextLine();
                    adminActions.viewTransactionHistory(username);
                    break;
                case 4:
                    adminActions.viewUserList();
                    break;
                case 5:
                    System.out.println("Enter the total amount to deposit:");
                    int deposit = Integer.parseInt(sc.nextLine());
                    adminActions.adminDeposit(deposit,sc);
                    break;
                case 6:
                    System.out.println("ATM Balance:"+ATM.getBalance());
                    break;
                case 7:
                    exitAdmin = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void userMenu(Scanner sc, UserActions userActions) throws CloneNotSupportedException {
        boolean exitUserMenu = false;
        x:while (!exitUserMenu) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int userChoice = Integer.parseInt(sc.nextLine());

            switch (userChoice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = Double.parseDouble(sc.nextLine());
//                    System.out.print("Enter denomination (e.g., 100, 200, 500, 2000): ");
//                    int depositDenomination = Integer.parseInt(sc.nextLine());
                    userActions.deposit(depositAmount,sc);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = Double.parseDouble(sc.nextLine());
//                    System.out.print("Enter denomination (e.g., 100, 200, 500, 2000): ");
//                    int withdrawDenomination = Integer.parseInt(sc.nextLine());
                    userActions.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Your balance: " + userActions.viewBalance());
                    break;
                case 4:
                    userActions.viewTransactionHistory();
                    break;
                case 5:
                    System.out.print("Enter current password: ");
                    int currentPassword = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new password: ");
                    int newPassword = Integer.parseInt(sc.nextLine());
                    userActions.changePassword(currentPassword, newPassword);
                    break;
                case 6:
                    System.out.println("User logged out.");
                    break x;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
