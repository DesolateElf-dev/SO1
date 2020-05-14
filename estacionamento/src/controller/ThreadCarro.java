package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	
	private int idCarro;
	private static int posicaoChegada;
	private static int posicaoSaida;
	private Semaphore semaforo;
	
	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		carroAndando();
		try { //tenta
			//------------------P (Acquire)-------------- ocupa espa�o no semaforo
			semaforo.acquire();
			carroEstacionado();
		} catch (InterruptedException e) { //se erro executa
			e.printStackTrace();
		} finally { //sempre executa
			//------------------V (Release)-------------- libera espa�o no semaforo
			semaforo.release();
		}
		carroSaindo();
	}
	
	private void carroAndando() {
		int distanciaTotal = (int)((Math.random() * 501) + 1500); // gera valor entre 1500 e 2000
		int distanciaPercorrida = 0;
		int deslocamento = 100;
		int tempo = 30;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento; //mesma coisa que distanciaPercorrida = distanciaPercorrida + deslocamento
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#"+idCarro+" andou "+ distanciaPercorrida+" m");
		}
		posicaoChegada++;
		System.out.println("#"+idCarro+" foi o "+posicaoChegada+"� a chegar");
		
	}
	
	private void carroEstacionado() { //cr�tica, pois s� 3 carros podem acessar ao mesmo tempo
		System.out.println("#"+idCarro+" estacionou");
		int tempo = (int)((Math.random() * 401) + 100); //tempo aleatorio que o carro ficar� parado
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void carroSaindo() {
		posicaoSaida++;
		System.out.println("#"+idCarro+" foi o "+posicaoSaida+"� a sair");
	}

}
