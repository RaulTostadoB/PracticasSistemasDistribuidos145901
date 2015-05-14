package com.Innova4d.DP;
import java.util.Random;
import java.util.concurrent.locks.Lock;
/**
 * La clase Filosofo que utiliza Runnable para poder ser implementada por un thread.
 * @author Raúl Tostado Blázquez
 * @version 1.1
 */
class Filosofo implements Runnable //Se implemento la clase Runnable para que funcionen los Threads
{
	// Tiempo en que come un filósofo
	private Random numGenerator = new Random();
	// El Id del filosofo
	private int id;

	/*
	 * En Java los recursos compartidos se definen como Locks.
	 */
	private Lock cubiertoIzquierdo; //Se define como tipo Lock -- comparten recursos
	private Lock cubiertoDerecho;  //Se define como tipo Lock-- comparten recursos

	/**
	 * El constructor del filósofto
	 * @param id el id del filósofo
	 * @param cubiertoIzquierdo cubierto izquierdo
	 * @param cubiertoDerecho cubierto derecho
	 */
	public Filosofo (int id, Lock cubiertoIzquierdo, Lock cubiertoDerecho) {
		this.id = id;
		this.cubiertoIzquierdo = cubiertoIzquierdo;
		this.cubiertoDerecho = cubiertoDerecho;
	}

	/**
	 * Ejecuta el thread, piensa, levanta cubiertos, come.
	 */
	public void run() {
		try {
			while (true) {
				piensa();
				levantaCubiertoIzquierdo();
				levantaCubiertoDerecho();
				come();
				bajaCubiertos();
			}
		} catch (InterruptedException e) {
			System.out.println("El Filósofo " + id + " fue interrumpido.\n");			
		}
	}

	/** 
	 * El filósofo está pensando
	 */
	private void piensa() throws InterruptedException {
		System.out.println("El Filósofo " + id + " está pensando.\n");
        Thread.sleep (numGenerator.nextInt(7));
		/*
		 * Cuando el filósofo está pensando debemos "dormir el hilo por un tiempo aleatorio"
		 * Se puede ir modificando los tiempos para que trabaje de una manera más rápida
		 */
	}

	/** 
	 * El filósofo ocupa el cubierto (Recurso compartido)por eso usa Lock
	 */
	private void levantaCubiertoIzquierdo() {
		cubiertoIzquierdo.lock();
		System.out.println("El filósofo " + id + " tiene en la mano un cubierto.\n");
	}

	/** 
	 * El filósofo ocupa el cubierto (Recurso compartido)
	 */
	private void levantaCubiertoDerecho() {
        cubiertoDerecho.lock();
        System.out.println("EL filósofo" + id + " tiene en la mano un cubierto.\n");
	}

	/**
	 * El filósofo come...
	 * @throws InterruptedException
	 */
	private void come() throws InterruptedException {
		System.out.println("El filósofo " + id + " está comiendo.\n");
		Thread.sleep (numGenerator.nextInt(10));
	}

	/**
	 * El filósofo baja los cubiertos
	 */
	private void bajaCubiertos() {

        cubiertoDerecho.unlock();
        cubiertoIzquierdo.unlock();
	}
}