package sda.prog1_10.threads.basics;

import static sda.prog1_10.threads.ThreadColor.ANSI_RED;

public class RunnableSample implements Runnable {

	@Override
	public void run() {

		System.out.println(ANSI_RED+" Runnable sample working ");
	}
}
