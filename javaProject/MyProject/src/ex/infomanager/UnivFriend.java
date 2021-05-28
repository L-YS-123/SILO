package ex.infomanager;

public class UnivFriend extends Friend {
	
	
	//대학 친구는 전공 정보를 가진다
	String major;
	
	public UnivFriend(String name, String phoneNumber, String address, String major) {	//생성자
		super(name, phoneNumber, address);
		this.major = major;
	}
	
	// 오버라이딩 한 메소드(공용)
	public void showData() {	
		super.showData();
		System.out.println("전   공: "+major);
	}
	
	// 오버라이딩 한 메소드(오버라이딩 전용)
	public void showBasicInfo() {	
		System.out.println("이름: " + name);
		System.out.println("전화: " + phoneNumber);
		System.out.println("전공: " + major);
	}
}