package sda.prog1_10.person;

public class English extends Person {

	private boolean hasGuardian;
	private String taxNumber;
	private String nationality;

	static { //przy uruchamianiu JVM i tworzeniu klasy
		//...
	}

	{//to jest blok inicjujący uruchamiany przy tworzeniu każdego obiektu
		this.hasGuardian = false;
		this.nationality = "English";
	}

	public English(String firstName, String lastName, String taxNumber) {
		super(firstName, lastName);
		this.taxNumber = taxNumber;
	}

	public English(String firstName, String lastName, int age, String sex, String taxNumber) {
		super(firstName, lastName, age, sex);
		this.taxNumber = taxNumber;
	}

	@Override
	public String getIdentity() {
		return taxNumber;
	}

	@Override
	public boolean canDriveCar() {
		return (getAge() > 16 && isDrivingLicense()) ||
				(getAge() > 14 && hasGuardian);
	}

	@Override
	public boolean canRace() {
		return getAge() > 12;
	}
}
