package Exercise2;


public class ThreadOne extends Thread {

	
	public void run() {

		System.out.println("Started Executing Thread 1");

		synchronized (DeadLock.lock1) {
			System.out.println("Thread 1 holding lock 1 ....");

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Thread 1 is waiting for the lock2");

			synchronized (DeadLock.lock2) {

				System.out.println("Thread 1 is holding lock1 and lock2");
			}
		}
	}
}
