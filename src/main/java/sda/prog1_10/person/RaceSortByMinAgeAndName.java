package sda.prog1_10.person;

import java.util.Comparator;

public class RaceSortByMinAgeAndName implements Comparator<Race> {

	@Override
	public int compare(Race o1, Race o2) {
		if(o1.getMinimumAge() - o2.getMinimumAge() != 0)
			return o1.getMinimumAge() - o2.getMinimumAge();

		return o1.getRaceName().compareTo(o2.getRaceName());
	}
}
