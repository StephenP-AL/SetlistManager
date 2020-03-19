package setlist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileIO {

    public void openCatalog(String path, Catalog target){
        FileReader infile;
        try {
            infile = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Unable to open file \"" + path + "\"");
            return;
        }

        Scanner scanFile = new Scanner (infile);
        // IntelliJ thinks new String() is redundant, but does not run properly without it
        String line = new String();
        boolean end = false;
        while (scanFile.hasNextLine() && !line.equals("#eof")){
            // Skip anything that is not a Song
            while (!line.equals("#song")) {
                line = scanFile.nextLine();
                if (line.equals("#eof")){
                    System.out.println("end of file 2");
                    return;
                }
              //  System.out.println(line + " | " + line.equals("#song"));
            }
            //System.out.println("out");
            Song newSong = new Song();
            //parse the song data
            while (!line.equals("#gnos")) {
                line = scanFile.nextLine();
                if(line.startsWith("title:")){
                    newSong.setTitle(line.substring(6));
                }
                else if(line.startsWith("composer:")){
                    newSong.setComposer(line.substring(9));
                }
                else if(line.startsWith("key:")){
                    newSong.setKey(line.substring(4));
                }
                else if(line.startsWith("genre:")){
                    newSong.setGenre(line.substring(6));
                }
                else if (line.startsWith("length:")){
                    newSong.setLength(Integer.parseInt(line.substring(7)));
                }
                else if (line.startsWith("tempo:")){
                    newSong.setTempo(Integer.parseInt(line.substring(6)));
                }
                else if (line.startsWith("intro:")){
                    newSong.setIntro(Integer.parseInt(line.substring(6)));
                }
                else if (line.equals("archive:0")){
                    newSong.setArchive(false);
                }
                else if (line.equals("arvhive:1")){
                    newSong.setArchive(true);
                }
                else if (line.equals("gnos")){
                    break;
                }
            }
            System.out.println(newSong.toString());
            target.addSong(newSong);
        }
        System.out.println("Something went wrong");
    }
}
