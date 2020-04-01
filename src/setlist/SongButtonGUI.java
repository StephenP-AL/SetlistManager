package setlist;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongButtonGUI extends JPanel {
    protected JButton edit;
    protected JButton remove;

    private void create(Song s, SongPropertiesGUI spv, Catalog c, ListGUI lv) {
        ImageIcon editIcon = new ImageIcon("EditSong.png");
        Image editImg = editIcon.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
        editIcon = new ImageIcon(editImg);
        ImageIcon finalEditIcon = editIcon;

        Border space = BorderFactory.createEmptyBorder(10,10,10,10);

        SongGUI sv = new SongGUI(s);

        Dimension buttonSize = new Dimension(175,33);
        edit = new JButton("Edit");
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spv.changeSong(s);
                int r = JOptionPane.showConfirmDialog(SongButtonGUI.this, spv, "Edit Song", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, finalEditIcon);
                if (r == 0) {
                    boolean length = true;
                    boolean tempo = true;
                    boolean intro = true;
                    try {
                        Integer.parseInt(spv.getLengthText());
                    } catch (NumberFormatException e1) {
                        length = false;
                        JOptionPane.showMessageDialog(SongButtonGUI.this,"Length may have been entered incorrectly", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        Integer.parseInt(spv.getTempoText());
                    } catch (NumberFormatException e1) {
                        tempo = false;
                        JOptionPane.showMessageDialog(SongButtonGUI.this,"Tempo may have been entered incorrectly", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        Integer.parseInt(spv.getIntroText());
                    } catch (NumberFormatException e1) {
                        intro = false;
                        JOptionPane.showMessageDialog(SongButtonGUI.this,"Intro may have been entered incorrectly", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    s.setTitle(spv.getTitle());
                    s.setComposer(spv.getComposer());
                    s.setKey(spv.getKey());
                    s.setGenre(spv.getGenre());
                    if (length) {
                        s.setLength(spv.getLength());
                    }
                    if (tempo) {
                        s.setTempo(spv.getTempo());
                    }
                    if (intro) {
                        s.setIntro(spv.getIntro());
                    }
                    s.setArchive(spv.getArchive());
                    spv.changeSong(s);
                    sv.changeSong(s);
                    spv.repaint();
                    spv.revalidate();
                    sv.repaint();
                    sv.revalidate();
                    repaint();
                    revalidate();
                    lv.repaint();
                    lv.revalidate();
                }
            }
        });
        edit.setBorder(space);
        edit.setMaximumSize(buttonSize);
        remove = new JButton("Remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lv.removeListElement(SongButtonGUI.this);
                c.remove(s);
            }
        });
        remove.setBorder(space);
        remove.setMaximumSize(buttonSize);

        ListGUI buttonPanel = new ListGUI(edit);
        buttonPanel.addListElement(remove);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        add(sv);
        add(buttonPanel);
    }

    public SongButtonGUI() {
        create(new Song(), new SongPropertiesGUI(), new Catalog(), new ListGUI());
    }

    public SongButtonGUI(Song s, SongPropertiesGUI spv, Catalog c, ListGUI lv) {
        create(s, spv, c, lv);
    }
}
