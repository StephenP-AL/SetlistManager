package setlist;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Team 3");

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
        int i = 135;
        test.setLength(i);
        System.out.println(i + " | " + test.getLength());
        System.out.println(test.getLengthMin() + ":" + test.getLengthSec());
    }
}
