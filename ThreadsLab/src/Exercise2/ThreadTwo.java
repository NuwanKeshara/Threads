package Exercise2;


public class ThreadTwo extends Thread {

	public void run() {

		System.out.println("Started Executing Thread 2");

		synchronized (DeadLock.lock2) {
			System.out.println("Thread 2 holding lock 2 ....");

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Thread 2 is waiting for the lock1");

			synchronized (DeadLock.lock1) {

				System.out.println("Thread 2 is holding lock1 and lock2");
			}
		}
	}
}
