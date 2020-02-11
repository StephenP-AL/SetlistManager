package setlist;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Testing methods of Song class
        Song test = new Song();
        System.out.println(test.toString());
        //Title
        String temp = "This is a title. ";
        test.setTitle(temp);
        System.out.println(temp +  " | " + test.getTitle());
        //Composer
        temp = "This is a composer. ";
        test.setComposer(temp);
        System.out.println(temp +  " | " + test.getComposer());
        //Key
        temp = "A maj";
        test.setKey(temp);
        System.out.println(temp + " | " + test.getKey());
        //Archive
        System.out.println("Should be False: " + test.isArchive());
        test.setArchive(true);
        System.out.println("Should now be True: " + test.isArchive());
        test.toggleArchive();
        System.out.println("Should now be False: " + test.isArchive());
        test.toggleArchive();
        System.out.println("Should now be True: " + test.isArchive());
        //Length
        int i = 59;
        test.setLength(i);
        System.out.println(i + " | " + test.getLength());
        System.out.println(test.getLengthMin() + ":" + test.getLengthSec());
        i++;
        i++;
        test.setLength(i);
        System.out.println(i + " | " + test.getLength());
        System.out.println(test.getLengthMin() + ":" + test.getLengthSec());
        //Tempo
        test.setTempo(i++);
        System.out.println(test.getTempo());
        //Order
        test.setOrder(i++);
        System.out.println(test.getOrder());
        System.out.println(test.toString());
    }
}
