package Ch7;
//Person 이라는 클래스를 정의해봅시다.
//① 이름을 저장하는 변수, 주민등록번호를 저장하는 변수를 정의해봅시다.
//② 인사하는 메소드를 정의해봅시다.
//- “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 문자열이 출력하도록 정의합시다.

public class Person {
	String name;
	String regiNum;
	int age;
	
	public Person() {
		name = "철수";
		regiNum = "960000-1000000";
		age = 121 - Integer.parseInt(regiNum.substring(0, 2));
	}
	
	public void hello() {
		System.out.printf("안녕하세요. 저는 %s입니다.\n", name);
		System.out.printf("저는 %s년생입니다.\n", regiNum.substring(0, 2));
		System.out.println();
	}			
}
