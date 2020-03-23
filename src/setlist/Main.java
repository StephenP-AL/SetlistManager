package setlist;

public class Main {

    public static void main(String[] args) {


        MainGUI.createAndShowGUI();

//         Catalog example = new Catalog();
//         FileIO open = new FileIO();
//         open.openCatalog("D:\\Code\\IdeaProjects\\SetlistManager\\Example.setlist",example);
//         /*for (Object i:example.reviewSongList()){
//             System.out.println(i.toString());
//         }
//         System.out.println(example.reviewSongList().size());
//         TitleView sortedExampleA = new TitleView();
//         sortedExampleA.Sort(example);*/

//         RandomView random = new RandomView();
//         random.Sort(example);
//         //for (Object i:random.getList().reviewSongList()){
//             //System.out.println(i.toString());
//         //}

//         System.out.println();
//         System.out.println("Testing Setlist");

//         Setlist set = new Setlist(2000,2,60);
//         set.Populate(random);
//         set.printList();

//         }


//        open.writeCatalog(sortedExampleA.getList(),"D:\\Code\\out.setlist");
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

//        Catalog example = new Catalog();
//        FileIO open = new FileIO();
//        open.openCatalog("D:\\Code\\IdeaProjects\\SetlistManager\\Example.setlist",example);
//        /*for (Object i:example.reviewSongList()){
//            System.out.println(i.toString());
//        }
//        System.out.println(example.reviewSongList().size());
//        TitleView sortedExampleA = new TitleView();
//        sortedExampleA.Sort(example);*/
//
//        RandomView random = new RandomView();
//        random.Sort(example);
//        //for (Object i:random.getList().reviewSongList()){
//            //System.out.println(i.toString());
//        //}
//
//        System.out.println("");
//        System.out.println("Testing SongSelector");
//        SongSelector select = new SongSelector(random);
//
//        Song temp = new Song("a","b","c","g",1,1);
//        int i = 0;
//        while (true){
//            temp = select.nextSong(i);
//            if (temp != null){
//
//                i++;
//                System.out.println(temp.toString());
//            }
//            else{
//                break;
//            }
//        }
//
//
//
//
////        open.writeCatalog(sortedExampleA.getList(),"D:\\Code\\out.setlist");
///*
//        System.out.println("Sorted by title:");
//        TitleView sortedExampleA = new TitleView();
//        sortedExampleA.Sort(example);
//        example = sortedExampleA.getList();
//        example.printList();
//        System.out.println("\n\nRandomly shuffled once:");
//        RandomView sortedExampleB = new RandomView();
//        sortedExampleB.Sort(example);
//        example = sortedExampleB.getList();
//        example.printList();
//        System.out.println("\n\nRandomly shuffled twice:");
//        sortedExampleB.Sort(example);
//        example = sortedExampleB.getList();
//        example.printList();
//        */
//
//        /*
//        Catalog example2 = example.duplicate();
//        System.out.println("Shuffled: ");
//        example2.Shuffle();
//        example2.printList();
//        System.out.println(test1.matchKey(test2));
//        Song Clonetest = null;
//        try {
//            Clonetest = (Song)test1.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        test1.setIntro(10);
//        System.out.println(test1.toString());
//        System.out.println(Clonetest.toString());
//        */

    }
}


