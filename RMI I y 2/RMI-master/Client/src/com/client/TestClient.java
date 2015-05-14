package com.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.interf.test.TestRemote;

/**
 * @author   Raúl Tostado Blázquez
 * @version  0.2
 * @since    2015-03-04
 * Modificado por Raúl Tostado Blázquez I.D. 145901
 */
public class TestClient {

	public static final String RMI_ID = "TestRMI";
	/**
	 * Define el puerto en donde se encuentra el servidor.
	 */
	public static final int RMI_PORT = 8080;

	public static void main(String[] args) throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry("localhost", RMI_PORT);//Direccion a donde se conecta el cliente
       //Registry registry = LocateRegistry.getRegistry("192.168.56.1", RMI_PORT);


		TestRemote remote = (TestRemote) registry.lookup(RMI_ID);
		System.out.println(remote.test("123"));
		System.out.println(remote.test("test"));
        System.out.println("EL resultado de su multiplicacion es "+remote.operation(44,112));//Numeros amultiplicar
        System.out.println("El resultado de comparar su palíndromo es "+ remote.palindromo("anita lava la tina"));
        System.out.println("El resultado de comparar su palíndromo 2 es "+ remote.palindromo("hoy es un buen dia"));
        //Palíndromo a verificar


	}

}
