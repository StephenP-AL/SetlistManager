package com.company;


public class Main {
    public static void main(String[] args) {
        MainView.createAndShowGUI();
    }
}



//
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Catalog c = new Catalog();
//        //File s1 = new File("songs1.txt");
//        FileIO fileIO = new FileIO();
//        fileIO.openCatalog("songs1.txt", c);
//
//        ListView songButtonList = new ListView();
//        int i = 0;
//        Song s;
//        while ((s = c.reviewSong(i)) != null) {
//            songButtonList.addListElement(new SongButtonView(s));
//            ++i;
//        }
//
//
//        //---------------------------------------
//
//        JFrame frame = new JFrame("Setlist Manager");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JTextArea setlistText = new JTextArea();
//        setlistText.setEditable(false);
//        try {
//            setlistText.read(new FileReader("C:\\Users\\hcsee\\IdeaProjects\\GUI_Test\\songs.txt"), "List of songs");
//        } catch (IOException e) {
//            System.exit(1);
//        }
//
//        JTextArea catalogText = new JTextArea();
//        catalogText.setEditable(false);
//        try {
//            catalogText.read(new FileReader("C:\\Users\\hcsee\\IdeaProjects\\GUI_Test\\songs.txt"), "List of songs");
//        } catch (IOException e) {
//            System.exit(2);
//        }
//
//        JButton setlistButton = new JButton("Create");
//        setlistButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //JOptionPane.showMessageDialog(frame, "Button Pressed");
//
//               /* JFileChooser c = new JFileChooser();
//                int r = c.showOpenDialog(frame);
//                if (r == JFileChooser.APPROVE_OPTION) {
//                    System.out.println(c.getSelectedFile().toString());
//                }*/
//
//               JFileChooser c = new JFileChooser();
//               int r = c.showSaveDialog(frame);
//               if (r == JFileChooser.APPROVE_OPTION) {
//                   String parent;
//                   System.out.println(parent = c.getCurrentDirectory().toString());
//                   String child;
//                   System.out.println(child = c.getSelectedFile().getName());
//                   File save = new File(parent, child);
//                   System.out.println(save.toString());
//                   try {
//                       boolean b = save.createNewFile();
//                       if (b == false) {
//                           System.out.println("Filename taken.");
//                       } else {
//                           FileWriter writer = new FileWriter(save);
//                           writer.write("Hello");
//                           writer.close();
//                       }
//                   } catch (IOException e1) {
//                       System.exit(3);
//                   }
//
//                   /*try {
//                       FileReader reader = new FileReader(save);
//                   } catch (IOException f) {
//                       System.exit(10);
//                   }*/
//
//
//
//                   /*try {
//                       FileWriter writer = new FileWriter(save);
//                       writer.write("Hello");
//                       writer.close();
//                   } catch (IOException e2) {
//                       System.exit(4);
//                   }*/
//
//               }
//
//            }
//        });
//        JButton setlistButton2 = new JButton("Really");
//        setlistButton2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ImageIcon editSong = new ImageIcon("EditSong.png");
//                Image editImg = editSong.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
//                editSong = new ImageIcon(editImg);
//                SongPropertiesView editView = new SongPropertiesView("s", "s", "s", "s", 1, 1, 1, true);
//                int r = JOptionPane.showConfirmDialog(frame, editView, "Edit Song", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, editSong);
//                if (r == 0) {
//                    Song s = new Song(editView.getTitle(), editView.getComposer(), editView.getKey(), editView.getGenre(), editView.getLength(), editView.getTempo(), editView.getIntro(), editView.getArchive());
//                    c.addSong(s);
//                    fileIO.writeCatalog(c, "songs1.txt");
//                    System.out.println(s.toString());
//
//                    setlistText.append(editView.getTitle() + " ");
//                    setlistText.append(editView.getComposer() + " ");
//                    setlistText.append(editView.getKey() + " ");
//                    setlistText.append(editView.getGenre() + " ");
//                    setlistText.append(editView.getLength() + " ");
//                    setlistText.append(editView.getTempo() + " ");
//                    setlistText.append(editView.getIntro() + " ");
//                    setlistText.append(editView.getArchive() + "\n");
//
//                    try {
//                        setlistText.write(new FileWriter("songs.txt"));
//                    } catch (IOException e333) {
//                        System.exit(10);
//                    }
//
//
//                    /*try {
//                        FileWriter w = new FileWriter("songs.txt");
//                        w.append(editView.getTitle()).append(" ");
//                        w.append(editView.getComposer()).append(" ");
//                        w.append(editView.getKey()).append(" ");
//                        w.append(editView.getGenre()).append(" ");
//                        w.append(String.valueOf(editView.getLength())).append(" ");
//                        w.append(String.valueOf(editView.getTempo())).append(" ");
//                        w.append(String.valueOf(editView.getIntro())).append(" ");
//                        w.append(String.valueOf(editView.getArchive())).append("\n");
//                        w.close();
//                    } catch (IOException i) {
//                        System.exit(33);
//                    }
//                    try {
//                        setlistText.read(new FileReader("C:\\Users\\hcsee\\IdeaProjects\\GUI_Test\\songs.txt"), "List of songs");
//                    } catch (IOException e11) {
//                        System.exit(11);
//                    }*/
//
//                    /*System.out.println(editView.getTitle());
//                    System.out.println(editView.getComposer());
//                    System.out.println(editView.getKey());
//                    System.out.println(editView.getGenre());
//                    System.out.println(editView.getLength());
//                    System.out.println(editView.getTempo());
//                    System.out.println(editView.getIntro());
//                    System.out.println(editView.getArchive());*/
//                }
//            }
//        });
//
//        /*JPanel songViewTest = new SongView("superman", "sasdf", "sfff", "sffff", 600, 100, 100, false);
//        songViewTest.setBorder(BorderFactory.createRaisedBevelBorder());
//        JPanel songViewTest2 = new SongView("what if the title's super long", "s", "s", "s", 1, 1, 1, true);
//        songViewTest2.setBorder(BorderFactory.createRaisedBevelBorder());
//        JPanel songViewTest3 = new SongView("superman", "sasdf", "sfff", "sffff", 600, 100, 100, false);
//        songViewTest3.setBorder(BorderFactory.createRaisedBevelBorder());
//        JPanel songViewTest4 = new SongView("superman", "sasdf", "sfff", "sffff", 600, 100, 100, false);
//        songViewTest4.setBorder(BorderFactory.createRaisedBevelBorder());
//        JPanel songViewTest5 = new SongView("superman", "sasdf", "sfff", "sffff", 600, 100, 100, false);
//        songViewTest5.setBorder(BorderFactory.createRaisedBevelBorder());
//        JPanel songViewTest6 = new SongView();
//        songViewTest6.setBorder(BorderFactory.createRaisedBevelBorder());
//        JPanel songViewTest7 = new SongView("superman", "sasdf", "sfff", "sffff", 600, 100, 100, false);
//        songViewTest7.setBorder(BorderFactory.createRaisedBevelBorder());
//        JPanel songViewTest8 = new SongView("superman", "sasdf", "sfff", "sffff", 600, 100, 100, false);
//        songViewTest8.setBorder(BorderFactory.createRaisedBevelBorder());*/
//
//        JPanel setlistButtons = new JPanel();
//        setlistButtons.setLayout(new BoxLayout(setlistButtons, BoxLayout.Y_AXIS));
//        setlistButtons.add(setlistButton);
//        setlistButtons.add(setlistButton2);
//
//        JButton catalogButton = new JButton("Add");
//        JButton catalogButton2 = new JButton("Add2");
//
//        JPanel catalogButtons = new JPanel();
//        catalogButtons.setLayout(new BoxLayout(catalogButtons, BoxLayout.Y_AXIS));
//        catalogButtons.add(catalogButton);
//        catalogButtons.add(catalogButton2);
//
//        //JScrollPane setlistScroll = new JScrollPane(setlistText);
//        JScrollPane setlistScroll = new JScrollPane(songButtonList);
//        JScrollPane catalogScroll = new JScrollPane(catalogText);
//        /*JPanel catalogTest = new JPanel();
//        BoxLayout textBox = new BoxLayout(catalogTest, BoxLayout.Y_AXIS);
//        catalogTest.setLayout(textBox);
//        catalogTest.add(songViewTest);
//        catalogTest.add(songViewTest2);
//        catalogTest.add(songViewTest3);
//        catalogTest.add(songViewTest4);
//        catalogTest.add(songViewTest5);
//        catalogTest.add(songViewTest6);
//        catalogTest.add(songViewTest7);
//        catalogTest.add(songViewTest8);
//        JScrollPane catalogScroll = new JScrollPane(catalogTest);*/
//
//        JPanel setlistPanel = new JPanel(new BorderLayout());
//        setlistPanel.add(setlistScroll, BorderLayout.CENTER);
//        setlistPanel.add(setlistButtons, BorderLayout.LINE_END);
//
//        JPanel catalogPanel = new JPanel(new BorderLayout());
//        //catalogPanel.add(songViewTest, BorderLayout.PAGE_START);
//        catalogPanel.add(catalogScroll, BorderLayout.CENTER);
//        //catalogPanel.add(songViewTest2, BorderLayout.PAGE_END);
//        catalogPanel.add(catalogButtons, BorderLayout.LINE_END);
//
//        JTabbedPane tabbedPane = new JTabbedPane();
//        tabbedPane.addTab("Setlist", setlistPanel);
//        tabbedPane.addTab("Catalog", catalogPanel);
//        tabbedPane.setPreferredSize(new Dimension(950, 500));
//
//        frame.add(tabbedPane);
//
//        frame.pack();
//        frame.setLocation(100, 100);
//        frame.setVisible(true);
//
//    }
//}




