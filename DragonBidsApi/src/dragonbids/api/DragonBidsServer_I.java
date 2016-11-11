package dragonbids.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DragonBidsServer_I extends Remote {
	
	public int createAuction() throws RemoteException;

}
