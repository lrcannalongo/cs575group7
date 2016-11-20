package dragonbids.structures.listings.ListingHandlers;


/**
 */
public interface ListingHandler
{
    public abstract boolean modifyDesc(String newDesc);
    public abstract boolean modifyTitle(String newTitle);
    public abstract boolean extendListing(long minutes);
    public abstract boolean modifyPhoto(Object photo);
}

