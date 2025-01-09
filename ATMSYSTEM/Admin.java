package ATM.bubalanatms.ATMSYSTEM;

public class Admin extends Account{//Admin pojo class.
    public Admin(String adminName, int adminPin) {//Admin constructor that is used to call the super constructor(Account).
        super(adminName,adminPin);//calling super constructor.
    }
}
