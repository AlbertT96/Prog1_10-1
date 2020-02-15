package sda.prog1_10.methods;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println("Czy 242 jest palindromem: " + isPalindrome(242));
		System.out.println("Czy -242 jest palindromem: " + isPalindrome(-242));
		System.out.println("Czy 2452 jest palindromem: " + isPalindrome(2452));
		System.out.println("Czy 2442 jest palindromem: " + isPalindrome(2442));
		System.out.println("Czy -2412 jest palindromem: " + isPalindrome(-2412));
	}

	/**
	 * 201
	 *
	 * 1 pętla
	 * reverseNumber = 0
	 * dodajemy do reverseNumber
	 * resztę z dzielenia
	 * 201/10
	 *
	 * na wyjściu z 1 pętli mamy
	 * checkNumber = 20
	 * reverse mamy = 1
	 *
	 * 2 pętla
	 * reverse jest 1 więc mnożymy 8 10 i dodajemy
	 * resztę z dzielenia 20/0 czyli 0
	 *
	 * reverse = 10
	 * check = 2
	 *
	 * 3 pętla
	 * reverse * 10 -> 100 i dodajemy resztę z dzielenia check / 10 czyli dodajemy 2
	 * reverse = 102
	 * check = 0
	 *
	 * @param number
	 * @return
	 */
	public static boolean isPalindrome(int number) {
		int reverseNumber = 0;
		int checkNumber = number;
		boolean isNegative = false;

		if(checkNumber < 0) {
			checkNumber *= -1; //checkNumber = checkNumber * -1;
			isNegative = true;
		}

		while(checkNumber > 0) {
			reverseNumber = reverseNumber * 10 + checkNumber % 10;
			checkNumber /= 10;
		}

		if(isNegative)
			reverseNumber *= -1;

		return (reverseNumber == number);

	}
}
