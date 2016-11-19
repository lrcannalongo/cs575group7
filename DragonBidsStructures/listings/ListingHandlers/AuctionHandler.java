package DragonBidsStructures.listings.ListingHandlers;
import DragonBidsStructures.listings.*;



/**
 */
public class AuctionHandler implements ListingHandler

{
    Auction auction;
    /**
     * Constructor for objects of class AuctionHandler
     */
    public AuctionHandler(Auction auction)
    {
        this.auction = auction;
    }
    
    public boolean placeBid(String userid, long newBid)
    {   
        if (newBid <= auction.getHighBid().getBidPrice())
        {
            //fail to bid
            return false;
        }
        else
        {
            auction.addBid(userid, newBid);
            return true;
        }
    }
        
    public boolean modifyDesc(String newDesc)
    {
        auction.setDesc(newDesc);
        return true;
    }
    
    public boolean modifyTitle(String newTitle)
    {
        auction.setTitle(newTitle);
        return true;
    }
    
    public boolean extendListing(long minutes)
    {
        auction.setExpiration(auction.getExpiration().plusMinutes(minutes));
        return true;
    }
    
    public boolean modifyPhoto(Object photo)
    {
        auction.setPhoto(photo);
        return true;
    }
}
