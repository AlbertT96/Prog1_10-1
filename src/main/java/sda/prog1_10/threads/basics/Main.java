package sda.prog1_10.threads.basics;

import static sda.prog1_10.threads.ThreadColor.ANSI_GREEN;
import static sda.prog1_10.threads.ThreadColor.ANSI_PURPLE;
import static sda.prog1_10.threads.ThreadColor.ANSI_RED;

public class Main {

	public static void main(String[] args) {
		//założenie banku
		//założenie klienta

		System.out.println(ANSI_PURPLE+" Main thread in action");

		Thread otherThread = new OtherThread();
		otherThread.setName("==== OTHER THREAD====");
		otherThread.start(); //wywołujemy start() mimo że przeładowaliśmy run()
		//otherThread.run(); //to nie powołuje nowego wątku
		Thread runnableSample = new Thread(new RunnableSample());
		runnableSample.start();
		System.out.println(ANSI_PURPLE + " End of main");

		//wątek na klasie anonimowej
		new Thread() {
			public void run() {
				System.out.println(ANSI_GREEN + "Anonymous class based thread");
			}
		}.start();

		runnableSample = new Thread(new RunnableSample() {
			@Override
			public void run() {
				System.out.println(ANSI_RED + " overridden RunnableSample");
				try {
					otherThread.join(); //jeden wątek czeka na drugi
					System.out.println(ANSI_RED + "Other thread terminated "
							+ "so I work again");
				} catch (InterruptedException e) {
					System.out.println(ANSI_RED + "overridden Runnable terminated");
				}
			}
		});
		runnableSample.start();
		//otherThread.interrupt();


	}

}
