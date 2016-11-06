
/**
 */
public interface Client
{   
    Collection sellingAuctions;
    Collection buyingAuctions;
    int userid;
    Collection<Messages> mailbox;
    
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
        
        return AuctionSite.existsOnServer(auctionJustCreated);
    }
    
    public boolean cancelAuction(Auction aucToCancel)
    {
        auctions.remove(aucToCancel);
    }
    
    public void modifyAuction(Auction aucToModify, int componentToMod)
    {
       if (componentToMod == 0)
       {
           aucToModify.modifyHeader();
       }
    }
    
    
    public boolean sendMessage()
    {
    }
    
    
}
