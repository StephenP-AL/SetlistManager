package setlist;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    public static void createAndShowGUI() {
        Catalog c = new Catalog();
        RandomView randomCatalog = new RandomView();
        Setlist setlist = new Setlist(3600, 1, 600);
        FileIO fileIO = new FileIO();

        JFrame frame = new JFrame("Setlist Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        //Border
        Border space = BorderFactory.createEmptyBorder(5,5,5,5);

        //Icons!!!
        ImageIcon editIcon = new ImageIcon("EditSong.png");
        Image editImg = editIcon.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
        editIcon = new ImageIcon(editImg);
        ImageIcon finalEditIcon = editIcon;
        ImageIcon addIcon = new ImageIcon("AddSong.png");
        Image addImg = addIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        addIcon = new ImageIcon(addImg);
        ImageIcon finalAddIcon = addIcon;

        //Button Border
        Border buttonBorder = BorderFactory.createEmptyBorder(10,10,10,10);

        //Buttons!!!
        JButton addSong = new JButton("Add Song");
        addSong.setBorder(buttonBorder);
        JButton addFromFile = new JButton("Add Song(s) from File");
        addFromFile.setBorder(buttonBorder);
        JButton exportCatalog = new JButton("Export Catalog");
        exportCatalog.setBorder(buttonBorder);
        JButton generate = new JButton("Generate Setlist");
        generate.setBorder(buttonBorder);
        JButton settings = new JButton("Setlist Settings");
        settings.setBorder(buttonBorder);
        JButton exportSetlist = new JButton("Export Setlist");
        exportSetlist.setBorder(buttonBorder);

        ListGUI catalogList = new ListGUI();
        JScrollPane catalogScroll = new JScrollPane(catalogList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        catalogScroll.setBorder(space);
        catalogScroll.getVerticalScrollBar().setUnitIncrement(16);

        ListGUI catalogButtons = new ListGUI();
        catalogButtons.setBorder(space);
        catalogButtons.addListElement(addSong);
        SongPropertiesGUI addSongView = new SongPropertiesGUI();
        addSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Song songToAdd = new Song();
                addSongView.changeSong(songToAdd);
                int r = JOptionPane.showConfirmDialog(frame, addSongView, "Add Song", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, finalAddIcon);
                if (r == 0) {
                    String p1 = addSongView.getTitle();
                    String p2 = addSongView.getComposer();
                    String p3 = addSongView.getKey();
                    String p4 = addSongView.getGenre();
                    int p5 = addSongView.getLength();
                    int p6 = addSongView.getTempo();
                    int p7 = addSongView.getIntro();
                    boolean p8 = addSongView.getArchive();
                    if (p1.equals("")) {
                        p1 = " ";
                    }
                    if (p2.equals("")) {
                        p2 = " ";
                    }
                    if (p3.equals("")) {
                        p3 = " ";
                    }
                    if (p4.equals("")) {
                        p4 = " ";
                    }
                    try {
                        Integer.parseInt(addSongView.getLengthText());
                    } catch (NumberFormatException e1) {
                        p5 = 0;
                    }
                    try {
                        Integer.parseInt(addSongView.getTempoText());
                    } catch (NumberFormatException e1) {
                        p6 = 0;
                    }
                    try {
                        Integer.parseInt(addSongView.getIntroText());
                    } catch (NumberFormatException e1) {
                        p7 = 0;
                    }
                    addSongView.changeSong(new Song(addSongView.getTitle(), addSongView.getComposer(), addSongView.getKey(), addSongView.getGenre(), p5, p6, p7, p8));
                    songToAdd.setTitle(p1);
                    songToAdd.setComposer(p2);
                    songToAdd.setKey(p3);
                    songToAdd.setGenre(p4);
                    songToAdd.setLength(p5);
                    songToAdd.setTempo(p6);
                    songToAdd.setIntro(p7);
                    songToAdd.setArchive(p8);
                    c.addSong(songToAdd);
                    SongPropertiesGUI elementView = new SongPropertiesGUI(addSongView);
                    catalogList.addListElement(new SongButtonGUI(songToAdd, elementView, c, catalogList));
                }
            }
        });
        catalogButtons.addListElement(addFromFile);
        addFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int r = fileChooser.showOpenDialog(frame);
                if (r == JFileChooser.APPROVE_OPTION) {
                    Catalog fileCatalog = new Catalog();
                    String filename = fileChooser.getSelectedFile().toString();
                    fileIO.openCatalog(filename, fileCatalog);
                    Song fileSong;
                    int i = 0;
                    while ((fileSong = fileCatalog.getSong(i)) != null) {
                        c.addSong(fileSong);
                        catalogList.addListElement(new SongButtonGUI(fileSong, new SongPropertiesGUI(fileSong), c, catalogList));
                        ++i;
                    }
                }
            }
        });
        catalogButtons.addListElement(exportCatalog);
        exportCatalog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int r = fileChooser.showSaveDialog(frame);
                if (r == JFileChooser.APPROVE_OPTION) {
                    String filename = fileChooser.getSelectedFile().toString();
                    fileIO.writeCatalog(c, filename);
                }
            }
        });

        PageGUI catalogPage = new PageGUI(catalogScroll, catalogButtons);

        //------------------------------------------------------------------------

        ListGUI setlistList = new ListGUI();
        JScrollPane setlistScroll = new JScrollPane(setlistList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setlistScroll.setBorder(space);
        setlistScroll.getVerticalScrollBar().setUnitIncrement(16);

        ListGUI setlistButtons = new ListGUI();
        setlistButtons.setBorder(space);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setlist.clear();
                setlistList.clear();
                setlistScroll.repaint();
                setlistScroll.revalidate();
                tabbedPane.repaint();
                tabbedPane.revalidate();

                randomCatalog.Sort(c);

                int retValue = setlist.Populate(randomCatalog);
                Song setlistSong;
                int i = 0;
                while ((setlistSong = setlist.getSong(i)) != null) {
                    setlistList.addListElement(new SongGUI(setlistSong));
                    ++i;
                }
                if (retValue == 1){
                    String error = "Failed to generate a complete setlist.\nIf this problem persists, try adjusting your settings or adding more songs to your catalog.";
                    JOptionPane.showMessageDialog(new JFrame(), error, "Incomplete Setlist", JOptionPane.ERROR_MESSAGE );
                }
            }
        });
        setlistButtons.addListElement(generate);
        SettingsGUI settingsGUI = new SettingsGUI(setlist);
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsGUI.update(setlist);
                int r = JOptionPane.showConfirmDialog(frame, settingsGUI, "Setlist Settings", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (r == 0) {
                    setlist.setLength(settingsGUI.getSetLength());
                    //System.out.println(settingsGUI.getSetLength());
                    setlist.setBreakLength(settingsGUI.getBreakLength());
                    setlist.setBreakCount(settingsGUI.getBreakAmount());
                    setlist.setGenreRestrict(settingsGUI.getGenreRestrict());
                }
            }
        });
        setlistButtons.addListElement(settings);
        exportSetlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int r = fileChooser.showSaveDialog(frame);
                if (r == JFileChooser.APPROVE_OPTION) {
                    String filename = fileChooser.getSelectedFile().toString();
                    fileIO.writeCatalog(setlist, filename);
                }
            }
        });
        setlistButtons.addListElement(exportSetlist);

        PageGUI setlistPage = new PageGUI(setlistScroll, setlistButtons);

        //--------------------------------------------------------------------------

        tabbedPane.add("Catalog", catalogPage);
        tabbedPane.add("Setlist", setlistPage);
        tabbedPane.setPreferredSize(new Dimension(950, 500));

        frame.add(tabbedPane);

        frame.pack();
        frame.setLocation(100, 100);
        frame.setVisible(true);

    }
}
