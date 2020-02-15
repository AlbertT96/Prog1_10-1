package sda.prog1_10;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SilniaTest {

	@Before
	public void setup() {
		System.out.println("Biforek");
	}

	@After
	public void clean() {
		System.out.println("Afterek");
	}

	@Test
	public void silnia() {
		int silniaValue = Silnia.silnia(6);
		assertEquals(720, silniaValue);
	}

	@Test
	public void testSilnia5() {
		int silniaValue = Silnia.silnia(5);
		assertEquals(120, silniaValue);
	}
}