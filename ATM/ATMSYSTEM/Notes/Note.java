package ATM.ATMSYSTEM.Notes;

public abstract class Note implements Cloneable{//implementing the cloneable interface becouse usage of clone() method.
        private int denomination;//2000,500,200,100
        private int note;//count of notes

        //constructor of Note....initiates the count to the respective denominations
        protected Note(int denomination, int quantity) {
            //super();[implicitly calling the constructor of object class]
            this.denomination = denomination;
            this.note = quantity;
        }

        //gettor & settor of note
        public int getNote() {
            return note;
        }

        public void setNote(int a){
            this.note=a;
        }

        //gettors of denominations
        public int getDenomination() {
            return denomination;
        }

        // clone method to deep copy the notesarraylist to the duplicatenotesarraylist.
        public Note clone() throws CloneNotSupportedException {
            return (Note) super.clone();//defaulty clone is the object gtype so exolicitly convertion to note type and returning .
        }
    }

