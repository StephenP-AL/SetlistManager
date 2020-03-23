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

    public ListGUI(Component c){
        create();
        add(c);
    }

    public void addListElement(Component c) {
        add(c);
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
