package Ch5;

public class Member {
//	이름, 전화번호, 전공, 학년, email, 생일, 주소
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
	}
}
