package setlist;

import java.util.ArrayList;
import java.util.Collections;

public class Catalog {
    private ArrayList<Song> SongList = new ArrayList<>();

    /**
     *
     * @param e Song to be added to SongList
     */
    public void addSong(Song e){
        SongList.add(e);
    }

    /**
     * @param index Index of the Song in Songlist
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
     * @param index Index of song to be removed
     * @return The song removed from SongList
     */
    public Song removeSong(int index){
        Song retSong = SongList.get(index);
        SongList.set(index,null);
        return retSong;
    }

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
     * @return New Catalog with duplicate SongList
     */
    public Catalog duplicate(){
        Catalog dup = new Catalog();
        for (Song i:SongList){
            dup.addSong(i);
        }
        return dup;
    }
    public ArrayList reviewSongList(){
        ArrayList dup = new ArrayList();
        for (Song i:SongList) {
            dup.add(i);
        }
        return dup;

    }
}