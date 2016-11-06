import java.util.*;

/**
 */
public class Client implements Buyer, Seller
{   
    Collection<Auction> sellingAuctions;
    Collection<Auction> buyingAuctions;
    protected int userid;
    // Collection<Messages> mailbox = null; //NYI
    private AuctionSite serverSite;
    
    /**
     * Constructor for objects of class User
     */
    public Client()
    {

    }

    /**
     */
    public boolean createAuction()
    {
        /*
         * some code to create auction on server
         */
        
        // return AuctionSite.existsOnServer(auctionJustCreated); //return true if creation successful
        return false;
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
    
    
}
