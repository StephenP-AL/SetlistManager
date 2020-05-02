package setlist;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * A listing of Songs for live performance
 */
public class Setlist extends Catalog {
    private int Length; // Target length of set in seconds
    private int BreakCount; // Number of breaks / intermissions
    private int BreakLength; // Length of each break in seconds
    private final ArrayList<String> GenreRestrict;

    /**
     * Parameterized constructor
     * @param length Length of the set in seconds
     * @param breakCount Number of breaks
     * @param breakLength Length of breaks in seconds
     */
    public Setlist(int length, int breakCount, int breakLength){
        Length = length;
        BreakCount = breakCount;
        BreakLength = breakLength;
        GenreRestrict = new ArrayList<>();
    }

    /**
     * Set desired set length in seconds
     * @param i Target length of the set in seconds
     */
    public void setLength(int i){
        this.Length = i;
    }

    /**
     * Get desired set length in seconds
     * @return Target length of set in seconds
     */
    public int getLength() {
        return Length;
    }

    /**
     * Get set length in whole hours. Use in conjunction with getLengthMinute and GetLengthSecond
     * @return Target length of set in whole hours
     */
    public int getLengthHour(){
        return (Length / 3600);
    }

    /**
     * Get set remaining whole minutes less whole hours. Use in conjunction with getLengthHour and getLengthSecond
     * @return Remaining minutes in target length of set less whole hours
     */
    public int getLengthMinute(){
        return ((Length % 3600) / 60);
    }

    /**
     * get set remaining seconds less whole minutes. Use in conjunction with getLengthHour and getLengthMinute
     * @return Remaining seconds in target set length less whole hours and whole minutes
     */
    public int getLengthSecond(){
        return (Length % 60 );
    }

    /**
     * Sets the number of breaks in the set
     * @param i Number of breaks or intermissions in the set`
     */
    public void setBreakCount(int i){
        BreakCount = i;
    }

    /**
     * Gets the number of breaks in the set
     * @return Number of breaks or intermissions in the set
     */
    public int getBreakCount() {
        return BreakCount;
    }

    /**
     * Sets the length of each break in the set
     * @param breakLength Length of break or intermission in seconds
     */
    public void setBreakLength(int breakLength) {
        BreakLength = breakLength;
    }

    /** Gets the length of each break in the set
     * @return Length of break or intermission in seconds
     */
    public int getBreakLength() {
        return BreakLength;
    }

    /**
     * Sets genre filters for the set.
     * @param input String of genres delimited by space or comma
     */

    public void setGenreRestrict(String in){
        String[] list = in.split(",");
        GenreRestrict.clear();
        for (String i:list){
            GenreRestrict.add(i);
        }
    }

    /**
     * Gets genre filters for the set
     * @return ArrayList of Genres for filtering
     */
    public ArrayList<String> getGenreRestrict() {
        return GenreRestrict;
    }



    /**
     * Adds Songs to SongList from a CatalogView
     * @param source CatalogView from which songs are selected
     * @return 0 if setlist fully populated, 1 if SongSelector couldn't return a next song when called
     */

    public int Populate(CatalogView source){
        SongSelector select = new SongSelector(source);
        Song prev = new Song("a","b","c","g",1,1,1,false);
        int index = 0;

        // Variables for dealing with breaks
        boolean[] breakState = new boolean[BreakCount]; //Array of flags to show if a scheduled break is has been added to the setlist
        for (int i = 0; i < BreakCount; i++){
            breakState[i] = false;
        }
        int playSegment = Length / (BreakCount + 1); //Time between intermissions

        while (LengthCurrent() < Length) {
            for (int i = 0; i < BreakCount; i++) {
                if (!breakState[i] && (LengthCurrent() > (playSegment * (i + 1) - (BreakLength / 2)))) {
                    System.out.println(LengthCurrent() + " | " + (playSegment * (i + 1)));
                    addSong(Break(BreakLength));
                    breakState[i] = true;
                }
            }
            Song next = (select.nextSong(prev, index));
            if (next == null) {
                System.out.println("SongSelector did not return a Song");
                return 1;
            } else {
                if (GenreRestrict.isEmpty() || GenreRestrict.get(0).isBlank()) {
                    addSong(next);
                    prev = next;
                    System.out.println("SETLIST.POPULATE added: " + next.getTitle() + " Total set length: " + LengthCurrent());
                    index++;
                } else {
                    for (String genre : GenreRestrict) {
                        if (next.getGenre().toUpperCase().replaceAll("\\s","").equals(genre.toUpperCase().replaceAll("\\s","")) ){
                            addSong(next);
                            prev = next;
                            System.out.println("SETLIST.POPULATE added: " + next.getTitle() + " Genre matched: " + genre + "Total set length: " + LengthCurrent());
                            index++;
                            break;
                        } else {
                            System.out.println("SETLIST.POPULATE rejected: " + next.getTitle() + ", wrong genre: " + next.getGenre() + " | " + genre);
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Creates a break/intermission in the format of a Song
     * @return A break formatted as a Song class
     */

    private Song Break(int time){
        return new Song("Intermission","","","", time,-1,-1,false);

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