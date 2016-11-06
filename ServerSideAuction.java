import java.util.*;
/**
 * Write a description of class ServerSideAuction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ServerSideAuction extends ConcreteAuction
{
    Map<Integer, Bid> bidHistory; //userid and bid
    int highBidder; //userid of high bidder

    /**
     */
    public ServerSideAuction()
    {
    }
}
