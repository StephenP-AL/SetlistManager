package setlist;

/**
 * A view of the catalog that sorts the Catalog by song title
 */
public class TitleView implements CatalogView{

    Catalog alphabeticalCatalog;

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
