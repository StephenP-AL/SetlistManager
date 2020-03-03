package setlist;

/**
 * Catalog view class that creates a randomized list of all the songs in the Catalog
 */
public class RandomView {
    Catalog randomCatalog;

    /**
     * Parameterized constructor
     */
    public RandomView(Catalog catalog)
    {
        randomCatalog = catalog.duplicate();
        randomCatalog.Shuffle(); // Randomizes catalog
    }
}
