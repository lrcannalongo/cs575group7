import java.util.*;
/**
 * Write a description of interface Buyer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Buyer
{
    public boolean cancelBid(int auctionID);
    
    public boolean placeBid(int auctionID, long bidPrice);
    
    public Map<Integer, Auction> retrieveListings(); //overload with various implementations in client class; strategy pattern
}
