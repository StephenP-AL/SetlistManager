// Need to test compareTo method with sorting

package com.company;

import java.util.Collections;
import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Song implements Comparable<Song> {
    private String Title;
    private String Composer;
    private String Key;
    private String Genre;
    private boolean Archive; // if true, song will not be considered for setlists
    private int Length; // song length in seconds
    private int Tempo; // in beats per minute
    private int Intro; // length of introduction in seconds

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
    public boolean equals(Song s) {
        if (Title.equals(s.getTitle())
        && Composer.equals(s.getComposer())
        && Key.equals(s.getKey())
        && Genre.equals(s.getGenre())
        && Archive == s.isArchive()
        && Length == s.getLength()
        && Tempo == s.getTempo()
        && Intro == s.getIntro()) {
            return true;
        } else {
            return false;
        }
    }

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
     * @param genre The song's genre
     */
    public void setGenre(String genre) {
        Genre = genre;
    }

    /**
     * @return The song's genre
     */
    public String getGenre() {
        return Genre;
    }

    /**
     * @return Returns true if archived
     */
    public boolean isArchive() {
        return this.Archive;
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
        if (this.Archive) {
            this.Archive = FALSE;
        }
        else {
            this.Archive = TRUE;
        }
    }

    /**
     * @param intro Length of introduction in seconds
     */
    public void setIntro(int intro) {
        this.Intro = intro;
    }

    /**
     * @return Returns intro length in seconds
     */
    public int getIntro(){
        return this.Intro;
    }

    /**
     * @param length Total length of song in seconds
     */
    public void setLength(int length) {
        this.Length = length;
    }

    /**
     * @return Returns total song length in seconds
     */
    public int getLength() {
        return this.Length;
    }

    /**
     * @return Returns whole minutes of the song
     */
    public int getLengthMin(){
        return (this.Length / 60);
    }

    /**
     * @return Returns remaining seconds of song. Use with getLengthMin for total song length
     */
    public int getLengthSec(){
        return (this.Length % 60);
    }

    /**
     * @param tempo Song tempo in BPM
     */
    public void setTempo(int tempo) {
        this.Tempo = tempo;
    }

    /**
     * @return Returns tempo in BPM
     */
    public int getTempo() {
        return this.Tempo;
    }

    /**
     * @param compare Song being compared
     * @param tolerence Range (from invoking song) of similarity to be considered a match. 0.1 is a 10% range
     * @return True if the compared Song Tempo is within the specified tolerence of the invoking Song Tempo
     */
    public boolean matchTempo(Song compare, double tolerence){
        double difference;
        if (compare.getTempo() > this.getTempo()){
            difference = compare.getTempo() - this.getTempo();
        }
        else{
            difference = this.getTempo() - compare.getTempo();
        }
        double ratio = difference / (double) this.getTempo();

        if ( ratio < tolerence){
            return TRUE;
        }
        else {
            return FALSE;
        }
    }

    /**
     * @param compare Song being compared
     * @return True if Key is the same, False if different
     */
    public boolean matchKey(Song compare){
        return (this.getKey().equals(compare.getKey()));
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

    @Override
    public int compareTo(Song o) {
        if ((this.getTitle().toUpperCase()).equals((o.getTitle()).toUpperCase())) {
            // System.out.println("Equal composer");
            return (this.getTitle().toUpperCase()).compareTo((o.getTitle()).toUpperCase());
        }
        else{
            return (this.getTitle().toUpperCase()).compareTo((o.getTitle()).toUpperCase());
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Song ret  = new Song(this.Title,this.Composer,this.Key,this.Genre,this.Length,this.Tempo,this.Intro,this.Archive);
        ret.setIntro(this.Intro);
        ret.setArchive(FALSE);
        return ret;
    }
}
