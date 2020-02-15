package sda.prog1_10.person;

import java.util.Comparator;

public class RaceSortByNameAndRacersNumber implements Comparator<Race> {

	@Override
	public int compare(Race o1, Race o2) {
		if(o1.getRaceName().compareTo(o2.getRaceName()) != 0)
			return o1.getRaceName().compareTo(o2.getRaceName());

		return o1.getDrivers().size() - o2.getDrivers().size();
	}
}
