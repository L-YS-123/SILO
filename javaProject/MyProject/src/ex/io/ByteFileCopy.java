package ex.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ByteFileCopy {

	public static void main(String[] args) {

		try() {
		
		// 1.파일을 바이너리 데이터로 읽어올 스트림 생성 : FileInputStream
		FileInputStream fileInputStream = new FileInputStream("orginal.pdf");
		// 2.파일을 쓰기위한 스트림 생성 : FileOutputStream
		FileOutputStream fileOutputStream = new FileOutputStream("copy.pdf");

		} catch() {
			
		}
	}

}
