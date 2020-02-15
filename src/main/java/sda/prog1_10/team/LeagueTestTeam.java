package sda.prog1_10.team;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeagueTestTeam {

	public static void main(String[] args) {
		Team footballTeam1 = new FootballTeam("Atletico Madrid");
		Team footballTeam2 = new FootballTeam("Real Madrid");
		FootballTeam footballTeam3 = new FootballTeam("Barcelona");
		FootballTeam footballTeam4 = new FootballTeam("Valencia CF");

		Team volleyballTeam1 = new VolleyballTeam();
		Team volleyballTeam2 = new VolleyballTeam();
		VolleyballTeam volleyballTeam3 = new VolleyballTeam();
		VolleyballTeam volleyballTeam4 = new VolleyballTeam();

		footballTeam1.setPoints(10);
		footballTeam2.setPoints(12);
		footballTeam3.setPoints(15);
		footballTeam4.setPoints(8);

		volleyballTeam1.setPoints(10);volleyballTeam1.setName("Asseco Resovia");
		volleyballTeam2.setPoints(12);volleyballTeam2.setName("Skra Belchatow");
		volleyballTeam3.setPoints(15);volleyballTeam3.setName("Zaksa");
		volleyballTeam4.setPoints(8);volleyballTeam4.setName("Jastrzebski Wegiel");

		LeagueTeam<FootballTeam> footballLeague = new LeagueTeam("Primiera Division");
		LeagueTeam<VolleyballTeam> volleyballLeague = new LeagueTeam("Plus Liga");
		footballLeague.addTeam((FootballTeam) footballTeam1);
		footballLeague.addTeam((FootballTeam) footballTeam2);
		footballLeague.addTeam(footballTeam3);
		footballLeague.addTeam(footballTeam4);
		volleyballLeague.addTeam((VolleyballTeam) volleyballTeam1);
		volleyballLeague.addTeam((VolleyballTeam) volleyballTeam2);
		volleyballLeague.addTeam(volleyballTeam3);
		volleyballLeague.addTeam(volleyballTeam4);

		//footballLeague.addTeam(volleyballTeam3);

		volleyballLeague.printTable();
		System.out.println("======================");
		for (FootballTeam footballTeam : footballLeague.getTeams()) {
			System.out.println(footballTeam.getName());
		}
		System.out.println("======================");
		System.out.println("Stream print");
		footballLeague.getTeams().stream()
				.forEach(x -> System.out.println(x.getName()));

		System.out.println("Stream print with maping teams to names");
		footballLeague.getTeams().stream()
				.map(x -> x.getName())
				.forEach(x -> System.out.println(x));


		System.out.println("Stream print with maping teams to names v2");
		footballLeague.getTeams().stream()
				.map(x -> x.getName())
				.forEach(System.out::println);

		System.out.println("Stream print with maping teams to names v3");
		footballLeague.getTeams().stream()
				.map(Team::getName)
				.forEach(System.out::println);

		System.out.println("Stream print with maping teams "
				+ "to names and limit to 2");
		footballLeague.getTeams().stream()
				.limit(2)
				.map(Team::getName)
				.forEach(System.out::println);

		System.out.println("Stream print with maping teams "
				+ "to names where points > 10");
		footballLeague.getTeams().stream()
				.filter(x -> x.getPoints() > 10)
				.map(Team::getName)
				.forEach(System.out::println);

		System.out.println("League copy with teams where points > 10");
		List<FootballTeam> teamCopy = footballLeague.getTeams().stream()
				.filter(x -> x.getPoints() > 10)
				.collect(Collectors.toList());

		teamCopy.stream()
				.forEach(x -> System.out.println(x.getName()));

		List<FootballTeam> teamCopy2 = footballLeague.getTeams();
		//łączenie strumieni
		List<FootballTeam> teamConcat =
				Stream.concat(teamCopy.stream(), teamCopy2.stream())
				.collect(Collectors.toList())
				//strumień zakończony, mamy listę drużyn
				;

		//łączenie strumieni v2
		List<FootballTeam> teamConcat2 =
				Stream.of(teamCopy, teamCopy2)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());

		//Lista nazw drużyn z listy drużyn
		List<String> teamNamesList = teamConcat2.stream()
				.map(Team::retriveName)
				.collect(Collectors.toList());

		Set<String> teamNamesSet = teamConcat2.stream()
				.map(Team::retriveName)
				.collect(Collectors.toSet());
		System.out.println("===ListPrint===");
		teamNamesList.stream().forEach(System.out::println);
		System.out.println("===SetPrint===");
		teamNamesSet.stream().forEach(System.out::println);

		//suma punktów drużyn
		int sumPoints = footballLeague.getTeams().stream()
				.map(Team::getPoints)
				.reduce(0,Integer::sum);
		System.out.println("Suma punktow:"+sumPoints);
		//zliczanie elementów
		long countElements = footballLeague.getTeams().stream()
				.map(Team::getPoints)
				.count();

		countElements = footballLeague.getTeams().stream()
				.count();

		countElements = footballLeague.getTeams().stream()
				.filter(x -> x.getPoints() < 8)
				.count();

		//suma punktów drużyn
		// gdzie drużyna ma co najmniej 10 punktów
		sumPoints = footballLeague.getTeams().stream()
				.filter(t -> t.getPoints() >= 10)
				.map(Team::getPoints)
				.reduce(0,Integer::sum);

		sumPoints = footballLeague.getTeams().stream()
				.map(Team::getPoints)
				.filter(t -> t >= 10)
				.reduce(0,Integer::sum);

		Integer max = footballLeague.getTeams().stream()
				.mapToInt( t -> t.getPoints())
				.max()
				.orElse(new Integer(0));
		System.out.println("max : " + max);
		Team teamExpected = footballLeague.getTeams().stream()
				.max(Comparator.comparing(Team::getPoints))
				.orElseThrow(NoSuchElementException::new);
		System.out.println("max from team : " + teamExpected.getPoints());
		Integer max2 = footballLeague.getTeams().stream()
				.max(Comparator.comparing(Team::getPoints))
				.map(Team::getPoints)
				.orElseThrow(NoSuchElementException::new);
		System.out.println("max2 : " + max2);

		Optional<Integer> max3 = footballLeague.getTeams().stream()
				.max(Comparator.comparing(Team::getPoints))
				.map(Team::getPoints);
		if(max3.isPresent())	System.out.println("max3 : " + max3);



	}
}
