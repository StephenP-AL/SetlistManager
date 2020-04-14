package setlist;

import javax.swing.*;
import java.awt.*;

/**
 * Displays a Song object's data in editable fields
 */
public class SongPropertiesGUI extends JPanel {

    private final JTextField titleTextField = new JTextField();
    private final JTextField composerTextField = new JTextField();
    private final JTextField keyTextField = new JTextField();
    private final JTextField genreTextField = new JTextField();
    private final JTextField lengthTextField = new JTextField();
    private final JTextField tempoTextField = new JTextField();
    private final JTextField introTextField = new JTextField();
    private final JCheckBox archiveCheckBox = new JCheckBox();

    private void create(Song s) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Dimension d = new Dimension(200, 20);

        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setPreferredSize(d);
        JLabel composerLabel = new JLabel("Composer: ");
        composerLabel.setPreferredSize(d);
        JLabel keyLabel = new JLabel("Key: ");
        keyLabel.setPreferredSize(d);
        JLabel genreLabel = new JLabel("Genre: ");
        genreLabel.setPreferredSize(d);
        JLabel lengthLabel = new JLabel("Length (in seconds): ");
        lengthLabel.setPreferredSize(d);
        JLabel tempoLabel = new JLabel("Tempo (in beats per minute): ");
        tempoLabel.setPreferredSize(d);
        JLabel introLabel = new JLabel("Intro (in seconds): ");
        introLabel.setPreferredSize(d);
        JLabel archiveLabel = new JLabel("Archive: ");
        archiveLabel.setPreferredSize(d);

        titleTextField.setText(s.getTitle());
        titleTextField.setPreferredSize(d);
        composerTextField.setText(s.getComposer());
        composerTextField.setPreferredSize(d);
        keyTextField.setText(s.getKey());
        keyTextField.setPreferredSize(d);
        genreTextField.setText(s.getGenre());
        genreTextField.setPreferredSize(d);
        lengthTextField.setText(String.valueOf(s.getLength()));
        lengthTextField.setPreferredSize(d);
        tempoTextField.setText(String.valueOf(s.getTempo()));
        tempoTextField.setPreferredSize(d);
        introTextField.setText(String.valueOf(s.getIntro()));
        introTextField.setPreferredSize(d);
        archiveCheckBox.setSelected(s.isArchive());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.add(titleLabel);
        titlePanel.add(titleTextField);

        JPanel composerPanel = new JPanel();
        composerPanel.setLayout(new BoxLayout(composerPanel, BoxLayout.X_AXIS));
        composerPanel.add(composerLabel);
        composerPanel.add(composerTextField);

        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new BoxLayout(keyPanel, BoxLayout.X_AXIS));
        keyPanel.add(keyLabel);
        keyPanel.add(keyTextField);

        JPanel genrePanel = new JPanel();
        genrePanel.setLayout(new BoxLayout(genrePanel, BoxLayout.X_AXIS));
        genrePanel.add(genreLabel);
        genrePanel.add(genreTextField);

        JPanel lengthPanel = new JPanel();
        lengthPanel.setLayout(new BoxLayout(lengthPanel, BoxLayout.X_AXIS));
        lengthPanel.add(lengthLabel);
        lengthPanel.add(lengthTextField);

        JPanel tempoPanel = new JPanel();
        tempoPanel.setLayout(new BoxLayout(tempoPanel, BoxLayout.X_AXIS));
        tempoPanel.add(tempoLabel);
        tempoPanel.add(tempoTextField);

        JPanel introPanel = new JPanel();
        introPanel.setLayout(new BoxLayout(introPanel, BoxLayout.X_AXIS));
        introPanel.add(introLabel);
        introPanel.add(introTextField);

        JPanel archivePanel = new JPanel();
        archivePanel.setLayout(new BoxLayout(archivePanel, BoxLayout.X_AXIS));
        archivePanel.add(archiveLabel);
        archivePanel.add(archiveCheckBox);

        add(titlePanel);
        add(composerPanel);
        add(keyPanel);
        add(genrePanel);
        add(lengthPanel);
        add(tempoPanel);
        add(introPanel);
        add(archivePanel);
    }

    /**
     * Creates GUI with default song
     */
    public SongPropertiesGUI() {
        Song s = new Song("", "", "", "", 0, 0, 0, false);
        create(s);
    }

    /**
     * Creates GUI with chosen song
     * @param s Song to display data from
     */
    public SongPropertiesGUI(Song s) {
        create(s);
    }

    /**
     * Copy constructor, creates GUI based on another GUI
     * @param spv GUI to display data from
     */
    public SongPropertiesGUI(SongPropertiesGUI spv) {
        create(new Song(spv.getTitle(), spv.getComposer(), spv.getKey(), spv.getGenre(), spv.getLength(), spv.getTempo(), spv.getIntro(), spv.getArchive()));
    }

    /**
     * Creates song based on parameters and creates GUI based on newly created song
     * @param title Title of the song
     * @param composer Composer of the song
     * @param key Key of the song
     * @param genre Genre of the song
     * @param length Length of the song in seconds
     * @param tempo Tempo of the song in BPM
     * @param intro Length of introduction in seconds
     * @param archive True to exclude from all created setlists
     */
    public SongPropertiesGUI(String title, String composer, String key, String genre, int length, int tempo, int intro, boolean archive) {
        Song s = new Song(title, composer, key, genre, length, tempo, intro, archive);
        create(s);
    }

    /**
     * Changes fields to new song data
     * @param s New song
     */
    public void changeSong(Song s) {
        titleTextField.setText(s.getTitle());
        composerTextField.setText(s.getComposer());
        keyTextField.setText(s.getKey());
        genreTextField.setText(s.getGenre());
        lengthTextField.setText(String.valueOf(s.getLength()));
        tempoTextField.setText(String.valueOf(s.getTempo()));
        introTextField.setText(String.valueOf(s.getIntro()));
        archiveCheckBox.setSelected(s.isArchive());
    }

    /**
     * @return Title field text, returns space if blank
     */
    public String getTitle() {
        if (titleTextField.getText().equals("")) {
            return " ";
        } else {
            return titleTextField.getText();
        }
    }

    /**
     * @return Composer field text, returns space if blank
     */
    public String getComposer() {
        if (composerTextField.getText().equals("")) {
            return " ";
        } else {
            return composerTextField.getText();
        }
    }

    /**
     * @return Key field text, returns space if blank
     */
    public String getKey() {
        if (keyTextField.getText().equals("")) {
            return " ";
        } else {
            return keyTextField.getText();
        }
    }

    /**
     * @return Genre field text, returns space if blank
     */
    public String getGenre() {
        if (genreTextField.getText().equals("")) {
            return " ";
        } else {
            return genreTextField.getText();
        }
    }

    /**
     * @return Integer parsed from length field text, if no integer can be parsed, displays error message and returns 0
     */
    public int getLength() {
        int n;
        try {
            n = Integer.parseInt(lengthTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Length may have been entered incorrectly", "Error", JOptionPane.ERROR_MESSAGE);
            n = 0;
        }
        return n;
    }

    /**
     * @return Text in length field
     */
    public String getLengthText() {
        return lengthTextField.getText();
    }

    /**
     * @return Integer parsed from tempo field text, if no integer can be parsed, displays error message and returns 0
     */
    public int getTempo() {
        int n;
        try {
            n = Integer.parseInt(tempoTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Tempo may have been entered incorrectly", "Error", JOptionPane.ERROR_MESSAGE);
            n = 0;
        }
        return n;
    }

    /**
     * @return Text in tempo field
     */
    public String getTempoText() {
        return tempoTextField.getText();
    }

    /**
     * @return Integer parsed from intro field text, if no integer can be parsed, displays error message and returns 0
     */
    public int getIntro() {
        int n;
        try {
            n = Integer.parseInt(introTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Intro may have been entered incorrectly", "Error", JOptionPane.ERROR_MESSAGE);
            n = 0;
        }
        return n;
    }

    /**
     * @return Text in intro field
     */
    public String getIntroText() {
        return introTextField.getText();
    }

    /**
     * @return Selection status of archive check box
     */
    public boolean getArchive() {
        return archiveCheckBox.isSelected();
    }
}
