package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongButtonView extends JPanel {
    protected JButton edit;
    protected JButton remove;

    private void create(Song s, SongPropertiesView spv, Catalog c, ListView lv) {
        ImageIcon editIcon = new ImageIcon("EditSong.png");
        Image editImg = editIcon.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
        editIcon = new ImageIcon(editImg);
        ImageIcon finalEditIcon = editIcon;

        Border space = BorderFactory.createEmptyBorder(10,10,10,10);

        SongView sv = new SongView(s);

        edit = new JButton("Edit");
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = JOptionPane.showConfirmDialog(SongButtonView.this, spv, "Edit Song", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, finalEditIcon);
                if (r == 0) {
                    s.setTitle(spv.getTitle());
                    s.setComposer(spv.getComposer());
                    s.setKey(spv.getKey());
                    s.setGenre(spv.getGenre());
                    s.setLength(spv.getLength());
                    s.setTempo(spv.getTempo());
                    s.setIntro(spv.getIntro());
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
        remove = new JButton("Remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lv.removeListElement(SongButtonView.this);
                c.remove(s);
            }
        });
        remove.setBorder(space);

        ListView buttonPanel = new ListView(edit);
        buttonPanel.addListElement(remove);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        add(sv);
        add(buttonPanel);
    }

    public SongButtonView() {
        create(new Song(), new SongPropertiesView(), new Catalog(), new ListView());
    }

    public SongButtonView(Song s, SongPropertiesView spv, Catalog c, ListView lv) {
        create(s, spv, c, lv);
    }
}
