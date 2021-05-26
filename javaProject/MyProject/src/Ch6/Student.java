package Ch6;
//2.Student 클래스를 정의해봅시다.
//①학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
//②변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
//③총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
public class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {	
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public Student() {}
	
	public String getName() {		return name;	}
	public void setName(String name) {		this.name=name;	}
	
	public int getPointKor() {		return kor;	}
	public void setPointKor(int kor) {		this.kor=kor;	}
	
	public int getPointEng() {		return eng;	}
	public void setPointEng(int eng) {		this.eng=eng;	}
	
	public int getPointMath() {		return math;	}
	public void setPointMath(int math) {		this.math=math; }
	
	
	int getSum() {
		return this.kor+this.eng+this.math;
	}
	
	float getAvg() {
		return getSum() / 3f ;
	}
	
}