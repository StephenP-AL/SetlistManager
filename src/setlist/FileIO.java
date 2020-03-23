package setlist;



import java.io.*;
import java.util.Scanner;

public class FileIO {

    /**
     * openCatalog populates a Catalog with song data from a .setlist file on disk
     * @param file Location of the .setlist file on the disk
     * @param target Catalog to be populated
     */
    public void openCatalog(String file, Catalog target){
        FileReader infile;
        try {
            infile = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Unable to open file \"" + file + "\"");
            return;
        }

        Scanner scanFile = new Scanner (infile);
        // IntelliJ thinks 'new String()' is redundant, but does not run properly without it
        String line = new String();
        boolean end = false;
        while (scanFile.hasNextLine()){
            // Skip anything that is not a Song
            while (!line.equals("#song")) {
                line = scanFile.nextLine();
                // Stops at the end of the file
                if (line.equals("#eof") || !scanFile.hasNextLine()){
                    //System.out.println("end of file");
                    return;
                }
            }
            Song newSong = new Song();
            //parse the song data
            while (!line.equals("#gnos")) {
                line = scanFile.nextLine();
                if(line.startsWith("title:")){
                    if (line.substring(6).equals("")) {
                        newSong.setTitle(" ");
                    } else {
                        newSong.setTitle(line.substring(6));
                    }
                }
                else if(line.startsWith("composer:")){
                    if (line.substring(9).equals("")) {
                        newSong.setComposer(" ");
                    } else {
                        newSong.setComposer(line.substring(9));
                    }
                }
                else if(line.startsWith("key:")){
                    if (line.substring(4).equals("")) {
                        newSong.setKey(" ");
                    } else {
                        newSong.setKey(line.substring(4));
                    }
                }
                else if(line.startsWith("genre:")){
                    if (line.substring(6).equals("")) {
                        newSong.setGenre(" ");
                    } else {
                        newSong.setGenre(line.substring(6));
                    }
                }
                else if (line.startsWith("length:")){
                    try {
                        newSong.setLength(Integer.parseInt(line.substring(7)));
                    } catch (NumberFormatException e) {
                        newSong.setLength(0);
                    }
                }
                else if (line.startsWith("tempo:")){
                    try {
                        newSong.setTempo(Integer.parseInt(line.substring(6)));
                    } catch (NumberFormatException e) {
                        newSong.setTempo(0);
                    }
                }
                else if (line.startsWith("intro:")){
                    try {
                        newSong.setIntro(Integer.parseInt(line.substring(6)));
                    } catch (NumberFormatException e) {
                        newSong.setIntro(0);
                    }
                }
                else if (line.equals("archive:0")){
                    newSong.setArchive(false);
                }
                else if (line.equals("archive:1")){
                    newSong.setArchive(true);
                }
                else if (line.equals("gnos")){
                    break;
                }
            }
            //System.out.println(newSong.toString());
            target.addSong(newSong);
        }
        //System.out.println("Something went wrong");
    }

    /**
     * Writes Song data from Catalog to file on disk
     * @param source Catalog that contains song data to be written
     * @param file Path on disk of file to be written
     */
    public void writeCatalog(Catalog source, String file){
        boolean overwrite = false;
        FileReader infile;
        try {
            infile = new FileReader(file);
        } catch (FileNotFoundException e) {
            overwrite = true;
        }
        if (overwrite){
            //some sort of warning about overwriting existing files
        }
        PrintWriter out = null;
        try {
            out =  new PrintWriter(new FileWriter(file, false));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Object i:source.reviewSongList()){
            if (out != null) {
                out.println("#song");
            }
            if (out != null) {
                out.println("title:" + ((Song)i).getTitle());
            }
            if (out != null) {
                out.println("composer:" + ((Song)i).getComposer());
            }
            if (out != null) {
                out.println("key:" + ((Song)i).getKey());
            }
            if (out != null) {
                out.println("genre:" + ((Song)i).getGenre());
            }
            if (out != null) {
                out.println("length:" + ((Song)i).getLength());
            }
            if (out != null) {
                out.println("tempo:" + ((Song)i).getTempo());
            }
            if (out != null) {
                out.println("intro:" + ((Song)i).getIntro());
            }
            if(((Song)i).isArchive()){
                if (out != null) {
                    out.println("archive:1");
                }
            }
            else{
                if (out != null) {
                    out.println("archive:0");
                }
            }
            if (out != null) {
                out.println("#gnos");
            }
            if (out != null) {
                out.println("");
            }
        }
        if (out != null) {
            out.println("#eof");
        }
        if (out != null) {
            out.close();
        }
    }
}