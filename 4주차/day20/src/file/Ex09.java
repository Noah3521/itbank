package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// 프로젝트 폴더에 ex09.txt 파일을 생성한 다음
		// RileWriter 를 이용하여 본인의 이름과 생일을 기록하세요
		// 이름은 첫 줄, 생일은 월과 일만 두번째 줄에 기록하세요
		
		// Scanner를 이용하여 대상 파일을 읽어서
		// 한줄씩 화면에 출력하세요
		
		File f = new File("ex09.txt");
		if(!f.exists()) {
			f.createNewFile();
		}
		
		boolean append = false;
		
		// 파일 입력
		FileWriter fw = new FileWriter(f, append);
		fw.append("송근욱\n");
		fw.append("1230\n");
		fw.flush();
		fw.close();
		
		// 파일 출력
		Scanner sc = new Scanner(f);
		String s = "";
		while(sc.hasNextLine()) {
			s += sc.nextLine() + "\n";
		}
		System.out.println(s);
		sc.close();
		
		// 파일 실행
		String command = "notepad " + f.getAbsolutePath();
		Process pro = Runtime.getRuntime().exec(command);
		Thread.sleep(5000);
		pro.destroy();
		
	}
}
