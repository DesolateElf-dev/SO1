package view;
//Exercício pág.37 arquivo 05_-_Semaforos.pdf

import java.util.concurrent.Semaphore;
import controller.ThreadCruzamento;

public class Principal {
	
	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for(int idCarro=0 ; idCarro<=3 ; idCarro++) { //inicia os 4 carros
			Thread tCruzamento = new ThreadCruzamento(idCarro, semaforo);
			tCruzamento.start();
		}

	}

}