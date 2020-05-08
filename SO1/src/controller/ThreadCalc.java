package controller;

public class ThreadCalc extends Thread {

	private static double res;
	private int idThread;
	
	public ThreadCalc(int idThread) {
		this.idThread = idThread;
		
	}
	@Override
	public void run() {
		op();
	}
	
	private void op() {
		res = 1;
		if (idThread % 2 == 0) {
			for (double i=1; i<10; i++) {
				res = res*i;
				System.out.println(res);
			}
		}
		else {
			for (double i =1; i<10; i++) {
				res = res/i;
				System.out.println(res);
			}
		}

	}

}
