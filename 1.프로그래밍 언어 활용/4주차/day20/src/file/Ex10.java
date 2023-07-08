package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Ex10 {
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("경로 입력");
		String url;
		
		url = sc.nextLine();
		
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		String contentType = conn.getContentType();
		int fileSize = conn.getContentLength();
		String fileName = "test.";
		fileName += contentType.split("/")[1];
		
		byte[] buf = new byte[1024];
		int b=0;
		int total = 0;
		InputStream is = conn.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File(fileName));
		
		while((b=is.read(buf,0,1024))!= -1) {
			total += b;
			int rate = total * 100 / fileSize;
			fos.write(buf, 0, b);
			System.out.printf("%d / %d (%d%%)\n", total, fileSize, rate);
		}
		fos.flush();
		fos.close();
	}
}
