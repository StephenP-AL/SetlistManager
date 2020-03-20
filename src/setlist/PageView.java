package setlist;

import javax.swing.*;
import java.awt.*;

public class PageView extends JPanel {
    public PageView(Component c1, Component c2) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(c1);
        add(c2);
    }
}
