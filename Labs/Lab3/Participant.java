package Lab3;

public class Participant extends Thread {
	
	private int n = 30;
	
	public Participant(String threadName) {
		super(threadName);
	}
	public Participant(String threadName, int n) {
		super(threadName);
		this.n = n;
	}
	
	@Override
	public void run() {
		practice();
	}
	
	public void practice() {
		for(int i = 1; i < n; i ++) {
			System.out.println(this.getName()+" practicing...");	
		}
	}
}
