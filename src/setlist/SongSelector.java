package setlist;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class SongSelector {
    private CatalogView view;
    private ArrayList<Song> SongList;
    private Song prev; // Initially set out of range
    private boolean toggle; //
    public SongSelector(CatalogView v){
        view = v;
        SongList = view.getList().reviewSongList();
        prev = new Song("t","c","H# Maj","G",1,5000);
        toggle = true;
        System.out.println("SongSelector created" + prev.toString());
    }

    /**
     * Selects the next appropriate Song for a Setlist
     * @return Returns a Song if an appropriate one is found, or null if no appropriate Songs exist.
     */
    public Song nextSong(){
        for (int i = 0; i < SongList.size(); i++ ){
            if (SongList.get(i) == null){
                //System.out.println(1);
                continue;
            }
            if (toggle){
                //System.out.println("odd");
                if (SongList.get(i).getKey().equals(prev.getKey())){
                    continue;
                }
                else{
                    toggle = false;
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
                    toggle = true;
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
