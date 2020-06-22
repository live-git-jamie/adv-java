package Lab5;

public class ThreadDriver{
	public static void main(String[] args) {
		EvenThread evenThread = new EvenThread();
		//OddThread oddThread = new OddThread();
		evenThread.start();
		//oddThread.start();
	}
}

/* Prints even #'s 2 - 10 */
class EvenThread extends Thread{
	@Override
	public void run() {
		OddThread oddThread = new OddThread();
		oddThread.start();
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Something went wrong");
		}
		for(int i = 2; i <= 10; i+=2) {
			System.out.println(i);
		}
	}
}

/* Prints odd #'s 1 - 9 */
class OddThread extends Thread {
	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Something went wrong");
		}
		for (int i = 1; i <=9 ; i+=2) {
			System.out.println(i);
		}
	}
}
