package sda.prog1_10;

public class Silnia {

//TODO dołożyć obsługe błędów

	public static int silnia(int arg) {
		int silnia  = 1;
		while(arg > 1) {
			silnia *= arg--;
		}
		return silnia;
	}

	//FIXME
	//postać rekurencyjna
	public static int silniaRecursive(int arg) {
		return arg > 1
				? silniaRecursive(arg - 1) * arg
				: 1;
	}
}
