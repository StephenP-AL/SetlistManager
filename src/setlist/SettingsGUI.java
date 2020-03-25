package setlist;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SettingsGUI extends JPanel {
    private JTextField setLengthTextField = new JTextField();
    private JTextField breakLengthTextField = new JTextField();
    private JTextField breakAmountTextField = new JTextField();
    private JTextField genreRestrictTextField = new JTextField();

    public SettingsGUI(Setlist s) {
        setLayout(new GridLayout(4, 2));

        JLabel setLengthLabel = new JLabel("Set Length:");
        JLabel breakLengthLabel = new JLabel("Break Length:");
        JLabel breakAmountLabel = new JLabel("Number of Breaks:");
        JLabel genreRestrictLabel = new JLabel("Genre(s) to exclude (separate with commas):");

        setLengthTextField.setText(String.valueOf(s.getLength()));
        breakLengthTextField.setText(String.valueOf(s.getBreakLength()));
        breakAmountTextField.setText(String.valueOf(s.getBreakCount()));
        ArrayList<String> genreRestrict = s.getGenreRestrict();
        String genreRestrictString = "";
        for (int i = 0; i < genreRestrict.size(); ++i) {
            if (i != genreRestrict.size()-1) {
                genreRestrictString += genreRestrict.get(i) + ", ";
            } else {
                genreRestrictString += genreRestrict.get(i);
            }
        }
        genreRestrictTextField.setText(genreRestrictString);


        add(setLengthLabel);
        add(setLengthTextField);
        add(breakLengthLabel);
        add(breakLengthTextField);
        add(breakAmountLabel);
        add(breakAmountTextField);
        add(genreRestrictLabel);
        add(genreRestrictTextField);
    }

    public void update(Setlist s) {
        setLengthTextField.setText(String.valueOf(s.getLength()));
        breakLengthTextField.setText(String.valueOf(s.getBreakLength()));
        breakAmountTextField.setText(String.valueOf(s.getBreakCount()));
        ArrayList<String> genreRestrict = s.getGenreRestrict();
        String genreRestrictString = "";
        for (int i = 0; i < genreRestrict.size(); ++i) {
            if (i != genreRestrict.size()-1) {
                genreRestrictString += genreRestrict.get(i) + ", ";
            } else {
                genreRestrictString += genreRestrict.get(i);
            }
        }
        genreRestrictTextField.setText(genreRestrictString);
    }

    public int getSetLength() {
        return Integer.parseInt(setLengthTextField.getText());
    }

    public int getBreakLength() {
        return Integer.parseInt(breakLengthTextField.getText());
    }

    public int getBreakAmount() {
        return Integer.parseInt(breakAmountTextField.getText());
    }

    public String getGenreRestrict() {
        return genreRestrictTextField.getText();
    }
}
