package ATM.ATMSYSTEM.ListofNotes;
import ATM.ATMSYSTEM.Notes.Note;

public class One extends Note {//class for 200 that extends Note
    public One(int denomination, int quantity) {//constructor of One class used to call the Note's constructor
        super(denomination, quantity);//calling super class's(Note) constructor.(constructor chaining)
    }

}
