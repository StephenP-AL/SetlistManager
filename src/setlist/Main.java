package setlist;


import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        /*
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
        System.out.println("Length: " + i + " | " + test.getLength());
        System.out.println("Length separated: " +test.getLengthMin() + ":" + test.getLengthSec());
        i++;
        i++;
        test.setLength(i);
        System.out.println("Length: " + i + " | " + test.getLength());
        System.out.println("Length separated: " + test.getLengthMin() + ":" + test.getLengthSec());
        //Intro
        test.setIntro(i);
        System.out.println("Intro: " + i + " | " + test.getIntro());
        //Tempo
        test.setTempo(++i);
        System.out.println("Tempo: " + i + " | " + test.getTempo());
        //Order
        test.setOrder(++i);
        System.out.println("Order: " + i + " | " + test.getOrder());
        //Random
        test.setOrderRandom();
        System.out.println("Order randomized: " + test.getOrder());
        System.out.println(test.toString());
*/
        //Song comparison
        Song a = new Song();
        a.setComposer("The cars");
        a.setTitle("a song");
        a.setOrder(2);
        Song b = new Song();
        b.setComposer("The Cars");
        b.setTitle("A song");
        b.setOrder(2);
        System.out.println("Comparison: " + a.compareTo(b));

        Comparator<Song> comp = new SongComparatorByOrder();
        System.out.println("Order: " + comp.compare(a,b));

    }
}
