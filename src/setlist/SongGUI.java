package setlist;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Displays song data for review
 */
public class SongGUI extends JPanel {

    private String title;
    private String composer;
    private String key;
    private String genre;
    private int length;
    private int tempo;
    private int intro;
    private boolean archive;

    private JLabel titleDataLabel;
    private JLabel composerDataLabel;
    private JLabel keyDataLabel;
    private JLabel genreDataLabel;
    private JLabel lengthDataLabel;
    private JLabel tempoDataLabel;
    private JLabel introDataLabel;
    private JCheckBox archiveDataLabel;

    private void create() {
        if (title.equals("")) {
            title = " ";
        }
        if (composer.equals("")) {
            composer = " ";
        }
        if (key.equals("")) {
            key = " ";
        }
        if (genre.equals("")) {
            genre = " ";
        }
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        Font Large = new Font("Serif", Font.PLAIN, 25);

        JPanel labels = new JPanel();
        BoxLayout labelsLayout = new BoxLayout(labels, BoxLayout.Y_AXIS);
        labels.setLayout(labelsLayout);

        JPanel data = new JPanel();
        BoxLayout dataLayout = new BoxLayout(data, BoxLayout.Y_AXIS);
        data.setLayout(dataLayout);

        Border labelBorder = BorderFactory.createEmptyBorder(1,1,1,20);

        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setBorder(labelBorder);
        titleLabel.setFont(Large);
        titleLabel.setMaximumSize(new Dimension(100,55));
        JLabel composerLabel = new JLabel("Composer: ");
        composerLabel.setBorder(labelBorder);
        JLabel keyLabel = new JLabel("Key: ");
        keyLabel.setBorder(labelBorder);
        JLabel genreLabel = new JLabel("Genre: ");
        genreLabel.setBorder(labelBorder);
        JLabel lengthLabel = new JLabel("Length: ");
        lengthLabel.setBorder(labelBorder);
        JLabel tempoLabel = new JLabel("Tempo: ");
        tempoLabel.setBorder(labelBorder);
        JLabel introLabel = new JLabel("Intro: ");
        introLabel.setBorder(labelBorder);
        JLabel archiveLabel = new JLabel("Archive: ");
        archiveLabel.setBorder(labelBorder);

        titleDataLabel = new JLabel(title);
        titleDataLabel.setBorder(labelBorder);
        titleDataLabel.setFont(Large);
        titleDataLabel.setMaximumSize(new Dimension(500,55)); // I have no idea why this works, but it does
        composerDataLabel = new JLabel(composer);
        composerDataLabel.setBorder(labelBorder);
        keyDataLabel = new JLabel(key);
        keyDataLabel.setBorder(labelBorder);
        genreDataLabel = new JLabel(genre);
        genreDataLabel.setBorder(labelBorder);
        lengthDataLabel = new JLabel(String.format("%d:%02d", (length / 60), (length % 60)));
        lengthDataLabel.setBorder(labelBorder);
        tempoDataLabel = new JLabel(String.valueOf(tempo));
        tempoDataLabel.setBorder(labelBorder);
        introDataLabel = new JLabel(String.valueOf(intro));
        introDataLabel.setBorder(labelBorder);
        archiveDataLabel = new JCheckBox("",archive);
        archiveDataLabel.setEnabled(false);
        archiveDataLabel.setBorder(labelBorder);

        labels.add(titleLabel);
        if (tempo != -1){labels.add(composerLabel);}
        if (tempo != -1){labels.add(keyLabel);}
        if (tempo != -1){labels.add(genreLabel);}
        labels.add(lengthLabel);
        if (tempo != -1){labels.add(tempoLabel);}
        if (tempo != -1){labels.add(introLabel);}
        if (tempo != -1){labels.add(archiveLabel);}

        data.add(titleDataLabel);
        if (tempo != -1){data.add(composerDataLabel);}
        if (tempo != -1){data.add(keyDataLabel);}
        if (tempo != -1){data.add(genreDataLabel);}
        data.add(lengthDataLabel);
        if (tempo != -1){data.add(tempoDataLabel);}
        if (tempo != -1){data.add(introDataLabel);}
        if (tempo != -1){data.add(archiveDataLabel);}

        add(labels);
        add(data);

        setBorder(BorderFactory.createRaisedBevelBorder());
    }

    /**
     * Default constructor
     */
    public SongGUI() {
        title = " ";
        composer = " ";
        key = " ";
        genre = " ";
        length = 0;
        tempo = 0;
        intro = 0;
        archive = false;
        create();
    }

    /**
     * Parameterized constructor using a Song reference
     * @param s A song
     */
    public SongGUI(Song s) {
        title = s.getTitle();
        composer = s.getComposer();
        key = s.getKey();
        genre = s.getGenre();
        length = s.getLength();
        tempo = s.getTempo();
        intro = s.getIntro();
        archive = s.isArchive();
        create();
    }

    /**
     * Parameterized constructor using individual data for Song class
     * @param title Song title
     * @param composer Song composer
     * @param key Song key
     * @param genre Song genre
     * @param length Length of Song in seconds
     * @param tempo Tempo of Song in BPM
     * @param intro Length of introduction in seconds
     * @param archive Archive state; true means will not be included in setlists
     */
    public SongGUI(String title, String composer, String key, String genre, int length, int tempo, int intro, boolean archive) {
        this.title = title;
        this.composer = composer;
        this.key = key;
        this.genre = genre;
        this.length = length;
        this.tempo = tempo;
        this.intro = intro;
        this.archive = archive;
        create();
    }

    /**
     * Sets GUI to display specified song
     * @param s song to display
     */
    public void changeSong(Song s) {
        title = s.getTitle();
        composer = s.getComposer();
        key = s.getKey();
        genre = s.getGenre();
        length = s.getLength();
        tempo = s.getTempo();
        intro = s.getIntro();
        archive = s.isArchive();

        if (title.equals("")) {
            title = " ";
        }
        if (composer.equals("")) {
            composer = " ";
        }
        if (key.equals("")) {
            key = " ";
        }
        if (genre.equals("")) {
            genre = " ";
        }

        titleDataLabel.setText(title);
        composerDataLabel.setText(composer);
        keyDataLabel.setText(key);
        genreDataLabel.setText(genre);
        lengthDataLabel.setText(String.format("%d:%02d", (length / 60), (length % 60)));
        tempoDataLabel.setText(String.valueOf(tempo));
        introDataLabel.setText(String.valueOf(intro));
        archiveDataLabel.setSelected(archive);
    }

    /**
     * Gets song title
     * @return song title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets song composer
     * @return Song composer
     */
    public String getComposer() {
        return composer;
    }

    /**
     * Gets song key
     * @return Song key
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets song genre
     * @return Song genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Gets song length
     * @return song length
     */
    public int getLength() {
        return length;
    }

    /**
     * Gets song tempo
     * @return song tempo
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Gets song introduction length
     * @return song introduction length
     */
    public int getIntro() {
        return intro;
    }

    /**
     * Gets song archive status
     * @return song archive status
     */
    public boolean getArchive() {
        return archive;
    }
}
