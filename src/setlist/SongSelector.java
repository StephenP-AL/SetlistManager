package setlist;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class SongSelector {
    private CatalogView view;
    private ArrayList<Song> SongList;
    private Song prev; // Initially set to
    public SongSelector(CatalogView v){
        view = v;
        SongList = view.getList().reviewSongList();
        prev = new Song("t","c","H# Maj","G",1,5000);
        System.out.println("SongSelector created" + prev.toString());
    }

    /**
     * Selects the next appropriate Song for a Setlist
     * @param index Index of the ArrayList where the Song will be added. This is used to determine if key or tempo will be compared to the previous Song
     * @return Returns a Song if an appropriate one is found, or null if no appropriate Songs exist.
     */
    public Song nextSong(int index){
        for (int i = 0; i < SongList.size(); i++ ){
            if (SongList.get(i) == null){
                System.out.println(1);
                continue;
            }
            if (index % 2 == 1){
                //System.out.println("odd");
                if (SongList.get(i).getKey().equals(prev.getKey())){
                    continue;
                }
                else{
                    prev = SongList.get(i);
                    SongList.remove(i);
                    return prev;
                }
            }
            else{
                //System.out.println("even");
                double difference;
                if (prev.getTempo() > SongList.get(i).getTempo()){
                    difference = prev.getTempo() - SongList.get(i).getTempo();
                }
                else{
                    difference = SongList.get(i).getTempo() - prev.getTempo();
                }
                double ratio = difference / (double) prev.getTempo();
                //System.out.println(ratio);
                if ( ratio > 0.1){
                    prev = SongList.get(i);
                    SongList.remove(i);
                    return prev;
                }
                else {
                    continue;
                }
            }
        }
        // No appropriate songs
        return null;
    }
}
