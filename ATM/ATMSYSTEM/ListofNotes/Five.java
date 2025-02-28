package ATM.ATMSYSTEM.ListofNotes;
import ATM.ATMSYSTEM.Notes.Note;
public class Five extends Note{//class for 500 that extends Note
    public Five(int denomination,  int quantity) {//constructor of Five class used to call the Note's constructor
        super(denomination, quantity);//calling super class's(Note) constructor.(constructor chaining)
    }

}
