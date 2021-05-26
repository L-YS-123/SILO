package Ch7;

public class Main {

	public static void main(String[] args) {
//		 ① Person 클래스를 상속받은 Male클래스와 Female클래스를 이용해서 인스턴스를 생성해 봅시다.
//		 ② 생성된 인스턴스들을 이용해서 메소드를 호출해봅시다.
		Person p1 = new Person();
		
		p1.hello("김철수", "960000-10000000");
	}
}
