class Calculator {
	int add(int a, int b) {
		return a+b;
	}
	int substract(int a, int b) {
		return a-b;
	}
	int multiply(int a, int b) {
		return a*b;
	}
	int divide(int a, int b) {
		return a/b;
	}
}
public class Member {

	public static void main(String[] args) {
		System.out.println("이윤성");	
		
		Calculator calc = new Calculator();
		System.out.println(calc.add(4, 7));
		System.out.println(calc.substract(4, 7));
		System.out.println(calc.multiply(4, 7));
		System.out.println(calc.divide(4, 7));
	}

}
