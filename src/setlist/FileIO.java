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

    public void exportPDF (Setlist source){
        //stub
    }

    public void exportSetlist(Setlist source, String file){
        if (file.endsWith(".txt")){
            exportTXT(source, file);
        }
        else if (file.endsWith(".setlist")){
            writeCatalog(source, file);
        }
        else if (file.endsWith(".html")){
            exportHTML(source, file);
        }
        else{
            file = file + ".html";
            exportHTML(source, file);
        }
    }

    private void exportTXT(Setlist source, String file){

        PrintWriter out = null;
        try {
            out =  new PrintWriter(new FileWriter(file, false));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (out != null) {
                out.println("Setlist     Total length: " + source.getLengthHour() + ":" + String.format("%02d", source.getLengthMinute()) + ":" + String.format("%02d", source.getLengthSecond()));
                out.println(source.getBreakCount() + " Breaks, " + source.getBreakLength() + " seconds each");
                out.printf("Genres: ");
                if (source.getGenreRestrict().isEmpty()){
                    out.printf(" All");
                }
                else {
                    for (String i : source.getGenreRestrict()) {
                        out.printf(i + "    ");
                    }
                }
                out.println("\n");
                for(Object i:source.reviewSongList()) {
                    if(((Song)i).getTempo() == -1){
                        out.println("\n   INTERMISSION             Length: " + ((Song) i).getLengthMin() + ":" + String.format("%02d", (((Song) i).getLengthSec())) );
                    }
                    else {
                        out.println("\n   " + ((Song) i).getTitle());
                        out.println("   By: " + ((Song) i).getComposer());
                        out.println("   Key:    " + ((Song) i).getKey() + "          Genre:" + ((Song) i).getGenre());
                        out.println("   Length: " + ((Song) i).getLengthMin() + ":" + String.format("%02d", (((Song) i).getLengthSec())) + "    Tempo:" + ((Song) i).getTempo() + "    Intro:" + ((Song) i).getIntro());
                    }
                }
                out.close();
            }
    }
    private void exportHTML(Setlist source, String file){
        PrintWriter out = null;
        try {
            out =  new PrintWriter(new FileWriter(file, false));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (out != null) {

            //Header information
            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "  <head>\n" +
                    "      <meta charset=\"utf-8\">\n" +
                    "      <title>Setlist</title>\n" +
                    "      <style>\n" +
                    "        body {font-family: Helvetica, Arial, Sans-Serif;letter-spacing: 1px;}\n" +
                    "        #header {\n" +
                    "          margin-top: 30px;\n" +
                    "          width: 600px;\n" +
                    "          display: grid;\n" +
                    "          grid-template-columns: repeat(2, 1fr);\n" +
                    "          grid-column-gap: 20px;\n" +
                    "          grid-row-gap: 0;\n" +
                    "          padding:3px;\n" +
                    "        }\n" +
                    "\n" +
                    "        #header > div {\n" +
                    "          height: 10px;\n" +
                    "          padding: 5px 0 5px 0;\n" +
                    "          }\n" +
                    "\n" +
                    "        .set {\n" +
                    "          grid-area: 1 / 1 / 2 / 2\n" +
                    "        }\n" +
                    "        .total {\n" +
                    "          grid-area: 1 / 2 / 2 / 3\n" +
                    "        }\n" +
                    "        .breaks {\n" +
                    "          grid-area: 2 / 1 / 2 / 3\n" +
                    "        }\n" +
                    "        .types {\n" +
                    "          grid-area: 3 / 1 / 4 / 3\n" +
                    "        }\n" +
                    "        .song {\n" +
                    "          margin-top: 30px;\n" +
                    "          width: 600px;\n" +
                    "          display: grid;\n" +
                    "          grid-template-columns: repeat(6, 1fr);\n" +
                    "          grid-column-gap: 20px;\n" +
                    "          grid-row-gap: 0;\n" +
                    "          padding:3px;\n" +
                    "          border: 1px solid black;\n" +
                    "          padding-left: 20px;\n" +
                    "          padding-bottom: 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .song > div {\n" +
                    "          padding: 10px 0 0 0;\n" +
                    "        }\n" +
                    "\n" +
                    "        .title {\n" +
                    "          font-size: 24px;\n" +
                    "          font-weight: 900;\n" +
                    "          margin-bottom: 10px;\n" +
                    "          overflow-wrap: break-word;\n" +
                    "          grid-area: 1 / 1 / 2 / 7;\n" +
                    "        }\n" +
                    "        .composer {\n" +
                    "          grid-area: 2 / 1 / 3 / 7;\n" +
                    "        }\n" +
                    "        .key {\n" +
                    "          grid-area: 3 / 1 / 4 / 4;\n" +
                    "        }\n" +
                    "        .genre {\n" +
                    "          grid-area: 3 / 4 / 4 / 7;\n" +
                    "        }\n" +
                    "        .length {\n" +
                    "          grid-area: 4 / 1 / 5 / 3\n" +
                    "        }\n" +
                    "        .tempo {\n" +
                    "          grid-area: 4 / 3 / 5 / 5\n" +
                    "        }\n" +
                    "        .intro {\n" +
                    "          grid-area: 4 / 5 / 5 / 7\n" +
                    "        }\n" +
                    "\n" +
                    "        .intermission {\n" +
                    "          margin-top: 30px;\n" +
                    "          width: 600px;\n" +
                    "          display: grid;\n" +
                    "          grid-template-columns: repeat(2, 1fr);\n" +
                    "          grid-row-gap: 0;\n" +
                    "          padding:3px;\n" +
                    "          font-size: 24px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .intermission > div {\n" +
                    "          height: 30px;\n" +
                    "          padding: 10px 0 0 0;\n" +
                    "          }\n" +
                    "\n" +
                    "      </style>\n" +
                    "  </head>\n" +
                    "\n" +
                    "  <body>\n" +
                    "\n" +
                    "    <div id=\"header\">\n" +
                    "      <div class=\"set\">Setlist</div>\n" +
                    "      <div class=\"total\">Total length:" +   source.getLengthHour() + ":" + String.format("%02d", source.getLengthMinute()) + ":" + String.format("%02d", source.getLengthSecond()) + "</div>\n" +
                    "      <div class=\"breaks\">" + source.getBreakCount() +  " breaks, " + (source.getBreakLength()/60) + ":" + String.format("%02d", (source.getBreakLength()%60)) + " each</div>");
                    out.printf("      <div class=\"types\">Genres: ");
                    if (source.getGenreRestrict().isEmpty()){
                        out.printf(" All");
                    }
                    else {
                        for (String i : source.getGenreRestrict()) {
                            out.printf(i + "    ");
                        }
                    }
                    out.printf("</div>\n" +
                    "    </div>");

                    for(Object i:source.reviewSongList()) {
                        if(((Song)i).getTempo() == -1){
                            out.println("<div class=\"intermission\">\n" +
                                            "      <div>INTERMISSION</div>\n" +
                                            "      <div>" +  ((Song) i).getLengthMin() + ":" + String.format("%02d", (((Song) i).getLengthSec())) + "</div>\n" +
                                            "    </div>");
                        }
                        else {
                            out.println(" <div class=\"song\">\n" +
                                    "      <div class=\"title\">"+  ((Song) i).getTitle() + "</div>\n" +
                                    "      <div class=\"composer\">By: "+ ((Song) i).getComposer() + "</div>\n" +
                                    "      <div class=\"key\">Key: " + ((Song) i).getKey() + "</div>\n" +
                                    "      <div class=\"genre\">Genre: " + ((Song)i).getGenre() + "</div>\n" +
                                    "      <div class=\"length\">Length: " + ((Song) i).getLengthMin() + ":" + String.format("%02d", (((Song) i).getLengthSec())) + "</div>\n" +
                                    "      <div class=\"tempo\">Tempo: " + ((Song)i).getTempo() + "</div>\n" +
                                    "      <div class=\"intro\">Intro: " + ((Song)i).getIntro() + "</div>\n" +
                                    "    </div>");
                        }
                    }
                    out.println("</body> </html>");
                    out.close();
        }
    }

}