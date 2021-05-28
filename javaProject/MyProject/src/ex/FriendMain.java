package ex;

public class FriendMain {
	
	public static void main(String[] args) {
		
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("이강인");
		Friend f3 = new Friend("손흥민");
		
		System.out.println(f1); // f1.toString() 호출
		System.out.println(f2);
		System.out.println(f3);
		
		System.out.println(f1 == f3); // f1과 f3은 값만 같고 주소값은 틀리기 때문에 같은 객체가 아님.
		System.out.println(f1.equals(f3)); // 참조값 비교 false
		
	}
	
}

class Friend {
	
	String myName;
	
	Friend(String name) {
		this.myName = name;
	}
	//toString()의 오버라이딩
	public String toString() {
		return "나의 이름은 " + myName + "입니다.";
	}
	
	
	
	public boolean equals(Object o) {
		
		boolean result = false;
		
		if(o != null && o instanceof Friend) {
			Friend f = (Friend) o;
			if(myName.equals((f.myName))) {
				result = true;
			}
		} 
		
		return result;
	}
	
}