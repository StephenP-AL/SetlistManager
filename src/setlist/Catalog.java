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
     * @param i Index of song to be removed
     * @return The song removed from SongList
     */
    public Song removeSong(int i){
        Song retSong = SongList.get(i);
        SongList.set(i,null);
        return retSong;
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
}
