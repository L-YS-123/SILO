package Ch14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import Ch11.FootballPlayer;

//4.축구선수의 번호를 key로 하고 
//축구선수 인스턴스를 저장하는 Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다.
public class CollectionFrameWork5  {

	public static void main(String[] args) {
		
		HashMap<Integer,FootballPlayer> hmfp = new HashMap<>();
		hmfp.put(7, new FootballPlayer("손흥민",7,"토트넘",27));
		hmfp.put(10, new FootballPlayer("케인", 10, "Tot", 26));
		hmfp.put(20, new FootballPlayer("케인2", 20, "Tot", 16));
		
		Iterator<Entry<Integer,FootballPlayer>> entry = hmfp.entrySet().iterator();
		while(entry.hasNext()) {
			Map.Entry<Integer, FootballPlayer> entry2 = entry.next();
			System.out.println("키 값:"+entry2.getKey() + ", " + "객체값: "+entry2.getValue());
		}
	}
	
}
