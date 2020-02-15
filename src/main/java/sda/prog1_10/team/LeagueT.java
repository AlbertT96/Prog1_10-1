package sda.prog1_10.team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeagueT<T> {
	private String name;
	private List<T> teams;

	public LeagueT(String name) {
		this.name = name;
		teams = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<T> getTeams() {
		return teams;
	}

	public boolean addTeam(T team) {
		if(!teams.contains(team)) {
			System.out.println("Adding "
					+ ((Team) team).getName() +" to "+ name);
			return teams.add(team);
		}
		System.out.println("Team "+ ((Team) team).getName() +" already in league");
		return false;
	}

	public void printTable() {
		Collections.sort((List<Team>) teams);
		System.out.println(name + " table:");
		for (T team : teams) {
			System.out.println(((Team) team).getName() +" " +((Team) team).getPoints());
		}
	}
}
