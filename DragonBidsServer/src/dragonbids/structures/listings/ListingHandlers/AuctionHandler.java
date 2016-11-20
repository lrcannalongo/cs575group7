package dragonbids.structures.listings.ListingHandlers;
import dragonbids.structures.listings.*;
import dragonbids.api.*;



/**
 */
public class AuctionHandler implements ListingHandler

{
    private Auction auction;
    
    public AuctionHandler(Auction auction)
    {
        this.auction = auction;
    }
    
    public boolean modify(ListingSkeleton skele)
    {
    	
    	//TODO modify duration
    	modifyTitle(skele.auctionTile);
    	modifyDesc(skele.auctionDescription);
    	
    	return true;
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
