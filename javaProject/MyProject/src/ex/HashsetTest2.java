package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashsetTest2 {

	public static void main(String[] args) {
		//해쉬셋 저장 공간 생성 : 인스턴스 저장, 중복 허용x, 저장 순서x
		
//		HashSet<String> hashSet = new HashSet<String>();
		Set<SimpleNumber> hashSet = new HashSet<>();
		
		// 데이터 저장
		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(20));
		hashSet.add(new SimpleNumber(20));
		
		
		// 데이터의 일괄 처리
		Iterator<SimpleNumber> itr = hashSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}


class SimpleNumber {
	int num;
	SimpleNumber(int num) {
		this.num=num;
	}
	
	public String toString() {
		return String.valueOf(num);
	}

	@Override
	public int hashCode() {
		return num%3; // 0 , 1 , 2 의 그룹
		
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		// obj는 null이 아니고, obj는 SimpleNumber 타입으로 형변환이 가능해야한다.
				
		if(obj != null && obj instanceof SimpleNumber)
		{
			SimpleNumber sNum = (SimpleNumber) obj;
			if(this.num == sNum.num) {
				result = true;
			}
		}
		
		return result;
	}
	
	
}