package com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.lang.StringBuilder;

import com.interf.test.TestRemote;

/**
 * @author   Raúl Tostado Blázquez
 * @version  0.2
 * @since    2015-03-04
 * Modificado por Raúl Tostado Blázquez I.D. 145901
 */
public class ServerDefinition extends UnicastRemoteObject implements TestRemote {

	/**
	 * Identificador único de la serialización (Default).
	 */
	private static final long serialVersionUID = 1L;

	protected ServerDefinition() throws RemoteException {
		super();
	}

	@Override
    // Se compara un nuevo String con el String test para saber si son iguales
	public Boolean test(String test) throws RemoteException {
		if(test.equalsIgnoreCase("test")) return true;
		return false;
	}// Fin método Test

    //Método con el cual vamos a realizar una multiplicación
    public Integer operation(int a, int b) throws RemoteException{
        Integer Resultado;
        Resultado = a * b;
        return Resultado;
    } //FIn método operation

    //Método para saber si una frase es un palíndromo
    public Boolean palindromo(String test2) throws RemoteException {
        String prueba, palabrasinespacios; //Strings con los que se trabaja
        palabrasinespacios =test2.replace(" ","");//Elimina los espacios del String y se asigna a una nueva variable
        System.out.println(palabrasinespacios);
        prueba = new StringBuilder(palabrasinespacios).reverse().toString();//La palabra se escribe en sentido opuesto
        System.out.println(prueba);

        if(prueba.equals(palabrasinespacios)){ //Inicia if
            System.out.println("La frase es un aplindromo");
            return true;
            }//Fin if
        else
        System.out.println("La frase no es un palíndromo");
        return false;
    }//FIn método palíndromo

}//Fin class ServerDefinition
