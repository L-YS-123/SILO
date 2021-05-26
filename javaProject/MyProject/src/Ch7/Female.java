package Ch7;
//Person 클래스를 상속해서 확장하는 새로운 클래스 Male 클래스와 Female 클래스를 정의 해봅시다.
//① 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
//② 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
//③ Person 클래스에서 정의된 인사하는 메소드를 오버라이딩 해봅시다.
//④ Person 클래스에 생성자를 정의해서 인스턴스 변수들을 초기화 해봅시다.

public class Female extends Person {
	String name="영희";
	String regiNum;
	int age;
	int grade=2;
	String gender="여자";
	
	public void hello() {
		System.out.printf("안녕하세요. 저는 %s입니다. 저의 성별은 %s입니다.\n", name, gender);
		System.out.printf("저는 대학교 %d학년 입니다.\n", grade);
		System.out.printf("저는 %d살 입니다.", super.age);
		System.out.println();
	}
}
