package setlist;


import java.util.ArrayList;
import java.util.Set;

public class Setlist extends Catalog {
    private int Length; // Target length of set in seconds
    private int BreakCount; // Number of breaks / intermissions
    private int BreakLength; // Length of each break in seconds
    private ArrayList<String> GenreRestrict;


    public Setlist(int l, int bc, int bl){
        Length = l;
        BreakCount = bc;
        BreakLength = bl;
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


    /**
     * @param index index of next song to be added
     * @param previous The previous song added to the Setlist
     * @return The song selected from the specificed catalog
     */
    private Song SelectNextSong(Song previous, int index){
        //stub: selects first appropriate song from catalog then sets it to null in the source catalog
        return null;
    }


    /**
     * @param source Catalog view from which songs are selected
     */

    public void Populate(CatalogView source){
        SongSelector select = new SongSelector(source);
        Song prev = new Song("a","b","c","g",1,1,1,false);
        int index = 0;

        // Variables for dealing with breaks
        boolean[] breakState = new boolean[BreakCount];
        for (int i = 0; i < BreakCount; i++){
            breakState[i] = false;
        }
        int playSegment = Length / (BreakCount + 1);

        while (LengthCurrent() < Length){
            for (int i = 0; i < BreakCount; i++){
                if (!breakState[i] && (LengthCurrent() > (playSegment * (i + 1) - (BreakLength / 2)))){
                    System.out.println(LengthCurrent() + " | " + (playSegment * (i + 1)));
                    addSong(Break(5));
                    breakState[i] = true;
                }
            }
            Song next =  (select.nextSong(prev,index));
            if (next != null) {
                addSong(next);
                prev = next;
                System.out.println(next.getTitle() + LengthCurrent());
                index++;
            }
            else{
                System.out.println("SongSelector did not return a suitable Song.");
                break;
            }
        }

    }


    /**
     * Creates a break/intermission in the format of a Song
     * @return A break formatted as a Song class
     */

    private Song Break(int time){
        return new Song("Intermission","","","", time,-1,1,false);

    }

    /**
     * calculates the total length of songs with introductions in the current setlist
     * @return Total length of the current set in seconds
     */
    private int LengthCurrent(){
        int total = 0;
        //not working right now
        for (Object s:super.reviewSongList()){
            if (!(s == null)) {
                total += (((Song) s).getLength() + ((Song) s).getIntro());
            }
        }
        return total;
    }
}