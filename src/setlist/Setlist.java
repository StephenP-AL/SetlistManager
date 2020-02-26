package setlist;

import java.util.ArrayList;

public class Setlist extends Catalog {
    private int Length; // Total length of set in seconds
    private int BreakCount; // Number of breaks / intermissions
    private int BreakLength; // Length of each break in seconds
    private ArrayList<String> GenreRestrict;


public void setLength(int i){
    //stub
}

    public int getLength() {
        return Length;
    }

    public int getLengthHour(){
    //stub Derived
        return 0;
    }

    public int getLengthMinute(){
    //stub Derive
        return 0;
    }
    public int getLengthSecond(){
    //stub Derived
        return 0;
    }

    public void setBreakCount(int i){
    //stub
    }

    public int getBreakCount() {
        return BreakCount;
    }

    public void setBreakLength(int breakLength) {
        BreakLength = breakLength;
    }

    public int getBreakLength() {
        return BreakLength;
    }

    public void setGenreRestrict(String input){
    //stub Parses string of delimited genres and ads them to arraylist
    }

    public void SelectNextSong(Catalog catalog){
    //stub: selects first appropriate song from catalog then sets it to null in the source catalog
    }

    public void Populate(Catalog catalog){
    //stub calls SelectNextSong and adds breaks as needed to meet total set length
    }

    private Song Break(int time){
        return new Song("Intermission","","","", time,-1);
    }

}
