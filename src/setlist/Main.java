package setlist;

public class Main {

    public static void main(String[] args) {

        Catalog example = new Catalog();
        Song test1 = new Song("Dsong","Bcomposer","A min","Ska",190,100);
        Song test2 = new Song("Csong","Ecomposer","A Maj","Punk",190,130);
        Song test3 = new Song("Asong","Ccomposer","A min","Bluegrass",190,120);
        Song test4 = new Song("Esong","Acomposer","A min","Ragtime",190,120);
        Song test5 = new Song("Bsong","Dcomposer","A min","Baroque",190,120);
        example.addSong(test1);
        example.addSong(test2);
        example.addSong(test3);
        example.addSong(test4);
        example.addSong(test5);
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

