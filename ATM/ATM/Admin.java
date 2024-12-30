package ATM;

import java.util.ArrayList;

public class Admin {
    private static String adminName;
    private static int adminPin;

    public static ArrayList<Transfer> getTransactionHistory() {
        return transactionHistory;
    }

    private static ArrayList<Transfer> transactionHistory = new ArrayList<Transfer>();

    public static void setAdminPin(int adminPin) {
        Admin.adminPin = adminPin;
    }

    public static  void setAdminName(String adminName) {
        Admin.adminName = adminName;
    }



    public Admin(String adminName, int adminPin) {
        this.adminName = adminName;
        this.adminPin = adminPin;
    }

    public static String getAdminName() {
        return adminName;
    }

    public static int getAdminPin() {
        return adminPin;
    }

}
