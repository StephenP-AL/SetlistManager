package setlist;

import java.util.ArrayList;

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
    public void sortTitle(){
        SongList.sort(Song::compareTo);
    }
}
