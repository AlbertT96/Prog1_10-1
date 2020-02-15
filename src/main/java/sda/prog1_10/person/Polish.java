package sda.prog1_10.person;

import java.util.Objects;

public class Polish extends Person {
	/**
	 * Przeładuj metodę toString aby wyświetlić wszystkie informacje o danej osobie.
	 */
	private String nationality;
	private int children;
	private String pesel;

	public Polish() {
		this.nationality = "Polish";
	}

	public Polish(String firstName, String lastName, int children) {
		super(firstName, lastName);
		this.children = children;
		this.nationality = "Polish";
	}

	@Override
	public boolean isRetired() {
		if(getSexShortName() ==Sex.MAN.getShortName() && getAge() > 65) return true;
		if(getSexShortName() ==Sex.WOMAN.getShortName() && getAge() > 60) return true;
		return false;
	}

	public boolean enabledKdr(){
		return children >= 3 ? true : false;
	}

	@Override
	public String toString() {
		return "Polish{" + super.toString() +
				", nationality='" + nationality + '\'' +
				", children=" + children +
				(enabledKdr() ? ", KDR" : "") +
				'}';
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Override
	public String getIdentity() {
		return pesel;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Polish polish = (Polish) o;
		return Objects.equals(pesel, polish.pesel) &&
				Objects.equals(getLastName()+getFirstName()
								,polish.getLastName() + polish.getFirstName())
				;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pesel+getLastName()+getFirstName());
	}

	@Override
	public boolean canDriveCar() {
		return getAge() > 16 && isDrivingLicense();
	}

	@Override
	public boolean canRace() {
		return getAge() > 10;
	}
}
