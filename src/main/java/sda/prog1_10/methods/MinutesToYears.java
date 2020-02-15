package sda.prog1_10.methods;

public class MinutesToYears {
	private static final long MINUTES_IN_YEAR = 365 * 24 * 60;
	private static final long MINUTES_IN_DAY = 24 * 60;
	private static final long MINUTES_IN_HOUR = 60;

	//piszemy psvm i wyskakuje metoda main
	public static void main(String[] args) {
		minutesInYears(126558L);
		minutesInYears(255758L);
		minutesInYears(122L);
	}

	public static void minutesInYears(long minutes) {
		long years, days, hours, leftMinutes;

		if(minutes < 0L) {
			System.out.println("Invalid entry minutes value: " + minutes);
		} else {
			years = minutes / MINUTES_IN_YEAR;
			if(years < 0L) years = 0L;

			days = (minutes - years * MINUTES_IN_YEAR) / MINUTES_IN_DAY;
			if(days < 0L) days = 0L;

			hours = (minutes - years * MINUTES_IN_YEAR - days * MINUTES_IN_DAY) / MINUTES_IN_HOUR;
			if(hours < 0L) hours = 0L;

			leftMinutes = (minutes - years * MINUTES_IN_YEAR
					- days * MINUTES_IN_DAY - hours * MINUTES_IN_HOUR);
			if(leftMinutes < 0L) leftMinutes = 0L;

			System.out.println(minutes + "min = "
			+ years + "y "+days +"d "+ hours + "h "+ leftMinutes + "min");

		}
	}

}
