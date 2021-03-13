package controller.interfaces;
import model.interfaces.Listable;
import view.ListingContainer;

public interface ListablePaneController {
    void init(Listable listing, ListingContainer parentContainer);
}
