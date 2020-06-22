package Lab3;

public class Trainer extends Thread {
	private int n = 7;
	
	public Trainer(String threadName) {
		super(threadName);
	}
	public Trainer(String threadName, int n) {
		super(threadName);
		this.n = n;
	}
	
	@Override
	public void run() {
		lecture();
	}
	
	public void lecture() {
		for(int i = 0; i < n; i++) {
			System.out.println(this.getName()+" lecturing.");	
		}
	}
}
