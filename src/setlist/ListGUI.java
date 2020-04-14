package setlist;

import javax.swing.*;
import java.awt.*;

/**
 * Displays JComponents vertically in a list
 */
public class ListGUI extends JPanel {
    final BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);

    /**
     * Applies layout
     */
    private void create() {
        setLayout(layout);
    }

    /**
     * Generic constructor
     */
    public ListGUI() {
        create();
    }

    /**
     * Parameterized constructor
     * @param c First JComponent in the list
     */
    public ListGUI(JComponent c){
        create();
        add(c);
        c.setAlignmentX(LEFT_ALIGNMENT);
    }

    /**
     * Adds JComponent
     * @param c JComponent to add to list
     */
    public void addListElement(JComponent c) {
        add(c);
        c.setAlignmentX(LEFT_ALIGNMENT);
        repaint();
        revalidate();
    }

    /**
     * Removes JComponent from the list
     * @param c JComponent to remove from list
     */
    public void removeListElement(JComponent c) {
        Component[] cList = this.getComponents();
        for (Component component : cList) {
            if (component.equals(c)) {
                this.remove(component);
            }
        }
        repaint();
        revalidate();
    }

    /**
     * Removes all JComponents
     */
    public void clear() {
        Component[] cList = this.getComponents();
        for (Component component : cList) {
            this.remove(component);
        }
        repaint();
        revalidate();
    }
}
