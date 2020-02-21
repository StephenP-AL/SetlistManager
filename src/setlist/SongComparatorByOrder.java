// Need to test this with sorting

package setlist;

import java.util.Comparator;

public class SongComparatorByOrder implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        if(o1.getOrder() < o2.getOrder()) {
            return -1;
        }
        else if(o1.getOrder() > o2.getOrder()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
