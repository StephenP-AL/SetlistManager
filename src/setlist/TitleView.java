package setlist;

/**
 * A view of the catalog that sorts the Catalog by song title
 */
public class TitleView {

    Catalog alphabeticalCatalog;

    /**
     * Parameterized constructor
     */
    public TitleView(Catalog catalog)
    {
        alphabeticalCatalog = catalog.duplicate();
        alphabeticalCatalog.sortTitle();
    }
}
