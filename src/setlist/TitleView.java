package setlist;

/**
 * A view of the catalog that sorts the Catalog by song title
 */
public class TitleView implements CatalogView{

    Catalog alphabeticalCatalog;

    /**
     * @param catalog Catalog to be sorted
     */
    @Override
    public void Sort(Catalog catalog) {
        alphabeticalCatalog = catalog.duplicate();
        alphabeticalCatalog.sortTitle();
    }

    @Override
    public Catalog getList() {
        return alphabeticalCatalog;
    }
}
