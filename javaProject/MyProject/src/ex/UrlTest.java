package ex;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {

	public static void main(String[] args) {
		String urlStr = "https://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=100";
		
		try {
			URL url = new URL(urlStr);
			
			System.out.println("protocol:" + url.getProtocol());
			System.out.println("host name:" + url.getHost());
			System.out.println("query:" + url.getQuery());
			System.out.println("path:" + url.getPath());
			System.out.println("file:" + url.getFile());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
