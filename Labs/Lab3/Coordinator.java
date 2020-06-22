package Lab3;

/* As a trainer, I would like to have program
 *  from understanding multithreading.
 *  
 * Class Trainer, Participant, Coordinator
 * Coordinator (main thread)

 * ORDER joining: C, T, P
 * ORDER leaving: P, T, C
*/
public class Coordinator extends Thread{

	public static void main(String[] args) throws InterruptedException {
		System.out.println("BEGINNING...");
		
		// Set up threads and start
		Coordinator coor = new Coordinator("Coordinator");
		coor.start();
		Trainer trainer = new Trainer("Trainer",5);
		Participant participant = new Participant("<A Being>",10);
		// Switches between trainer and participant thread
		trainer.start();
		participant.start();
		
		// Everyone go home.
		participant.join();
		System.out.println('\n'+participant.getName()+" left.");
		trainer.join();
		System.out.println(trainer.getName()+" left.");
		coor.join();
		System.out.println(coor.getName()+" left.");

		// Exit main thread.
		System.out.println("EXITING...");
	}
	
	public Coordinator(String threadName) {
		super(threadName);
	}
	
	@Override
	public void run() {
		startup();
	}
	
	public void startup() {
		System.out.println(this.getName()+" have started meeting.");
	}
}
