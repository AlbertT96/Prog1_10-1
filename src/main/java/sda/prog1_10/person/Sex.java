package sda.prog1_10.person;

public enum Sex {
	WOMAN("W", "woman", "kobieta", 1),
	MAN("M", "man", "mezczyzna", 2);

	private String shortName;
	private String englishName;
	private String polishName;
	private int index;

	Sex(String shortName, String englishName, String polishName, int index) {
		this.shortName = shortName;
		this.englishName = englishName;
		this.polishName = polishName;
		this.index = index;
	}

	public static Sex getByShortName(String sexShortName) {
		for (Sex s : Sex.values()) {
			if(s.getShortName() == sexShortName)
				return s;
		}
		return null;
	}

	public String getShortName() {
		return shortName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public String getPolishName() {
		return polishName;
	}

	public int getIndex() {
		return index;
	}
}
