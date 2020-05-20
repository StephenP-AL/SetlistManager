package setlist;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

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

    public void setLastCatalog(String s){
        lastCatalog = s;
        System.out.println(this.lastCatalog);
    }

    public String getLastCatalog(){
        return lastCatalog;
    }

    public void setDefaultBreakLength(int i){
        if (i < 0) {
            i = 0;
        }
        this.defaultBreakLength = i;
    }

    public int getDefaultBreakLength() {
        return defaultBreakLength;
    }

    public void setDefaultBreakCount(int i){
        if (i < 0){
            i=0;
        }
        this.defaultBreakCount = i;
    }

    public int getDefaultBreakCount(){
        return defaultBreakCount;
    }

    public void setDefaultIntro(int defaultIntro) {
        this.defaultIntro = defaultIntro;
    }

    public int getDefaultIntro(){
        return this.defaultIntro;
    }

    public void setDefaultSetLength(int defaultSetLength) {
        this.defaultSetLength = defaultSetLength;
    }

    public int getDefaultSetLength() {
        return defaultSetLength;
    }

    public void loadConfig(){
        System.out.println("Loading local configuration");
        String file;
        if(OS.startsWith("Windows")){
            file = System.getProperty("user.home") + "\\AppData\\Roaming\\SetlistManager\\settings.cfg";
        }
        else if (OS.startsWith("Linux")){
            file = System.getProperty("user.home") + "/.config/SetlistManager/settings.cfg";
        }
        else {
            file = System.getProperty("user.dir") + "/.settings.cfg";
        }

        FileReader infile;
        try {
            infile = new FileReader(file);
            System.out.println("Configuration file found: " + file );
            Scanner scanFile = new Scanner(infile);
            String line = "placeholder";
            int i = 1;
            while (scanFile.hasNextLine()){

                System.out.println(line);
                line = scanFile.nextLine();
                System.out.println(line + '1');
                if (line.startsWith("lastCatalog=")){
                    System.out.println(line.substring(12));
                    lastCatalog = line.substring(12);
                }
                else if(line.startsWith("defaultBreakLength=")){
                    defaultBreakLength = Integer.parseInt(line.substring(19));
                }
                else if (line.startsWith("defaultBreakCount=")){
                    defaultBreakCount = Integer.parseInt(line.substring(18));
                }
                else if (line.startsWith("defaultSetLength=")){
                    defaultSetLength = Integer.parseInt(line.substring(17));
                }
                else if (line.startsWith("defaultIntro=")){
                    defaultIntro = Integer.parseInt((line.substring(13)));
                }
                else {
                    System.out.println("Line " + i + " not processed");
                }

            }
            System.out.println("Local configuration loaded");
        } catch (FileNotFoundException e) {
            PrintWriter out = null;
            e.printStackTrace();
            if (OS.startsWith("Windows")){
                System.out.println("Creating directory");
                new File(System.getProperty("user.home") + "\\AppData\\Roaming\\SetlistManager").mkdirs();

            }
            else if (OS.startsWith("Linux")){
                new File(  System.getProperty("user.home")+"/.config/SetlistManager").mkdirs();
            }

            return;
        }

    }

    public void writeConfig(){
        String file;
        if(OS.startsWith("Windows")){
            file = System.getProperty("user.home") + "\\AppData\\Roaming\\SetlistManager\\settings.cfg";
        }
        else if (OS.startsWith("Linux")){
            file = System.getProperty("user.home") + "/.config/SetlistManager/settings.cfg";
        }
        else {
            file = System.getProperty("user.dir") + "/.settings.cfg";
        }

        System.out.println("configwriter: " + file);
        PrintWriter out = null;
        try {
            out =  new PrintWriter(new FileWriter(file, false));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (out != null){
            out.println("lastCatalog=" + lastCatalog);
            out.println("defaultBreakLength=" + defaultBreakLength);
            out.println("defaultBreakCount="+ defaultBreakCount);
            out.println("defaultSetLength=" + defaultSetLength);
            out.println("defaultIntro=" + defaultIntro);
            out.close();
        }

    }
    public String toString(){
        return "lastCatalog='" + lastCatalog + '\'' +
                ", defaultBreakLength='" + defaultBreakLength + '\'' +
                ", defaultBreakCount='" + defaultBreakCount + '\'' +
                ", defaultSetLength='" + defaultSetLength + '\'' +
                ", defaultIntro='" + defaultIntro + '\'';
        //return ret;
    }
}