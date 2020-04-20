package setlist;

/**
 * Catalog view class that creates a randomized list of all the songs in the Catalog
 */
public class RandomView implements CatalogView{
    Catalog randomCatalog;

    /**
     * Shuffles the catalog view to a random order
     * @param catalog Source Catalog to be shuffled
     */
    @Override
    public void Sort(Catalog catalog) {
        randomCatalog = catalog.duplicate();
        randomCatalog.Shuffle();
    }

    /**
     * A means to interface with this view
     * @return the randomized catalog
     */
    @Override
    public Catalog getList() {
        return randomCatalog;
    }
}
