package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCarro;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idCarro=0 ; idCarro<10 ; idCarro++) { //lança 10 carros
			Thread tCarro = new ThreadCarro(idCarro, semaforo);
			tCarro.start();
		}
		
	}

}
