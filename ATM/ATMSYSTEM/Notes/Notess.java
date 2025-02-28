package ATM.ATMSYSTEM.Notes;

public class Notess <T extends Note>
{
    T[] notearray = (T[]) new Note[4];
    int length =0;

    public  void set(T object)
    {
        if(notearray.length >length){
            notearray[length] =object;
            length++;
        }
    }

    public  T[] getNotearray()
    {
        return notearray;
    }

}
