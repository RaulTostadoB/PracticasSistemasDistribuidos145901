package com.Innova4D.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author   Raúl Tostado Blázquez 145901
 * @version  0.2
 * @since    2015-03-13
 *
 */

public interface RemoteInterface extends Remote {
	
	/*
	 * Aquí se definen los métodos a implementarse en el servidor.
	 */
	public Object[][] getMapaPistas()  throws RemoteException;
	
	/*
	 * Métodos para el Avion.
	 */
    /**
     * Registra al avion en la pista.
     * @param a el avion que se desea hacer checkIn.
     * @return
     * @throws RemoteException
     */
	public Boolean checkInAvion(Avion a)      throws RemoteException;
	public Avion   getAvion(String id, int c) throws RemoteException;
	public Boolean moverAvion(Avion a, int c) throws RemoteException;
	
	/*
	 * Métodos para el auto.
	 */
	/**
	 * Registra al auto en la pista.
	 * @param a el auto que se desea hacer checkIn.
	 * @return
	 * @throws RemoteException
	 */
	public Boolean checkInAuto(Auto a)       throws RemoteException;
	public Auto    getAuto(String id, int c) throws RemoteException;
	public Boolean moverAuto(Auto a, int c)  throws RemoteException;

    /*
	 * Métodos para el Boeing.
	 */
    /**
     * Registra al Boeing en la pista.
     * @param a el Boeing que se desea hacer checkIn.
     * @return
     * @throws RemoteException
     */

    public Boolean checkInBoeing(Boeing a)       throws RemoteException;
    public Boeing    getBoeing(String id, int c) throws RemoteException;
    public Boolean moverBoeing(Boeing a, int c)  throws RemoteException;

    /*
	 * Métodos para el UFO.
	 */
    /**
     * Registra al UFO en la pista.
     * @param a el UFO que se desea hacer checkIn.
     * @return
     * @throws RemoteException
     */


    public Boolean checkInUFO(UFO a)       throws RemoteException;
    public UFO    getUFO(String id, int c) throws RemoteException;
    public Boolean moverUFO(UFO a, int c)  throws RemoteException;
} //FIn de la clase RemoteInterface
