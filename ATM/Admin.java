import java.util.ArrayList;

public class Admin {
    private String adminName;
    private ArrayList<Transfer> admintransaction;

    public void setAdminPin(int adminPin) {
        this.adminPin = adminPin;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    private int adminPin;

    public Admin(String adminName, int adminPin) {
        this.adminName = adminName;
        this.adminPin = adminPin;
    }

    public String getAdminName() {
        return adminName;
    }

    public int getAdminPin() {
        return adminPin;
    }

}
