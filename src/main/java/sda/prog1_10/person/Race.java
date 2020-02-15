package sda.prog1_10.person;

import java.util.ArrayList;
import java.util.List;

public class Race implements Comparable<Race>{
	private String raceName;
	private List<Person> drivers;
	private int minimumAge;
	private int raceYear;

	public Race(String raceName, int minimumAge) {
		this.raceName = raceName;
		this.minimumAge = minimumAge;
		drivers = new ArrayList<>();
	}

	public Race(String raceName) {
		this.raceName = raceName;
		drivers = new ArrayList<>();
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public List<Person> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Person> drivers) {
		this.drivers = drivers;
	}

	public int getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(int minimumAge) {
		this.minimumAge = minimumAge;
	}

	public int getRaceYear() {
		return raceYear;
	}

	public void setRaceYear(int raceYear) {
		this.raceYear = raceYear;
	}

	public boolean addDriver(Person driver) {
		if(isDriverOnList(driver)) {
			System.out.println("Kierowca " + driver.getLastName()+" "
					+ driver.getFirstName()+
			" już jest na liście");
			return false;
		}
		if(driver.getAge() > minimumAge) {
			System.out.println("Kierowca "+ driver.getLastName() +
					" " + driver.getFirstName() + " dodany");
			return drivers.add(driver);
		}
		System.out.println("Kierowca za młody");
		return false;
	}

	private boolean isDriverOnList(Person driver) {
		return drivers.indexOf(driver) >= 0;
	}

	public boolean removeDriver(Person driver) {
		if(!isDriverOnList(driver)) {
			System.out.println("Kierowcy "
					+ driver.getLastName() + " "
					+ driver.getFirstName() + " nie ma na liscie");
			return false;
		}
		return drivers.remove(driver);
	}

	@Override
	public int compareTo(Race o) {
		return o.getMinimumAge() - minimumAge;
	}
}
