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
        String line;
        while (scanFile.hasNextLine()){
            // Skip anything that is not a Song
            do {
                line = scanFile.nextLine();
            } while line.equals("#song");


        }


    }
}
