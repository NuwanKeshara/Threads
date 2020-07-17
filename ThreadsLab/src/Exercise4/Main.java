package Exercise4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Map<String, Integer> number1 = new LinkedHashMap<>();
	
	static Object obj1 = new Object();

	static Scanner myScn = new Scanner(System.in);

	public static void main(String[] args) {

		T1 t1 = new T1();
		t1.start();

		T2 t2 = new T2();
		t2.start();

	}

}

class T1 extends Thread {

	
	
	public void run() {

		synchronized (Main.obj1) {

			while (true) {
				System.out.println("Thread 01 started..");
				

				for (int i = 0; i < 3; ++i) {

					System.out.println("Please enter no1 and no2 as keyboard Inputs 3 times.");

					System.out.print("Enter no1 : ");
					String no1 = Main.myScn.next();

					System.out.print("Enter no2 : ");
					String no2 = Main.myScn.next();

					int No1, No2;

					try {
						No1 = Integer.parseInt(no1);
						No2 = Integer.parseInt(no2);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						break;

					}

					Main.number1.put(no1 + " * " + no2 + " = ", No1 * No2);

				}
				Main.obj1.notify();
				try {
					
					System.out.println("Thread 01 goes to waiting state \n");
					Main.obj1.wait();

				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}

	}

}

class T2 extends Thread {

	public void run() {

		synchronized (Main.obj1) {

			while (true) {
				System.out.println("Thread 02 started.");
				System.out.println("You entered no1 * no2 = result as output");

				for (Map.Entry<String, Integer> val : Main.number1.entrySet()) {

					System.out.print(val.getKey());
					System.out.println(val.getValue());
				}
				
				System.out.println("Thread 01 notified \n");
				Main.obj1.notify();

				try {
					Main.obj1.wait();

				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}
	}
}