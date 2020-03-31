package setlist;

import javax.swing.*;
import java.awt.*;

public class ListGUI extends JPanel {
    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);

    private void create() {
        setLayout(layout);
    }

    public ListGUI() {
        create();
    }

    public ListGUI(Component c){ // Can we safely change this to JComponent?
        create();
        add(c);
        ((JComponent)c).setAlignmentX(LEFT_ALIGNMENT);
    }

    public void addListElement(Component c) {
        add(c);
        ((JComponent)c).setAlignmentX(LEFT_ALIGNMENT);
        repaint();
        revalidate();
    }

    public void removeListElement(Component c) {
        Component[] cList = this.getComponents();
        for (Component component : cList) {
            if (component.equals(c)) {
                this.remove(component);
            }
        }
        repaint();
        revalidate();
    }

    public void clear() {
        Component[] cList = this.getComponents();
        for (Component component : cList) {
            this.remove(component);
        }
        repaint();
        revalidate();
    }
}
