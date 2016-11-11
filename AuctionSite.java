import java.util.*;

/**
 * Write a description of class AuctionSite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AuctionSite
{
    List<User> users;
    Map<Integer, Auction> activeListings;

    /**
     * Constructor for objects of class AuctionSite
     */
    public AuctionSite()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public User newUser()
    {
        return new User();
    }
    
    Auction getAuction(int auctionID)
    {
        return activeListings.get(auctionID);
    }
    
    Map<Integer, Auction> getAuctionList(String criteria)
    {
        return new HashMap<Integer, Auction>();
    }
    
    boolean addAuction(String criteria)
    {
        Auction a = new ServerSideAuction();
        int id = a.generateID();
        
        activeListings.put(id, a);
        
        if (activeListings.containsKey(id))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    boolean removeAuction(int auctionID)
    {
        try
        {
            activeListings.remove(auctionID); //incorrect implementation
        }
        finally
        {
            return activeListings.containsKey(auctionID);
        }
    }
    
    boolean placeBid(int userid, int auctionID, long bidPrice)
    {
        ServerSideAuction a = (ServerSideAuction) activeListings.get(auctionID);
        return a.placeBid(userid, bidPrice);
    }
}
