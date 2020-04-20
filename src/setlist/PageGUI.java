package setlist;

import javax.swing.*;
import java.awt.*;

/**
 * Arranges GUI in a 2 tabbed window
 */
public class PageGUI extends JPanel {
    /**
     * Arranges 2 components horizontally in a panel
     * @param c1 Left component
     * @param c2 Right component
     */
    public PageGUI(Component c1, Component c2) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(c1);
        add(c2);
    }
}
