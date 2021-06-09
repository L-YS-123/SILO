package Ch14;

import java.util.HashSet;
/*
 * 3.TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 같은 팀의 선수들은 이름 순으로 정렬하고, 같은 이름의 선수는 번호 순으로
 * 저장하는 프로그램을 만들어 봅시다.
 */
import java.util.Iterator;
import java.util.TreeSet;

import Ch11.FootballPlayer;

public class CollectionFrameWork3 extends FootballPlayer implements Comparable<FootballPlayer> {

	public CollectionFrameWork3(String name, int number, String team, int age) {
		super(name, number, team, age);
	}

	@Override
	public int compareTo(FootballPlayer o) {
		int result = this.getTeam().compareTo(o.getTeam());
		if (result == 0) {
			result = this.getName().compareTo(o.getName());
			if (result == 0) {
				result = this.getNumber() - o.getNumber();
			}
		}
		return result;
	}

	public static void main(String[] args) {

		TreeSet<FootballPlayer> hsfp = new TreeSet<>();
		hsfp.add(new FootballPlayer("Son1", 7, "Tot", 27));		// TreeSet 을 HashSet으로 잘못 써서 오류가 남
		hsfp.add(new FootballPlayer("Park1", 7, "Man", 37));
		hsfp.add(new FootballPlayer("Son1", 9, "Tot", 27));
		hsfp.add(new FootballPlayer("Son2", 20, "Tot", 17));
		hsfp.add(new FootballPlayer("Park2", 20, "Man", 31));
		hsfp.add(new FootballPlayer("Park2", 21, "Man", 31));

		Iterator<FootballPlayer> itr = hsfp.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
