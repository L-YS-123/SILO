import java.util.Scanner;
class Calculator2 {
	
	long plus (int a, int b) {
		return (long)a+b;
	}	
	long minus (int a, int b) {
		return (long)a-b;
	}	
	long multiply (int a, int b) {
		return (long)a*b;
	}	
	long divide (int a, int b) {
		return (long)a/b;
	}	
	
	
	double Pi = 3.14d;
		
	
	double circle (float r) {
		return 2*Pi*r;
	}	
	double circleArea (float r) {
		return Pi*r*r;
	}

	
	public static void main(String[] args) {		
		Calculator2 calc = new Calculator2();
		System.out.println(calc.Pi);
		System.out.println("1 + 2 = " + calc.plus(1, 2));
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("덧셈을 합니다.\n숫자를 입력해주세요.");
		int num1 = scanner.nextInt();
		System.out.println("숫자 2를 입력해주세요.");
		int num2 = scanner.nextInt();
		
		System.out.println(num1 + " + " + num2 + " = " + calc.plus(num1, num2));
		
		System.out.println("--------------------------------------------------");
		
		System.out.println("반지름을 입력해주세요.");
		float r = scanner.nextFloat();
		
		System.out.println("입력 받은 반지름의 길이 : " + r);
		System.out.println("원의 둘레: " + calc.circle(r));
		System.out.println("원의 넓이: " + calc.circleArea(r));
	}
}