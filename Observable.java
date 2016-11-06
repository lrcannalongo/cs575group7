import java.util.*;
/**
 * Write a description of interface Observable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Observable
{
    void notifyObservers();

    
    void notifyObservers(Object obj);

    
    public void addObserver(Observer o);
    
    
    public void deleteObserver(Observer o);

    
    void deleteObservers();

    
    void setChanged();

    
    void clearChanged();

    
    boolean hasChanged();

    
    public int countObservers();

}
