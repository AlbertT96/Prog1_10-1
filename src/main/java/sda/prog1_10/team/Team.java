package sda.prog1_10.team;

public abstract class Team implements Comparable<Team> {
	private String name;
	private int points;

	public Team() {
	}

	public Team(String name) {
		this.name = name;
	}

	/**
	 * use retriveName method
	 * @return team name
	 */
	@Deprecated
	public String getName() {
		return name;
	}

	public String retriveName() {return name;}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int compareTo(Team o) {
		if(this.points > o.getPoints()) return -1;
		if(this.points==o.getPoints()) return 0;
		return 1;
	}

	@Override
	public String toString() {
		return "Team{" +
				"name='" + name + '\'' +
				'}';
	}
}
