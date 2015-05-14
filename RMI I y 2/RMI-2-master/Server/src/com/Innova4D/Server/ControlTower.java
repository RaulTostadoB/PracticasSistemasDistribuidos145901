package com.Innova4D.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.Innova4D.Interface.*;
/**
 * @author   Raúl Tostado Blázquez 145901
 * @version  0.2
 * @since    2015-03-13
 *
 */

public class ControlTower extends UnicastRemoteObject implements RemoteInterface {
	
	/*
	 * El constructor, protegido para asegurar la integridad de ControlTower.
	 * Protected: Accesible únicamente por ésta clase y sus subclases.
	 */
	protected ControlTower() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 }
	 */	
	private Object[][] mapaPista = new Object[4][8]; //Creamos la matriz con la cuál se trabajará

	private static final long serialVersionUID = 1L;

	/**
 	* Regresa el mapa de las pistas.
 	*/
	@Override
	public Object[][] getMapaPistas() throws RemoteException {
		return this.mapaPista;
	}
	
	/**
	 * Mueve un avión en la matriz, un bloque a la vez. Izq. Der.
	 */
	@Override
	public Boolean moverAvion(Avion a, int c) throws RemoteException {
		Boolean flag = false;
		int newY = a.getY() + 1;
		if (newY < 8) {
		try {
				this.mapaPista[c][a.getY()] = null;
				this.mapaPista[c][newY] = a;
				a.setX(0);
				a.setY(newY);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}
	
  /**
 	* Busca por un avión en el mapa aéreo usando su ID.
 	* @param id El identificador del objeto.
 	* @param c  El carril donde se encuentra el objeto.
 	*/
	@Override
	public Avion getAvion(String id, int c) throws RemoteException {
		Avion a = null;
		for (int i = 0; i < 8; i++) {
		    if(this.mapaPista[c][i] != null){
		    	a = (Avion) this.mapaPista[c][i];
		    	if(!a.getId().equals(id))
		    		a = null;
		    }
		}
		return a;
	}

	@Override
	public Boolean checkInAvion(Avion a) throws RemoteException {
		if(this.mapaPista[a.getX()][a.getY()] == null)
			this.mapaPista[a.getX()][a.getY()] = a;
		return true;
	}

	/*
	 * Aquí comienzan los métodos del Boeing
	 */


    /* Método con el cual vamos a mover al Boeing de izquierda a derecha */
    @Override
    public Boolean moverBoeing(Boeing a, int c) throws RemoteException {
        Boolean flag = false;
        int newY = a.getY() + 1;
        if (newY < 8) {
            try {
                this.mapaPista[c][a.getY()] = null;
                this.mapaPista[c][newY] = a;
                a.setX(0);
                a.setY(newY);
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * Busca por un Boeing en el mapa aéreo usando su ID.
     * @param id El identificador del objeto.
     * @param c  El carril donde se encuentra el objeto.
     */
    @Override
    public Boeing getBoeing(String id, int c) throws RemoteException {
        Boeing a = null;
        for (int i = 0; i < 8; i++) {
            if(this.mapaPista[c][i] != null){
                a = (Boeing) this.mapaPista[c][i];
                if(!a.getId().equals(id))
                    a = null;
            }
        }
        return a;
    }

    @Override
    public Boolean checkInBoeing(Boeing a) throws RemoteException {
        if(this.mapaPista[a.getX()][a.getY()] == null)
            this.mapaPista[a.getX()][a.getY()] = a;
        return true;
    }

    /*
     * Aquí comienzan los métodos del UFO.
     */
	@Override
	public Boolean checkInUFO(UFO a) throws RemoteException {
		if(this.mapaPista[a.getX()][a.getY()] == null)
			this.mapaPista[a.getX()][a.getY()] = a;
		return true;
	}
	@Override
	public UFO getUFO(String id, int c) throws RemoteException {
		UFO a = null;
		for (int i = 0; i < 8; i++) {
		    if(this.mapaPista[c][i] != null){
		    	a = (UFO) this.mapaPista[c][i];
		    	if(!a.getId().equals(id))
		    		a = null;
		    }
		}
		return a;
	}
    /* MOver de izquierda a derecha el UFO*/
	@Override
	public Boolean moverUFO(UFO a, int c) throws RemoteException {
		Boolean flag = false;
		int newY = a.getY() + 1;
		if (newY < 8) {
		try {
				this.mapaPista[c][a.getY()] = null;
				this.mapaPista[c][newY] = a;
				a.setX(0);
				a.setY(newY);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}

    public Boolean checkInAuto(Auto a) throws RemoteException {
        if(this.mapaPista[a.getX()][a.getY()] == null)
            this.mapaPista[a.getX()][a.getY()] = a;
        return true;
    }
    @Override
    public Auto getAuto(String id, int c) throws RemoteException {
        Auto a = null;
        for (int i = 0; i < 8; i++) {
            if(this.mapaPista[c][i] != null){
                a = (Auto) this.mapaPista[c][i];
                if(!a.getId().equals(id))
                    a = null;
            }
        }
        return a;
    }

    @Override
    public Boolean moverAuto(Auto a, int c) throws RemoteException {
        Boolean flag = false;
        int newY = a.getY() + 1;
        if (newY < 8) {
            try {
                this.mapaPista[c][a.getY()] = null;
                this.mapaPista[c][newY] = a;
                a.setX(0);
                a.setY(newY);
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }






}