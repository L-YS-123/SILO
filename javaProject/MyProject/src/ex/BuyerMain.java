package ex;

public class BuyerMain {
	
	public static void main(String[] args) {
		
		//구매자 객체생성
		Buyer buyer = new Buyer();
		
		//제품 객체 생성
		Tv tv = new Tv(100);
		Computer com = new Computer(30);
		
		//구매. 형변환 이루어짐
		buyer.buy(tv);
		buyer.buy(com);
		
		//결과 지표
//		System.out.println("현재 소지한 금액은" + buyer.money + "원 입니다.");
//		System.out.println("현재 보유한 보너스 포인트는 " + buyer.bonusPoint + "원 입니다.");
		
		//구매지표 출력
		buyer.summary();
		
	}

}
