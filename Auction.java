
/**
 * Abstract class Auction - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Auction
{
    double currentPrice;
    double reservePrice; //implies that seller can accept ending price that is less than reserve
    String description;
    int startTime;
    int duration;
    int auctionUID; 
    
    
    
    public Auction()
    {
    }
    
    
    
    public long remainingSeconds()
    {
        return System.currentTimeMillis() - (startTime + duration);
    }
    
    public int generateID()
    {
        return 5;
    }
}
