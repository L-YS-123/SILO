package ex.infomanager;

public class HighFriend extends Friend {

	String work;
	
	//생성자
	public HighFriend(String name, String phoneNumber, String address, String work) {	
		super(name, phoneNumber, address);
		this.work = work;
	}

	// 오버라이딩 한 메소드(공용)
	@Override
	public void showData() {	
		super.showData();
		System.out.println("직   업: " + work);
	}

	// 오버라이딩 한 메소드(오버라이딩 전용)
	@Override
	public void showBasicInfo() {	
		System.out.println("이름: "+name);
		System.out.println("전화: "+phoneNumber);
	}
	
}
