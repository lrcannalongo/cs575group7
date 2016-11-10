import java.util.*;

/**
 */
public class User implements Buyer, Seller
{   
    Collection<Auction> sellingAuctions;
    Collection<Auction> buyingAuctions;
    protected int userid;
    // Collection<Messages> mailbox = null; //NYI
    private AuctionSite serverSite;
    
    /**
     * Constructor for objects of class User
     */
    public User()
    {

    }

    /**
     */
    public boolean createAuction()
    {
        return serverSite.addAuction("criteria");
    }
    
    public boolean cancelAuction(int idToCancel)
    {
        sellingAuctions.remove(idToCancel);
        return false;
    }
    
    public void modifyAuction(int idToModify, int componentToMod)
    {
       if (componentToMod == 0)
       {
           //aucToModify.modifyHeader(); // NYI
       }
    }
    
    
    public boolean sendMessage()
    {
        return true;
    }
    
    public boolean cancelBid(int auctionID)
    {
        return false;
    }
    
    public boolean placeBid(int auctionID, long bidPrice)
    {
        
        buyingAuctions.add(serverSite.getAuction(auctionID));  // if the bid is successful, add this auction to the collection of auctions this user is bidding on
        return true;
    }
    
    public Map<Integer, Auction> retrieveListings()
    {
        
        return serverSite.getAuctionList("criteria");
    }
}
