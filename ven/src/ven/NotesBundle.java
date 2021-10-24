package ven;

public class NotesBundle {
    public int twinty_dollar;
    public int fifty_dollar;


    public NotesBundle(int... enteredNotes) {
        this.twinty_dollar = enteredNotes[0];
        this.fifty_dollar = enteredNotes[1];
      

    }


    public int getTotal(){
        int total = 0;
        total = total+this.twinty_dollar*notes.Twenty_dollar.getValue();
        total = total+this.fifty_dollar*notes.Fifty_dollar.getValue();
       
        return total;
    }

}
