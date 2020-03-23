package setlist;

import javax.swing.*;
import java.awt.*;

public class SettingsGUI extends JPanel {
    private JTextField setLengthTextField = new JTextField();
    private JTextField breakLengthTextField = new JTextField();
    private JTextField breakAmountTextField = new JTextField();

    public SettingsGUI(Setlist s) {
        setLayout(new GridLayout(3, 2));

        JLabel setLengthLabel = new JLabel("Set Length:");
        JLabel breakLengthLabel = new JLabel("Break Length:");
        JLabel breakAmountLabel = new JLabel("Number of Breaks:");

        setLengthTextField.setText(String.valueOf(s.getLength()));
        breakLengthTextField.setText(String.valueOf(s.getBreakLength()));
        breakAmountTextField.setText(String.valueOf(s.getBreakCount()));

        add(setLengthLabel);
        add(setLengthTextField);
        add(breakLengthLabel);
        add(breakLengthTextField);
        add(breakAmountLabel);
        add(breakAmountTextField);
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
}
