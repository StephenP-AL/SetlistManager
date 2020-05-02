// Need to test compareTo method with sorting

package setlist;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Data representation of a song and its characteristics
 */
public class Song implements Comparable<Song> {
    private String Title;
    private String Composer;
    private String Key;
    private String Genre;
    private boolean Archive; // if true, song will not be considered for setlists
    private int Length; // song length in seconds
    private int Tempo; // in beats per minute
    private int Intro; // length of introduction in seconds

    /**
     * Default constructor, stores data about a song
     */
    public Song() {
        Title = "";
        Composer = "";
        Key = "";
        Genre = "";
        Length = 0;
        Tempo = 0;
        Intro = 0;
        this.setArchive(false);
    }

    /**
     * Parameterized constructor, stores data about a song
     * @param title Title of the song
     * @param composer Composer of the song
     * @param key Key of the song
     * @param genre Genre of the song
     * @param length Length of the song in seconds
     * @param tempo Tempo of the song in BPM
     * @param intro Length of introduction in seconds
     * @param archive True to exclude from all created setlists
     */
    public Song(String title, String composer, String key, String genre, int length, int tempo, int intro, boolean archive){
        this.setTitle(title);
        this.setComposer(composer);
        this.setKey(key);
        this.setGenre(genre);
        this.setLength(length);
        this.setTempo(tempo);
        this.setIntro(intro);
        this.setArchive(archive);

    }

    /**
     * Determines if song data is equal to another song
     * @param s Song compared to
     * @return Returns true if songs are equal, false if not
     */
    public boolean equals(Song s) {
        return super.equals(s) || (
                Title.equals(s.getTitle())
                        && Composer.equals(s.getComposer())
                        && Key.equals(s.getKey())
                        && Genre.equals(s.getGenre())
                        && Archive == s.isArchive()
                        && Length == s.getLength()
                        && Tempo == s.getTempo()
                        && Intro == s.getIntro());
    }

    /**
     * Sets the song title
     * @param title Title of the song.
     */
    public void setTitle(String title){
        this.Title = title;
    }

    /**
     * Gets the song title
     * @return Title of the song
     */
    public String getTitle(){
        return this.Title;
    }

    /**
     * Sets song composer
     * @param composer The song's composer
     */
    public void setComposer(String composer){
        this.Composer = composer;
    }

    /**
     * Gets song composer
     * @return The song's composer
     */
    public String getComposer(){
        return this.Composer;
    }

    /**
     * Sets song key
     * @param key The song's key
     */
    public void setKey(String key) {
        this.Key = key;
    }

    /**
     * Gets song key
     * @return The song's key
     */
    public String getKey(){
        return this.Key;
    }

    /**
     * Sets song genre
     * @param genre The song's genre
     */
    public void setGenre(String genre) {
        Genre = genre;
    }

    /**
     * Gets song genre
     * @return The song's genre
     */
    public String getGenre() {
        return Genre;
    }

    /**
     * Get song archive status
     * @return Returns true if archived
     */
    public boolean isArchive() {
        return this.Archive;
    }

    /**
     * Set song archive status
     * @param archive Set TRUE to archive song
     */
    public void setArchive(boolean archive) {
        Archive = archive;
    }

    /**
     * Switches Archive marker to TRUE if FALSE, or FALSE if TRUE
     */
    public void toggleArchive(){
        if (this.Archive) {
            this.Archive = FALSE;
        }
        else {
            this.Archive = TRUE;
        }
    }

    /**
     * Sets song introduction length
     * @param intro Length of introduction in seconds
     */
    public void setIntro(int intro) {
        this.Intro = intro;
    }

    /**
     * Gets song introduction length
     * @return Returns intro length in seconds
     */
    public int getIntro(){
        return this.Intro;
    }

    /**
     * Sets song length
     * @param length Total length of song in seconds
     */
    public void setLength(int length) {
        this.Length = length;
    }

    /**
     * Gets song length
     * @return Returns total song length in seconds
     */
    public int getLength() {
        return this.Length;
    }

    /**
     * Get song length in whole minutes. Use in conjunction with getLengthSec
     * @return Returns whole minutes of the song
     */
    public int getLengthMin(){
        return (this.Length / 60);
    }

    /**
     * Get song length in seconds less whole minutes. Use in conjunction with getLengthMin
     * @return Returns remaining seconds of song. Use with getLengthMin for total song length
     */
    public int getLengthSec(){
        return (this.Length % 60);
    }

    /**
     * Sets song tempo
     * @param tempo Song tempo in BPM
     */
    public void setTempo(int tempo) {
        this.Tempo = tempo;
    }

    /**
     * Gets song tempo
     * @return Returns tempo in BPM
     */
    public int getTempo() {
        return this.Tempo;
    }

    @Override
    public String toString() {
        return "Song{" +
                "Title='" + Title + '\'' +
                ", Composer='" + Composer + '\'' +
                ", Key='" + Key + '\'' +
                ", Genre = '" + Genre + '\'' +
                ", Archive=" + Archive +
                ", Length=" + Length +
                ", Tempo=" + Tempo +
                ", Intro=" + Intro +
                '}';
    }

    /**
     * Compares to another song for sorting.
     * @param o Song compared to
     * @return Returns 0 if equal, negative number if less than the compared song, positive number if greater than compared song
     */
    @Override
        public int compareTo(Song o) {
        if ((this.getComposer().toUpperCase()).equals((o.getComposer()).toUpperCase())) {
                return (this.getTitle().toUpperCase()).compareTo((o.getTitle()).toUpperCase());
            }
            else{
                return (this.getComposer().toUpperCase()).compareTo((o.getComposer()).toUpperCase());
            }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Song(this.Title,this.Composer,this.Key,this.Genre,this.Length,this.Tempo,this.Intro,false);
    }
}
