package view;

//Apenas para fins de teste do GitHub

import java.util.concurrent.Semaphore;

import controller.CarParkThread;

public class CarPark {
	
	public static Semaphore semaforo;
	
	public static void main(String[] args) {
		
		int totalCarros = 10;
		int maxCarros = 3;
		semaforo = new Semaphore(maxCarros);
		for(int i=0; i<totalCarros; i++) {
			Thread estacionamento = new CarParkThread(i, semaforo);
			estacionamento.start();
		}
	}

}
