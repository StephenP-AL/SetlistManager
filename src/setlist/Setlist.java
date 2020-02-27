package setlist;

import java.util.ArrayList;

public class Setlist extends Catalog {
    private int Length; // Target length of set in seconds
    private int BreakCount; // Number of breaks / intermissions
    private int BreakLength; // Length of each break in seconds
    private ArrayList<String> GenreRestrict;

    /**
     * @param i Target length of the set in seconds
     */
    public void setLength(int i){
    this.Length = i;
}

    /**
     * @return Target length of set in seconds
     */
    public int getLength() {
        return Length;
    }

    /**
     * @return Target length of set in whole hours
     */
    public int getLengthHour(){
        return (Length / 3600);
    }

    /**
     * @return Remaining minutes in target length of set less whole hours
     */
    public int getLengthMinute(){
        return ((Length % 3600) / 60);
    }

    /**
     * @return Remaining seconds in target set length less whole hours and whole minutes
     */
    public int getLengthSecond(){
        return (Length % 60 );
    }

    /**
     * @param i Number of breaks or intermissions in the set`
     */
    public void setBreakCount(int i){
        BreakCount = i;
    }

    /**
     * @return Number of breaks or intermissions in the set
     */
    public int getBreakCount() {
        return BreakCount;
    }

    /**
     * @param breakLength Length of break or intermission in seconds
     */
    public void setBreakLength(int breakLength) {
        BreakLength = breakLength;
    }

    /**
     * @return Length of break or intermission in seconds
     */
    public int getBreakLength() {
        return BreakLength;
    }

    /**
     * @param input String of genres delimited by space or comma
     */
    public void setGenreRestrict(String input){
    //stub Parses string of delimited genres and ads them to arraylist
    }

    /**
     * @param catalog Catalog of songs in shuffled order
     * @param previous The previous song added to the Setlist
     * @return The song selected from the specificed catalog
     */
    private Song SelectNextSong(Catalog catalog, Song previous){
    //stub: selects first appropriate song from catalog then sets it to null in the source catalog
        // need some way to see if end of the invoked catalog
        int i = 0;
        Song selected = catalog.removeSong(i);
        return selected;
    }

    /**
     * @param catalog
     */
    public void Populate(Catalog catalog){
    //stub calls SelectNextSong and adds breaks as needed to meet total set length
    }

    /**
     * @param time Length of the break
     * @return A break formatted as a Song class
     */
    private Song Break(int time){
        return new Song("Intermission","","","", time,-1);
    }

}
