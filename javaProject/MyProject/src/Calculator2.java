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
	
	
	double circle (long r) {
		return 2*Pi*r;
	}
	
	double circleArea (long r) {
		return Pi*r*r;
	}

	public static void main(String[] args) {
		
		Calculator2 calc = new Calculator2();
		System.out.println(calc.Pi);
		System.out.println("1 + 2 = " + calc.plus(1, 2));
	}
}