package DragonBidsServer.src.dragonbids.server;

import DragonBidsStructures.listings.*;
import DragonBidsStructures.listings.ListingHandlers.*;
import DragonBidsApi.src.dragonbids.api.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class DragonBidsServer implements DragonBidsServer_I {
	
	private Registry registry;
	private String dragonBidsServer = "DragonBids";

	@Override
	public int createAuction() {
		// TODO Auto-generated method stub
		//Would invoke auction factory to create an auction, and would return the auctionId
		System.out.println("DEBUG: Just Received Invocation of Method From Client: createAuction!");
		return 0;
	}
	
	public boolean bindServerToRegister(int port)
	{
		boolean bindSuccess = false;
        try {
        	DragonBidsServer obj = new DragonBidsServer();
        	DragonBidsServer_I stub = (DragonBidsServer_I) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            registry = LocateRegistry.getRegistry(port);
            registry.bind(dragonBidsServer, stub);
            System.out.println("DragonBids Server Online ...");
            bindSuccess = true;
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
            bindSuccess = false;
        }
        return bindSuccess;
	}
	
	public boolean unbindServerFromRegister()
	{
		boolean unbindSuccess = false;
		try {
			registry.unbind(dragonBidsServer);
			unbindSuccess = true;
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unbindSuccess;
	}
}