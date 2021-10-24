package ven;

public enum notes {
	 Twenty_dollar(2000), Fifty_dollar(5000) ;

    private int value;

    notes(int value){
        this.value = value;
    }

    public static int[] parseNotes(String Notes){
        String[] numberNotesInText = Notes.split(",");
        int[] result = new int[numberNotesInText.length];
        for(int index=0;index<numberNotesInText.length;index++){
            result[index] = Integer.parseInt(numberNotesInText[index]);
        }
        return result;
    }

    public int getValue(){
        return this.value;
    }

}
