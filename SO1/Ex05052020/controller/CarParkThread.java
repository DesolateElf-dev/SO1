package controller;

import java.util.concurrent.Semaphore;

public class CarParkThread extends Thread{
	
	private int numCarro;
	private Semaphore semaforo;
	
	public CarParkThread(int numCarro, Semaphore semaforo) {
		this.numCarro = numCarro;
		this.semaforo = semaforo;
	}
	
	
	public void run() {
		try {
			semaforo.acquire();
			entraCarro();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
		
	}
	
	public void entraCarro() {
		System.out.println("O carro "+numCarro+" entrou");
		ficaCarro();
		saiCarro();
	}
	
	public void ficaCarro() {
		int tempoEspera = (int) ((Math.random()+1)*5000);
		try {
			Thread.sleep(tempoEspera);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void saiCarro() {
		System.out.println("O carro "+numCarro+" saiu");
	}

}
