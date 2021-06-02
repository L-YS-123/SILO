package ex.io;

import java.io.*;


public class ByteFileCopy2 {

	public static void main(String[] args) {

		try {

			// 1.파일을 바이너리 데이터로 읽어올 스트림 생성 : FileInputStream
			// FileInputStream fileInputStream = new FileInputStream("orginal.pdf");
			InputStream fileInputStream = new FileInputStream("orginal.pdf");
			// 2.파일을 쓰기위한 스트림 생성 : FileOutputStream
			FileOutputStream fileOutputStream = new FileOutputStream("copy.pdf");

			// 카피한 데이터의 크기
			int copyByte = 0;
			// 파일에서 읽어 올 바이트 데이터 배열
			byte[] buf = new byte[1024]; // 1kb 사이즈 배열
			// 읽어온 데이터 배열의 개수
			int readLen = 0;

			while (true) {
				readLen = System.in.read(buf); // 완료시점에 -1 반환

				// 탈출의 조건 : 파일의 모든 데이터를 읽은 경우
				if (readLen == -1) {
					break;
				}
				// 출력: 파일에 데이터를 쓴다
				System.out.write(buf, 0, readLen);
				copyByte += readLen;

			}

			// 스트림 닫기
			System.in.close();
			System.out.close();

			System.out.println("복사완료! 복사된 바이트 사이즈는 : " + copyByte + "byte");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
