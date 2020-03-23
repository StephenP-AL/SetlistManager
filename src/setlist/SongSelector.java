package setlist;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class SongSelector {
    private CatalogView view;
    private ArrayList<Song> SongList;
    private boolean toggle; //
    public SongSelector(CatalogView v){
        //System.out.println("SONGSELECTOR");
        view = v;
        SongList = view.getList().reviewSongList();
        /*for (Song i:SongList){
            if (i == null){
                continue;
            }
            System.out.println(i.toString());
        }*/

        //prev = new Song("t","c","H# Maj","G",1,5000,1,false);
        //System.out.println("SongSelector created" + prev.toString());

    }

    /**
     * Selects the next appropriate Song for a Setlist
     * @return Returns a Song if an appropriate one is found, or null if no appropriate Songs exist.
     */
    public Song nextSong(Song prev, int index){
        for (int i = 0; i < SongList.size(); i++ ){
            if (SongList.get(i) == null){
                //System.out.println(1);
                continue;
            }
            if (index % 2 == 0){
                //System.out.println("odd");
                if (SongList.get(i).getKey().equals(prev.getKey())){
                    System.out.println(SongList.get(i).getTitle() + " rejected: same key");
                }
                else{
                    Song ret = SongList.get(i);
                    SongList.remove(i);
                    return ret;
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
                    Song ret = SongList.get(i);
                    SongList.remove(i);
                    return ret;
                }
                else {
                    System.out.println(SongList.get(i).getTitle() + " rejected: same tempo");
                }
            }
        }
        // No appropriate songs
        return null;
    }
}
