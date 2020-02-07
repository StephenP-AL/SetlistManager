package setlist;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Song {
    private String Title;
    private String Composer;
    private String Key;
    private boolean Archive; // if true, song will not be considered for setlists
    private int Length; // song length in seconds
    private int Tempo; // in beats per minute
    private int Intro; // length of introduction in seconds
    private int Order; // for randomized sorting

    /**
     * @param title Title of the song.
     */
    public void setTitle(String title){
        this.Title = title;
    }

    /**
     * @return Title of the song
     */
    public String getTitle(){
        return this.Title;
    }

    /**
     * @param composer The song's composer
     */
    public void setComposer(String composer){
        this.Composer = composer;
    }

    /**
     * @return The song's composer
     */
    public String getComposer(){
        return this.Composer;
    }

    /**
     * @param key The song's key
     */
    public void setKey(String key) {
        this.Key = key;
    }

    /**
     * @return The song's key
     */
    public String getKey(){
        return this.Key;
    }

    /**
     * @return Returns true if archived
     */
    public boolean isArchive() {
        return Archive;
    }

    /**
     * @param archive Set TRUE to archive song
     */
    public void setArchive(boolean archive) {
        Archive = archive;
    }

    /**
     * Switches Archive marker to TRUE if FALSE, or FALSE if TRUE
     */
    public void toggleArchive(){
        if (this.Archive){
            this.Archive = FALSE;
        }
        else if (this.Archive == FALSE){
            this.Archive = TRUE;
        }
    }
}
