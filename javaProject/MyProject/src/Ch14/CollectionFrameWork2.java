package Ch14;

import java.util.HashSet;
import java.util.Set;

class FootballPlayer2 {
	String name2;
	int number2;
	String team2;
	int age2;

	public FootballPlayer2(String name2, int number2, String team2, int age2) {

		this.name2 = name2;
		this.number2 = number2;
		this.team2 = team2;
		this.age2 = age2;
	}

	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof FootballPlayer2) {
			FootballPlayer2 footballPlayer2 = (FootballPlayer2) obj;
			if(this.name2.equals(footballPlayer2.name2) && this.team2.equals(footballPlayer2.team2) && this.age2 == footballPlayer2.age2); {
				return true;
			}
		}
		return false;
	}
	
	public int hashCode() {
		return age2%10;
	}

	@Override
	public String toString() {
		return "FootballPlayer2 [name2=" + name2 + ", number2=" + number2 + ", team2=" + team2 + ", age2=" + age2 + "]";
	}

}

/*
 * 2.축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 입력이 되지 않도록 Set<E> 컬렉션을 이용해서 축구선수
 * 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
 */
public class CollectionFrameWork2 {

	public static void main(String[] args) {

		HashSet<FootballPlayer2> fp2 = new HashSet<>();
		fp2.add(new FootballPlayer2("이천수", 10, "레알 소시에다드", 20));
		fp2.add(new FootballPlayer2("이수", 10, "레알 소시에다드", 20));
		fp2.add(new FootballPlayer2("손흥민", 10, "레알 소시에다드", 20));

//		for (int i = 0; i < fp2.size(); i++) {
		System.out.println(fp2.toString());
//		}
	}

}
