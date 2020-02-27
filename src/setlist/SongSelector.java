package setlist;

import java.util.ArrayList;

public class SongSelector {
    private ArrayList<Song> SongList = new ArrayList<>();
    private int Length; // Target length of set in seconds
    private int BreakCount; // Number of breaks / intermissions
    private int BreakLength; // Length of each break in seconds
    private ArrayList<String> GenreRestrict;

    public SongSelector(ArrayList<Song> songlist, int length, int breakcount, int breaklength, String genre){
        SongList = songlist;
        Length = length;
        
    }
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

}
