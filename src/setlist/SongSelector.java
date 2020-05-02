package setlist;

import java.util.ArrayList;

/**
 * Procedurally selects songs from a CatalogView to ensure sequential variety in key and tempo.
 */
public class SongSelector {
    private final ArrayList<Song> SongList;
    public SongSelector(Catalog view){
        SongList = view.reviewSongList();
        SongList.removeIf(Song::isArchive);
        SongList.sort(Song::compareTo);
    }

    /**
     * Selects the next appropriate Song for a Setlist
     * @param index Index of the next Song to be added to the Setlist
     * @param prev Previous Song in the Setlist
     * @return Returns a Song if an appropriate one is found, or null if no appropriate Songs exist.
     */
    public Song nextSong(Song prev, int index){
        for (int i = 0; i < SongList.size(); i++ ){
            if (SongList.get(i) == null) {
                continue;
            }
            if (index % 2 == 0){
                if (SongList.get(i).getKey().equals(prev.getKey())){
                    System.out.println("SONG SELECTOR rejected: '" + SongList.get(i).getTitle() + "', same key");
                }
                else{
                    Song ret = SongList.get(i);
                    SongList.remove(i);
                    return ret;
                }
            }
            else{
                double difference;
                if (prev.getTempo() > SongList.get(i).getTempo()){
                    difference = prev.getTempo() - SongList.get(i).getTempo();
                }
                else{
                    difference = SongList.get(i).getTempo() - prev.getTempo();
                }
                double ratio = difference / (double) prev.getTempo();
                if ( ratio > 0.1){
                    Song ret = SongList.get(i);
                    SongList.remove(i);
                    return ret;
                }
                else {
                    System.out.println("SONG SELECTOR rejected: '" + SongList.get(i).getTitle() + "', same tempo");
                }
            }
        }
        // No appropriate songs
        return null;
    }
}
