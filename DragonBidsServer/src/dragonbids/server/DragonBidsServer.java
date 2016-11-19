package dragonbids.server;

import dragonbids.api.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Vector;

public class DragonBidsServer implements DragonBidsServer_I {
	
	private Registry registry;
	private String dragonBidsServer = "DragonBids";
	private Vector<User> activeUsers = new Vector<User>(); //Vector of User Classes Held by the server

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
	
	@Override
	public boolean createUser(String username) throws RemoteException {
		// TODO Auto-generated method stub
		Iterator<User> it = activeUsers.iterator();
		while(it.hasNext())
		{
			if (it.next().getUsername().equals(username.toString())) // We found the user already, so Let Client Login
			{
				System.out.println("User " + username + ", has connected to server ...");
				return false;
			}
		}

		try {
			activeUsers.add(new User(username)); // Create new user, and add to our vector
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean createListing(ListingSkeleton arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector<ListingSkeleton> getListings() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getUsers() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyListing(ListingSkeleton arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean placeBid(ListingSkeleton arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remoteListing(int arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}