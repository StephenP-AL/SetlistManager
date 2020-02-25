package setlist;

public class Main {

    public static void main(String[] args) {

        Catalog example = new Catalog();
        Song test1 = new Song("test6","ctest1","A min",190,120);
        Song test2 = new Song("test1","ctest1","A min",190,120);
        Song test3 = new Song("test3","ctest2","A min",190,120);
        Song test4 = new Song("test2","ctest2","A min",190,120);
        Song test5 = new Song("test5","ctest3","A min",190,120);
        example.addSong(test1);
        example.addSong(test2);
        example.addSong(test3);
        example.addSong(test4);
        example.addSong(test5);
        example.printList();
        example.sortTitle();
        System.out.println("Sorted:");
        example.printList();
        System.out.println("Shuffled: ");
        example.sortOrder();
        example.printList();
    }
}

