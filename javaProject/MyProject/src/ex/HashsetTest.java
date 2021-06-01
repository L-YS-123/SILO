package ex;

import java.util.HashSet;
import java.util.Iterator;

public class HashsetTest {

	public static void main(String[] args) {
		//해쉬셋 저장 공간 생성 : 인스턴스 저장, 중복 허용x, 저장 순서x
		
//		HashSet<String> hashSet = new HashSet<String>();
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		// 데이터 저장
//		hashSet.add("first");
//		hashSet.add("second");
//		hashSet.add("third");
//		hashSet.add("first");
		hashSet.add(1);
		hashSet.add(3);
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		
		
		// 데이터의 일괄 처리
		Iterator<Integer> itr = hashSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
