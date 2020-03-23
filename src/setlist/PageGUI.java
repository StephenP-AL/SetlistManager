package setlist;

import javax.swing.*;
import java.awt.*;

public class PageGUI extends JPanel {
    public PageGUI(Component c1, Component c2) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(c1);
        add(c2);
    }
}
