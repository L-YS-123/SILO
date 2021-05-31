//2.Calulator 인터페이스를 상속하는 인스턴스를 생성할 수 있는 클래스를 정의해봅시다.
package Interface;
import java.util.Scanner;

public class Ex2 implements Calculator {
	Scanner sc = new Scanner(System.in);
	long n1 = sc.nextLong();
	long n2 = sc.nextLong();

	@Override
	public long add(long n1, long n2) {
		
		return n1+n2;
	}

	@Override
	public long substract(long n1, long n2) {
		
		return n1-n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		
		return n1*n2;
	}

	@Override
	public double divide(double n1, double n2) {
		
		return (double)n1/n2;
	}
	
	public void act() {
		System.out.println(this.add(n1, n2));
		System.out.println(this.substract(n1, n2));
		System.out.println(this.multiply(n1, n2));
		System.out.println(this.divide(n1, n2));
	}

}
