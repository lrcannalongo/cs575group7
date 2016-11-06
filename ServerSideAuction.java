import java.util.*;
/**
 * Write a description of class ServerSideAuction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ServerSideAuction extends ConcreteAuction implements Observable
{
    LinkedList<Bid> bidHistory; //userid and bid
    Collection<Observer> auctionWatchers;
    int highBidder; //userid of high bidder

    /**
     */
    public ServerSideAuction()
    {
    }
    
    public void notifyObservers()
    {
        // take some actions to notify observes of a change
    }
    
    public void notifyObservers(Object obj)
    {}
    
    public void addObserver(Observer o)
    {
    }
    
    public void deleteObserver(Observer o)
    {}
    
    public void deleteObservers()
    {}
    
    public void setChanged()
    {}
    
    public void clearChanged()
    {}
    
    public boolean hasChanged()
    {return true;}
    
    public int countObservers()
    {return 0;}
    
    /*
     * returns true if placed bid is new high bid
     */
    public boolean placeBid(int userid, long bidPrice)
    {
        //function not complete
        
        if (bidPrice > currentPrice)
        {
            highBidder = userid;
            currentPrice = bidPrice;
            bidHistory.add(new Bid(userid, bidPrice));
            return true;
        }
        
        return false;
    }
    
    private class Bid
    {
        int userid;
        long bid;
     
     protected Bid(int userid, long price)
     {
         this.userid = userid;
         this.bid = price;
     }
    }
}
