package setlist;

public class Main {

    public static void main(String[] args) {

        Catalog example = new Catalog();
        Song test1 = new Song("test6","ctest1","A min","Ska",190,100);
        Song test2 = new Song("test1","ctest1","A Maj","Punk",190,130);
        Song test3 = new Song("test3","ctest2","A min","Bluegrass",190,120);
        Song test4 = new Song("test2","ctest2","A min","Ragtime",190,120);
        Song test5 = new Song("test5","ctest3","A min","Baroque",190,120);
        example.addSong(test1);
        example.addSong(test2);
        example.addSong(test3);
        example.addSong(test4);
        example.addSong(test5);
        example.sortTitle();
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


    }
}

