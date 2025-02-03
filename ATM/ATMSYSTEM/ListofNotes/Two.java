package ATM.ATMSYSTEM.ListofNotes;
import ATM.ATMSYSTEM.Notes.Note;
public class Two extends Note{//class for 200 that extends Note
    public Two(int denomination,  int quantity) {//constructor of Two class used to call the Note's constructor
        super(denomination,  quantity);//calling super class's(Note) constructor.
    }
}
