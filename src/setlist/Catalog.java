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
    public void sortTitle(){SongList.sort(Song::compareTo); }

    /**
     * Shuffles SongList to a random order
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

    /**
     * @return New duplicate of SongList
     */
    public ArrayList<Song> duplicate(){
        ArrayList<Song> dup = new ArrayList<>();
        for (Song i:SongList){
            //skip archived or null records
            if (i == null || i.isArchive()){
                continue;
            }
            else {
                dup.add(i);
            }
        }
        return dup;
    }
}
