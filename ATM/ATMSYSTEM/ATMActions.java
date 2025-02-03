package ATM.ATMSYSTEM;

import java.util.Scanner;
import java.lang.String;

public class ATMActions {//Actions of ATM

    public static void start() throws CloneNotSupportedException {//start method definition
        Scanner sc = new Scanner(System.in);//Scanner object
        AdminActions adminActions = new AdminActions();//creating the instance for the AdminActions

        //assigning the default admin name and passwords
        ATM.getListofuser().add(new Admin(1234, 1234));
//        ATM.getListofuser().add(new Account("admin2", 5678));

        while (true) {
            //ATM menu
            System.out.println("\nSystem Menu:");
            System.out.println("1. Admin Login \n2.User Login \n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1)
            {
                //getting username
                System.out.print("Enter Admin login id: ");
                int adminUsername = Integer.parseInt(sc.nextLine());
                //calls the adminlogin ,from the adminActions.store the return value of adminlogin method
                Admin a = (Admin) AdminActions.adminLogin(sc,adminUsername);
                if (a ==null) { //if cond to check whether the admin object 'a' is null or not
                    System.out.println("Invalid admin");
                } else if(a.getAcnum()==0) //it checks whether the 'a' obj containing admin username is == admin users list
                {
                    System.out.println("Invalid credentials...");
                }
                else {
                    adminMenu(sc, adminActions,a);// it calls the adminactions method, if admin username and password get matched
                }


            } else if (choice == 2)
            {   //calls the userlogin ,from the UserActions....stores the return value of userlogin method
               User user = (User)UserActions.userLogin(sc);
                if (user != null) {//if only admin is correctly logined.
                    userMenu(sc,user);//calls the usermenu method with the user object.
                }
            } else if (choice == 3)//if we want to logout the atm .
            {
                System.out.println("Exiting the ATM system...");
                break;
            } else//choice is not valid.
            {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void adminMenu(Scanner sc, AdminActions adminActions,Admin admin) {//adminmenu method definitions
        boolean exitAdmin = false;//for the condition purpose.
        while (!exitAdmin) {
            //Admin menu list
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add user \n2. Delete user \n3. View user list \n4. Admin Deposit \n5. View your balance \n 6. Transaction \n7. Exit");
            int adminChoice = Integer.parseInt(sc.nextLine());
            // swith case for perform the adminopertions
            switch (adminChoice) {
                case 1:
                    // case for calling the method to adding the user
                    adminActions.addUserAccount(sc);
                    break;
                case 2:
                    // case for calling the method to delete the user
                    System.out.print("Enter account number to delete: ");
                    int usernumToDelete = Integer.parseInt(sc.nextLine());
                    adminActions.deleteUserAccount(usernumToDelete);
                    break;
                case 3:
                    // case for calling the method to view the user list
                    adminActions.viewUserList();
                    break;
                case 4:
                    // case for calling the method to admin deposit
                    System.out.println("Enter the total amount to deposit:");
                    int deposit = Integer.parseInt(sc.nextLine());
                    adminActions.adminDeposit(deposit,sc,admin);
                    break;
                case 5:
                    // case for calling the method to view balance of atm
                    System.out.println("ATM Balance:"+ ATM.getBalance());
                    break;
                case 6:
                    // case for calling the method to view the transactions
                    System.out.print("Transaction History :");
                    adminActions.viewtrahis(sc,admin);
                    break;

                case 7:
                    // case for exiting the adminmenu
                    exitAdmin = true;
                    break;
                default:
                    //if coice is invalid ...
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void userMenu(Scanner sc,User user) throws CloneNotSupportedException {//usermenu method definitions
        UserActions userActions= new UserActions();//object creation for the useractions class.
        boolean exitUserMenu = false;//for the condition purpose.
        while (!exitUserMenu) {
            //user menu list
            System.out.println("\nUser Menu:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int userChoice = Integer.parseInt(sc.nextLine());

            switch (userChoice) {// swith case for perform the adminopertions

                case 1:
                    // case for calling the user deposit
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = Double.parseDouble(sc.nextLine());
                    userActions.deposit(depositAmount,sc,user);
                    break;
                case 2:
                    //case for calling the user withdraw
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = Double.parseDouble(sc.nextLine());
                    userActions.withdraw(withdrawAmount,user);
                    break;
                case 3:
                    //case to check the user balance
                    System.out.println("Your balance: " + userActions.viewBalance(user));
                    break;
                case 4:
                    //case to see the user's transac history
                    userActions.viewTransactionHistory(user);
                    break;
                case 5:
                    //case to change the user pin

                    //getting the currentpass
                    System.out.print("Enter current password: ");
                    int currentPassword = Integer.parseInt(sc.nextLine());
                    //calling the changepassword method
                    userActions.changePassword(currentPassword,user,sc);
                    break;
                case 6:
                    // case to break the loop
                    System.out.println("User logged out.");
                    exitUserMenu = true;
                    break ;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
