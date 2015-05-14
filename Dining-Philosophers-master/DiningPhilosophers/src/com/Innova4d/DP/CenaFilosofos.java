package com.Innova4d.DP;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * El problema de los filósofos (Esta versión causa un Deadlock).
 * @author Raúl Tostado Blázquez
 * @version 1.1
 */
public class CenaFilosofos {
	// El número de filósofos...
	private static final int NUM_FILOSOFOS = 5; //Se cambia a 5 para que corresponda al arreglo de filósofos
	
	/**
	 * Una prueba de los filósofos.
	 * @param args Not used
	 */
	public static void main (String[] args) {
		/*
		 *  Cada tenedor es un recurso compartido.
		 *  Los recursos compartidos en Java se definen como tipo Lock.
		 */
		ReentrantLock tenedores[]; //Se definen los tenedores para que puedan ser utilizados
        //Se usa un ReentrantLock porque no es necesario usar una estructura de bloque por bloque

		tenedores = new ReentrantLock[NUM_FILOSOFOS];// Se definio el tipo de los tenedores
		for (int i = 0; i < NUM_FILOSOFOS; i++) {
			tenedores[i] = new ReentrantLock();
            Filosofo filosofo = new Filosofo(i, tenedores[0], tenedores[(0+1)%NUM_FILOSOFOS]);
            new Thread(filosofo).start();
		}
		/*
		 *  Crear un arreglo de filósofos [5] 
		 *  En cada posición del arreglo, crear un filósofo
		 *  Inicializar el Thread para cada filósofo.
		 *   
		 *  En el siguiente ejemplo se implementa un código para inicializar un Thread con un filósofo, 
		 *  realiza el código para inicializar 5 ó más filósofos.
		 *  Checar la variable NUM_FILOSOFOS.
		 */
		Filosofo filosofo = new Filosofo(0, tenedores[0], tenedores[(0+1)%NUM_FILOSOFOS]);
		new Thread(filosofo).start();
        Filosofo filosofo1 = new Filosofo(1, tenedores[1], tenedores[(1+1)%NUM_FILOSOFOS]);
        new Thread(filosofo1).start();
        Filosofo filosofo2 = new Filosofo(2, tenedores[2], tenedores[(2+1)%NUM_FILOSOFOS]);
        new Thread(filosofo2).start();
        Filosofo filosofo3 = new Filosofo(3, tenedores[3], tenedores[(3+1)%NUM_FILOSOFOS]);
        new Thread(filosofo3).start();
        Filosofo filosofo4 = new Filosofo(4, tenedores[4], tenedores[(4+1)%NUM_FILOSOFOS]);
        new Thread(filosofo4).start();


	}

}