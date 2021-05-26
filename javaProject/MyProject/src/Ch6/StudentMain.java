package Ch6;

public class StudentMain {

	public static void main(String[] args) {
//		3.main()메소드에 아래 내용을 정의해봅시다.
//		①Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
//		②Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
//		③배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
		
		Student[] scores = new Student[10]; // **class가 배열이 아니더라도 생성자에서 배열로 선언 가능! (아주 중요)
		
		scores[0] = new Student("홍길동1", 100, 10, 16);
		scores[1] = new Student("홍길동2", 89, 22, 66);
		scores[2] = new Student("홍길동3", 78, 65, 86);
		scores[3] = new Student("홍길동4", 67, 48, 96);
		scores[4] = new Student("홍길동5", 86, 98, 46);
		scores[5] = new Student("홍길동6", 95, 63, 86);
		scores[6] = new Student("홍길동7", 44, 55, 66);
		scores[7] = new Student("홍길동8", 33, 42, 76);
		scores[8] = new Student("홍길동9", 62, 23, 16);
		scores[9] = new Student("홍길동10", 71, 17, 36);
		
		System.out.println("  이름  " + "  국어  "+"  영어  "+"  수학  "+"  합계  "+"  평균  ");
		System.out.println("===========================================================");
		System.out.println();
		
		for(int i=0; i<scores.length; i++) {
			System.out.println( scores[i].getName()+"\t"+
								scores[i].getPointKor()+"\t"+
								scores[i].getPointEng()+"\t"+
								scores[i].getPointMath()+"\t"+
								scores[i].getSum()+"\t"+
								scores[i].getAvg());
		}
		
	}

}
