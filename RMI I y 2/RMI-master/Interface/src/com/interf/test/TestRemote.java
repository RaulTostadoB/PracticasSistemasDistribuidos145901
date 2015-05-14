package com.interf.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author   Raúl Tostado Blázquez
 * @version  0.2
 * @since    2015-03-04
 * Modificado por Rául Tostado Blázquez
 */
public interface TestRemote extends Remote{

	/*
	 * En ésta interfaz se definen los métodos que deberá
	 * implementar el servidor.
	 *
	 * En caso de agregar métodos que reciban o envíen objetos
	 * Se debe tener encuenta el serializado de dicho objeto (Marshalling).
	 * Para éste ejemplo definimos un simple método test.
	 *
	 * @param test Un String a comparar, si es idéntico a la palabra "test".
	 *
	 * @return true en caso de que sea idéntico a "test".
	 */
	public Boolean test(String test) throws RemoteException;//COmparar dos Strings

    public Integer operation(int a, int b) throws RemoteException;// HAcer una multimplicación

    public Boolean palindromo(String test2) throws RemoteException; //Método para Leer el Palíndromo

     //public Integer primero(int a, int b) throws RemoteException;// HAcer una multimplicación
   // public Boolean segundo(String palindromo) throws RemoteException; //Método para Leer el Palíndromo

}

