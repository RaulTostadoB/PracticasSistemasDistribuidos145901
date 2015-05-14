package com.Innova4D.Client;

/**
 * @author   Raúl Tostado Blázquez 145901
 * @version  0.2
 * @since    2015-03-13
 *
 */
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.Innova4D.Interface.*;

public class ClientLauncher {
	
	public static void main(String[] args) throws RemoteException, NotBoundException {
		/*
		 * Iniciar el cliente de la interfaz gráfica.
		 */
		ClientLauncher.guiClient();
		/*
		 * Iniciar el cliente para mandar un avión...
		 */
		ClientLauncher.avionClient();
		/*
		 * Iniciar el cliente para mandar un auto...
		 */
		ClientLauncher.autoClient();

        ClientLauncher.UFOClient();

        ClientLauncher.BoeingClient();
	}
	/**
	 * Se crea un cliente que administra el avión.
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	private static void avionClient () throws RemoteException, NotBoundException {
		/*
		 * Buscar el servidor en localhost, en puerto -> Constant.RMI_PORT.
		 */
		Registry registry = LocateRegistry.getRegistry("localhost", Constant.RMI_PORT);
		final RemoteInterface remote = (RemoteInterface) registry.lookup(Constant.RMI_ID);

		/*
		 * Crear una nave, con un ID y una Ubicación (0,0 default).
		 * El objeto es de tipo final para asegurar que la información no va a cambiar.
		 */
		final Avion a1 = new Avion("Lufthansa",0,0); //"L" Aparece en el mapa.
		remote.checkInAvion(a1);
		/*
		 * Temporizador que ejecuta movePlane cada 3 segundos.
		 * También se obtiene el espacio aéreo y se imprime.
		 */
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    remote.moverAvion(remote.getAvion(a1.getId(), 0), 0);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
	}
	/**
	 * Se crea un cliente que administra el auto.
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
    private static void BoeingClient () throws RemoteException, NotBoundException {
		/*
		 * Buscar el servidor en localhost, en puerto -> Constant.RMI_PORT.
		 */
        Registry registry = LocateRegistry.getRegistry("localhost", Constant.RMI_PORT);
        final RemoteInterface remote = (RemoteInterface) registry.lookup(Constant.RMI_ID);

		/*
		 * Crear una nave, con un ID y una Ubicación (0,0 default).
		 * El objeto es de tipo final para asegurar que la información no va a cambiar.
		 */
        final Boeing a1 = new Boeing("United",3,1); //"L" Aparece en el mapa.
        remote.checkInBoeing(a1);
		/*
		 * Temporizador que ejecuta movePlane cada 3 segundos.
		 * También se obtiene el espacio aéreo y se imprime.
		 */
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    remote.moverBoeing(remote.getBoeing(a1.getId(), 3), 3);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
    /**
     * Se crea un cliente que administra el auto.
     * @throws RemoteException
     * @throws NotBoundException
     */



	private static void autoClient () throws RemoteException, NotBoundException {
		/*
		 * Buscar el servidor en localhost, en puerto -> Constant.RMI_PORT.
		 */
		Registry registry = LocateRegistry.getRegistry("localhost", Constant.RMI_PORT);
		final RemoteInterface remote = (RemoteInterface) registry.lookup(Constant.RMI_ID);

		/*
		 * Crear un auto, con un ID y una Ubicación (1,0 default).
		 * El objeto es de tipo final para asegurar que la información no va a cambiar.
		 */
		final Auto a1 = new Auto("Servicio",1,0); // "S" Aparece en el mapa.
		remote.checkInAuto(a1);
		/*
		 * Temporizador que ejecuta moverAuto cada 2 segundos.
		 */
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
		  @Override
		  public void run() {
			try {
				remote.moverAuto(remote.getAuto(a1.getId(), 1), 1);
			} catch (Exception e) {
				//e.printStackTrace();
			}
		  }
		}, 0, 4, TimeUnit.SECONDS);
	}
	/**
	 * Cliente que imprime la GUI (Graphical user interface) de las pistas.
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */



    private static void UFOClient () throws RemoteException, NotBoundException {
		/*
		 * Buscar el servidor en localhost, en puerto -> Constant.RMI_PORT.
		 */
        Registry registry = LocateRegistry.getRegistry("localhost", Constant.RMI_PORT);
        final RemoteInterface remote = (RemoteInterface) registry.lookup(Constant.RMI_ID);

		/*
		 * Crear una nave, con un ID y una Ubicación (0,0 default).
		 * El objeto es de tipo final para asegurar que la información no va a cambiar.
		 */
        final UFO a1 = new UFO("Enterprise",2,0); //"E" Aparece en el mapa.
        remote.checkInUFO(a1);
		/*
		 * Temporizador que ejecuta movePlane cada 3 segundos.
		 * También se obtiene el espacio aéreo y se imprime.
		 */
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    remote.moverUFO(remote.getUFO(a1.getId(), 2), 2);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }, 0, 3, TimeUnit.SECONDS);
    }
    /**
     * Se crea un cliente que administra el UFO.
     * @throws RemoteException
     * @throws NotBoundException
     */
	private static void guiClient () throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", Constant.RMI_PORT);
		final RemoteInterface remote = (RemoteInterface) registry.lookup(Constant.RMI_ID);
		/*
		 * Obtiene la pista y se imprime.
		 */
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
		  @Override
		  public void run() {
			try {
				System.out.println(ClientLauncher.printPista(remote.getMapaPistas()));
			} catch (Exception e) {
				//e.printStackTrace();
			}
		  }
		}, 0, 1, TimeUnit.SECONDS);
	}
	/**
	 * Imprime en consola el espacio aéreo desde la
	 * torre de control (Servidor) en el Cliente.
	 * ** Método que implementa guiClient() **
	 * @param a Matriz que contiene el espacio aéreo a imprimir.
	 * @throws RemoteException
	 */
	private static String printPista(Object[][] a) throws RemoteException {
		Object o = null;
		String output = "=== Pista ===\n";
		for (int i = 0; i < 4; i++) {
		    for (int j = 0; j < 8; j++) {
		    	if(a[i][j] != null) {
		    		o = a[i][j];

                    if ((o.getClass().getSimpleName()).equals("Auto")){
                        output = output + "["+((Auto)o).getId().charAt(0)+"]";
                    }

                    if ((o.getClass().getSimpleName()).equals("Avion")){
                        output = output + "["+((Avion)o).getId().charAt(0)+"]";
                    }
                    if ((o.getClass().getSimpleName()).equals("UFO")){
                        output = output + "["+((UFO)o).getId().charAt(0)+"]";
                    }
                    if ((o.getClass().getSimpleName()).equals("Boeing")){
                        output = output + "["+((Boeing)o).getId().charAt(0)+"]";
                    }


		    	/*	switch (o.getClass().getSimpleName()) {
		    			case "Auto":  output = output + "["+((Auto)o).getId().charAt(0)+"]"; break;
		    			case "Avion": output = output + "["+((Avion)o).getId().charAt(0)+"]"; break;
		    		}
                 */   //////////////////////////////////////////////////////////////////////////////////////////
		    	} else { 
		    		output = output + "[ ]";
		    	}
		    }
		    if (i == 0 ) output = output + "<- Avión";
		    if (i == 1 ) output = output + "<- Auto ";
            if (i == 2 ) output = output + "<- UFO ";
            if (i == 3 ) output = output + "<- Boeing ";
		    output = output + "\n";	
		}
		return output = output + "\n";
	}
}
