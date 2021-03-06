package dragonbids.structures.listings.ListingHandlers;
import dragonbids.api.ListingSkeleton;

/**
 */
public interface ListingHandler
{
	public abstract boolean modify(ListingSkeleton skele);
    public abstract boolean modifyDesc(String newDesc); //candidate for deprecation
    public abstract boolean modifyTitle(String newTitle); //candidate for deprecation
    public abstract boolean extendListing(long minutes); //candidate for deprecation
    public abstract boolean modifyPhoto(Object photo); //candidate for deprecation
}

