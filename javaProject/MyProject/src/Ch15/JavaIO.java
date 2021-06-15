package Ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 1.콘솔기반으로 메모장 기능을 만들어 봅시다.
①File 클래스를 이용해서 저장 폴더 생성
②문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
③파일의 이름은 날짜와 메모의 제목을 이용해서 생성
④메모리스트와 파일 읽기 기능을 구현해봅시다. 메모리스트????

 */
public class JavaIO {
	BufferedWriter writer = null;
	BufferedReader reader = null;

	public static void main(String[] args) {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Yun\\Documents\\GitHub\\Text.txt"));

			writer.write("2021-06-13");
			writer.newLine();
			writer.write("제목미정");
			writer.newLine();
			writer.write("자바 너무 어려움");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Yun\\Documents\\GitHub\\Text.txt"));
			String Line = null;
			while ((Line = reader.readLine()) != null ){	// 왜 line 이라는 참조변수를 이용해야지만 제대로 된 결과가 나오는지??
				System.out.println(Line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
