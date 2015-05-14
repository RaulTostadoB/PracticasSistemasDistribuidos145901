package com.server;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.lang.StringBuilder;

/**
 * @author   Raúl Tostado Blázquez
 * @version  0.2
 * @since    2015-03-04
 */
public class RMIServer {
	
	public static final String RMI_ID = "TestRMI";
	/**
	 * Define el puerto en donde se encuentra el servidor.
	 */
	public static final int RMI_PORT = 8080;//Puerto con el que se trabaja
	
	/**
	 * 
	 * @param args
	 * @throws AccessException
	 * @throws RemoteException
	 * @throws AlreadyBoundException
	 */
	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException {
				
		ServerDefinition impl = new ServerDefinition();
		Registry registry = LocateRegistry.createRegistry(RMI_PORT);
		registry.bind(RMI_ID, impl);
		
		System.out.println("Server is running...");
	}//Pones en marcha el servidor
}
