package Ch14;

import java.util.ArrayList;
import java.util.List;

class FootballPlayer {
	String name;
	int number;
	String team;
	int age;

	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}

}

public class CollectionFrameWork {
	/*
	 * 1.축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
	 */
	public static void main(String[] args) {
		List<FootballPlayer> fp = new ArrayList<FootballPlayer>();

		fp.add(0, new FootballPlayer("손흥민", 7, "토트넘", 27));
		fp.add(1, new FootballPlayer("박지성", 13, "맨유", 37));
		fp.add(2, new FootballPlayer("안정환", 23, "부산 아이파크", 47));
		fp.add(3, new FootballPlayer("아길라르", 33, "인천 유나이티드", 17));
		
		for(int i=0; i<fp.size(); i++) {
			System.out.println(fp.get(i));
		}
	}

}
