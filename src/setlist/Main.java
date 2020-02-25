package setlist;


import java.util.ArrayList;
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
*/
        Catalog example = new Catalog();
        Song test1 = new Song("test6","ctest1","A min",190,120);
        Song test2 = new Song("test1","ctest1","A min",190,120);
        Song test3 = new Song("test3","ctest2","A min",190,120);
        Song test4 = new Song("test2","ctest2","A min",190,120);
        Song test5 = new Song("test5","ctest3","A min",190,120);
       // System.out.println(test1.toString());
        //ArrayList<Song> blerg = new ArrayList<>();
        //blerg.add(test1);
        example.addSong(test1);
        example.addSong(test2);
        example.addSong(test3);
        example.addSong(test4);
        example.addSong(test5);
        example.printList();
        example.sortTitle();
        System.out.println("Sorted:");
        example.printList();

    }
}

