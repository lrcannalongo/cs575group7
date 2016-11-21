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
    
    public boolean modify(Listing lst, ListingSkeleton skele)
    {
    	
    	// check each "modifiable" property and update it if it has changed
    	
    	
    	//check description, title for changes and update as necessary
    	if (!(lst.getDesc().equals(skele.auctionDescription)))
    	{
    		lst.setDesc(skele.auctionDescription);
    	}
    	
    	if (!lst.getTitle().equals(skele.auctionTile))
    	{
    		lst.setTitle(skele.auctionTile);
    	}
    			
    	return false;
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