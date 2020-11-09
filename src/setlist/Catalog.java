package setlist;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Aggregates Songs
 */
public class Catalog {
    private final ArrayList<Song> SongList = new ArrayList<>();

    /**
     * Add a song to the catalog
     * @param e Song to be added to SongList
     */
    public void addSong(Song e){
        SongList.add(e);
    }

    /**
     * Returns a clone of a song at specified index
     * @param index Index of the Song in Songlist
     * @return Song at index, returns null if index out of list bounds
     */
    public Song reviewSong(int index){
        // need some exception handling for outside of arraylist
        //EXEPTION HANDLING IMPLEMENTED HERE
        if (index >= SongList.size()) {
            return null;
        }
        //------------------------------------
        while (SongList.get(index) == null ){
            index ++;
        }
        Song ret = null;
        try {
            ret = (Song)(SongList.get(index)).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Used to retrieve a Song from SongList
     * @param index Starting position in the ArrayList to look for a Song
     * @return Returns null if SongList is empty, the Song at the index position, or the next valid song if the index position is null
     */
    public Song getSong(int index) {
        if (index >= SongList.size()) {
            return null;
        }
        while (SongList.get(index) == null ){
            index ++;
        }
        return SongList.get(index);
    }

    /**
     * Prints all songs (using toString) contained Songlist in order
     */
    public void printList(){
        for (Song i:SongList){
            if (i == null){
                continue;
            }
            System.out.println(i.toString());
        }
    }

    /**
     * Sorts SongList by default comparison
     */
    public void sortTitle(){
        SongList.sort(Song::compareTo);
    }

    /**
     * Shuffles SongList to a random order We should remove this from Catalog class
     */
    public void Shuffle(){
        Collections.shuffle(SongList);
    }

    /**
     * Removes a song from the catalog
     * @param index Index of song to be removed
     * @return The song removed from SongList
     */
    public Song removeSong(int index){
        Song retSong = SongList.get(index);
        SongList.set(index,null);
        return retSong;
    }

    /**
     * Removes a Song from the SongList
     * @param s Reference to Song to be removed
     */
    public void remove(Song s) {
        int i = 0;
        while (i < SongList.size()) {
            if (s.equals(SongList.get(i))) {
                SongList.remove(i);
            }
            ++i;
        }
    }

    /**
     * Creates a copy of the catalog
     * @return New Catalog with duplicate SongList
     */
    public Catalog duplicate(){
        Catalog dup = new Catalog();
        for (Song i:SongList){
            dup.addSong(i);
        }
        return dup;
    }

    /**
     * Returns an ArrayList of all songs in the catalog
     * @return Returns a copy of the SongList
     */
    public ArrayList<Song> reviewSongList(){
        return new ArrayList<>(SongList);
    }

    /**
     * Clears the SongList
     */
    public void clear() {
        SongList.clear();
    }
    /**
    * Returns the size of the catalog
    */
    public int size() {
        return SongList.size();
    }
}
