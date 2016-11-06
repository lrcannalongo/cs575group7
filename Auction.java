
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
    
    
    
    public Auction()
    {
    }
    
    public int remainingSeconds()
    {
        return currentTime - (startTime + duration);
    }
    
    public void notifyAuctionWatcher()
    {
    }
}
