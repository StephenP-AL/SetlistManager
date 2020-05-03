package setlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Files;

/**
 * Manages user preferences
 */
public class ConfigManager {
    private String lastCatalog;
    private String OS;
    private int defaultBreakLength;
    private int defaultBreakCount;
    private int defaultSetLength;
    private int defaultIntro;

    /**
     * Default constructor
     */
    public ConfigManager(){
        OS = System.getProperty("os.name");
        System.out.println(OS);
        loadConfig();
    }

    public void loadConfig(){
        String file;
        if(OS.startsWith("Windows")){
            file = System.getProperty("user.home") + "\\SetlistManager\\settings.cfg";
        }
        else if (OS.startsWith("Linux")){
            file = "~/.config/SetlistManager/settings.cfg";
        }
        else {
            file = System.getProperty("user.dir") + "/.settings.cfg";
        }

        FileReader infile;
        try {
            infile = new FileReader(file);
            System.out.println("file found");
        } catch (FileNotFoundException e) {
            PrintWriter out = null;
            e.printStackTrace();
            if (OS.startsWith("Windows")){
                System.out.println("making directory");
                new File(System.getProperty("user.home") + "\\AppData\\Roaming\\SetlistManger").mkdirs();

            }
            else if (OS.startsWith("Linux")){
                new File(  System.getProperty("user.home")+"/.config/SetlistManger").mkdirs();
            }

            return;
        }


    }
}