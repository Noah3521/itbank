package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex08 {
	public static void main(String[] args) throws IOException {
		
		File f = new File("a.txt");
		if(!f.exists()) {
			f.createNewFile();
		}
		
		// 기존 내용을 유지하고 아래쪽에 내용을 추가할 것인가?
		boolean append = true;
		
		FileWriter fw = new FileWriter(f, append);
		fw.append("hello\n");
		fw.append("world\n");
		fw.append("java\n");
		fw.append("한글\n");
		fw.flush();
		fw.close();
		
		System.out.println("완료");
		
	}
}
