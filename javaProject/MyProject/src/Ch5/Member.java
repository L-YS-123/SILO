package Ch5;

public class Member {
//	접근제어 지시자 private을 쓰는 이유
	// 클래스 내부 멤버들만 참조 가능 : 정보 은닉, 변수의 데이터 보호
	
	private String name ;
	private String phoneNum ;
	private String major ;
	private int grade ;
	private String eMail ; 
	private String birthday ; 
	private String adress ;
	
	//생성자 -> 초기화 목적
	//클래스이름(매개변수) {초기화코드}
	//생성자는 반드시 하나 이상이 있어야 한다(기본생성자) == 클래스이름( ) { } // 아예 없으면 기본적으로 컴파일러가 생성
	
	Member(String name, String phoneNum, String major, int grade,
			String eMail, String birthday, String adress) {
		this.name = name; this.phoneNum = phoneNum; this.major=major; this.grade=grade;
		this.eMail=eMail; this.birthday=birthday; this.adress=adress;
		//this(name, phoneNum, major, grade, eMail, birthday, adress);
	}
	
	
	// 오버로딩의 조건 :
			// 1.메소드의 이름은 같다
			// 2.매개변수의 개수가 틀리거나, 매개변수의 타입이 달라야 오버로딩이 성립
			// 3.반환타입은 상관없다
	
	Member(String name, String phoneNum, String major, int grade) {
		//this.name=name; this.phoneNum=phoneNum; this.major=major; this.grade=grade;
		this(name, phoneNum, major, grade, null, null, null); // <없는 값은 기본 값을 적어주어야 함>
	// 파란색 = 인스턴스 변수, 갈색 = 지역(매개)변수
	}

	
	void showInfo () {
		System.out.println("이름" + this.name);
		System.out.println("전화번호" + phoneNum);
		System.out.println("전공" + major);
		System.out.println("학년" + grade);
		System.out.println("이메일" + eMail);
		System.out.println("생일" + birthday);
		System.out.println("주소" + adress);
		
		
	}
	public static void main(String[] args) {
		
		Member member = new Member("철수", "010-0000-0000", "음악", 4, 
									"ch@gmail.com", "2000-01-01", "Seoul");
		member.showInfo();
		
		
		
		
		Member member2 = new Member("손흥민", "010-0000-0000", "축구", 2);
		member2.showInfo();
	}
}
