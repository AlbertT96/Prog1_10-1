package sda.prog1_10.person;

import java.util.Optional;

public abstract class Person implements Driver {
	/**
	 * Dopisz metodę public boolean isRetired sprawdzającą czy osoba jest emerytem
	 * (kobieta powyżej 65 lat, mężczyzna powyżej 67)
	 * Przeładuj metodę toString aby wyświetlić wszystkie informacje o danej osobie.
	 * Na kilku przykładach sprawdź działanie klasy.
	 */
	private String firstName;
	private String lastName;
	private int age;
	private Sex sex;
	private boolean drivingLicense;

	public Person() {
	}

	public Person(String firstName, String lastName, int age, String sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = Sex.getByShortName(sex);
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSexShortName() {
		return Optional.ofNullable(sex).map(Sex::getShortName).orElse("");
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public boolean isDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(boolean drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public boolean isRetired() {
		if(this.sex ==Sex.MAN && this.age > 67) return true;
		if(this.sex ==Sex.WOMAN && this.age > 65) return true;
		return false;
	}
//CTRL + /
	@Override
	public String toString() {
		return "Person{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				", sex='" + getSexShortName() + '\'' +
				'}';
	}

	public abstract String getIdentity();
}
