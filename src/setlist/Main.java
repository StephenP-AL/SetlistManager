package setlist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Catalog example = new Catalog();
        FileIO open = new FileIO();
        open.openCatalog("D:\\Code\\IdeaProjects\\SetlistManager\\Example.setlist",example);
        for (Object i:example.reviewSongList()){
            System.out.println(i.toString());
        }
        /*
        System.out.println("Sorted by title:");
        TitleView sortedExampleA = new TitleView();
        sortedExampleA.Sort(example);
        example = sortedExampleA.getList();
        example.printList();
        System.out.println("\n\nRandomly shuffled once:");
        RandomView sortedExampleB = new RandomView();
        sortedExampleB.Sort(example);
        example = sortedExampleB.getList();
        example.printList();
        System.out.println("\n\nRandomly shuffled twice:");
        sortedExampleB.Sort(example);
        example = sortedExampleB.getList();
        example.printList();
        */

        /*
        Catalog example2 = example.duplicate();
        System.out.println("Shuffled: ");
        example2.Shuffle();
        example2.printList();
        System.out.println(test1.matchKey(test2));
        Song Clonetest = null;
        try {
            Clonetest = (Song)test1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        test1.setIntro(10);
        System.out.println(test1.toString());
        System.out.println(Clonetest.toString());
        */

    }
}

