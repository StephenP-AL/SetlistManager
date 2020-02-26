package setlist;

import java.util.ArrayList;
import java.util.Collections;

public class Catalog {
    private ArrayList<Song> SongList = new ArrayList<>();

    public void addSong(Song e){
        SongList.add(e);
    }

    public void printList(){
        for (Song i:SongList){
            System.out.println(i.toString());
        }
    }
    public void sortTitle(){SongList.sort(Song::compareTo); }
    public void sortOrder(){
        Collections.shuffle(SongList);
    }

    public Song removeSong(int i){
        //Stub: Should set index position to null and return song that was in the index
        return SongList.get(1);
    }
}
