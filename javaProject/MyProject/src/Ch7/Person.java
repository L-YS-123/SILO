package Ch7;
//Person 이라는 클래스를 정의해봅시다.

//① 이름을 저장하는 변수, 주민등록번호를 저장하는 변수를 정의해봅시다.
//② 인사하는 메소드를 정의해봅시다.
//- “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 문자열이 출력하도록 정의합시다.

public class Person {

	Person() {
		String name = "";
		String regiNum = "960000-10000000";
//		int age = 121 - Integer.parseInt(regiNum, 2);
	}

	public void hello(String name,String regiNum) {
		System.out.println("안녕하세요. 저는 " + name + "입니다." + regiNum + "살 입니다.");
	}
}