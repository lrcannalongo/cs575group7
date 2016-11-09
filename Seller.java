
/**
 * Write a description of interface Seller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Seller
{
    public boolean cancelAuction(int idToCancel);

    public void modifyAuction(int idToModify, int componentToMod);
    
    public boolean createAuction();
    
    
}
