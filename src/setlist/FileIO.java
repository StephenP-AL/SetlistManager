package setlist;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
        // IntelliJ thinks new String() is redundant, but does not run properly without it
        String line = new String();
        boolean end = false;
        while (scanFile.hasNextLine()){
            // Skip anything that is not a Song
            while (!line.equals("#song")) {
                line = scanFile.nextLine();
                // Stops at the end of the file
                if (line.equals("#eof")){
                    System.out.println("end of file");
                    return;
                }
            }
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

    public void writeCatalog(Catalog source, String file){
        //stub
    }
}
