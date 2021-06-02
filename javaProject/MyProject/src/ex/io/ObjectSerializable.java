package ex.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectSerializable {

	public static void main(String[] args) {

		// 인스턴스를 저장
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));

			out.writeObject(new Circle(1, 2, 3.4));
			out.writeObject(new Circle(3, 5, 7.9));
			out.writeObject("Hello");
			
			ArrayList<Circle> list = new ArrayList<>();
			list.add(new Circle(1,2, 3.4));
			list.add(new Circle(5,6, 7.8));
			list.add(new Circle(9,10, 11.12));
			list.add(new Circle(13,23, 33.43));
			list.add(new Circle(15,25, 35.45));
			out.writeObject(list);
			
			
			out.close();

			System.out.println("인스턴스 저장 완료");

			// 인스턴스 복원
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));

			// 복원 순서는 저장 순서와 똑같이 구성해야 한다.
			Circle c1 = (Circle) in.readObject();
			Circle c2 = (Circle) in.readObject();
			String str = (String) in.readObject();
			
			ArrayList<Circle> list2 = (ArrayList<Circle>) in.readObject();
			
			for (Circle circle : list2) {
				System.out.println(circle);
			}

			System.out.println("복원된 인스턴스의 데이터를 출력");

			c1.showData();
			c2.showData();
			System.out.println(str);

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
}
	class Circle implements Serializable {

		// 클래스가 직렬화 대상임을 알려주는 역할을 하는 Serializable

		int x;
		int y;
		double r;

		public Circle(int x, int y, double r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

		public void showData() {
			System.out.println("원점 [" + x + "," + y + "]");
			System.out.println("반지름: " + r);
		}

	}
