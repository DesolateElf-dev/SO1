package view;

import controller.ThreadCalc;

public class Principal {

	public static void main(String[] args) {
		for(int idThread = 2; idThread <= 3; idThread++) {
			Thread t = new ThreadCalc(idThread);
			t.start();
		}

	}

}
