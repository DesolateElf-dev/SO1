package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {
	
	private int idCarro;
	private static int posicaoChegada;
	private Semaphore semaforo;
	
	public ThreadCruzamento(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		carroAndando();	
		try {
			semaforo.acquire();
			carroCruzando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		System.out.println("O carro #"+idCarro+" saiu do cruzamento");
	}
	
	
	private void carroAndando() { //simulado o carro chegando no cruzamento
		int distanciaTotal = (int)((Math.random()*501)+2000); // gera uma distância aleatória que o carro está do cruzamento, entre 2000 e 2500m
		int distanciaPercorrida = 0;
		int deslocamento = 100; //deslocamento em metros
		int tempo = 30; //tempo em segundos
		//velocidade = deslocamento/tempo -> 100m/30s
		while(distanciaPercorrida<distanciaTotal) {// carro percorrendo a distanciaTotal
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro #"+idCarro+" andou "+distanciaPercorrida+"m");
		}
		posicaoChegada++;
		System.out.println("O carro #"+idCarro+" foi o "+posicaoChegada+"º a chegar ao cruzamento");
		
	}
	
	private void carroCruzando() { //crítica pois só pode cruzar 1 carro de cada vez
		System.out.println("O carro #"+idCarro+" está cruzando");
		int tempo = 5; //tempo para cruzar o cruzamento em segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
